(defproject hden/duct.auth.jwks "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/hden/duct.auth.jwks"
  :license {:name "EPL-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [com.auth0/jwks-rsa "0.12.0"]
                 [integrant "0.8.0"]]
  :repl-options {:init-ns duct.auth.jwks}
  :profiles
  {:dev {:dependencies [[ring/ring-mock "0.3.2"]
                        [duct/middleware.buddy "0.1.0"
                         :exclusions [buddy/buddy-auth]]
                        [buddy/buddy-auth "2.2.0"]]}})
