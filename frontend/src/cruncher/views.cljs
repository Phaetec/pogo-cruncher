(ns cruncher.views
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom :include-macros true]
            [cruncher.communication.auth :as auth]
            [cruncher.communication.favorites :as favorites]
            [cruncher.communication.main :as com]
            [cruncher.communication.progress :as progress]
            [cruncher.communication.evolutions :as evolutions]
            [cruncher.moves.main :as moves]
            [cruncher.selections :as selections]
            [cruncher.utils.status :as status]
            [cruncher.rename :as rename]
            [cruncher.shredder.main :as shredder]
            [cruncher.utils.extensions]
            [cruncher.utils.lib :as lib]
            [cruncher.utils.views :as vlib]))

;;;; Auxiliary
(defn favorite-td [id favorite]
  (dom/span #js {:className "pointer"
                 :onClick   #(favorites/toggle-favorite id favorite)}
            (if favorite (vlib/fa-icon "fa-star") (vlib/fa-icon "fa-star-o"))))


;;;; Controls
(defui Controls
  Object
  (render [this]
    (dom/div nil
             (dom/div #js {:className "row"}
                      (dom/div #js {:className "col-md-6"}
                               (dom/p #js {:className "lead"} "Controls")
                               (vlib/button-primary #(com/route :get-all-pokemon) "Load your Pokemon")
                               (vlib/button-primary #(shredder/power-on this) (dom/span nil (vlib/fa-icon "fa-eraser") " Crunch selected Pokemon")))
                      (dom/div #js {:className "col-md-6"}
                               (dom/p #js {:className "lead"} "Information")
                               (dom/div nil (:evolution-number (om/props this)) " Evolutions available")))
             (dom/br nil)
             (dom/div nil (selections/controls (om/props this)))
             (dom/br nil)
             (dom/div nil (rename/controls (om/props this)))
             (dom/br nil)
             (dom/div nil (progress/progress-bar (om/props this))))))
(def controls (om/factory Controls))


;;;; Messages
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

(defui InfoMessage
  Object
  (render [this]
    (when (lib/info?)
      (dom/div #js {:className "alert alert-success"}
               (dom/a #js {:href         "#"
                           :onClick      #(lib/info! nil)
                           :className    "close"
                           :data-dismiss "alert"
                           :aria-label   "close"}
                      (vlib/safe-html "&times;"))
               (lib/get-info)))))
(def info-message (om/factory InfoMessage))


;;;; Poketable
(defui PokeTableEntryDetails
  Object
  (render [this]
    (let [pokemon (om/props this)
          player (:player pokemon)]
      (dom/tr #js {:id        (str "poketable-row-details-" (:id pokemon))
                   :className "collapse"}
              (dom/td #js {:className "well"})
              (dom/td #js {:className "well" :colSpan 13}
                      (dom/div #js {:className "row"}
                               (dom/div #js {:className "col-md-4"}
                                        (dom/div #js {:className "row"}
                                                 (dom/div #js {:className "col-md-4"} "Evolves to:")
                                                 (dom/div #js {:className "col-md-8"} (or (lib/pokemon-evolution pokemon) "None")))
                                        (dom/div #js {:className "row"}
                                                 (dom/div #js {:className "col-md-4"} "Candy:")
                                                 (dom/div #js {:className "col-md-8"} (:candy pokemon)))
                                        (dom/div #js {:className "row"}
                                                 (dom/div #js {:className "col-md-4"} "Evolutions:")
                                                 (dom/div #js {:className "col-md-8"} (lib/calc-evolutions pokemon)))
                                        (dom/div #js {:className "row"}
                                                 (dom/div #js {:className "col-md-4"} "Powerup Cost: ")
                                                 (dom/div #js {:className "col-md-8"} (:powerup_cost_stardust pokemon) " Dust, "
                                                          (:powerup_cost_candy pokemon) " Candy")))
                               (dom/div #js {:className "col-md-4"}
                                        (dom/div #js {:className "row"}
                                                 (dom/div #js {:className "col-md-12"}
                                                          (if (not= (lib/calc-evolutions pokemon) 0)
                                                            (dom/button #js {:className "btn btn-sm btn-info"
                                                                             :type      "button"
                                                                             :onClick   #(evolutions/evolve (:id pokemon))}
                                                                        "Evolve!"))))
                                        (dom/br nil)
                                        (dom/div #js {:className "row"}
                                                 (if (and (>= (:candy pokemon) (:powerup_cost_candy pokemon))
                                                          (>= (:stardust player) (:powerup_cost_stardust pokemon))
                                                          (> (+ 1.5 (:level player)) (:level pokemon)))
                                                   (dom/div #js {:className "col-md-12"} (dom/button #js {:className "btn btn-sm btn-info"
                                                                                                          :type      "button"
                                                                                                          :onClick   #(evolutions/powerup (:id pokemon))}
                                                                                                     "Power Up!"))))
                                        )
                               (dom/div #js {:className "col-md-4"}
                                        (dom/div #js {:className "row"}
                                                 (dom/div #js {:className "col-md-4"} "Attack:")
                                                 (dom/div #js {:className "col-md-8"} (:attack pokemon)))
                                        (dom/div #js {:className "row"}
                                                 (dom/div #js {:className "col-md-4"} "Defense:")
                                                 (dom/div #js {:className "col-md-8"} (:defense pokemon)))
                                        (dom/div #js {:className "row"}
                                                 (dom/div #js {:className "col-md-4"} "Health:")
                                                 (dom/div #js {:className "col-md-8"} (:health pokemon))))))))))

(def poketable-entry-details (om/factory PokeTableEntryDetails {}))

(defui PokeTableEntry
  Object
  (render [this]
    (let [pokemon (om/props this)
          move-1 (moves/get-move (:move_1 pokemon))
          move-2 (moves/get-move (:move_2 pokemon))]
      (dom/tr #js {:id              (str "poketable-row-" (:id pokemon))
                   :className       "poketable-row"
                   :data-favorite   (:favorite pokemon)
                   :data-id         (:id pokemon)
                   :data-iv-perfect (:individual_percentage pokemon)
                   :data-cp         (:cp pokemon)
                   :data-at         (:individual_attack pokemon)
                   :data-df         (:individual_defense pokemon)
                   :data-st         (:individual_stamina pokemon)}
              (dom/td nil
                      (dom/div #js {:className "checkbox"})
                      (dom/label nil
                                 (dom/input #js {:id        (str "poketable-checkbox-" (:id pokemon))
                                                 :className "poketable-checkbox"
                                                 :type      "checkbox"
                                                 :value     (:id pokemon)})))
              (dom/td nil (favorite-td (:id pokemon) (:favorite pokemon)))
              (dom/td nil (:pokemon_id pokemon))
              (dom/td nil (dom/img #js {:src (str "img/pokemon/models/" (:pokemon_id pokemon) ".png") :className "pokemon-image-thumb"}))
              (vlib/td-two-lines (:name pokemon) (:nickname pokemon))
              (vlib/td-two-lines (:name move-1) (str (:type move-1) " / " (moves/get-move-dps move-1 pokemon) " DPS"))
              (vlib/td-two-lines (:name move-2) (str (:type move-2) " / " (moves/get-move-dps move-2 pokemon) " DPS"))
              (dom/td nil (:cp pokemon))
              (dom/td nil (:individual_percentage pokemon))
              (dom/td nil (:individual_attack pokemon))
              (dom/td nil (:individual_defense pokemon))
              (dom/td nil (:individual_stamina pokemon))
              (dom/td nil (dom/button #js {:className     "btn btn-sm btn-info"
                                           :type          "button"
                                           :data-toggle   "collapse"
                                           :data-target   (str "#poketable-row-details-" (:id pokemon))
                                           :aria-expanded "false"
                                           :aria-controls (str "poketable-row-details-" (:id pokemon))}
                                      "Details"))))))
(def poketable-entry (om/factory PokeTableEntry {}))

(defui PokeTable
  Object
  (render [this]
    (dom/div #js {:id "poketable"}
             (dom/div nil (controls (om/props this)))
             (dom/br nil)
             (dom/table #js {:className "table table-hover"}
                        (dom/thead nil
                                   (dom/tr nil
                                           (dom/th nil "")
                                           (vlib/sortable-table-header :favorite "Fav.")
                                           (vlib/sortable-table-header :pokemon_id "#")
                                           (dom/th nil "")
                                           (vlib/sortable-table-header :name "Name")
                                           (vlib/sortable-table-header :move_1 "Fast")
                                           (vlib/sortable-table-header :move_2 "Special")
                                           (vlib/sortable-table-header :cp "CP")
                                           (vlib/sortable-table-header :individual_percentage "IV%")
                                           (vlib/sortable-table-header :individual_attack "AT")
                                           (vlib/sortable-table-header :individual_defense "DF")
                                           (vlib/sortable-table-header :individual_stamina "ST")
                                           (dom/th nil "")))
                        (dom/tbody nil
                                   (interleave
                                     (map #(poketable-entry (lib/merge-react-key %)) (lib/inventory-pokemon))
                                     (map #(poketable-entry-details (merge (lib/merge-react-key %) {:player (lib/playerinfo)})) (lib/inventory-pokemon)))))
             #_(let [jquery (js* "$")]
                 (.stickyTableHeaders (jquery "#poketable"))))))

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
             (dom/span #js {:className "pull-right"} (vlib/loader (om/props this)))
             (dom/ul nil
                     (dom/li nil
                             "If you have 2-factor Auth enabled in your Google Account, please add an "
                             (dom/a #js {:href   "https://security.google.com/settings/security/apppasswords?pli=1"
                                         :target "_blank"}
                                    "app-password")
                             " to your account")
                     (dom/li nil "Click on the table headers to sort the data")
                     (dom/li nil "Crunching Pokemon really means you're sending them away -- "
                             (dom/strong nil "there is no possibility to get them back!!!"))
                     (dom/li nil "Automated Pokemon crunching takes between 2 and 3 seconds per pokemon to prevent robotic behaviour.")
                     (dom/li nil "Your selected favorite Pokemon cannot be sent away and are automatically unselected when start sending them away."))
             (dom/hr nil))))
(def header (om/factory Header))

(defn google-ptc-switch [this]
  (dom/form #js {:id   "google-ptc-switch"
                 :role "form"}
            (dom/label #js {:className "radio-inline"}
                       (dom/input #js {:type    "radio"
                                       :onClick #(vlib/commit-component-state this :service "google")
                                       :name    "google-ptc-switch"})
                       "Google")
            (dom/label #js {:className "radio-inline"}
                       (dom/input #js {:type    "radio"
                                       :onClick #(vlib/commit-component-state this :service "ptc")
                                       :name    "google-ptc-switch"})
                       "Pokemon Trainer Club")))

(defn validate-login-button
  "Show Login button and disable it when one of these fields is empty."
  [email password location service]
  (let [not-empty? (and
                     (pos? (count email))
                     (pos? (count password))
                     (pos? (count service)))]
    (vlib/button-primary #(auth/ajax-login email password service) not-empty? "Login")))

(defui Login
  Object
  (render [this]
    ;; TODO return empty string if om/get-state is empty
    (let [email (or (om/get-state this :email) "")
          password (or (om/get-state this :password) "")
          location (or (om/get-state this :location) "")
          service (or (om/get-state this :service) "")]
      (dom/div #js {:className "row"}
               (dom/div #js {:className "col-md-6 col-md-offset-3"}
                        (vlib/panel-wrapper
                          (dom/div nil
                                   (dom/h5 #js {:className "text-center"} "Login")
                                   (dom/div #js {:className "input-group"}
                                            (dom/span #js {:className "input-group-addon"}
                                                      (vlib/fa-icon "fa-user fa-fw"))
                                            (dom/input #js {:className   "form-control"
                                                            :onChange    #(vlib/commit-component-state this :email %)
                                                            :value       email
                                                            :placeholder "email / PTC Username"}))
                                   (dom/div #js {:className "input-group"}
                                            (dom/span #js {:className "input-group-addon"}
                                                      (vlib/fa-icon "fa-key fa-fw"))
                                            (dom/input #js {:className   "form-control"
                                                            :onChange    #(vlib/commit-component-state this :password %)
                                                            :value       password
                                                            :type        "password"
                                                            :placeholder "password"}))
                                   (google-ptc-switch this)
                                   (validate-login-button email password location service))))))))
(def login (om/factory Login))

(defn view-dispatcher
  "Dispatch current template in main view by the app state."
  [this]
  (let [view (lib/current-view)]
    (cond
      (= view :login) (login (om/props this))
      (not (lib/logged-in?)) (login (om/props this))
      :else (poketable (om/props this)))))

(defui Main
  Object
  (render [this]
    (dom/div nil
             (dom/div nil (header (om/props this)))
             (dom/div nil (error-message (om/props this)))
             (dom/div nil (info-message (om/props this)))
             (view-dispatcher this)
             (dom/div nil (vlib/back-to-top))
             (dom/hr nil)
             (dom/div nil (status/api-test (om/props this)))
             #_(dom/div nil (poketable (om/props this)))
             #_(dom/div nil (login)))))


