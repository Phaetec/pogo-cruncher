(ns cruncher.config)

(defn get-location []
  (let [hostname (.. js/window -location -hostname)]
    (if (or (nil? hostname)
            (= "" hostname))
      "localhost"
      hostname)))

(def api {:host                    (str "http://" (get-location) ":5000/")
          :init                    "api/init/"
          :base                    "api/"
          :login                   "api/login"
          :get-all-pokemon         "api/pokemon"
          :toggle-favorite         "api/pokemon/favorite"
          :crunch-selected-pokemon "api/pokemon/delete"
          :rename-selected-pokemon "api/pokemon/rename"
          :status-delete           "api/status/delete"
          :get-player              "api/player"
          :evolve-pokemon          "api/pokemon/evolve"
          :upgrade-pokemon         "api/pokemon/upgrade"})
