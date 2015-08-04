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
package io.fabric8.kubernetes.client.dsl.internal;

import com.ning.http.client.AsyncHttpClient;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.DoneableOAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeTokenList;

import java.net.URL;

public class OAuthAuthorizeTokenOperationsImpl extends HasMetadataOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken,
  Resource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken, Boolean>> {

  public OAuthAuthorizeTokenOperationsImpl(AsyncHttpClient httpClient, URL rootUrl) {
    super(httpClient, rootUrl, "oauthauthorizetokens", null, null);
  }

  public OAuthAuthorizeTokenOperationsImpl(AsyncHttpClient httpClient, URL rootUrl, String namespace, String name) {
    super(httpClient, rootUrl, "oauthauthorizetokens", namespace, name);
  }
}
