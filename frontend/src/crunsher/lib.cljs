(ns crunsher.lib
  (:require [om.next :as om]
            [clojure.walk :refer [keywordize-keys]]
            [cognitect.transit :as transit]))

(def app-state
  (atom
    {:pokemon [{:pokemon_id         4
                :id                 (rand-int 9999999999999999)
                :individual_attack  10
                :individual_defense 10
                :individual_stamina 10
                :name               "Glumanda"}
               {:pokemon_id         25
                :id                 (rand-int 9999999999999999)
                :individual_attack  10
                :individual_defense 10
                :individual_stamina 10
                :name               "Pikachu"}]}))


;;;; React compatibility
(defonce counter (atom 0))

(defn get-unique-key
  "Return unique react-key."
  []
  (str "crunsher-unique-react-key-" (swap! counter inc)))

(defn merge-react-key
  "Get a unique key, create a small map with :react-key property and merge it with the given collection."
  [col]
  (merge {:react-key (get-unique-key)} col))


;;;; Reconciler action
(defmulti read (fn [env key params] key))

(defmethod read :default
  [{:keys [state] :as env} key params]
  (let [st @state]
    (if-let [[_ value] (find st key)]
      {:value value}
      {:value :not-found})))

(defmulti mutate om/dispatch)

#_(defmethod mutate 'color/temp
    [{:keys [state]} _ {:keys [color]}]
    {:action (fn [] (swap! state update-in [:user :selected-color] (fn [] color)))})

#_(defmethod mutate 'color/set
    [{:keys [state]} _ {:keys [name field]}]
    (let [color (get-selected-color)]
      {:action (fn [] (swap! state update-in [:scarf field] (fn [] color)))}))

(defonce reconciler
         (om/reconciler
           {:state  app-state
            :parser (om/parser {:read read :mutate mutate})}))


;;;; Get stuff
(defn inventory-pokemon
  "Return all pokemon which are currently stored."
  []
  (get-in @app-state [:pokemon]))


;;;; Conversions
(defn json->clj
  "Use cognitec's transit reader for json to convert it to proper Clojure datastructures."
  [response]
  (let [r (transit/reader :json)]
    (keywordize-keys (transit/read r response))))