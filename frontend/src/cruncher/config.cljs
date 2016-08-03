(ns cruncher.config)

(def api {:host "http://0.0.0.0:5000/"
          :init "api/init/"
          :base "api/"
          :login "api/login"
          :get-all-pokemon "api/pokemon"
          :toggle-favorite "api/pokemon/favorite"
          :crunch-selected-pokemon "api/pokemon/delete"
          :status-delete "api/status/delete"})
