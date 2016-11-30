(ns cruncher.moves.main
  (:require [cruncher.moves.data :as data]
            [cruncher.data.pokemon :as pokemon-db]
            [cljs.pprint :as pprint]))

(defn get-name
  "Return move object from moves-database by the move id."
  [id]
  (:name (get data/all id)))

(defn get-move
  "Return complete move by its id."
  [id]
  (if-let [move (get data/all id)]
    move
    {:id -1, :vfx-name "not_found", :name (str "Not found: " id), :type "dummy", :unique-id "V0000_DUMMY", :energy-delta -1, :accuracy-change -1, :duration-ms -1, :power -1, :animation-id -1,:damage-window-end-ms -1, :trainer-level-min 1, :critical-chance 0}))

(defn get-move-dps
  "Return the Damage per Second value for the quick move of the Pokmeon."
  [move pokemon]
  (let [pokemon-data (get pokemon-db/all (:pokemon_id pokemon))
        type-1 (first (:type-1 pokemon-data))
        type-2 (first (:type-2 pokemon-data))
        STAB (if (or (= type-1 (:type move)) (= type-2 (:type move)))
               1.25
               1)]
    (pprint/cl-format nil "~,2f" (/ (* (:power move) 1000 STAB) (:duration-ms move)))))