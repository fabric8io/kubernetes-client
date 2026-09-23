/*
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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.certificates.v1beta1.PodCertificateRequest;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.PodCertificateRequestBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(https = false, crud = true)
class V1beta1PodCertificateRequestTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  @DisplayName("certificates().v1beta1().podCertificateRequests() manages namespaced certificates.k8s.io/v1beta1 resources")
  void podCertificateRequests() throws InterruptedException {
    // Given
    client.certificates().v1beta1().podCertificateRequests().inNamespace("ns").resource(new PodCertificateRequestBuilder()
        .withNewMetadata().withName("pcr").endMetadata()
        .withNewSpec().withPodName("my-pod").withSignerName("example.com/signer").endSpec()
        .build()).create();

    // When
    final PodCertificateRequest result = client.certificates().v1beta1().podCertificateRequests()
        .inNamespace("ns").withName("pcr").get();

    // Then
    assertThat(server.getLastRequest().getPath())
        .isEqualTo("/apis/certificates.k8s.io/v1beta1/namespaces/ns/podcertificaterequests/pcr");
    assertThat(result)
        .hasFieldOrPropertyWithValue("apiVersion", "certificates.k8s.io/v1beta1")
        .hasFieldOrPropertyWithValue("spec.podName", "my-pod");
  }
}
