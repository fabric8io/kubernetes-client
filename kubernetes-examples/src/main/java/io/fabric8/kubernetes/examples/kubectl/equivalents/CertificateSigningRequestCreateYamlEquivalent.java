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
package io.fabric8.kubernetes.examples.kubectl.equivalents;

import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestCondition;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestConditionBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/**
 * This sample code is Java equivalent to `kubectl create -f test-csr-v1.yml`. It loads
 * YAML manifest for specified csr and creates it.
 */
public class CertificateSigningRequestCreateYamlEquivalent {

  public static void main(String[] args) {
    try (KubernetesClient client = new DefaultKubernetesClient()) {

      CertificateSigningRequest csr = client.certificates().v1().certificateSigningRequests().load(CertificateSigningRequestCreateYamlEquivalent.class.getResourceAsStream("/test-csr-v1.yml")).get();
      client.certificates().v1().certificateSigningRequests().create(csr);
    }
  }
}
