 (ns cruncher.rename
   (:require [om.next :as om :refer-macros [defui]]
             [om.dom :as dom :include-macros true]
             [goog.dom :as gdom]
             [cruncher.utils.views :as vlib]
             [cruncher.utils.lib :as lib]))


(defui RenamingControls
       Object
       (render [this]
               (dom/div nil
                        (dom/p #js {:className "lead"} "Rename Pokemon")
                        "hm?")))
(def controls (om/factory RenamingControls))