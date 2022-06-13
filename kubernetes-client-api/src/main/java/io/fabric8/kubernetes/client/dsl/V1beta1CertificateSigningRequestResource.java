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
package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestCondition;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestConditionBuilder;

public interface V1beta1CertificateSigningRequestResource<T> extends Resource<T> {

  /**
   * Deny a given CertificateSigningRequest.
   *
   * Creates an opinionated CertificateSigningRequestCondition while denying
   * provided CertificateSigningRequest
   *
   * @return updated CertificateSigningRequest from Kubernetes ApiServer
   */
  default T deny() {
    return deny(new CertificateSigningRequestConditionBuilder()
        .withType("Denied")
        .withStatus("True")
        .withReason("DeniedViaRESTApi")
        .withMessage("Denied by REST API /approval endpoint.")
        .build());
  }

  /**
   * Reject a given CertificateSigningRequest.
   *
   * @param certificateSigningRequestCondition a condition of a CertificateSigningRequest object
   * @return updated CertificateSigningRequest from Kubernetes ApiServer
   */
  T deny(CertificateSigningRequestCondition certificateSigningRequestCondition);

  /**
   * Approve a given CertificateSigningRequest.
   *
   * @param certificateSigningRequestCondition a condition of a CertificateSigningRequest object
   * @return updated CertificateSigningRequest from Kubernetes ApiServer
   */
  T approve(CertificateSigningRequestCondition certificateSigningRequestCondition);

  /**
   * Approve a given CertificateSigningRequest.
   *
   * Creates an opinionated CertificateSigningRequestCondition while approving
   * provided CertificateSigningRequest
   *
   * @return updated CertificateSigningRequest from Kubernetes ApiServer
   */
  default T approve() {
    return approve(new CertificateSigningRequestConditionBuilder()
        .withType("Approved")
        .withStatus("True")
        .withReason("ApprovedViaRESTApi")
        .withMessage("Approved by REST API /approval endpoint.")
        .build());
  }
}
