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

package io.fabric8.kubernetes.client.dsl.internal.certificates.v1;

import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestCondition;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestList;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestStatus;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestStatusBuilder;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.CertificateSigningRequestResource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;

public class CertificateSigningRequestOperationsImpl extends
    HasMetadataOperation<CertificateSigningRequest, CertificateSigningRequestList, CertificateSigningRequestResource<CertificateSigningRequest>>
    implements CertificateSigningRequestResource<CertificateSigningRequest> {
  public CertificateSigningRequestOperationsImpl(Client client) {
    this(HasMetadataOperationsImpl.defaultContext(client));
  }

  CertificateSigningRequestOperationsImpl(OperationContext context) {
    super(context.withApiGroupName("certificates.k8s.io")
        .withApiGroupVersion("v1")
        .withPlural("certificatesigningrequests"), CertificateSigningRequest.class, CertificateSigningRequestList.class);
  }

  @Override
  public CertificateSigningRequestOperationsImpl newInstance(OperationContext context) {
    return new CertificateSigningRequestOperationsImpl(context);
  }

  @Override
  public CertificateSigningRequest approve(CertificateSigningRequestCondition certificateSigningRequestCondition) {
    return addStatusToCSRAndSubmit(certificateSigningRequestCondition);
  }

  @Override
  public CertificateSigningRequest deny(CertificateSigningRequestCondition certificateSigningRequestCondition) {
    return addStatusToCSRAndSubmit(certificateSigningRequestCondition);
  }

  private CertificateSigningRequest addStatusToCSRAndSubmit(
      CertificateSigningRequestCondition certificateSigningRequestCondition) {
    CertificateSigningRequest fromServerCsr = get();
    fromServerCsr.setStatus(createCertificateSigningRequestStatus(certificateSigningRequestCondition));
    return newInstance(context.withSubresource("approval")).update(fromServerCsr);
  }

  private CertificateSigningRequestStatus createCertificateSigningRequestStatus(
      CertificateSigningRequestCondition certificateSigningRequestCondition) {
    return new CertificateSigningRequestStatusBuilder()
        .addToConditions(certificateSigningRequestCondition)
        .build();
  }
}
