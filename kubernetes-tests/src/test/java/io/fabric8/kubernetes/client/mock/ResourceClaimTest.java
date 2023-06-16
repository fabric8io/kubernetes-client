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

import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaim;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimBuilder;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class ResourceClaimTest {
  private KubernetesClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/resource.k8s.io/v1alpha2/namespaces/test/resourceclaims/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewResourceClaim("test-get"))
        .once();

    // When
    ResourceClaim resourceClaim = client.dynamicResourceAllocation().v1alpha2().resourceClaims().inNamespace("test")
        .withName("test-get").get();

    // Then
    assertThat(resourceClaim)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/resource.k8s.io/v1alpha2/namespaces/test/resourceclaims")
        .andReturn(HttpURLConnection.HTTP_OK, new ResourceClaimListBuilder()
            .addToItems(createNewResourceClaim("test-list"))
            .build())
        .once();

    // When
    ResourceClaimList resourceClaimList = client.dynamicResourceAllocation().v1alpha2().resourceClaims().inNamespace("test")
        .list();

    // Then
    assertThat(resourceClaimList).isNotNull();
    assertThat(resourceClaimList.getItems()).hasSize(1);
    assertThat(resourceClaimList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/resource.k8s.io/v1alpha2/namespaces/test/resourceclaims/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewResourceClaim("cluster"))
        .once();

    // When
    boolean isDeleted = client.dynamicResourceAllocation().v1alpha2().resourceClaims().inNamespace("test").withName("cluster")
        .delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ResourceClaim createNewResourceClaim(String name) {
    return new ResourceClaimBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withNewParametersRef()
        .withKind("kindValue")
        .withName("nameValue")
        .withApiGroup("apiGroupValue")
        .endParametersRef()
        .withAllocationMode("Immediate")
        .withResourceClassName("resource-class-name")
        .endSpec()
        .build();
  }
}
