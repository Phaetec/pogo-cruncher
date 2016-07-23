(ns cruncher.devcards.core
  (:require [devcards.core :refer-macros [defcard deftest]]
            [devcards-om-next.core :refer-macros [om-next-root defcard-om-next]]
            [cljs.test :refer-macros [is testing]]
            [cruncher.core]
            [cruncher.utils.lib :as lib]
            [cruncher.views :as views]))

(defcard-om-next poketable
                 "## Poketable"
                 views/PokeTable
                 lib/reconciler)