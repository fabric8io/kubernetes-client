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

import io.fabric8.openshift.api.model.hive.v1.SyncSet;
import io.fabric8.openshift.api.model.hive.v1.SyncSetBuilder;
import io.fabric8.openshift.api.model.hive.v1.SyncSetList;
import io.fabric8.openshift.api.model.hive.v1.SyncSetListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.server.mock.EnableOpenShiftMockClient;
import io.fabric8.openshift.client.server.mock.OpenShiftMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class SyncSetTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/syncsets/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSyncSet("test-get"))
        .once();

    // When
    SyncSet syncSet = client.hive().syncSets().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(syncSet)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/syncsets")
        .andReturn(HttpURLConnection.HTTP_OK, new SyncSetListBuilder()
            .addToItems(createNewSyncSet("test-list"))
            .build())
        .once();

    // When
    SyncSetList syncSetList = client.hive().syncSets().inNamespace("ns1").list();

    // Then
    assertThat(syncSetList).isNotNull();
    assertThat(syncSetList.getItems()).hasSize(1);
    assertThat(syncSetList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/syncsets/syncset1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSyncSet("syncset1"))
        .once();

    // When
    boolean isDeleted = client.hive().syncSets().inNamespace("ns1").withName("syncset1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private SyncSet createNewSyncSet(String name) {
    return new SyncSetBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withResourceApplyMode("Upsert")
        .addNewClusterDeploymentRef()
        .withName("ClusterName")
        .endClusterDeploymentRef()
        .addNewSecretMapping()
        .withNewSourceRef()
        .withName("ad-bind-password")
        .withNamespace("default")
        .endSourceRef()
        .withNewTargetRef()
        .withName("ad-bind-password")
        .withNamespace("openshift-config")
        .endTargetRef()
        .endSecretMapping()
        .endSpec()
        .build();
  }
}
