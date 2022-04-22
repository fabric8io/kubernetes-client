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

import io.fabric8.openshift.api.model.operator.v1.ClusterCSIDriver;
import io.fabric8.openshift.api.model.operator.v1.ClusterCSIDriverBuilder;
import io.fabric8.openshift.api.model.operator.v1.ClusterCSIDriverList;
import io.fabric8.openshift.api.model.operator.v1.ClusterCSIDriverListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ClusterCSIDriverTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/operator.openshift.io/v1/clustercsidrivers/manila.csi.openstack.org")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterCSIDriver("manila.csi.openstack.org"))
        .once();

    // When
    ClusterCSIDriver clusterCSIDriver = client.operator().clusterCSIDrivers().withName("manila.csi.openstack.org").get();

    // Then
    assertThat(clusterCSIDriver)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "manila.csi.openstack.org");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/operator.openshift.io/v1/clustercsidrivers")
        .andReturn(HttpURLConnection.HTTP_OK, new ClusterCSIDriverListBuilder()
            .addToItems(createNewClusterCSIDriver("test-list"))
            .build())
        .once();

    // When
    ClusterCSIDriverList clusterCSIDriverList = client.operator().clusterCSIDrivers().list();

    // Then
    assertThat(clusterCSIDriverList).isNotNull();
    assertThat(clusterCSIDriverList.getItems()).hasSize(1);
    assertThat(clusterCSIDriverList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/operator.openshift.io/v1/clustercsidrivers/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterCSIDriver("cluster"))
        .once();

    // When
    boolean isDeleted = client.operator().clusterCSIDrivers().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ClusterCSIDriver createNewClusterCSIDriver(String name) {
    return new ClusterCSIDriverBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withLogLevel("Normal")
        .withOperatorLogLevel("Normal")
        .endSpec()
        .build();
  }
}
