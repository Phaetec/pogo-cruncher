(ns cruncher.communication.auth
  (:require [ajax.core :refer [POST]]
            [cruncher.config :as config]
            [cruncher.communication.main :as com]
            [cruncher.communication.utils :as clib]
            [cruncher.utils.lib :as lib]))

(defn success-login
  "Callback function when login was successful. Set attributes of user."
  [response]
  (let [res (com/process-response response)]
    (if (= "ok" (:status res))
      (do
        (lib/no-error!)
        (lib/logged-in!)
        (lib/loading! false)
        (com/ajax-get (:get-player config/api) com/player-success-handler)
        (lib/change-view! :default))
      (do
        (lib/error! (:message res))
        (lib/loading! false)))))

(defn ajax-login
  "Get cleaned data and send ajax request."
  [email password location service]
  (lib/loading!)
  (let [url (:login config/api)]
    (POST (clib/make-url url)
          {:body            (clib/clj->json {:email    email
                                             :password password
                                             :location location
                                             :service  service})
           :handler         success-login
           :error-handler   com/error-handler
           :response-format :json
           :headers         {"Content-Type" "application/json"}
           :keywords?       true})))

(defn login
  "Use login form data, validate it and send ajax request."
  [email password location service]
  (when (and
          (pos? (count email))
          (pos? (count password))
          (pos? (count location))
          (pos? (count service)))
    (ajax-login email password location service)))