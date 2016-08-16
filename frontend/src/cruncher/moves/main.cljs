(ns cruncher.moves.main
  (:require [cruncher.moves.data :as data]))

(defn get-name
  "Return move object from moves-database by the move id."
  [id]
  (:name (get data/all id)))

(defn get-move
  "Return complete move by its id"
  [id]
  (get data/all id))