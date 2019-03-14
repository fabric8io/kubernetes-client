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

import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;
import io.fabric8.openshift.api.model.DoneableOAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAccessTokenList;
import io.fabric8.openshift.client.OpenShiftConfig;


import static io.fabric8.openshift.client.OpenShiftAPIGroups.OAUTH;

public class OAuthAccessTokenOperationsImpl extends OpenShiftOperation<OAuthAccessToken, OAuthAccessTokenList, DoneableOAuthAccessToken,
  Resource<OAuthAccessToken, DoneableOAuthAccessToken>> {

  public OAuthAccessTokenOperationsImpl(OkHttpClient client, OpenShiftConfig config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public OAuthAccessTokenOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(OAUTH)
      .withPlural("oauthaccesstokens"));
    this.type = OAuthAccessToken.class;
    this.listType = OAuthAccessTokenList.class;
    this.doneableType = DoneableOAuthAccessToken.class;
  }

  @Override
  public OAuthAccessTokenOperationsImpl newInstance(OperationContext context) {
    return new OAuthAccessTokenOperationsImpl(context);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}
