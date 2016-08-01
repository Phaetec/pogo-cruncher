(ns cruncher.communication.main
  (:require [ajax.core :refer [GET POST]]
            [cruncher.communication.utils :as clib]
            [cruncher.config :as config]
            [cruncher.utils.lib :as lib]))

;;;; Generic helpers
(defn process-response
  "Generic success handler, which sets error handling and returns a cljs-compatible response."
  [response]
  (lib/loading! false)
  (clib/json->clj response))


;;;; Handlers
(defn error-handler
  "Generic error handler for ajax requests."
  [{:keys [status status-text]}]
  (lib/loading! false)
  (.log js/console (str "Seems like you're not catching 'em all any more... " status " " status-text)))

(defn success-handler
  "React on response after sending a new statement. Reset atom and call newly received url."
  [response]
  (let [res (process-response response)]
    (lib/update-pokemon! res)))


;;;; Requests
(defn ajax-get
  "Make ajax call to defined server in config."
  ([url success-handler error-handler]
   (lib/loading!)
   (GET (clib/make-url url)
        {:handler       success-handler
         :error-handler error-handler}))
  ([url success-handler] (ajax-get url success-handler error-handler))
  ([url] (ajax-get url success-handler)))


;;;; Routes
(defn route
  "Dispatch routes for ajax calls. Based on the URLs defined in the config file."
  [key]
  (cond
    (= :init key) (ajax-get (:init config/api))
    (= :get-all-pokemon key) (ajax-get (:get-all-pokemon config/api))))