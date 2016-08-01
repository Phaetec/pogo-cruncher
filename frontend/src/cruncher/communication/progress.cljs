(ns cruncher.communication.progress
  "Functions concerning the progress bar."
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom :include-macros true]
            [goog.dom :as gdom]
            [cruncher.communication.auth :as auth]
            [cruncher.communication.main :as com]
            [cruncher.utils.extensions]
            [cruncher.utils.lib :as lib]
            [cruncher.utils.views :as vlib]))



(defui ProgressBar
  Object
  (render [this]
    (dom/div #js {:className "progress"}
             (dom/div #js {:className "progress-bar progress-bar-striped active"
                           :role "progressbar"
                           :aria-valuenow "70"
                           :aria-valuemin "0"
                           :aria-valuemax "100"
                           :style #js {:width "40%"}}))))
(def progress-bar (om/factory ProgressBar))