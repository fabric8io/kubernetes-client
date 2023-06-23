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
package io.fabric8.kubernetes.client.server.mock.crud;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.server.mock.crud.crd.Owl;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.fabric8.kubernetes.client.dsl.internal.OperationSupport.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KubernetesCrudDispatcherPostTest extends KubernetesCrudDispatcherTestBase {

  @Test
  @DisplayName("create, namespaced and not existing, creates new resource with default metadata")
  void createSetsDefaultValues() {
    // Given
    final Pod pod = new PodBuilder()
        .withNewSpec().withDnsPolicy("always-dns").endSpec()
        .withNewMetadata().withName("foo").addToLabels("app", "bar").endMetadata()
        .build();
    // When
    final Pod result = client.resources(Pod.class).inNamespace("a-namespace").resource(pod).create();
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("metadata.namespace", "a-namespace")
        .hasFieldOrPropertyWithValue("metadata.name", "foo")
        .hasFieldOrPropertyWithValue("metadata.generation", 1L)
        .hasFieldOrPropertyWithValue("metadata.resourceVersion", "1")
        .hasFieldOrPropertyWithValue("spec.dnsPolicy", "always-dns")
        .extracting(Pod::getMetadata)
        .satisfies(m -> assertThat(m.getCreationTimestamp()).isNotBlank())
        .satisfies(m -> assertThat(m.getUid()).isNotBlank());
    assertLocked(1, 0);
  }

  @Test
  @DisplayName("create, not existing and generateName, creates new resource with default metadata")
  void createGenerateNameSetsDefaultValues() {
    // Given
    final Pod pod = new PodBuilder()
        .withNewSpec().withDnsPolicy("always-dns").endSpec()
        .withNewMetadata().withGenerateName("foo-gen").addToLabels("app", "bar").endMetadata()
        .build();
    // When
    final Pod result = client.resources(Pod.class).resource(pod).create();
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("metadata.namespace", "test")
        .hasFieldOrPropertyWithValue("metadata.generation", 1L)
        .hasFieldOrPropertyWithValue("metadata.resourceVersion", "1")
        .hasFieldOrPropertyWithValue("spec.dnsPolicy", "always-dns")
        .extracting(Pod::getMetadata)
        .satisfies(m -> assertThat(m.getName()).startsWith("foo-gen-"))
        .satisfies(m -> assertThat(m.getCreationTimestamp()).isNotBlank())
        .satisfies(m -> assertThat(m.getUid()).isNotBlank());
    assertLocked(1, 0);
  }

  @Test
  @DisplayName("create, existing, should return conflict")
  void createExistingConflict() {
    // Given
    final Pod pod = new PodBuilder()
        .withNewSpec().withDnsPolicy("always-dns").endSpec()
        .withNewMetadata().withName("foo").addToLabels("app", "bar").endMetadata()
        .build();
    client.resources(Pod.class).resource(pod).create();
    final Resource<Pod> podResource = client.resources(Pod.class).resource(pod);
    // When
    final KubernetesClientException result = assertThrows(KubernetesClientException.class, podResource::create);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("code", 409)
        .hasMessageContaining("Pod 'foo' already exists");
    assertLocked(2, 0);
  }

  @Test
  @DisplayName("create, missing kind, should return bad request")
  void createMissingKind() {
    // Given
    final GenericKubernetesResource cm = new GenericKubernetesResource();
    cm.setMetadata(new ObjectMetaBuilder().withName("name").build());
    final Resource<GenericKubernetesResource> resource = client
        .genericKubernetesResources("v1", "ConfigMap")
        .resource(cm);
    // When
    final KubernetesClientException result = assertThrows(KubernetesClientException.class, resource::create);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("code", 422)
        .hasMessageContaining("Required value: kind is required");
    assertLocked(1, 0);
  }

  @Test
  @DisplayName("create, missing metadata, should return unprocessable entity")
  void createMissingMetadata() {
    // Given
    final GenericKubernetesResource cm = new GenericKubernetesResource();
    cm.setKind("ConfigMap");
    final Resource<GenericKubernetesResource> resource = client
        .genericKubernetesResources("v1", "ConfigMap").withName("name");
    ;
    // When
    final KubernetesClientException result = assertThrows(KubernetesClientException.class, () -> resource.create(cm));
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("code", 422)
        .hasMessageContaining("ConfigMap is invalid")
        .hasMessageContaining("Required value: metadata is required");
    assertLocked(1, 0);
  }

  @Test
  @DisplayName("HTTP POST, namespace mismatch, should return bad request")
  void postNamespaceMismatch() throws Exception {
    // Given
    final HttpClient httpClient = client.getHttpClient();
    final ConfigMap cm = new ConfigMapBuilder().withNewMetadata()
        .withName("name")
        .withNamespace("different").endMetadata()
        .build();
    final HttpRequest request = httpClient.newHttpRequestBuilder()
        .post(JSON, Serialization.asJson(cm))
        .uri(server.url("/api/v1/namespaces/test/configmaps"))
        .build();
    // When
    final HttpResponse<String> result = httpClient.sendAsync(request, String.class).get(10, TimeUnit.SECONDS);
    // Then
    assertThat(result)
        .returns(400, HttpResponse::code)
        .extracting(HttpResponse::body).asString()
        .contains("the namespace of the object (different) does not match the namespace on the URL (test)");
    assertLocked(1, 0);
  }

  @Test
  @DisplayName("create, custom resource with status, ignores changes to status stanza")
  // POST requests to the custom resource ignore changes to the status stanza.
  void createCrIgnoreStatusChanges() {
    // Given
    client.apiextensions().v1().customResourceDefinitions().resource(Owl.toCrd()).create();
    final Owl owl = new Owl();
    owl.setMetadata(new ObjectMetaBuilder().withName("lincoln-march").build());
    owl.getSpec().setSpecies("Barn owl");
    owl.getStatus().setNotes("Should be removed");
    // When
    final Owl result = client.resources(Owl.class).resource(owl).create();
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("spec.species", "Barn owl")
        .hasFieldOrPropertyWithValue("status.notes", null);
    assertLocked(2, 0);
  }
}
