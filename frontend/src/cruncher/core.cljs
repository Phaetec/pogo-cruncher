(ns cruncher.core
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom :include-macros true]
            [goog.dom :as gdom]
            [cruncher.data.pokemon]
            [cruncher.communication.auth]
            [cruncher.utils.extensions]
            [cruncher.utils.lib :as lib]
            [cruncher.selections]
            [cruncher.shredder.main]
            [cruncher.views :as views]
            [om.next :as om]))

(enable-console-print!)

(.log js/console "Started Cruncher Version 0.3.3")

(om/add-root! lib/reconciler views/Main (gdom/getElement "cruncher-main"))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )
