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
package io.fabric8.openclustermanagement.test.operator;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openclustermanagement.api.model.operator.v1.Klusterlet;
import io.fabric8.openclustermanagement.api.model.operator.v1.KlusterletBuilder;
import io.fabric8.openclustermanagement.api.model.operator.v1.KlusterletList;
import io.fabric8.openclustermanagement.api.model.operator.v1.KlusterletListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class KlusterletTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/operator.open-cluster-management.io/v1/klusterlets/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewKlusterlet("test-get"))
        .once();

    // When
    Klusterlet klusterlet = client.operator().klusterlets().withName("test-get").get();

    // Then
    assertThat(klusterlet)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/operator.open-cluster-management.io/v1/klusterlets")
        .andReturn(HttpURLConnection.HTTP_OK, new KlusterletListBuilder()
            .addToItems(createNewKlusterlet("test-list"))
            .build())
        .once();

    // When
    KlusterletList klusterletList = client.operator().klusterlets().list();

    // Then
    assertThat(klusterletList).isNotNull();
    assertThat(klusterletList.getItems()).hasSize(1);
    assertThat(klusterletList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/operator.open-cluster-management.io/v1/klusterlets/sample-klusterlet")
        .andReturn(HttpURLConnection.HTTP_OK, createNewKlusterlet("sample-klusterlet"))
        .once();

    // When
    boolean isDeleted = client.operator().klusterlets().withName("sample-klusterlet").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Klusterlet createNewKlusterlet(String name) {
    return new KlusterletBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withRegistrationImagePullSpec("quay.io/open-cluster-management/registration")
        .withWorkImagePullSpec("quay.io/open-cluster-management/work")
        .withClusterName("cluster1")
        .withNamespace("open-cluster-management-agent")
        .addNewExternalServerURL()
        .withUrl("https://localhost")
        .endExternalServerURL()
        .endSpec()
        .build();
  }
}
