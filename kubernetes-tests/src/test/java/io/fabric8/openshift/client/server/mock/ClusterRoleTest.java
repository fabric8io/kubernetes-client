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

import io.fabric8.openshift.api.model.ClusterRole;
import io.fabric8.openshift.api.model.ClusterRoleBuilder;
import io.fabric8.openshift.api.model.ClusterRoleList;
import io.fabric8.openshift.api.model.ClusterRoleListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ClusterRoleTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/authorization.openshift.io/v1/clusterroles/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterRole("test-get"))
        .once();

    // When
    ClusterRole clusterRole = client.clusterRoles().withName("test-get").get();

    // Then
    assertThat(clusterRole)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/authorization.openshift.io/v1/clusterroles")
        .andReturn(HttpURLConnection.HTTP_OK, new ClusterRoleListBuilder()
            .addToItems(createNewClusterRole("test-list"))
            .build())
        .once();

    // When
    ClusterRoleList clusterRoleList = client.clusterRoles().list();

    // Then
    assertThat(clusterRoleList).isNotNull();
    assertThat(clusterRoleList.getItems()).hasSize(1);
    assertThat(clusterRoleList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/authorization.openshift.io/v1/clusterroles/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterRole("cluster"))
        .once();

    // When
    boolean isDeleted = client.clusterRoles().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ClusterRole createNewClusterRole(String name) {
    return new ClusterRoleBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .addNewRule()
        .addToApiGroups("template.openshift.io")
        .addToResources("templates", "processedtemplates", "templateauthorizations", "templateinstances")
        .withVerbs("*")
        .endRule()
        .build();
  }

}
