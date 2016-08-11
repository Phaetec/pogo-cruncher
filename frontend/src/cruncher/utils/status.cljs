(ns cruncher.utils.status
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]
            [cljs.core.async :refer [<!]]
            [cruncher.communication.main :as com]
            [cruncher.config :as config]
            [cruncher.utils.extensions]
            [cruncher.utils.views :as vlib]
            [cruncher.utils.lib :as lib])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn success-handler []
  (om/transact! lib/reconciler `[(status/niantic {:status true})]))

(defn error-handler []
  (om/transact! lib/reconciler `[(status/niantic {:status false})]))

(defui APITest
  static om/IQuery
  (query [_]
    [:api :connected?])
  Object
  (render [this]
    (let [{:keys [connected?]} (om/props this)]
      (when (nil? connected?)
        (com/ajax-get (:api-status config/api) success-handler error-handler false))
      (dom/div nil
               (vlib/button (fn [] (com/ajax-get (:api-status config/api) success-handler error-handler false))
                            true "Test API" "btn-default btn-xs")
               (if connected?
                 (dom/span #js {:className "label label-success"} "API connected")
                 (dom/span #js {:className "label label-warning"} "API not connected"))))))
(def api-test (om/factory APITest {}))