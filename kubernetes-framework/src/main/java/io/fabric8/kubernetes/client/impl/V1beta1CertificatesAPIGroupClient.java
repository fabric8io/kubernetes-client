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

import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestList;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.V1beta1CertificateSigningRequestResource;
import io.fabric8.kubernetes.client.dsl.V1beta1CertificatesAPIGroupDSL;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1beta1CertificatesAPIGroupClient extends ClientAdapter<V1beta1CertificatesAPIGroupClient>
    implements V1beta1CertificatesAPIGroupDSL {

  @Override
  public NonNamespaceOperation<CertificateSigningRequest, CertificateSigningRequestList, V1beta1CertificateSigningRequestResource<CertificateSigningRequest>> certificateSigningRequests() {
    return (NonNamespaceOperation<CertificateSigningRequest, CertificateSigningRequestList, V1beta1CertificateSigningRequestResource<CertificateSigningRequest>>) resources(
        CertificateSigningRequest.class, CertificateSigningRequestList.class,
        V1beta1CertificateSigningRequestResource.class);
  }

  @Override
  public V1beta1CertificatesAPIGroupClient newInstance() {
    return new V1beta1CertificatesAPIGroupClient();
  }
}
