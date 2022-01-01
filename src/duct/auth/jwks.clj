(ns duct.auth.jwks
  (:require [integrant.core :as ig]
            [buddy.auth :refer [throw-unauthorized]])
  (:import [com.auth0.jwk JwkProviderBuilder SigningKeyNotFoundException]))

(defmethod ig/init-key :duct.auth.jwks/provider [_ {:keys [domain]}]
  (let [provider (.build (JwkProviderBuilder. ^String domain))]
    (fn [{:keys [kid]}]
      (when-not (string? kid)
        (throw-unauthorized))
      (try
        (.getPublicKey (.get provider ^String kid))
        (catch SigningKeyNotFoundException ex
          (throw-unauthorized (Throwable->map ex)))))))
