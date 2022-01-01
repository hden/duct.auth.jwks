# duct.auth.jwks [![CircleCI](https://circleci.com/gh/hden/duct.auth.jwks.svg?style=svg)](https://circleci.com/gh/hden/duct.auth.jwks)

A Duct library to retrieve RSA public keys from a JWKS (JSON Web Key Set) endpoint.

## Installation

To install, add the following to your project `:dependencies`:

```
[hden/duct.auth.jwks "0.2.0"]
```

## Usage

This library currently only supports a single Integrant key: `:duct.auth.jwks/provider`. This keyword wraps the [jwks-rsa-java](https://github.com/auth0/jwks-rsa-java) library. The domain  is denoted by a keyword on the `:domain` key:

```clojure
{:duct.middleware.buddy/authentication
 {:backend :jws
  :token-name "Bearer"
  :options {:alg :rs256}
  :secret #ig/ref :duct.auth.jwks/provider
  :authfn #ig/ref :example.auth/auth-function}

 :duct.auth.jwks/provider
 {:domain "https://samples.auth0.com/"}

 :example.auth/auth-function {}}
```

## License

Copyright © 2020 Haokang Den

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.
