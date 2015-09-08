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
package io.fabric8.openshift.client.dsl.internal;

import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.openshift.api.model.DoneableOAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeTokenList;
import io.fabric8.openshift.client.OpenShiftClient;

public class OAuthAuthorizeTokenOperationsImpl extends OpenshiftOperation<OpenShiftClient, OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken,
  ClientResource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken>> {

  public OAuthAuthorizeTokenOperationsImpl(OpenShiftClient client) {
    super(client, "oauthauthorizetokens", null, (String) null);
  }

  public OAuthAuthorizeTokenOperationsImpl(OpenShiftClient client, String namespace, String name) {
    super(client, "oauthauthorizetokens", namespace, name);
  }

  public OAuthAuthorizeTokenOperationsImpl(OpenShiftClient client, String namespace, OAuthAuthorizeToken o) {
    super(client, "oauthauthorizetokens", namespace, o);
  }
}
