(defproject hden/duct.auth.jwks "0.1.0"
  :description "FIXME: write description"
  :url "https://github.com/hden/duct.auth.jwks"
  :license {:name "EPL-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [buddy/buddy-sign "3.4.1"]
                 [com.auth0/jwks-rsa "0.19.0"]
                 [integrant "0.8.0"]]
  :repl-options {:init-ns duct.auth.jwks}
  :profiles
  {:dev {:dependencies [[ring/ring-mock "0.4.0"]
                        [duct/middleware.buddy "0.2.0"
                         :exclusions [buddy/buddy-auth]]
                        [buddy/buddy-auth "3.0.1"]]}})
