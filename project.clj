(defproject org.cyverse/clojure-commons "3.0.11"
  :description "Common Utilities for Clojure Projects"
  :url "https://github.com/cyverse-de/clojure-commons"
  :license {:name "BSD"
            :url "https://cyverse.org/license"}
  :eastwood {:exclude-namespaces [:test-paths]
             :linters [:wrong-arity :wrong-ns-form :wrong-pre-post :wrong-tag :misplaced-docstrings]}
  :plugins [[com.github.clj-kondo/lein-clj-kondo "2025.02.20"]
            [jonase/eastwood "1.4.3"]
            [lein-ancient "0.7.0"]
            [test2junit "1.4.4"]]
  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]]
  :dependencies [[org.clojure/clojure "1.11.3"]
                 [org.clojure/tools.logging "1.3.0"]
                 [buddy/buddy-sign "3.5.351"]
                 [metosin/compojure-api "1.1.14"]
                 [cheshire "5.13.0"]
                 [clj-http "3.13.0"]
                 [clj-time "0.15.2"]
                 [clojurewerkz/propertied "1.3.0"]
                 [com.cemerick/url "0.1.1" :exclusions [com.cemerick/clojurescript.test]]
                 [commons-configuration "1.10"    ; provides org.apache.commons.configuration
                  :exclusions [commons-logging]]
                 [io.github.clj-kondo/config-slingshot-slingshot "1.0.0"]
                 [me.raynes/fs "1.4.6"]
                 [medley "1.4.0"]
                 [slingshot "0.12.2"]
                 [trptcolin/versioneer "0.2.0"]
                 [org.cyverse/service-logging "2.8.4"]]
  :profiles {:test {:resource-paths ["resources" "test-resources"]}})
