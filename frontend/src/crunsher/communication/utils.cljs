(ns crunsher.communication.utils
  (:require [crunsher.config :as config]
            [clojure.walk :refer [keywordize-keys]]
            [cognitect.transit :as transit]))

(defn make-url
  "Prefix url with host."
  [url]
  (str (:host config/api) url))


;;;; Conversions
(defn clj->json
  "Convert CLJS to valid JSON."
  [col]
  (.stringify js/JSON (clj->js col)))

(defn json->clj
  "Use cognitec's transit reader for json to convert it to proper Clojure datastructures."
  [response]
  (keywordize-keys response)
  #_(let [r (transit/reader :json)]
    (keywordize-keys (transit/read r response))))