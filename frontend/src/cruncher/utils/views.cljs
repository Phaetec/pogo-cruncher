(ns cruncher.utils.views
  "Reusable components, which use twitter bootstrap to reduce redundancy."
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom :include-macros true]
            [goog.dom :as gdom]
            [cruncher.utils.lib :as lib]))

(defn commit-component-state
  "Set local state of view, parse the value of the target of val."
  [this key val]
  (cond
    (= (type val) js/Event) (om/update-state! this assoc key (.. val -target -value))
    (= (type val) js/String) (om/update-state! this assoc key val)
    :else (om/update-state! this assoc key (.. val -target -value))))

(defn sortable-table-header
  "Sort list of pokemon by given key."
  [key & str]
  (dom/th #js {:className "pointer"
               :onClick   #(lib/sort-pokemon! key)}
          str))

(defn button
  "Create dom element of a bootstrap primary button."
  ([fn not-empty? str btn-class]
   (dom/button #js {:className (clojure.string/join " " ["btn" btn-class])
                    :onClick   fn
                    :disabled  (or (lib/loading?) (lib/progress?) (not not-empty?))
                    :react-key (lib/get-unique-key)}
               str)))

(defn button-primary
  "Create primary button in bootstrap style."
  ([fn not-empty? str] (button fn not-empty? str "btn-primary"))
  ([fn str] (button-primary fn true str)))

(defn button-default
  "Create default button in bootstrap style."
  ([fn not-empty? str] (button fn not-empty? str "btn-default"))
  ([fn str] (button-default fn true str)))

(defn fa-icon
  "Wrapper for font-awesome icons."
  ([class]
   (dom/i #js {:react-key (lib/get-unique-key)
               :className (str "fa " class)}))
  ([class f]
   (dom/i #js {:react-key (lib/get-unique-key)
               :className (str "pointer fa " class)
               :onClick   f})))

(defn panel-wrapper
  "Wrap content into bootstrap's panel class."
  [content]
  (dom/div #js {:className "panel panel-default"}
           (dom/div #js {:className "panel-body"}
                    content)))

(defn safe-html
  "Creates DOM element with interpreted HTML."
  [string]
  (dom/span #js {:dangerouslySetInnerHTML #js {:__html string}}))


;;;; UIs
(defui Loader
  ; "Spinning icon to indicate if there is data being transferred."
  Object
  (render [this]
    (when (or (lib/loading?) (lib/progress?))
      (dom/div #js {:style #js {:paddingTop "2em"}}
               (fa-icon "fa-circle-o-notch fa-spin fa-fw")
               " Loading..."))))
(def loader (om/factory Loader))

(defui LoggedIn
  Object
  (render [this]
    (if (lib/logged-in?)
      (let [{:keys [player]} (om/props this)]
        (dom/div nil
                 (dom/div nil (:name player))
                 (dom/div nil
                          (:stardust player) (dom/img #js {:src "img/stardust_vector.png" :className "currency_image" :title "Dust"})
                          (:pokecoins player) (dom/img #js {:src "img/pokecoin.png" :className "currency_image" :title "Coins"}))
                 (dom/a #js {:href    "javascript:void(0)"
                             :onClick #(lib/logged-in! false)}
                        (fa-icon "fa-sign-out")
                        " Logout")))
      (dom/div nil
               (dom/a #js {:href    "javascript:void(0)"
                           :onClick #(lib/change-view! :login)}
                      (fa-icon "fa-sign-out")
                      " Login")))))
(def login-indicator (om/factory LoggedIn))

(defui BackToTop
  Object
  (render [this]
    (dom/div #js {:className (str "scrolltop")
                  :onClick   #(.scroll js/window 0 0)}
             (dom/div #js {:className "scroll icon"}
                      (fa-icon "fa-angle-up")))))
(def back-to-top (om/factory BackToTop))