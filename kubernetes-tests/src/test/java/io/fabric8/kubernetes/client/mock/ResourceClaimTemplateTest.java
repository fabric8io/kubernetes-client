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

import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimTemplate;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimTemplateBuilder;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimTemplateList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimTemplateListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class ResourceClaimTemplateTest {
  private KubernetesClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/resource.k8s.io/v1alpha2/namespaces/test/resourceclaimtemplates/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewResourceClaimTemplate("test-get"))
        .once();

    // When
    ResourceClaimTemplate resourceClaimTemplate = client.dynamicResourceAllocation().v1alpha2().resourceClaimTemplates()
        .inNamespace("test").withName("test-get").get();

    // Then
    assertThat(resourceClaimTemplate)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/resource.k8s.io/v1alpha2/namespaces/test/resourceclaimtemplates")
        .andReturn(HttpURLConnection.HTTP_OK, new ResourceClaimTemplateListBuilder()
            .addToItems(createNewResourceClaimTemplate("test-list"))
            .build())
        .once();

    // When
    ResourceClaimTemplateList resourceClaimList = client.dynamicResourceAllocation().v1alpha2().resourceClaimTemplates()
        .inNamespace("test").list();

    // Then
    assertThat(resourceClaimList).isNotNull();
    assertThat(resourceClaimList.getItems()).hasSize(1);
    assertThat(resourceClaimList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/resource.k8s.io/v1alpha2/namespaces/test/resourceclaimtemplates/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewResourceClaimTemplate("cluster"))
        .once();

    // When
    boolean isDeleted = client.dynamicResourceAllocation().v1alpha2().resourceClaimTemplates().inNamespace("test")
        .withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ResourceClaimTemplate createNewResourceClaimTemplate(String name) {
    return new ResourceClaimTemplateBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withNewMetadata()
        .addToAnnotations("annotationKey", "annotationValue")
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
        .endSpec()
        .build();
  }
}
