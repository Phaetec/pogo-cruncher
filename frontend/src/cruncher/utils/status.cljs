(ns cruncher.utils.status
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]
            [cljs.core.async :refer [<!]]
            [cruncher.communication.main :as com]
            [cruncher.config :as config]
            [cruncher.utils.extensions]
            [cruncher.utils.lib :as lib])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn success-handler [this]
  (om/transact! this `[(status/niantic {:status true})]))

(defn query
  "Query API to find if I am still connected."
  [this]
  (com/ajax-get (:api-status config/api) #(success-handler this) com/error-handler false)
  (go (loop [_ 1]
        (<! (lib/timeout 120000))
        (com/ajax-get (:api-status config/api) #(success-handler this) com/error-handler false)
        (recur 1)))
  (dom/div nil))

(defui APIConnectedBadge
  static om/IQuery
  (query [_]
    [:connected?])
  Object
  (render [this]
    (let [{:keys [connected?]} (om/props this)]
      (dom/div nil
               #_(query this)
               (when-not connected?
                 (dom/img #js {:src "img/status/api_not_connected.svg"}))))))
(def api-connected-badge (om/factory APIConnectedBadge {}))