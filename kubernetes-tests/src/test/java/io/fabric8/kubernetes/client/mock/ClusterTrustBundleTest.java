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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.certificates.v1alpha1.ClusterTrustBundle;
import io.fabric8.kubernetes.api.model.certificates.v1alpha1.ClusterTrustBundleBuilder;
import io.fabric8.kubernetes.api.model.certificates.v1alpha1.ClusterTrustBundleList;
import io.fabric8.kubernetes.api.model.certificates.v1alpha1.ClusterTrustBundleListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class ClusterTrustBundleTest {
  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/certificates.k8s.io/v1alpha1/clustertrustbundles/example.com:mysigner:foo")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterTrustBundle())
        .once();

    // When
    ClusterTrustBundle clusterTrustBundle = client.certificates().v1alpha1().clusterTrustBundles()
        .withName("example.com:mysigner:foo").get();

    // Then
    assertThat(clusterTrustBundle)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "example.com:mysigner:foo");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/certificates.k8s.io/v1alpha1/clustertrustbundles")
        .andReturn(HttpURLConnection.HTTP_OK, new ClusterTrustBundleListBuilder()
            .addToItems(createNewClusterTrustBundle())
            .build())
        .once();

    // When
    ClusterTrustBundleList clusterTrustBundleList = client.certificates().v1alpha1().clusterTrustBundles().list();

    // Then
    assertThat(clusterTrustBundleList).isNotNull();
    assertThat(clusterTrustBundleList.getItems()).hasSize(1);
    assertThat(clusterTrustBundleList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "example.com:mysigner:foo");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/certificates.k8s.io/v1alpha1/clustertrustbundles/example.com:mysigner:foo")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterTrustBundle())
        .once();

    // When
    boolean isDeleted = client.certificates().v1alpha1().clusterTrustBundles().withName("example.com:mysigner:foo").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ClusterTrustBundle createNewClusterTrustBundle() {
    return new ClusterTrustBundleBuilder()
        .withNewMetadata()
        .withName("example.com:mysigner:foo")
        .endMetadata()
        .withNewSpec()
        .withSignerName("example.com/mysigner")
        .withTrustBundle("-----BEGIN CERTIFICATE-----" +
            "MIIDETCCAfmgAwIBAgIRAKAPhDl/fZibvMiMibeV0qQwDQYJKoZIhvcNAQELBQAw\n" +
            "-----END CERTIFICATE-----")
        .endSpec()
        .build();
  }
}
