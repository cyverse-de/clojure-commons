(defproject org.cyverse/clojure-commons "3.0.8-SNAPSHOT"
  :description "Common Utilities for Clojure Projects"
  :url "https://github.com/cyverse-de/clojure-commons"
  :license {:name "BSD"
            :url "https://cyverse.org/license"}
  :eastwood {:exclude-namespaces [:test-paths]
             :linters [:wrong-arity :wrong-ns-form :wrong-pre-post :wrong-tag :misplaced-docstrings]}
  :plugins [[jonase/eastwood "0.3.5"]
            [test2junit "1.2.2"]]
  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]]
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/tools.logging "1.0.0"]
                 [buddy/buddy-sign "3.1.0"]
                 [metosin/compojure-api "1.1.13"]
                 [cheshire "5.10.0"]
                 [clj-http "3.10.0"]
                 [clj-time "0.15.2"]
                 [clojurewerkz/propertied "1.3.0"]
                 [com.cemerick/url "0.1.1" :exclusions [com.cemerick/clojurescript.test]]
                 [commons-configuration "1.10"    ; provides org.apache.commons.configuration
                  :exclusions [commons-logging]]
                 [me.raynes/fs "1.4.6"]
                 [medley "1.2.0"]
                 [slingshot "0.12.2"]
                 [trptcolin/versioneer "0.2.0"]
                 [org.cyverse/service-logging "2.8.2"]]
  :profiles {:test {:resource-paths ["resources" "test-resources"]}})
