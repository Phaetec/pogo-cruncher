(ns cruncher.rename
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom :include-macros true]
            [goog.dom :as gdom]
            [cruncher.utils.views :as vlib]
            [cruncher.utils.lib :as lib]
            [cruncher.config :as config]))

(defn- dispatch-scheme
  "Gets a string containing the user's selection. Construct the new nickname from it."
  [scheme iv at df st]
  (let [iv-int (lib/str->int iv)]
    (cond
      (and (= "rename-scheme-1" scheme) (= iv-int 100)) (str iv-int "%")
      (= "rename-scheme-1" scheme) (str iv-int "% " at "/" df "/" st)
      (= "rename-scheme-2" scheme) (str at "/" df "/" st)
      (= "rename-scheme-3" scheme) (str iv-int "%"))))

(defn- create-list-of-new-names
  "Returns list of maps like this one: {:id 42, :name 33% 15/0/0}, while :name is also
   a string."
  [scheme]
  (let [rows (gdom/getElementsByClass "poketable-row")]
    (remove nil? (map (fn [row]
                        (let [id (.getAttribute row "data-id")
                              iv (.getAttribute row "data-iv-perfect")
                              at (.getAttribute row "data-at")
                              df (.getAttribute row "data-df")
                              st (.getAttribute row "data-st")
                              checkbox (gdom/getElement (str "poketable-checkbox-" id))]
                          (when (.-checked checkbox)
                            {:id id
                             :name (dispatch-scheme scheme iv at df st)})))
                      rows))))

(defn- do-the-rename-dance!
  "Rename all selected pokemon according to the selected scheme. Not reversible!"
  [this scheme]
  (let [url (:rename-selected-pokemon config/api)
        new-nicknames (create-list-of-new-names scheme)]
    (lib/log new-nicknames)))

(defui SelectSchemes
  Object
  (render [this]
    (let [scheme (or (om/get-state this :scheme) "rename-scheme-1")]
      (dom/div nil
               (dom/div #js {:className "input-group"}
                        (dom/select #js {:className "form-control"
                                         :onChange  #(vlib/commit-component-state this :scheme %)
                                         :value     scheme}
                                    (dom/option #js {:value "rename-scheme-1"} "IV% AT/DF/ST")
                                    (dom/option #js {:value "rename-scheme-2"} "AT/DF/ST")
                                    (dom/option #js {:value "rename-scheme-3"} "IV%"))
                        (dom/div #js {:className "input-group-btn"}
                                 (vlib/button-default #(do-the-rename-dance! this scheme) "Rename")))))))
(def select-schemes (om/factory SelectSchemes {}))

(defui RenamingControls
  Object
  (render [this]
    (dom/div nil
             (dom/p #js {:className "lead"} "Renaming")
             (dom/label #js {:className "control-label"} "Renames selected Pokemon. Not reversible.")
             (dom/div #js {:className "row"}
                      (dom/div #js {:className "col-md-3"}
                               (select-schemes (om/props this)))))))
(def controls (om/factory RenamingControls))