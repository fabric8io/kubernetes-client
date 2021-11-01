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
package io.fabric8.openshift.client.dsl.internal.oauth;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeTokenBuilder;
import io.fabric8.openshift.api.model.OAuthAuthorizeTokenList;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.internal.OpenShiftOperation;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.OAUTH;

public class OAuthAuthorizeTokenOperationsImpl extends OpenShiftOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList,
  Resource<OAuthAuthorizeToken>> {

  public OAuthAuthorizeTokenOperationsImpl(HttpClient client, OpenShiftConfig config) {
    this(new OperationContext().withHttpClient(client).withConfig(config));
  }

  public OAuthAuthorizeTokenOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(OAUTH)
      .withPlural("oauthauthorizetokens"), OAuthAuthorizeToken.class, OAuthAuthorizeTokenList.class);
  }

  @Override
  public OAuthAuthorizeTokenOperationsImpl newInstance(OperationContext context) {
    return new OAuthAuthorizeTokenOperationsImpl(context);
  }

  @Override
  protected VisitableBuilder<OAuthAuthorizeToken, ?> createVisitableBuilder(OAuthAuthorizeToken item) {
    return new OAuthAuthorizeTokenBuilder(item);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}
