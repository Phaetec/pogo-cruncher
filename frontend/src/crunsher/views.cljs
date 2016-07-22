(ns crunsher.views
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom :include-macros true]
            [goog.dom :as gdom]
            [crunsher.communication.main :as com]
            [crunsher.utils.bootstrap :as bs]
            [crunsher.utils.extensions]
            [crunsher.utils.lib :as lib]))

;;;; Controls
(defui Controls
  Object
  (render [this]
    (dom/div nil
             (bs/button-primary #(com/route :get-all-pokemon) "Get all Pokemon"))))
(def controls (om/factory Controls))


;;;; Poketable
(defui PokeTableEntry
  Object
  (render [this]
    (let [pokemon (om/props this)
          pokemon-db (lib/get-pokemon-by-id (:pokemon_id pokemon))]
      (dom/tr nil
              (dom/td nil (:pokemon_id pokemon))
              (dom/td nil (:name pokemon-db))
              (dom/td nil (:individual_attack pokemon))
              (dom/td nil (:individual_defense pokemon))
              (dom/td nil (:individual_stamina pokemon))))))
(def poketable-entry (om/factory PokeTableEntry {}))

(defui PokeTable
  Object
  (render [this]
    (dom/div nil
             (dom/table #js {:className "table table-hover"}
                        (dom/thead nil
                                   (dom/tr nil
                                           (dom/th nil "#")
                                           (dom/th nil "Name")
                                           (dom/th nil "Attack")
                                           (dom/th nil "Defense")
                                           (dom/th nil "Stamina")))
                        (apply dom/tbody nil
                               (map #(poketable-entry (lib/merge-react-key %)) (lib/inventory-pokemon)))))))
(def poketable (om/factory PokeTable {}))

(defui Main
  Object
  (render [this]
    (dom/div nil
             (dom/h1 nil "Poké-Crunsher")
             (dom/div nil (poketable (om/props this)))
             (dom/div nil (controls)))))


