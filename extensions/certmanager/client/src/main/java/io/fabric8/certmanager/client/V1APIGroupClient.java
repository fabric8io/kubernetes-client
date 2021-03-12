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
package io.fabric8.certmanager.client;

import io.fabric8.certmanager.api.model.acme.v1.Challenge;
import io.fabric8.certmanager.api.model.acme.v1.ChallengeList;
import io.fabric8.certmanager.api.model.acme.v1.Order;
import io.fabric8.certmanager.api.model.acme.v1.OrderList;
import io.fabric8.certmanager.api.model.v1.*;
import io.fabric8.certmanager.client.api.v1.internal.CertificateOperationsImpl;
import io.fabric8.certmanager.client.api.v1.internal.CertificateRequestOperationsImpl;
import io.fabric8.certmanager.client.api.v1.internal.ChallengeOperationsImpl;
import io.fabric8.certmanager.client.api.v1.internal.ClusterIssuerOperationsImpl;
import io.fabric8.certmanager.client.api.v1.internal.IssuerOperationsImpl;
import io.fabric8.certmanager.client.api.v1.internal.OrderOperationsImpl;
import io.fabric8.certmanager.client.dsl.V1APIGroupDSL;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import okhttp3.OkHttpClient;

public class V1APIGroupClient extends BaseClient implements V1APIGroupDSL {
  public V1APIGroupClient() {super();}

  public V1APIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<Certificate, CertificateList, Resource<Certificate>> certificates() {
    return new CertificateOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<CertificateRequest, CertificateRequestList, Resource<CertificateRequest>> certificateRequests() {
    return new CertificateRequestOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<Issuer, IssuerList, Resource<Issuer>> issuers() {
    return new IssuerOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public NonNamespaceOperation<ClusterIssuer, ClusterIssuerList, Resource<ClusterIssuer>> clusterIssuers() {
    return new ClusterIssuerOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<Challenge, ChallengeList, Resource<Challenge>> challenges() {
    return new ChallengeOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<Order, OrderList, Resource<Order>> orders() {
    return new OrderOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }
}
