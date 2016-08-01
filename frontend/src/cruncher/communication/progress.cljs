(ns cruncher.communication.progress
  "Functions concerning the progress bar."
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom :include-macros true]
            [goog.dom :as gdom]
            [cruncher.communication.auth :as auth]
            [cruncher.communication.main :as com]
            [cruncher.config :as config]
            [cruncher.utils.extensions]
            [cruncher.utils.lib :as lib]
            [cruncher.utils.views :as vlib]))

(defn update-progress-handler
  "Set new app state with the progress information from the API."
  [response]
  (lib/update-progress-status! (com/process-response response)))

(defn query-status
  "Make ajax request to request status of the crunching-progress."
  []
  (let [url (:status-delete config/api)]
    (com/ajax-get url update-progress-handler)))

(defui ProgressBar
  Object
  (render [this]
    (let [progress (lib/get-progress-status)
          to-delete (:to-delete progress)
          deleted (:deleted progress)
          percent (* 100 (/ deleted to-delete))]
      (dom/div nil
               (vlib/button-primary #(println (lib/get-progress-status)) "Get progress status")
               " "
               (vlib/button-primary #(query-status) "Query")
               (dom/br nil)
               (dom/br nil)
               (dom/div #js {:className "progress"}
                        (dom/div #js {:className     "progress-bar progress-bar-striped active"
                                      :role          "progressbar"
                                      :aria-valuenow percent
                                      :aria-valuemin 0
                                      :aria-valuemax to-delete
                                      :style         #js {:width (str percent "%")}}))))))
(def progress-bar (om/factory ProgressBar))