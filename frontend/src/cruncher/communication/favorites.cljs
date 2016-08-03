(ns cruncher.communication.favorites
  (:require [ajax.core :refer [POST]]
            [cruncher.utils.lib :as lib]
            [cruncher.config :as config]
            [cruncher.communication.utils :as clib]
            [cruncher.communication.main :as com]))

(defn success-handler [response]
  (let [res (com/process-response response)]
    (let [col (map-indexed vector (get-in @lib/app-state [:pokemon]))
          [index] (doall (for [[index pokemon] col :when (= (:id pokemon) (:id res))] index))
          new-col (update-in (vec (get-in @lib/app-state [:pokemon])) [index :favorite] (constantly (:set_favorite res)))]
      (lib/update-pokemon! new-col))))

(defn error-handler [response]
  (let [res (com/process-response response)]
    (lib/error! (:message res))))

(defn post-favorite
  "Get cleaned data and send ajax request."
  [id favorite]
  (lib/loading!)
  (let [url (:toggle-favorite config/api)]
    (POST (clib/make-url url)
          {:body            (clib/clj->json {:id id
                                             :set_favorite favorite})
           :handler         success-handler
           :error-handler   error-handler
           :response-format :json
           :headers         {"Content-Type" "application/json"}
           :keywords?       true})))

(defn toggle-favorite
  "Mark / Unmark Pokemon as favorite."
  [id favorite]
  (post-favorite id (not favorite)))