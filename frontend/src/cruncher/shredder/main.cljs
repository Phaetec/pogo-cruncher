(ns cruncher.shredder.main
  (:require [ajax.core :refer [GET POST]]
            [goog.dom :as gdom]
            [cruncher.utils.lib :as lib]
            [cruncher.config :as config]
            [cruncher.communication.utils :as clib]
            [cruncher.communication.main :as com]))

(defn success-handler
  "React on response after sending a new statement. Reset atom and call newly received url."
  [response]
  (let [res (com/process-response response)]
    (lib/info! "Converted Pokemon to bonbons. Jeah!")))

(defn power-on
  "Crunch 'em all!"
  []
  (let [url (:crunch-selected-pokemon config/api)
        selected-pokemon (vec (map #(.. % -value) (filter #(.. % -checked) (gdom/getElementsByClass "poketable-checkbox"))))]
    (when (pos? (count selected-pokemon))
      (when (js/confirm "Do you really want to send away the selected Pokemon?\nYou won't get them back!\n\nConsider your decision.")
        (lib/loading!)
        (POST (clib/make-url url)
              {:body            (clib/clj->json {:ids selected-pokemon})
               :handler         success-handler
               :error-handler   com/error-handler
               :response-format :json
               :headers         {"Content-Type" "application/json"}
               :keywords?       true})))))