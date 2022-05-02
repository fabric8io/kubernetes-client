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

import io.fabric8.openshift.api.model.hive.v1.ClusterImageSet;
import io.fabric8.openshift.api.model.hive.v1.ClusterImageSetBuilder;
import io.fabric8.openshift.api.model.hive.v1.ClusterImageSetList;
import io.fabric8.openshift.api.model.hive.v1.ClusterImageSetListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.server.mock.EnableOpenShiftMockClient;
import io.fabric8.openshift.client.server.mock.OpenShiftMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ClusterImageSetTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/clusterimagesets/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterImageSet("test-get"))
        .once();

    // When
    ClusterImageSet egressRouter = client.hive().clusterImageSets().withName("test-get").get();

    // Then
    assertThat(egressRouter)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/clusterimagesets")
        .andReturn(HttpURLConnection.HTTP_OK, new ClusterImageSetListBuilder()
            .addToItems(createNewClusterImageSet("test-list"))
            .build())
        .once();

    // When
    ClusterImageSetList ipPoolList = client.hive().clusterImageSets().list();

    // Then
    assertThat(ipPoolList).isNotNull();
    assertThat(ipPoolList.getItems()).hasSize(1);
    assertThat(ipPoolList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/hive.openshift.io/v1/clusterimagesets/clusterimageset1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterImageSet("clusterimageset1"))
        .once();

    // When
    boolean isDeleted = client.hive().clusterImageSets().withName("clusterimageset1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ClusterImageSet createNewClusterImageSet(String name) {
    return new ClusterImageSetBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withReleaseImage("quay.io/openshift-release-dev/ocp-release:4.0.0-0.6")
        .endSpec()
        .build();
  }
}
