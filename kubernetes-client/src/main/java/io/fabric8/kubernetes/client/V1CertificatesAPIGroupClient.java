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

import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestCondition;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestList;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.V1CertificatesAPIGroupDSL;
import okhttp3.OkHttpClient;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class V1CertificatesAPIGroupClient extends BaseClient implements V1CertificatesAPIGroupDSL {
  public V1CertificatesAPIGroupClient() {
    super();
  }

  public V1CertificatesAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public NonNamespaceOperation<CertificateSigningRequest, CertificateSigningRequestList, Resource<CertificateSigningRequest>> certificateSigningRequests() {
    return Handlers.getOperation(CertificateSigningRequest.class, CertificateSigningRequestList.class, httpClient, getConfiguration());
  }

  @Override
  public CertificateSigningRequest approve(CertificateSigningRequest csr, String name) {

    OffsetDateTime now = OffsetDateTime.now();
    List<CertificateSigningRequestCondition> csrc = new ArrayList<CertificateSigningRequestCondition>() {
      {
        add(new CertificateSigningRequestCondition(now.toString(), now.toString(), "", "Kubernetes Java Client", "True", "Approved"));
      }
    };
    csr.getStatus().setConditions(csrc);
    return csr;
  }
}
