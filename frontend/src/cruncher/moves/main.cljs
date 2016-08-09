(ns cruncher.moves.main
  (:require [cruncher.moves.data :as data]))

(defn get
  "Return move object from moves-database by the move id."
  [id]
  (id data/all))