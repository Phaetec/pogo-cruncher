(ns crunsher.communication.utils
  (:require [crunsher.config :as config]))

(defn make-url
  "Prefix url with host."
  [url]
  (str (:host config/api) url))