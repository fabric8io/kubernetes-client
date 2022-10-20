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
package io.fabric8.certmanager.client.dsl;

import io.fabric8.certmanager.api.model.acme.v1beta1.Challenge;
import io.fabric8.certmanager.api.model.acme.v1beta1.ChallengeList;
import io.fabric8.certmanager.api.model.acme.v1beta1.Order;
import io.fabric8.certmanager.api.model.acme.v1beta1.OrderList;
import io.fabric8.certmanager.api.model.v1beta1.*;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

public interface V1beta1APIGroupDSL extends Client {
  MixedOperation<Certificate, CertificateList, Resource<Certificate>> certificates();

  MixedOperation<CertificateRequest, CertificateRequestList, Resource<CertificateRequest>> certificateRequests();

  MixedOperation<Issuer, IssuerList, Resource<Issuer>> issuers();

  NonNamespaceOperation<ClusterIssuer, ClusterIssuerList, Resource<ClusterIssuer>> clusterIssuers();

  MixedOperation<Challenge, ChallengeList, Resource<Challenge>> challenges();

  MixedOperation<Order, OrderList, Resource<Order>> orders();
}
