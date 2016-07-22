(ns crunsher.communication.auth
  (:require [ajax.core :refer [POST]]
            [goog.crypt.base64 :as gtfo]
            [crunsher.communication.utils :as com]
            [crunsher.config :as config]
            [crunsher.debug :as debug]
            [crunsher.utils.common :as lib]
            [crunsher.communication.main :as com]
            [crunsher.communication.utils :as clib]
            ))

(defn success-login
  "Callback function when login was successful. Set attributes of user."
  [response]
  (let [res (com/process-response response)]
    (println "Successfully logged in." res)))

(defn ajax-login
  "Get cleaned data and send ajax request."
  [nickname password]
  (let [url (str (:base config/api) "login")]
    (POST (clib/make-url url)
          {:body            (clib/clj->json {:nickname nickname
                                            :password password})
           :handler         success-login
           :error-handler   com/error-handler
           :response-format :json
           :headers         {"Content-Type" "application/json"}
           :keywords?       true})))

(defn login
  "Use login form data, validate it and send ajax request."
  [nickname password]
  (when (and
          (pos? (count nickname))
          (pos? (count password)))
    (ajax-login nickname password)))