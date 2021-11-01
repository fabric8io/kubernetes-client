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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestList;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.V1beta1CertificatesAPIGroupDSL;
import io.fabric8.kubernetes.client.http.HttpClient;

public class V1beta1CertificatesAPIGroupClient extends BaseClient implements V1beta1CertificatesAPIGroupDSL {
  public V1beta1CertificatesAPIGroupClient() {
    super();
  }

  public V1beta1CertificatesAPIGroupClient(HttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public NonNamespaceOperation<CertificateSigningRequest, CertificateSigningRequestList, Resource<CertificateSigningRequest>> certificateSigningRequests() {
    return Handlers.getOperation(CertificateSigningRequest.class, CertificateSigningRequestList.class, httpClient, getConfiguration());
  }
}
