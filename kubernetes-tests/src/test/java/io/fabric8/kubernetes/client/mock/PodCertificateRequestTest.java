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

import io.fabric8.kubernetes.api.model.certificates.v1.PodCertificateRequest;
import io.fabric8.kubernetes.api.model.certificates.v1.PodCertificateRequestBuilder;
import io.fabric8.kubernetes.api.model.certificates.v1.PodCertificateRequestList;
import io.fabric8.kubernetes.api.model.certificates.v1.PodCertificateRequestListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(https = false)
class PodCertificateRequestTest {
  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/certificates.k8s.io/v1/namespaces/test/podcertificaterequests/test-pcr")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPodCertificateRequest("test-pcr"))
        .once();

    // When
    PodCertificateRequest podCertificateRequest = client.certificates().v1().podCertificateRequests()
        .inNamespace("test").withName("test-pcr").get();

    // Then
    assertThat(podCertificateRequest)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-pcr");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/certificates.k8s.io/v1/namespaces/test/podcertificaterequests")
        .andReturn(HttpURLConnection.HTTP_OK, new PodCertificateRequestListBuilder()
            .addToItems(createNewPodCertificateRequest("pcr1"))
            .addToItems(createNewPodCertificateRequest("pcr2"))
            .build())
        .once();

    // When
    PodCertificateRequestList podCertificateRequestList = client.certificates().v1().podCertificateRequests()
        .inNamespace("test").list();

    // Then
    assertThat(podCertificateRequestList).isNotNull();
    assertThat(podCertificateRequestList.getItems()).hasSize(2);
  }

  @Test
  void create() {
    // Given
    PodCertificateRequest podCertificateRequest = createNewPodCertificateRequest("new-pcr");
    server.expect().post().withPath("/apis/certificates.k8s.io/v1/namespaces/test/podcertificaterequests")
        .andReturn(HttpURLConnection.HTTP_CREATED, podCertificateRequest)
        .once();

    // When
    PodCertificateRequest created = client.certificates().v1().podCertificateRequests()
        .inNamespace("test").resource(podCertificateRequest).create();

    // Then
    assertThat(created)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "new-pcr");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/certificates.k8s.io/v1/namespaces/test/podcertificaterequests/pcr-to-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPodCertificateRequest("pcr-to-delete"))
        .once();

    // When
    boolean isDeleted = client.certificates().v1().podCertificateRequests()
        .inNamespace("test").withName("pcr-to-delete").withGracePeriod(0).delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private PodCertificateRequest createNewPodCertificateRequest(String name) {
    return new PodCertificateRequestBuilder()
        .withNewMetadata()
        .withName(name)
        .withNamespace("test")
        .endMetadata()
        .withNewSpec()
        .withPodName("test-pod")
        .withPodUID("test-pod-uid")
        .withServiceAccountName("test-sa")
        .withServiceAccountUID("test-sa-uid")
        .withNodeName("test-node")
        .withNodeUID("test-node-uid")
        .withSignerName("example.com/signer")
        .withMaxExpirationSeconds(86400)
        .endSpec()
        .build();
  }
}
