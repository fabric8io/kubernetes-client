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

import io.fabric8.kubernetes.api.model.APIService;
import io.fabric8.kubernetes.api.model.APIServiceBuilder;
import io.fabric8.kubernetes.api.model.APIServiceList;
import io.fabric8.kubernetes.api.model.APIServiceListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class APIServiceTest {
  private KubernetesMockServer server;
  private KubernetesClient client;

  @Test
  @DisplayName("Should load a yaml resource")
  void get() {
    // Given
    server.expect().get().withPath("/apis/apiregistration.k8s.io/v1/apiservices/test-apiservice")
        .andReturn(HttpURLConnection.HTTP_OK, new APIServiceBuilder()
            .withNewMetadata().withName("as1").endMetadata().build())
        .once();

    // When
    APIService apiService = client.apiServices().withName("test-apiservice").get();

    // Then
    assertNotNull(apiService);
    assertEquals("as1", apiService.getMetadata().getName());
  }

  @Test
  @DisplayName("Should get a resource from APIServer")
  void load() {
    // Given

    // When
    APIService apiService = client.apiServices().load(getClass().getResourceAsStream("/test-apiservice.yml")).item();

    // Then
    assertNotNull(apiService);
    assertEquals("v1alpha1.demo.fabric8.io", apiService.getMetadata().getName());
    assertEquals("demo.fabric8.io", apiService.getSpec().getGroup());
    assertEquals("v1alpha1", apiService.getSpec().getVersion());
  }

  @Test
  @DisplayName("Should list APIService objects")
  void list() {
    // Given
    server.expect().get().withPath("/apis/apiregistration.k8s.io/v1/apiservices")
        .andReturn(HttpURLConnection.HTTP_OK, new APIServiceListBuilder()
            .addNewItem()
            .withNewMetadata().withName("as1").endMetadata().endItem().build())
        .once();

    // When
    APIServiceList apiServiceList = client.apiServices().list();

    // Then
    assertNotNull(apiServiceList);
    assertEquals(1, apiServiceList.getItems().size());
    assertEquals("as1", apiServiceList.getItems().get(0).getMetadata().getName());
  }

  @Test
  @DisplayName("Should delete APIService")
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/apiregistration.k8s.io/v1/apiservices/v1alpha1.demo.fabric8.io")
        .andReturn(HttpURLConnection.HTTP_OK, new APIServiceBuilder()
            .withNewMetadata().withName("v1alpha1.demo.fabric8.io").endMetadata().build())
        .once();

    // When
    boolean isDeleted = client.apiServices().withName("v1alpha1.demo.fabric8.io").delete().size() == 1;

    // Then
    assertTrue(isDeleted);
  }
}
