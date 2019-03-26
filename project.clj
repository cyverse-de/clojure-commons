(defproject org.cyverse/clojure-commons "3.0.3-SNAPSHOT"
  :description "Common Utilities for Clojure Projects"
  :url "https://github.com/cyverse-de/iplant-clojure-commons"
  :license {:name "BSD"
            :url "http://iplantcollaborative.org/sites/default/files/iPLANT-LICENSE.txt"}
  :eastwood {:exclude-namespaces [:test-paths]
             :linters [:wrong-arity :wrong-ns-form :wrong-pre-post :wrong-tag :misplaced-docstrings]}
  :plugins [[jonase/eastwood "0.3.5"]
            [test2junit "1.2.2"]]
  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]]
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/tools.logging "0.4.1"]
                 [buddy/buddy-sign "0.7.0"]
                 [metosin/compojure-api "1.1.12"]
                 [cheshire "5.8.1"]
                 [clj-http "3.9.1"]
                 [clj-time "0.15.1"]
                 [com.cemerick/url "0.1.1" :exclusions [com.cemerick/clojurescript.test]]
                 [commons-configuration "1.10"    ; provides org.apache.commons.configuration
                  :exclusions [commons-logging]]
                 [me.raynes/fs "1.4.6"]
                 [medley "1.1.0"]
                 [slingshot "0.12.2"]
                 [trptcolin/versioneer "0.2.0"]
                 [org.cyverse/service-logging "2.8.0"]]
  :profiles {:test {:resource-paths ["resources" "test-resources"]}})
