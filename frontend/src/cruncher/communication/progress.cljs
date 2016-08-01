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
<<<<<<< da416801d037474fa44e000aeee4d19da7bd2c16
  [this]
  (lib/progress! true)
  (let [channel (chan)]
    (go (loop [_ 1]
          (let [{:keys [progress]} (om/props this)
                to-delete (:to_delete progress)
                deleted (:deleted progress)
                status (:status progress)]
            (if (and (< deleted to-delete)
                     (= status "ok"))
              (do (<! (timeout 1000))
                  (com/ajax-get (:status-delete config/api) update-progress-handler error-handler)
                  (recur 1))
              (do (close! channel)
                  (lib/progress! false))))
          ))))
=======
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
>>>>>>> Add flat to kill async process

(defui ProgressBar
  Object
  (render [this]
    ;;(when (lib/progress?))
    (let [{:keys [progress]} (om/props this)
          to-delete (:to_delete progress)
          deleted (:deleted progress)
          percent (* 100 (/ deleted to-delete))]
      (dom/div nil
               (dom/div #js {:id        "progress-bar"
                             :className "progress"}
                        (dom/div #js {:className     (str "progress-bar progress-bar-striped active" (when (and (zero? to-delete) (zero? deleted) (not (lib/progress?))) " progress-bar-success"))
                                      :role          "progressbar"
                                      :aria-valuenow percent
                                      :aria-valuemin 0
                                      :aria-valuemax to-delete
                                      :style         #js {:width (str percent "%")}}))))))
(def progress-bar (om/factory ProgressBar))