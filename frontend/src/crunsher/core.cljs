(ns crunsher.core
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom :include-macros true]
            [goog.dom :as gdom]
            [crunsher.data.pokemon]
            [crunsher.utils.extensions]
            [crunsher.utils.lib :as lib]
            [crunsher.views :as views]
            [om.next :as om]))

(enable-console-print!)

(om/add-root! lib/reconciler
              views/Main (gdom/getElement "crunsher-main"))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
