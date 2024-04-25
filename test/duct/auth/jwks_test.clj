(ns duct.auth.jwks-test
  (:require [clojure.test :refer [deftest testing is]]
            [duct.auth.jwks :as jwks]
            [integrant.core :as ig])
  (:import [java.security.interfaces RSAPublicKey]))

(deftest domain-provider-test
  (let [config {:domain "https://samples.auth0.com/"}
        kid "NkJCQzIyQzRBMEU4NjhGNUU4MzU4RkY0M0ZDQzkwOUQ0Q0VGNUMwQg"]
    (testing "provider"
      (let [f   (ig/init-key ::jwks/provider config)
            key (f {:kid kid})]
        (is (instance? RSAPublicKey key))))

    (testing "key not found exception"
      (let [f (ig/init-key ::jwks/provider config)]
        (is (thrown-with-msg? clojure.lang.ExceptionInfo #"Unauthorized."
                              (f {:kid "no such key"})))))))

(deftest url-provider-test
  (let [config {:url "https://www.googleapis.com/oauth2/v3/certs"}
        kid "e1b93c640144b84bd05bf296d67262b6bc61a487"]
    (testing "provider"
      (let [f   (ig/init-key ::jwks/provider config)
            key (f {:kid kid})]
        (is (instance? RSAPublicKey key))))

    (testing "key not found exception"
      (let [f (ig/init-key ::jwks/provider config)]
        (is (thrown-with-msg? clojure.lang.ExceptionInfo #"Unauthorized."
                              (f {:kid "no such key"})))))))
