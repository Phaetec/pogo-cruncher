(ns cruncher.selections
  "Enable mass selections of pokemon."
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom :include-macros true]
            [goog.dom :as gdom]
            [cruncher.utils.views :as vlib]))

(defn mass-selections
  "Function for mass selections of pokemon depending on a predicate.

   Example: Select all Pokemon which are not marked as favorite. The function
   call would then look like this: (mass-selections \"data-favorite\" \"true\" = true)"
  ([data-prop-str comparator operator checked]
   (let [rows (gdom/getElementsByClass "poketable-row")]
     (doall (map (fn [row]
                   (let [id (.getAttribute row "data-id")
                         data-prop (.getAttribute row data-prop-str)
                         checkbox (gdom/getElement (str "poketable-checkbox-" id))]
                     (if (operator comparator data-prop)
                       (set! (.. checkbox -checked) checked)
                       (set! (.. checkbox -checked) (not checked))))) rows))))
  ([data-prop-str comparator] (mass-selections data-prop-str comparator = true)))

(defn select-all-but-favorite []
  (mass-selections "data-favorite" "false"))

(defn unselect-all []
  (mass-selections "data-id" 0 not= false))

(defn select-all []
  (mass-selections "data-id" 0 < true))

(defn select-below-iv-perfect [percentage]
  (mass-selections "data-iv-perfect" percentage > true))


;;;; Views
(defui IVPercentage
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
                                        :placeholder "42"})
                        (dom/span #js {:className "input-group-addon"} "%")
                        (dom/span #js {:className "input-group-btn"}
                                  (vlib/button-default #(select-below-iv-perfect percentage) "Select")))))))
(def iv-percentage (om/factory IVPercentage))

(defui SelectionButtons
  Object
  (render [this]
    (dom/div nil
             (dom/p #js {:className "lead"} "Selections")
             (dom/div #js {:className "row"}
                      (dom/div #js {:className "col-md-6"}
                               (dom/label #js {:className "control-label"} "Clicking a button always overrides manual selections")
                               (dom/br nil)
                               (vlib/button-default select-all "Select all")
                               (vlib/button-default unselect-all "Unselect all")
                               (vlib/button-default select-all-but-favorite "Select all but favorite"))
                      (dom/div #js {:className "col-md-offset-2 col-md-4"}
                               (dom/div nil (iv-percentage (om/props this))))))))
(def controls (om/factory SelectionButtons))
