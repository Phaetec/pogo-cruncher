(ns crunsher.communication.auth
  (:require [ajax.core :refer [POST]]
            [crunsher.config :as config]
            [crunsher.communication.main :as com]
            [crunsher.communication.utils :as clib]))

(defn success-login
  "Callback function when login was successful. Set attributes of user."
  [response]
  (let [res (com/process-response response)]
    (println "Successfully logged in." res)))

(defn ajax-login
  "Get cleaned data and send ajax request."
  [email password location]
  (let [url (:login config/api)]
    (POST (clib/make-url url)
          {:body            (clib/clj->json {:email email
                                             :password password
                                             :location location})
           :handler         success-login
           :error-handler   com/error-handler
           :response-format :json
           :headers         {"Content-Type" "application/json"}
           :keywords?       true})))

(defn login
  "Use login form data, validate it and send ajax request."
  [email password location]
  (when (and
          (pos? (count email))
          (pos? (count password))
          (pos? (count location)))
    (ajax-login email password location)))