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
      (dom/tr nil
              (dom/td nil (:pokemon_id pokemon))
              (dom/td nil (:name pokemon))
              (dom/td nil (:individual_attack pokemon))
              (dom/td nil (:individual_defense pokemon))
              (dom/td nil (:individual_stamina pokemon))))))
(def poketable-entry (om/factory PokeTableEntry {}))

(defui PokeTable
  Object
  (render [this]
    (dom/table #js {:className "table table-hover"}
               (dom/thead nil
                          (dom/th nil "#")
                          (dom/th nil "Name")
                          (dom/th nil "Attack")
                          (dom/th nil "Defense")
                          (dom/th nil "Stamina"))
               (apply dom/tbody nil
                      (map #(poketable-entry (lib/merge-react-key %)) (lib/inventory-pokemon))))))
(def poketable (om/factory PokeTable))

(defui ^:once Main
  Object
  (render [this]
    (dom/div nil
             (dom/h1 nil "Poké-Crunsher")
             (poketable))))