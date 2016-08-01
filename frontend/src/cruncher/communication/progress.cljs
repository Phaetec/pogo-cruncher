(ns cruncher.communication.progress
  "Functions concerning the progress bar."
  (:require [cljs.core.async :refer [chan close! <!]]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom :include-macros true]
            [cruncher.communication.main :as com]
            [cruncher.config :as config]
            [cruncher.utils.extensions]
            [cruncher.utils.lib :as lib]
            [cruncher.utils.views :as vlib])
  (:require-macros [cljs.core.async.macros :as m :refer [go]]))

(defn timeout [ms]
  (let [c (chan)]
    (js/setTimeout (fn [] (close! c)) ms)
    c))

(defn update-progress-handler
  "Set new app state with the progress information from the API."
  [response]
  (lib/no-error!)
  (lib/update-progress-status! (com/process-response response)))

(defn error-handler
  "Show some information to the user if something went wrong."
  [response]
  (let [res (com/process-response response)]
    (lib/error! (str "API is not responding while crunching the pokemon... " (:status res)))))

(defn query-status
  "Make ajax request to request status of the crunching-progress."
  []
  (lib/progress! true)
  (go (while (lib/progress?)
        (let [url (:status-delete config/api)
              progress (lib/get-progress-status)
              to-delete (:to-delete progress)
              deleted (:deleted progress)
              status (:status progress)]
          (if (and (= status "ok") (not= to-delete deleted))
            (do
              (<! (timeout 500))
              (lib/progress! true)
              (com/ajax-get url update-progress-handler error-handler))
            (lib/progress! false))))))

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