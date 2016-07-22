(ns crunsher.views
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom :include-macros true]
            [goog.dom :as gdom]
            [crunsher.communication.auth :as auth]
            [crunsher.communication.main :as com]
            [crunsher.utils.bootstrap :as bs]
            [crunsher.utils.extensions]
            [crunsher.utils.lib :as lib]))

;;;; Other
(defn fa-icon
  "Wrapper for font-awesome icons."
  ([class]
   (dom/i #js {:react-key (lib/get-unique-key)
               :key       (lib/get-unique-key)
               :className (str "fa " class)}))
  ([class f]
   (dom/i #js {:react-key (lib/get-unique-key)
               :key       (lib/get-unique-key)
               :className (str "pointer fa " class)
               :onClick   f})))

;;;; Controls
(defui Controls
  Object
  (render [this]
    (dom/div nil
             (bs/button-primary #(com/route :get-all-pokemon) "Get all Pokemon"))))
(def controls (om/factory Controls))


;;;; Poketable
(defui PokeTableEntry
  Object
  (render [this]
    (let [pokemon (om/props this)
          pokemon-db (lib/get-pokemon-by-id (:pokemon_id pokemon))]
      (dom/tr nil
              (dom/td nil (:pokemon_id pokemon))
              (dom/td nil (:name pokemon-db))
              (dom/td nil (:nickname pokemon))
              (dom/td nil (:cp pokemon))
              (dom/td nil (:health pokemon))
              (dom/td nil (:individual_percentage pokemon))
              (dom/td nil (:individual_attack pokemon))
              (dom/td nil (:individual_defense pokemon))
              (dom/td nil (:individual_stamina pokemon))))))
(def poketable-entry (om/factory PokeTableEntry {}))

(defui PokeTable
  Object
  (render [this]
    (dom/div nil
             (dom/table #js {:className "table table-hover"}
                        (dom/thead nil
                                   (dom/tr nil
                                           (dom/th nil "#")
                                           (dom/th nil "Name")
                                           (dom/th nil "Nickname")
                                           (dom/th nil "CP")
                                           (dom/th nil "Health")
                                           (dom/th nil "IV % Perfekt")
                                           (dom/th nil "IV Attack")
                                           (dom/th nil "IV Defense")
                                           (dom/th nil "IV Stamina")))
                        (apply dom/tbody nil
                               (map #(poketable-entry (lib/merge-react-key %)) (lib/inventory-pokemon))))
             (dom/div nil (controls)))))
(def poketable (om/factory PokeTable {}))

(defui Header
  Object
  (render [this]
    (dom/div nil
             (dom/h1 nil "Poké-Cruncher"))))
             (dom/div #js {:className "page-header"}
                      (dom/h1 nil "Poké-Crunsher"))
             (dom/p nil "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."))))
(def header (om/factory Header))

(defn commit-component-state
  "Set local state of view, parse the value of the target of val."
  [this key val]
  (cond
    (= (type val) js/Event) (om/update-state! this assoc key (.. val -target -value))
    (= (type val) js/String) (om/update-state! this assoc key val)
    :else (om/update-state! this assoc key (.. val -target -value))))

(defn google-ptc-switch [this]
  (dom/form #js {:id   "google-ptc-switch"
                 :role "form"}
            (dom/label #js {:className "radio-inline"}
                       (dom/input #js {:type "radio"
                                       :onClick #(commit-component-state this :service "google")
                                       :name "google-ptc-switch"})
                       "Google")
            (dom/label #js {:className "radio-inline"}
                       (dom/input #js {:type "radio"
                                       :onClick #(commit-component-state this :service "ptc")
                                       :name "google-ptc-switch"})
                       "Pokemon Trainer Club")))

(defui Login
  Object
  (render [this]
    ;; TODO return empty string if om/get-state is empty
    (let [email (om/get-state this :email)
          password (om/get-state this :password)
          location (om/get-state this :location)
          service (om/get-state this :service)]
      (dom/div #js {:className "row"}
               (dom/div #js {:className "col-md-6 col-md-offset-3"}
                        (dom/h5 #js {:className "text-center"} "Login")
                        (dom/div #js {:className "input-group"}
                                 (dom/span #js {:className "input-group-addon"}
                                           (fa-icon "fa-user fa-fw"))
                                 (dom/input #js {:className   "form-control"
                                                 :onChange    #(commit-component-state this :email %)
                                                 :value       email
                                                 :placeholder "email"}))
                        (dom/div #js {:className "input-group"}
                                 (dom/span #js {:className "input-group-addon"}
                                           (fa-icon "fa-key fa-fw"))
                                 (dom/input #js {:className   "form-control"
                                                 :onChange    #(commit-component-state this :password %)
                                                 :value       password
                                                 :type        "password"
                                                 :placeholder "password"}))
                        (dom/div #js {:className "input-group"}
                                 (dom/span #js {:className "input-group-addon"}
                                           (fa-icon "fa-map-marker fa-fw"))
                                 (dom/input #js {:className   "form-control"
                                                 :onChange    #(commit-component-state this :location %)
                                                 :value       location
                                                 :placeholder "Düsseldorf, Germany"}))
                        (google-ptc-switch this)
                        (dom/button #js {:className "btn btn-default"
                                         :onClick   #(auth/login email password location service)}
                                    "Login"))))))
(def login (om/factory Login))

(defn view-dispatcher
  "Dispatch current template in main view by the app state."
  []
  (let [view (lib/current-view)]
    (cond
      (= view :login) (login)
      (not (lib/logged-in?)) (login)
      :else (poketable))))

(defui Main
  Object
  (render [this]
    (dom/div nil
             (dom/div nil (header))
             (view-dispatcher)
             #_(dom/div nil (poketable (om/props this)))
             #_(dom/div nil (login)))))


