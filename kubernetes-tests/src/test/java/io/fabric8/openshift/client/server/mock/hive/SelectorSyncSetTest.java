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
package io.fabric8.openshift.client.server.mock.hive;

import io.fabric8.openshift.api.model.hive.v1.SelectorSyncSet;
import io.fabric8.openshift.api.model.hive.v1.SelectorSyncSetBuilder;
import io.fabric8.openshift.api.model.hive.v1.SelectorSyncSetList;
import io.fabric8.openshift.api.model.hive.v1.SelectorSyncSetListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.server.mock.EnableOpenShiftMockClient;
import io.fabric8.openshift.client.server.mock.OpenShiftMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class SelectorSyncSetTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/selectorsyncsets/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSelectorSyncSet("test-get"))
        .once();

    // When
    SelectorSyncSet selectorSyncSet = client.hive().selectorSyncSets().withName("test-get").get();

    // Then
    assertThat(selectorSyncSet)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/selectorsyncsets")
        .andReturn(HttpURLConnection.HTTP_OK, new SelectorSyncSetListBuilder()
            .addToItems(createNewSelectorSyncSet("test-list"))
            .build())
        .once();

    // When
    SelectorSyncSetList selectorSyncSetList = client.hive().selectorSyncSets().list();

    // Then
    assertThat(selectorSyncSetList).isNotNull();
    assertThat(selectorSyncSetList.getItems()).hasSize(1);
    assertThat(selectorSyncSetList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/hive.openshift.io/v1/selectorsyncsets/selectorsyncset1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSelectorSyncSet("selectorsyncset1"))
        .once();

    // When
    boolean isDeleted = client.hive().selectorSyncSets().withName("selectorsyncset1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private SelectorSyncSet createNewSelectorSyncSet(String name) {
    return new SelectorSyncSetBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withNewClusterDeploymentSelector()
        .addToMatchLabels("cluster-group", "abutcher")
        .endClusterDeploymentSelector()
        .endSpec()
        .build();
  }
}
