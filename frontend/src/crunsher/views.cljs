(ns crunsher.views
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom :include-macros true]
            [goog.dom :as gdom]
            [crunsher.extensions]
            [crunsher.lib :as lib]))

(defui PokeTableEntry
  Object
  (render [this]
    (let [pokemon (om/props this)]
      (dom/li nil (:name pokemon)))))
(def poketable-entry (om/factory PokeTableEntry {}))

(defui PokeTable
  Object
  (render [this]
    (dom/div nil
             (apply dom/ul nil
                    (map #(poketable-entry (lib/merge-react-key %)) (lib/inventory-pokemon))))))
(def poketable (om/factory PokeTable))

(defui ^:once Main
  Object
  (render [this]
    (dom/div nil
             (dom/h1 nil "Hello World"
                     (dom/span #js {:className "small"} " Let's crunsh some Pokemon"))
             (poketable))))