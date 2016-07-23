(ns cruncher.shredder.main
  (:require [cruncher.utils.lib :as lib]
            [cruncher.config :as config]
            [cruncher.communication.utils :as clib]
            [cruncher.communication.main :as com]))

(defn success-handler
  "React on response after sending a new statement. Reset atom and call newly received url."
  [response]
  (let [res (com/process-response response)]
    (println "Crunched!" res)))

(defn power-on
  "Crunch 'em all!"
  []
  (if true
    (println "Not implemented")
    (do
      (lib/loading!)
      (let [url (:crunch-selected-pokemon config/api)
            ;; TODO
            ;; (reduce #(conj [] (.. % -value)) (gdom/getElementsByClass "poketable-checkbox"))
            ;; BUT select only the checked ones
            selected-pokemon []]
        (POST (clib/make-url url)
              {:body            (clib/clj->json {:ids selected-pokemon})
               :handler         success-handler
               :error-handler   com/error-handler
               :response-format :json
               :headers         {"Content-Type" "application/json"}
               :keywords?       true})))))
