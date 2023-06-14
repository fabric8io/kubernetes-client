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
package io.fabric8.kubernetes.client.dsl.internal.core.v1;

import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.api.model.authentication.TokenRequest;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ServiceAccountResource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.utils.URLUtils;

import java.io.IOException;
import java.net.URL;

public class ServiceAccountOperationsImpl
    extends HasMetadataOperation<ServiceAccount, ServiceAccountList, ServiceAccountResource> implements ServiceAccountResource {
  public ServiceAccountOperationsImpl(Client client) {
    this(HasMetadataOperationsImpl.defaultContext(client));
  }

  private ServiceAccountOperationsImpl(OperationContext context) {
    super(context.withPlural("serviceaccounts"), ServiceAccount.class, ServiceAccountList.class);
  }

  @Override
  public ServiceAccountOperationsImpl newInstance(OperationContext context) {
    return new ServiceAccountOperationsImpl(context);
  }

  @Override
  public TokenRequest tokenRequest(TokenRequest tokenRequest) {
    return handleTokenRequest(tokenRequest);
  }

  private TokenRequest handleTokenRequest(TokenRequest tokenRequest) {
    try {
      URL requestUrl = new URL(URLUtils.join(getResourceUrl().toString(), "token"));

      HttpRequest.Builder requestBuilder = httpClient.newHttpRequestBuilder()
          .post(JSON, getKubernetesSerialization().asJson(tokenRequest)).url(requestUrl);
      return handleResponse(requestBuilder, TokenRequest.class);
    } catch (IOException exception) {
      throw KubernetesClientException.launderThrowable(forOperationType("token request"), exception);
    }
  }
}
