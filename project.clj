(defproject pattern-matching "0.1.0-SNAPSHOT"
  :description "Pattern mathching example"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [proto-repl "0.3.1"]
                 [org.clojure/core.match "0.3.0-alpha5"]]
  :main pattern-matching.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
