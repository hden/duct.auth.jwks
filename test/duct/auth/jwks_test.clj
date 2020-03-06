(ns duct.auth.jwks-test
  (:require [clojure.test :refer :all]
            [duct.auth.jwks :refer :all]
            [duct.middleware.buddy :as buddy]
            [integrant.core :as ig]
            [ring.mock.request :as mock])
  (:import [com.auth0.jwk Jwk]))

(deftest provider-test
  (testing "create-provider"
    (let [provider (create-provider {:domain "https://samples.auth0.com/"})]
      (is (instance? Jwk (.get provider "NkJCQzIyQzRBMEU4NjhGNUU4MzU4RkY0M0ZDQzkwOUQ0Q0VGNUMwQg"))))))
