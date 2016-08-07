(ns cruncher.communication.main
  (:require [ajax.core :refer [GET POST]]
            [cruncher.communication.utils :as clib]
            [cruncher.config :as config]
            [cruncher.utils.lib :as lib]))

;;;; Generic helpers
(defn something-went-wrong?
  "Given a status message from the API, show an error message. Returns a boolean indicating errors."
  [status message]
  (if (= "error" status)
    (do (lib/error! message)
        true)
    (do (lib/no-error!)
        false)))

(defn process-response
  "Generic success handler, which sets error handling and returns a cljs-compatible response."
  [response]
  (lib/loading! false)
  (clib/json->clj response))


;;;; Handlers
(defn error-handler
  "Generic error handler for ajax requests."
  [response]
  (let [res (process-response response)
        status-text (:status-text res)]
    (if (= "Request failed" status-text)
      (lib/error! "Could not reach our API. Maybe it is offline? Try to access http://localhost:5000")
      (lib/error! (:message res)))
    (.log js/console (str "Seems like you're not catching 'em all any more... " (:message res) status-text))))

(defn success-handler
  "React on response after sending a new statement. Reset atom and call newly received url."
  [response]
  (let [res (process-response response)
        errors? (something-went-wrong? (:status res) (:message res))]
    (when-not errors?
      (lib/update-pokemon! res)
      (lib/update-evolution-amount! res))))

(defn player-success-handler
  "React upon the receival of updated playerdata. Insert Information into app-state atom."
  [response]
  (let [res (process-response response)
        errors? (something-went-wrong? (:status res) (:message res))]
    (when-not errors?
      (lib/update-player! res))))


;;;; Requests
(defn ajax-get
  "Make ajax call to defined server in config."
  ([url success-handler error-handler toggle-loading?]
   (when toggle-loading?
     (lib/loading!))
   (GET (clib/make-url url)
        {:handler       success-handler
         :error-handler error-handler}))
  ([url success-handler] (ajax-get url success-handler error-handler true))
  ([url] (ajax-get url success-handler)))


;;;; Routes
(defn route
  "Dispatch routes for ajax calls. Based on the URLs defined in the config file."
  [key]
  (cond
    (= :init key) (ajax-get (:init config/api))
    (= :get-all-pokemon key) (ajax-get (:get-all-pokemon config/api))))