(ns crunsher.devcards.core
  (:require [devcards.core :refer-macros [defcard deftest]]
            [devcards-om-next.core :refer-macros [om-next-root defcard-om-next]]
            [cljs.test :refer-macros [is testing]]
            [crunsher.core]
            [crunsher.utils.lib :as lib]
            [crunsher.views :as views]))

(defcard-om-next poketable
                 "## Poketable"
                 views/PokeTable
                 lib/reconciler)