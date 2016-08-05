(ns cruncher.config)

(def api {:host "http://localhost:5000/"
          :init "api/init/"
          :base "api/"
          :login "api/login"
          :get-all-pokemon "api/pokemon"
          :toggle-favorite "api/pokemon/favorite"
          :crunch-selected-pokemon "api/pokemon/delete"
          :status-delete "api/status/delete"
          :get-player "api/player"})
