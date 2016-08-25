(ns cruncher.selections
  "Enable mass selections of pokemon."
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom :include-macros true]
            [goog.dom :as gdom]
            [cruncher.utils.views :as vlib]
            [cruncher.utils.lib :as lib]))

(defn unselect-favorites
  "Unselect all favorites. Useful before crunching them."
  []
  (let [rows (gdom/getElementsByClass "poketable-row")]
    (doall (map (fn [row]
                  (let [id (.getAttribute row "data-id")
                        favorite (lib/str->bool (.getAttribute row "data-favorite"))
                        checkbox (gdom/getElement (str "poketable-checkbox-" id))]
                    (when favorite (set! (.. checkbox -checked) false))))
                rows))))

(defn unselect-all
  "Unselect all pokemon."
  []
  (let [rows (gdom/getElementsByClass "poketable-row")]
    (doall (map (fn [row]
                  (let [id (.getAttribute row "data-id")
                        checkbox (gdom/getElement (str "poketable-checkbox-" id))]
                    (set! (.. checkbox -checked) false)))
                rows))))

(defn mass-selections
  "Function for mass selections of pokemon depending on a predicate.

   Example: Select all Pokemon which are not marked as favorite. The function
   call would then look like this: (mass-selections \"data-favorite\" \"true\" = true)"
  ([data-prop-str comparator operator checked]
   (let [rows (gdom/getElementsByClass "poketable-row")]
     (doall (map (fn [row]
                   (let [id (.getAttribute row "data-id")
                         favorite (lib/str->bool (.getAttribute row "data-favorite"))
                         data-prop (.getAttribute row data-prop-str)
                         checkbox (gdom/getElement (str "poketable-checkbox-" id))]
                     (if (and (not favorite) (operator comparator (lib/str->int data-prop)))
                       (set! (.. checkbox -checked) checked)
                       (set! (.. checkbox -checked) (not checked))))) rows))))
  ([data-prop-str comparator] (mass-selections data-prop-str comparator = true)))

(defn select-all-but-favorite []
  (mass-selections "data-favorite" "false"))

(defn select-below-iv-threshold [percentage]
  (mass-selections "data-iv-perfect" percentage > true))

(defn select-below-cp-threshold [percentage]
  (mass-selections "data-cp" percentage > true))

;;;; Views
(defui CPThreshold
  Object
  (render [this]
    (let [percentage (om/get-state this :percentage)]
      (dom/div #js {:className "form-group"}
               (dom/label #js {:className "control-label"} "Select all below CP Threshold")
               (dom/div #js {:className "input-group"}
                        (dom/input #js {:type        "text"
                                        :className   "form-control"
                                        :onChange    #(vlib/commit-component-state this :percentage %)
                                        :value       percentage
                                        :placeholder "in whole numbers"})
                        (dom/span #js {:className "input-group-addon"} "CP")
                        (dom/span #js {:className "input-group-btn"}
                                  (vlib/button-default #(select-below-cp-threshold percentage) (not (js/isNaN (js/parseFloat percentage))) "Select")))))))
(def cp-threshold (om/factory CPThreshold))

(defui IVThreshold
  Object
  (render [this]
    (let [percentage (om/get-state this :percentage)]
      (dom/div #js {:className "form-group"}
               (dom/label #js {:className "control-label"} "Select all below IV % Perfect Threshold")
               (dom/div #js {:className "input-group"}
                        (dom/input #js {:type        "text"
                                        :className   "form-control"
                                        :onChange    #(vlib/commit-component-state this :percentage %)
                                        :value       percentage
                                        :placeholder "in whole numbers"})
                        (dom/span #js {:className "input-group-addon"} "%")
                        (dom/span #js {:className "input-group-btn"}
                                  (vlib/button-default #(select-below-iv-threshold percentage) (not (js/isNaN (js/parseFloat percentage))) "Select")))))))
(def iv-threshold (om/factory IVThreshold))

(defui SelectionButtons
  Object
  (render [this]
    (dom/div nil
             (dom/p #js {:className "lead"} "Selections")
             (dom/div #js {:className "row"}
                      (dom/div #js {:className "col-md-6"}
                               (dom/label #js {:className "control-label"} "Clicking a button always overrides manual selections")
                               (dom/br nil)
                               (vlib/button-default unselect-all "Unselect")
                               (vlib/button-default unselect-favorites "Unselect Favorites")
                               (vlib/button-default select-all-but-favorite "Select all but Favorites"))
                      (dom/div #js {:className "col-md-3"}
                               (dom/div nil (cp-threshold (om/props this))))
                      (dom/div #js {:className "col-md-3"}
                               (dom/div nil (iv-threshold (om/props this))))))))
(def controls (om/factory SelectionButtons))
