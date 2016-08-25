(ns cruncher.rename
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom :include-macros true]
            [goog.dom :as gdom]
            [cruncher.utils.views :as vlib]
            [cruncher.utils.lib :as lib]))

(defn do-the-rename-dance!
  "Rename all selected pokemon according to the selected scheme. Not reversible!"
  [scheme]
  (let [rows (gdom/getElementsByClass "poketable-row")]
    (doall (map (fn [row]
                  (let [id (.getAttribute row "data-id")
                        at (.getAttribute row "data-at")
                        df (.getAttribute row "data-df")
                        st (.getAttribute row "data-st")
                        iv (.getAttribute row "data-iv-perfect")
                        checkbox (gdom/getElement (str "poketable-checkbox-" id))]
                    (if (.-checked checkbox)
                      (println "ahoi")
                      (println "nope"))))
                rows))))

(defui SelectSchemes
  Object
  (render [this]
    (let [selected (or (om/get-state this :selected) "rename-scheme-1")]
      (dom/div nil
               (dom/div #js {:className "input-group"}
                        (dom/select #js {:className "form-control"
                                         :onChange  #(vlib/commit-component-state this :selected %)
                                         :value     selected}
                                    (dom/option #js {:value "rename-scheme-1"} "IV% AT/DF/ST")
                                    (dom/option #js {:value "rename-scheme-2"} "AT/DF/ST")
                                    (dom/option #js {:value "rename-scheme-3"} "IV%"))
                        (dom/div #js {:className "input-group-btn"}
                                 (vlib/button-default #(do-the-rename-dance! selected) "Rename")))))))
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