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

import io.fabric8.kubernetes.api.model.NodeSelectorBuilder;
import io.fabric8.kubernetes.api.model.NodeSelectorRequirementBuilder;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClass;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClassBuilder;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClassList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClassListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class ResourceClassTest {
  private KubernetesClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/resource.k8s.io/v1alpha2/resourceclasses/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewResourceClass("test-get"))
        .once();

    // When
    ResourceClass resourceClass = client.dynamicResourceAllocation().v1alpha2().resourceClasses().withName("test-get").get();

    // Then
    assertThat(resourceClass)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/resource.k8s.io/v1alpha2/resourceclasses")
        .andReturn(HttpURLConnection.HTTP_OK, new ResourceClassListBuilder()
            .addToItems(createNewResourceClass("test-list"))
            .build())
        .once();

    // When
    ResourceClassList resourceClassList = client.dynamicResourceAllocation().v1alpha2().resourceClasses().list();

    // Then
    assertThat(resourceClassList).isNotNull();
    assertThat(resourceClassList.getItems()).hasSize(1);
    assertThat(resourceClassList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/resource.k8s.io/v1alpha2/resourceclasses/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewResourceClass("cluster"))
        .once();

    // When
    boolean isDeleted = client.dynamicResourceAllocation().v1alpha2().resourceClasses().withName("cluster").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ResourceClass createNewResourceClass(String name) {
    return new ResourceClassBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewParametersRef()
        .withKind("kindValue")
        .withName("nameValue")
        .withApiGroup("apiGroupValue")
        .endParametersRef()
        .withDriverName("driver-name")
        .withSuitableNodes(new NodeSelectorBuilder()
            .addNewNodeSelectorTerm()
            .addToMatchExpressions(new NodeSelectorRequirementBuilder()
                .withKey("environment")
                .withOperator("In")
                .addToValues("dev")
                .build())
            .addToMatchFields(new NodeSelectorRequirementBuilder()
                .withKey("metadata.name")
                .withOperator("In")
                .addToValues("backend")
                .build())
            .endNodeSelectorTerm()
            .build())
        .build();
  }
}
