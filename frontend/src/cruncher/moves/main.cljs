(ns cruncher.moves.main
  (:require [cruncher.moves.data :as data]))

(defn get-name
  "Return move object from moves-database by the move id."
  [id]
  (:name (get data/all id)))