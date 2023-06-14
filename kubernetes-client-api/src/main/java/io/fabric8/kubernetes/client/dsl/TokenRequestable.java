/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.authentication.TokenRequest;
import io.fabric8.kubernetes.api.model.authentication.TokenRequestBuilder;

public interface TokenRequestable {
  /**
   * Request a token to authenticate to the kubernetes api server as the given service account.
   * Creates an opinionated TokenRequest object with default expiration seconds time of 3600.
   *
   * @return TokenRequest object containing token in status
   */
  default TokenRequest tokenRequest() {
    return tokenRequest(new TokenRequestBuilder()
        .withNewSpec()
        .withExpirationSeconds(3600L)
        .endSpec()
        .build());
  }

  /**
   * Request a token to authenticate to the kubernetes api server as the given service account.
   *
   * @param tokenRequest TokenRequest
   * @return TokenRequest object containing token in status
   */
  TokenRequest tokenRequest(TokenRequest tokenRequest);
}
