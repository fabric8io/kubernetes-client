/*
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

import io.fabric8.kubernetes.api.model.resource.v1.DeviceClass;
import io.fabric8.kubernetes.api.model.resource.v1.DeviceClassBuilder;
import io.fabric8.kubernetes.api.model.resource.v1.DeviceClassList;
import io.fabric8.kubernetes.api.model.resource.v1.DeviceClassListBuilder;
import io.fabric8.kubernetes.api.model.resource.v1.ResourceClaim;
import io.fabric8.kubernetes.api.model.resource.v1.ResourceClaimBuilder;
import io.fabric8.kubernetes.api.model.resource.v1.ResourceClaimList;
import io.fabric8.kubernetes.api.model.resource.v1.ResourceClaimListBuilder;
import io.fabric8.kubernetes.api.model.resource.v1.ResourceClaimTemplate;
import io.fabric8.kubernetes.api.model.resource.v1.ResourceClaimTemplateBuilder;
import io.fabric8.kubernetes.api.model.resource.v1.ResourceClaimTemplateList;
import io.fabric8.kubernetes.api.model.resource.v1.ResourceClaimTemplateListBuilder;
import io.fabric8.kubernetes.api.model.resource.v1.ResourceSlice;
import io.fabric8.kubernetes.api.model.resource.v1.ResourceSliceBuilder;
import io.fabric8.kubernetes.api.model.resource.v1.ResourceSliceList;
import io.fabric8.kubernetes.api.model.resource.v1.ResourceSliceListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class V1DynamicResourceAllocationTest {
  private KubernetesClient client;
  KubernetesMockServer server;

  // ResourceClaim Tests (Namespaced)
  @Test
  void resourceClaimGet() {
    // Given
    server.expect().get().withPath("/apis/resource.k8s.io/v1/namespaces/test/resourceclaims/test-claim")
        .andReturn(HttpURLConnection.HTTP_OK, createNewResourceClaim("test-claim"))
        .once();

    // When
    ResourceClaim resourceClaim = client.dynamicResourceAllocation().v1().resourceClaims()
        .inNamespace("test").withName("test-claim").get();

    // Then
    assertThat(resourceClaim)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-claim");
  }

  @Test
  void resourceClaimList() {
    // Given
    server.expect().get().withPath("/apis/resource.k8s.io/v1/namespaces/test/resourceclaims")
        .andReturn(HttpURLConnection.HTTP_OK, new ResourceClaimListBuilder()
            .addToItems(createNewResourceClaim("claim1"))
            .addToItems(createNewResourceClaim("claim2"))
            .build())
        .once();

    // When
    ResourceClaimList resourceClaimList = client.dynamicResourceAllocation().v1().resourceClaims()
        .inNamespace("test").list();

    // Then
    assertThat(resourceClaimList).isNotNull();
    assertThat(resourceClaimList.getItems()).hasSize(2);
  }

  @Test
  void resourceClaimCreate() {
    // Given
    ResourceClaim resourceClaim = createNewResourceClaim("new-claim");
    server.expect().post().withPath("/apis/resource.k8s.io/v1/namespaces/test/resourceclaims")
        .andReturn(HttpURLConnection.HTTP_CREATED, resourceClaim)
        .once();

    // When
    ResourceClaim created = client.dynamicResourceAllocation().v1().resourceClaims()
        .inNamespace("test").resource(resourceClaim).create();

    // Then
    assertThat(created)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "new-claim");
  }

  @Test
  void resourceClaimDelete() {
    // Given
    server.expect().delete().withPath("/apis/resource.k8s.io/v1/namespaces/test/resourceclaims/claim-to-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewResourceClaim("claim-to-delete"))
        .once();

    // When
    boolean isDeleted = client.dynamicResourceAllocation().v1().resourceClaims()
        .inNamespace("test").withName("claim-to-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  // ResourceClaimTemplate Tests (Namespaced)
  @Test
  void resourceClaimTemplateGet() {
    // Given
    server.expect().get()
        .withPath("/apis/resource.k8s.io/v1/namespaces/test/resourceclaimtemplates/test-template")
        .andReturn(HttpURLConnection.HTTP_OK, createNewResourceClaimTemplate("test-template"))
        .once();

    // When
    ResourceClaimTemplate template = client.dynamicResourceAllocation().v1().resourceClaimTemplates()
        .inNamespace("test").withName("test-template").get();

    // Then
    assertThat(template)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-template");
  }

  @Test
  void resourceClaimTemplateList() {
    // Given
    server.expect().get().withPath("/apis/resource.k8s.io/v1/namespaces/test/resourceclaimtemplates")
        .andReturn(HttpURLConnection.HTTP_OK, new ResourceClaimTemplateListBuilder()
            .addToItems(createNewResourceClaimTemplate("template1"))
            .addToItems(createNewResourceClaimTemplate("template2"))
            .build())
        .once();

    // When
    ResourceClaimTemplateList templateList = client.dynamicResourceAllocation().v1().resourceClaimTemplates()
        .inNamespace("test").list();

    // Then
    assertThat(templateList).isNotNull();
    assertThat(templateList.getItems()).hasSize(2);
  }

  @Test
  void resourceClaimTemplateCreate() {
    // Given
    ResourceClaimTemplate template = createNewResourceClaimTemplate("new-template");
    server.expect().post().withPath("/apis/resource.k8s.io/v1/namespaces/test/resourceclaimtemplates")
        .andReturn(HttpURLConnection.HTTP_CREATED, template)
        .once();

    // When
    ResourceClaimTemplate created = client.dynamicResourceAllocation().v1().resourceClaimTemplates()
        .inNamespace("test").resource(template).create();

    // Then
    assertThat(created)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "new-template");
  }

  @Test
  void resourceClaimTemplateDelete() {
    // Given
    server.expect().delete()
        .withPath("/apis/resource.k8s.io/v1/namespaces/test/resourceclaimtemplates/template-to-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewResourceClaimTemplate("template-to-delete"))
        .once();

    // When
    boolean isDeleted = client.dynamicResourceAllocation().v1().resourceClaimTemplates()
        .inNamespace("test").withName("template-to-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  // DeviceClass Tests (Cluster-scoped)
  @Test
  void deviceClassGet() {
    // Given
    server.expect().get().withPath("/apis/resource.k8s.io/v1/deviceclasses/test-device-class")
        .andReturn(HttpURLConnection.HTTP_OK, createNewDeviceClass("test-device-class"))
        .once();

    // When
    DeviceClass deviceClass = client.dynamicResourceAllocation().v1().deviceClasses()
        .withName("test-device-class").get();

    // Then
    assertThat(deviceClass)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-device-class");
  }

  @Test
  void deviceClassList() {
    // Given
    server.expect().get().withPath("/apis/resource.k8s.io/v1/deviceclasses")
        .andReturn(HttpURLConnection.HTTP_OK, new DeviceClassListBuilder()
            .addToItems(createNewDeviceClass("device-class1"))
            .addToItems(createNewDeviceClass("device-class2"))
            .build())
        .once();

    // When
    DeviceClassList deviceClassList = client.dynamicResourceAllocation().v1().deviceClasses().list();

    // Then
    assertThat(deviceClassList).isNotNull();
    assertThat(deviceClassList.getItems()).hasSize(2);
  }

  @Test
  void deviceClassCreate() {
    // Given
    DeviceClass deviceClass = createNewDeviceClass("new-device-class");
    server.expect().post().withPath("/apis/resource.k8s.io/v1/deviceclasses")
        .andReturn(HttpURLConnection.HTTP_CREATED, deviceClass)
        .once();

    // When
    DeviceClass created = client.dynamicResourceAllocation().v1().deviceClasses()
        .resource(deviceClass).create();

    // Then
    assertThat(created)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "new-device-class");
  }

  @Test
  void deviceClassDelete() {
    // Given
    server.expect().delete().withPath("/apis/resource.k8s.io/v1/deviceclasses/device-class-to-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewDeviceClass("device-class-to-delete"))
        .once();

    // When
    boolean isDeleted = client.dynamicResourceAllocation().v1().deviceClasses()
        .withName("device-class-to-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  // ResourceSlice Tests (Cluster-scoped)
  @Test
  void resourceSliceGet() {
    // Given
    server.expect().get().withPath("/apis/resource.k8s.io/v1/resourceslices/test-resource-slice")
        .andReturn(HttpURLConnection.HTTP_OK, createNewResourceSlice("test-resource-slice"))
        .once();

    // When
    ResourceSlice resourceSlice = client.dynamicResourceAllocation().v1().resourcesSlices()
        .withName("test-resource-slice").get();

    // Then
    assertThat(resourceSlice)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-resource-slice");
  }

  @Test
  void resourceSliceList() {
    // Given
    server.expect().get().withPath("/apis/resource.k8s.io/v1/resourceslices")
        .andReturn(HttpURLConnection.HTTP_OK, new ResourceSliceListBuilder()
            .addToItems(createNewResourceSlice("slice1"))
            .addToItems(createNewResourceSlice("slice2"))
            .build())
        .once();

    // When
    ResourceSliceList resourceSliceList = client.dynamicResourceAllocation().v1().resourcesSlices().list();

    // Then
    assertThat(resourceSliceList).isNotNull();
    assertThat(resourceSliceList.getItems()).hasSize(2);
  }

  @Test
  void resourceSliceCreate() {
    // Given
    ResourceSlice resourceSlice = createNewResourceSlice("new-slice");
    server.expect().post().withPath("/apis/resource.k8s.io/v1/resourceslices")
        .andReturn(HttpURLConnection.HTTP_CREATED, resourceSlice)
        .once();

    // When
    ResourceSlice created = client.dynamicResourceAllocation().v1().resourcesSlices()
        .resource(resourceSlice).create();

    // Then
    assertThat(created)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "new-slice");
  }

  @Test
  void resourceSliceDelete() {
    // Given
    server.expect().delete().withPath("/apis/resource.k8s.io/v1/resourceslices/slice-to-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewResourceSlice("slice-to-delete"))
        .once();

    // When
    boolean isDeleted = client.dynamicResourceAllocation().v1().resourcesSlices()
        .withName("slice-to-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  // Helper methods to create test resources
  private ResourceClaim createNewResourceClaim(String name) {
    return new ResourceClaimBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withDevices(new io.fabric8.kubernetes.api.model.resource.v1.DeviceClaimBuilder()
            .addNewRequest()
            .withName("gpu-request")
            .withNewExactly()
            .withDeviceClassName("gpu-class")
            .withCount(1L)
            .endExactly()
            .endRequest()
            .build())
        .endSpec()
        .build();
  }

  private ResourceClaimTemplate createNewResourceClaimTemplate(String name) {
    return new ResourceClaimTemplateBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withNewMetadata()
        .addToAnnotations("example.com/annotation", "value")
        .endMetadata()
        .withNewSpec()
        .withDevices(new io.fabric8.kubernetes.api.model.resource.v1.DeviceClaimBuilder()
            .addNewRequest()
            .withName("accelerator-request")
            .withNewExactly()
            .withDeviceClassName("accelerator-class")
            .withCount(1L)
            .endExactly()
            .endRequest()
            .build())
        .endSpec()
        .endSpec()
        .build();
  }

  private DeviceClass createNewDeviceClass(String name) {
    return new DeviceClassBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .addNewSelector()
        .withNewCel()
        .withExpression("device.driver == \"example.com\"")
        .endCel()
        .endSelector()
        .endSpec()
        .build();
  }

  private ResourceSlice createNewResourceSlice(String name) {
    return new ResourceSliceBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withDriver("example.com/driver")
        .withNewPool()
        .withName("pool-1")
        .withGeneration(1L)
        .withResourceSliceCount(1L)
        .endPool()
        .endSpec()
        .build();
  }
}
