(ns cruncher.shredder.main
  (:require [ajax.core :refer [GET POST]]
            [goog.dom :as gdom]
            [cruncher.utils.lib :as lib]
            [cruncher.config :as config]
            [cruncher.communication.utils :as clib]
            [cruncher.communication.main :as com]
            [cruncher.communication.progress :as progress]
            [cruncher.selections :as selections]
            [cruncher.utils.views :as vlib]))

(defn success-handler
  "React on response after sending a new statement. Reset atom and call newly received url."
  [response]
  (lib/update-progress-status! {:status "finished", :to_delete 1, :deleted 1})
  (com/route :get-all-pokemon))

(defn power-on
  "Crunch 'em all!"
  [this]
  (selections/unselect-favorites)
  (let [url (:crunch-selected-pokemon config/api)
        selected-pokemon (vlib/get-selected-pokemon)]
    (when (pos? (count selected-pokemon))
      (when (js/confirm "Do you really want to send away the selected Pokemon?\nYou won't get them back!\n\nConsider your decision.")
        (lib/loading!)
        (lib/update-progress-status! {:status "ok", :to_delete (count selected-pokemon), :deleted 0})
        (progress/query-status this)
        (POST (clib/make-url url)
              {:body            (clib/clj->json {:ids selected-pokemon
                                                 :safe 1})
               :handler         success-handler
               :error-handler   com/error-handler
               :response-format :json
               :headers         {"Content-Type" "application/json"}
               :keywords?       true})))))