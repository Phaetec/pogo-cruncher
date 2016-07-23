(ns cruncher.config)

(def api {:host "http://localhost:5000/"
          :init "api/init/"
          :base "api/"
          :login "api/login"
          :get-all-pokemon "api/pokemon"
          :crunch-selected-pokemon "api/pokemon/delete"})