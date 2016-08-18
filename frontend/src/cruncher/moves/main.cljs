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
  (get data/all id))

(defn get-move-dps
  "Return the Damage per Second value for the quick move of the Pokmeon."
  [move pokemon]
  (let [pokemon-data (get pokemon-db/all (:pokemon_id pokemon))
        type-1 (first (:type-1 pokemon-data))
        type-2 (first (:type-2 pokemon-data))
        STAB (if (or (= type-1 (:type move)) (= type-2 (:type move)))
               1.25
               1)]
    (print type-1 " - " type-2 " - Move-Type: " (:type move))
    (pprint/cl-format nil "~,2f" (/ (* (:power move) 1000 STAB) (:duration-ms move)))))