(ns cruncher.config)

(def api {:host                    (str "http://" (.. js/window -location -hostname) ":5000/")
          :init                    "api/init/"
          :base                    "api/"
          :login                   "api/login"
          :get-all-pokemon         "api/pokemon"
          :toggle-favorite         "api/pokemon/favorite"
          :crunch-selected-pokemon "api/pokemon/delete"
          :status-delete           "api/status/delete"
          :get-player              "api/player"
          :evolve-pokemon          "api/pokemon/evolve"})
