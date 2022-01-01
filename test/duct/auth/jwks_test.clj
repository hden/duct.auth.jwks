(ns duct.auth.jwks-test
  (:require [clojure.test :refer [deftest testing is]]
            [duct.auth.jwks]
            [integrant.core :as ig])
  (:import [java.security.interfaces RSAPublicKey]))

(def ^:private config {:domain "https://samples.auth0.com/"})
(def ^:private ^:const kid "NkJCQzIyQzRBMEU4NjhGNUU4MzU4RkY0M0ZDQzkwOUQ0Q0VGNUMwQg")

(deftest provider-test
  (testing "provider"
    (let [f (ig/init-key :duct.auth.jwks/provider config)
          key (f {:kid kid})]
      (is (instance? RSAPublicKey key))))

  (testing "key not found exception"
    (let [f (ig/init-key :duct.auth.jwks/provider config)]
      (is (thrown-with-msg? clojure.lang.ExceptionInfo #"Unauthorized."
                            (f {:kid "no such key"}))))))
