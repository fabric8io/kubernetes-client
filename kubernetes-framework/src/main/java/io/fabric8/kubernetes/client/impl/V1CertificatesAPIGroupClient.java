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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestList;
import io.fabric8.kubernetes.client.dsl.CertificateSigningRequestResource;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.V1CertificatesAPIGroupDSL;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1CertificatesAPIGroupClient extends ClientAdapter<V1CertificatesAPIGroupClient>
    implements V1CertificatesAPIGroupDSL {

  @Override
  public NonNamespaceOperation<CertificateSigningRequest, CertificateSigningRequestList, CertificateSigningRequestResource<CertificateSigningRequest>> certificateSigningRequests() {
    // we need the cast to satisfy java 8
    return (NonNamespaceOperation<CertificateSigningRequest, CertificateSigningRequestList, CertificateSigningRequestResource<CertificateSigningRequest>>) resources(
        CertificateSigningRequest.class, CertificateSigningRequestList.class,
        CertificateSigningRequestResource.class);
  }

  @Override
  public V1CertificatesAPIGroupClient newInstance() {
    return new V1CertificatesAPIGroupClient();
  }

}
