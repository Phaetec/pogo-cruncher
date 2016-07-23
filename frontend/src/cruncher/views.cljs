(ns cruncher.views
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom :include-macros true]
            [goog.dom :as gdom]
            [cruncher.communication.auth :as auth]
            [cruncher.communication.main :as com]
            [cruncher.utils.extensions]
            [cruncher.utils.lib :as lib]
            [cruncher.utils.views :as vlib]))

;;;; Controls
(defui Controls
  Object
  (render [this]
    (dom/div nil
             (dom/span #js {:className "pull-right"} (vlib/loader (om/props this)))
             (vlib/button-primary #(com/route :get-all-pokemon) "Get all Pokemon"))))
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
             (dom/div nil (controls (om/props this)))
             (dom/br nil)
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
                               (map #(poketable-entry (lib/merge-react-key %)) (lib/inventory-pokemon)))))))
(def poketable (om/factory PokeTable {}))


;;;; Other
(defui Header
  Object
  (render [this]
    (dom/div nil
             (dom/div #js {:className "page-header"}
                      (dom/div #js {:className "pull-right"}
                               (vlib/login-indicator (om/props this)))
                      (dom/h1 nil "Poké-Cruncher"))
             (dom/p nil "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.")
             (dom/hr nil))))
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
                       (dom/input #js {:type    "radio"
                                       :onClick #(commit-component-state this :service "google")
                                       :name    "google-ptc-switch"})
                       "Google")
            (dom/label #js {:className "radio-inline"}
                       (dom/input #js {:type    "radio"
                                       :onClick #(commit-component-state this :service "ptc")
                                       :name    "google-ptc-switch"})
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
                        (vlib/panel-wrapper
                          (dom/div nil
                                   (dom/h5 #js {:className "text-center"} "Login")
                                   (dom/div #js {:className "input-group"}
                                            (dom/span #js {:className "input-group-addon"}
                                                      (vlib/fa-icon "fa-user fa-fw"))
                                            (dom/input #js {:className   "form-control"
                                                            :onChange    #(commit-component-state this :email %)
                                                            :value       email
                                                            :placeholder "email"}))
                                   (dom/div #js {:className "input-group"}
                                            (dom/span #js {:className "input-group-addon"}
                                                      (vlib/fa-icon "fa-key fa-fw"))
                                            (dom/input #js {:className   "form-control"
                                                            :onChange    #(commit-component-state this :password %)
                                                            :value       password
                                                            :type        "password"
                                                            :placeholder "password"}))
                                   (dom/div #js {:className "input-group"}
                                            (dom/span #js {:className "input-group-addon"}
                                                      (vlib/fa-icon "fa-map-marker fa-fw"))
                                            (dom/input #js {:className   "form-control"
                                                            :onChange    #(commit-component-state this :location %)
                                                            :value       location
                                                            :placeholder "Düsseldorf, Germany"}))
                                   (google-ptc-switch this)
                                   (vlib/button-primary #(auth/login email password location service) "Login"))))))))
(def login (om/factory Login))

(defn view-dispatcher
  "Dispatch current template in main view by the app state."
  [this]
  (let [view (lib/current-view)]
    (cond
      (= view :login) (login (om/props this))
      (not (lib/logged-in?)) (login (om/props this))
      :else (poketable (om/props this)))))

(defui ErrorMessage
  Object
  (render [this]
    (when (lib/error?)
      (dom/div #js {:className "alert alert-warning"}
               (dom/a #js {:href         "#"
                           :className    "close"
                           :data-dismiss "alert"
                           :aria-label   "close"}
                      (vlib/safe-html "&times;"))
               (dom/strong nil "Error: ")
               (lib/get-error)))))
(def error-message (om/factory ErrorMessage))

(defui Main
  Object
  (render [this]
    (dom/div nil
             (dom/div nil (header (om/props this)))
             (dom/div nil (error-message (om/props this)))
             (view-dispatcher this)
             #_(dom/div nil (poketable (om/props this)))
             #_(dom/div nil (login)))))


