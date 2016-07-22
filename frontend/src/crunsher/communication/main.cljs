(ns crunsher.communication.main
  (:require [ajax.core :refer [GET POST]]
            [crunsher.communication.utils :as clib]
            [crunsher.utils.lib :as lib]))

;;;; Generic helpers
(defn process-response
  "Generic success handler, which sets error handling and returns a cljs-compatible response."
  [response]
  (lib/json->clj response))

;;;; Handlers
(defn error-handler
  "Generic error handler for ajax requests."
  [{:keys [status status-text]}]
  (.log js/console (str "I feel a disturbance in the Force... " status " " status-text)))

(defn success-handler
  "React on response after sending a new statement. Reset atom and call newly received url."
  [response]
  (let [res (process-response response)]
    (println res)))


;;;; Requests
(defn ajax-get
  "Make ajax call to dialogue based argumentation system."
  ([url handler]
   (GET (clib/make-url url)
        {:handler       handler
         :error-handler error-handler}))
  ([url]
   (ajax-get url success-handler)))