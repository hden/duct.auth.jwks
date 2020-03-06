(ns duct.auth.jwks
  (:require [integrant.core :as ig]
            [buddy.sign.jws :as jws])
  (:import [com.auth0.jwk JwkProviderBuilder]))

(defn create-provider [{:keys [domain]}]
  (.build (JwkProviderBuilder. domain)))

(defmethod ig/init-key :duct.auth.jwks/provider
  [_ config]
  (let [provider (create-provider config)]
    (fn [{:keys [kid]}]
      (.getPublicKey (.get provider kid)))))
