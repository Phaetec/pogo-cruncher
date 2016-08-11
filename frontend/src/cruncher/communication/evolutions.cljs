(ns cruncher.communication.evolutions
  (:require [ajax.core :refer [GET POST]]
            [goog.dom :as gdom]
            [cruncher.utils.lib :as lib]
            [cruncher.config :as config]
            [cruncher.communication.utils :as clib]
            [cruncher.communication.main :as com]
            [cruncher.communication.progress :as progress]
            [cruncher.selections :as selections]))

(defn success-handler [response]
  (com/ajax-get (:get-all-pokemon config/api)))

(defn error-handler [response]
  (let [res (com/process-response response)]
    (lib/error! (:message res))))

(defn evolve
  "Get cleaned data and send ajax request."
  [id]
  (lib/loading!)
  (let [url (:evolve-pokemon config/api)]
    (POST (clib/make-url url)
          {:body            (clib/clj->json {:id id})
           :handler         success-handler
           :error-handler   error-handler
           :response-format :json
           :headers         {"Content-Type" "application/json"}
           :keywords?       true})))
