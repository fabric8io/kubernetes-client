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

import io.fabric8.certmanager.api.model.acme.v1alpha2.Challenge;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ChallengeList;
import io.fabric8.certmanager.api.model.acme.v1alpha2.Order;
import io.fabric8.certmanager.api.model.acme.v1alpha2.OrderList;
import io.fabric8.certmanager.api.model.v1alpha2.Certificate;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateList;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateRequest;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateRequestList;
import io.fabric8.certmanager.api.model.v1alpha2.ClusterIssuer;
import io.fabric8.certmanager.api.model.v1alpha2.ClusterIssuerList;
import io.fabric8.certmanager.api.model.v1alpha2.Issuer;
import io.fabric8.certmanager.api.model.v1alpha2.IssuerList;
import io.fabric8.certmanager.client.dsl.V1alpha2APIGroupDSL;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.http.HttpClient;

public class V1alpha2APIGroupClient extends BaseClient implements V1alpha2APIGroupDSL {
  public V1alpha2APIGroupClient() {
    super();
  }

  public V1alpha2APIGroupClient(HttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<Certificate, CertificateList, Resource<Certificate>> certificates() {
    return Handlers.getOperation(Certificate.class, CertificateList.class, this.getHttpClient(),  this.getConfiguration());
  }

  @Override
  public MixedOperation<CertificateRequest, CertificateRequestList, Resource<CertificateRequest>> certificateRequests() {
    return Handlers.getOperation(CertificateRequest.class, CertificateRequestList.class, this.getHttpClient(),  this.getConfiguration());
  }

  @Override
  public MixedOperation<Issuer, IssuerList, Resource<Issuer>> issuers() {
    return Handlers.getOperation(Issuer.class, IssuerList.class, this.getHttpClient(),  this.getConfiguration());
  }

  @Override
  public NonNamespaceOperation<ClusterIssuer, ClusterIssuerList, Resource<ClusterIssuer>> clusterIssuers() {
    return Handlers.getOperation(ClusterIssuer.class, ClusterIssuerList.class, this.getHttpClient(),  this.getConfiguration());
  }

  @Override
  public MixedOperation<Challenge, ChallengeList, Resource<Challenge>> challenges() {
    return Handlers.getOperation(Challenge.class, ChallengeList.class, this.getHttpClient(),  this.getConfiguration());
  }

  @Override
  public MixedOperation<Order, OrderList, Resource<Order>> orders() {
    return Handlers.getOperation(Order.class, OrderList.class, this.getHttpClient(),  this.getConfiguration());
  }
}
