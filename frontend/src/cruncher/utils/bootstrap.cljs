(ns cruncher.utils.bootstrap
  (:require [om.dom :as dom]))

(defn row
  [& content]
  (dom/div #js {:className "row"}
           content))

(defn col
  [size & content]
  (dom/div #js {:className (str "col-md-" size)}
           content))