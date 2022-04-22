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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.openshift.api.model.operator.v1.Storage;
import io.fabric8.openshift.api.model.operator.v1.StorageBuilder;
import io.fabric8.openshift.api.model.operator.v1.StorageList;
import io.fabric8.openshift.api.model.operator.v1.StorageListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class StorageTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/operator.openshift.io/v1/storages/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewStorage("test-get"))
        .once();

    // When
    Storage storage = client.operator().storages().withName("test-get").get();

    // Then
    assertThat(storage)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/operator.openshift.io/v1/storages")
        .andReturn(HttpURLConnection.HTTP_OK, new StorageListBuilder()
            .addToItems(createNewStorage("test-list"))
            .build())
        .once();

    // When
    StorageList storageList = client.operator().storages().list();

    // Then
    assertThat(storageList).isNotNull();
    assertThat(storageList.getItems()).hasSize(1);
    assertThat(storageList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/operator.openshift.io/v1/storages/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewStorage("cluster"))
        .once();

    // When
    boolean isDeleted = client.operator().storages().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Storage createNewStorage(String name) {
    return new StorageBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withLogLevel("Normal")
        .withOperatorLogLevel("TraceAll")
        .endSpec()
        .build();
  }
}
