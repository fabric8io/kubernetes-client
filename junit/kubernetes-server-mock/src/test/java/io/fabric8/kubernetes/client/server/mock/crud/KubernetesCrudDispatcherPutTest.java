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
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.rbac.ClusterRole;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ReplaceDeletable;
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

class KubernetesCrudDispatcherPutTest extends KubernetesCrudDispatcherTestBase {

  @Test
  @DisplayName("replace, not existing, should return not found")
  void replaceNotFound() {
    // Given
    final Resource<ConfigMap> resource = client.resources(ConfigMap.class)
        .resource(new ConfigMapBuilder().withNewMetadata().withName("not-found").endMetadata().build());
    // When
    final KubernetesClientException result = assertThrows(KubernetesClientException.class, resource::replace);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("code", 404)
        .hasMessageContaining("Not Found");
    // replace will first fetch from the server, resulting in the 404 status
    assertLocked(0, 1);
  }

  @Test
  @DisplayName("HTTP PUT, not existing, should return not found")
  void putNotFound() throws Exception {
    // Given
    final HttpClient httpClient = client.getHttpClient();
    final HttpRequest request = httpClient.newHttpRequestBuilder()
        .put(JSON, Serialization.asJson(
            new ConfigMapBuilder().withNewMetadata().withName("not-found").endMetadata().build()))
        .uri(server.url("/api/v1/namespaces/test/not-found"))
        .build();
    // When
    final HttpResponse<String> result = httpClient.sendAsync(request, String.class).get(10, TimeUnit.SECONDS);
    // Then
    assertThat(result)
        .returns(404, HttpResponse::code);
    assertLocked(1, 0);
  }

  @Test
  @DisplayName("HTTP PUT, name mismatch, should return bad request")
  void putNameMismatch() throws Exception {
    // Given
    final ConfigMap original = client.resources(ConfigMap.class).resource(
        new ConfigMapBuilder().withNewMetadata().withName("mismatched-name").endMetadata().build()).create();
    final HttpClient httpClient = client.getHttpClient();
    final ConfigMap cm = new ConfigMapBuilder(original).editMetadata().withName("different").endMetadata()
        .build();
    final HttpRequest request = httpClient.newHttpRequestBuilder()
        .put(JSON, Serialization.asJson(cm))
        .uri(server.url("/api/v1/namespaces/test/configmaps/mismatched-name"))
        .build();
    // When
    final HttpResponse<String> result = httpClient.sendAsync(request, String.class).get(10, TimeUnit.SECONDS);
    // Then
    assertThat(result)
        .returns(400, HttpResponse::code)
        .extracting(HttpResponse::body).asString()
        .contains("the name of the object (different) does not match the name on the URL (mismatched-name)");
    assertLocked(2, 0);
  }

  @Test
  @DisplayName("replace, namespaced, updates values incrementing generation preserving creation metadata")
  void replaceUpdatesFieldsWithGenerationIncrement() {
    // Given
    final ConfigMap original = client.resources(ConfigMap.class).inNamespace("a-namespace").resource(
        new ConfigMapBuilder().withNewMetadata().withName("name").endMetadata()
            .addToData("key", "value").addToData("change", "me").build())
        .create();
    final ConfigMap replacement = new ConfigMapBuilder(original)
        .editMetadata().withNamespace("").withCreationTimestamp(null).withUid(null).endMetadata()
        .addToData("change", "changed").build();
    // When
    final ConfigMap replaced = client.resources(ConfigMap.class).inNamespace("a-namespace").resource(replacement)
        .replace();
    // Then
    assertThat(replaced)
        .hasFieldOrPropertyWithValue("metadata.name", "name")
        .hasFieldOrPropertyWithValue("metadata.namespace", "a-namespace")
        .hasFieldOrPropertyWithValue("metadata.uid", original.getMetadata().getUid())
        .hasFieldOrPropertyWithValue("metadata.creationTimestamp",
            original.getMetadata().getCreationTimestamp())
        .hasFieldOrPropertyWithValue("metadata.resourceVersion", "2")
        .hasFieldOrPropertyWithValue("metadata.generation", 2L)
        .hasFieldOrPropertyWithValue("data.change", "changed");
    assertLocked(2, 0);
  }

  @Test
  @DisplayName("replace, cluster scoped, updates values incrementing generation")
  void replaceClusterScopedUpdatesFieldsWithGenerationIncrement() {
    // Given
    final ClusterRole original = client.resources(ClusterRole.class).resource(
        new ClusterRoleBuilder().withNewMetadata().withName("name").endMetadata()
            .addNewRule().withResourceNames("Resource").endRule().build())
        .create();
    final ClusterRole replacement = new ClusterRoleBuilder(original)
        .addNewRule().withResourceNames("Other").endRule().build();
    // When
    final ClusterRole replaced = client.resources(ClusterRole.class).resource(replacement).replace();
    // Then
    assertThat(replaced)
        .hasFieldOrPropertyWithValue("metadata.resourceVersion", "2")
        .hasFieldOrPropertyWithValue("metadata.generation", 2L)
        .extracting(ClusterRole::getRules).asList().flatExtracting("resourceNames")
        .containsExactlyInAnyOrder("Resource", "Other");
    assertLocked(2, 0);
  }

  @Test
  @DisplayName("replace, with same values, leaves resource unchanged and keeps resourceVersion and generation")
  void replaceWithSameLeavesResourceUnchanged() {
    // Given
    final ConfigMap original = client.resources(ConfigMap.class).resource(
        new ConfigMapBuilder().withNewMetadata().withName("name").endMetadata()
            .addToData("key", "value").addToData("change", "me").build())
        .create();
    final ConfigMap replacement = new ConfigMapBuilder(original).build();
    // When
    final ConfigMap replaced = client.resources(ConfigMap.class).resource(replacement).replace();
    // Then
    assertThat(replaced)
        .hasFieldOrPropertyWithValue("metadata.resourceVersion", "1")
        .hasFieldOrPropertyWithValue("metadata.generation", 1L)
        .hasFieldOrPropertyWithValue("data.change", "me");
    assertLocked(2, 0);
  }

  @Test
  @DisplayName("replace, with an old resource version, should return conflict")
  void replaceWithOldResourceVersion() throws Exception {
    final HttpClient httpClient = client.getHttpClient();
    // Given
    final ConfigMap original = client.resources(ConfigMap.class).resource(
        new ConfigMapBuilder().withNewMetadata().withName("name").endMetadata()
            .addToData("key", "value").addToData("change", "me").build())
        .create();
    final ConfigMap replacementV1 = new ConfigMapBuilder(original).addToData("key", "value2").build();

    client.resources(ConfigMap.class).resource(replacementV1).replace();

    final ConfigMap replacementV2 = new ConfigMapBuilder(original).addToData("key", "value3").build();

    // When
    ReplaceDeletable<ConfigMap> operation = client.resources(ConfigMap.class).resource(replacementV2)
        .lockResourceVersion(original.getMetadata().getResourceVersion());
    KubernetesClientException e = assertThrows(KubernetesClientException.class,
        operation::replace);

    // Then
    assertThat(e)
        .returns(409, KubernetesClientException::getCode)
        .extracting(KubernetesClientException::getMessage).asString()
        .contains("the object has been modified");
    assertLocked(3, 0);
  }

  @Test
  @DisplayName("replaceStatus, updates status values incrementing resourceVersion, generation remains unchanged")
  void replaceStatusUpdatesFieldsWithResourceVersionIncrement() {
    // Given
    final Pod original = client.resources(Pod.class).resource(
        new PodBuilder().withNewMetadata().withName("name").endMetadata().build()).create();
    final Pod replacement = new PodBuilder(original).editOrNewStatus().withMessage("new-message").endStatus().build();
    // When
    final Pod replaced = client.resources(Pod.class).resource(replacement).replaceStatus();
    // Then
    assertThat(replaced)
        .hasFieldOrPropertyWithValue("metadata.resourceVersion", "2")
        .hasFieldOrPropertyWithValue("metadata.generation", 1L)
        .hasFieldOrPropertyWithValue("status.message", "new-message");
    assertLocked(2, 0);
  }

  @Test
  @DisplayName("replace, custom resource with status, ignores changes to the status stanza")
  // PUT requests to the custom resource ignore changes to the status stanza.
  void replaceCrIgnoreStatusChanges() {
    // Given
    client.apiextensions().v1().customResourceDefinitions().resource(Owl.toCrd()).create();
    final Owl owl = new Owl();
    owl.setMetadata(new ObjectMetaBuilder().withName("lincoln-march").build());
    owl.getSpec().setSpecies("Barn owl");
    client.resources(Owl.class).resource(owl).create();
    owl.getSpec().setSpecies("Snowy owl");
    owl.getStatus().setNotes("updated");
    // When
    final Owl result = client.resources(Owl.class).resource(owl).replace();
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("spec.species", "Snowy owl")
        .hasFieldOrPropertyWithValue("status.notes", null);
    assertLocked(3, 1);
  }

  @Test
  @DisplayName("replaceStatus, custom resource with status, ignores all changes except the status stanza")
  // PUT requests to the /status subresource take a custom resource object and ignore changes to anything except the status stanza.
  void replaceStatusCrIgnoreAllChangesExceptStatus() {
    // Given
    client.apiextensions().v1().customResourceDefinitions().resource(Owl.toCrd()).create();
    final Owl owl = new Owl();
    owl.setMetadata(new ObjectMetaBuilder().withName("lincoln-march").build());
    owl.getSpec().setSpecies("Barn owl");
    client.resources(Owl.class).resource(owl).create();
    owl.getSpec().setSpecies("Snowy owl");
    owl.getStatus().setNotes("updated");
    // When
    final Owl result = client.resources(Owl.class).resource(owl).replaceStatus();
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("spec.species", "Barn owl")
        .hasFieldOrPropertyWithValue("status.notes", "updated");
    assertLocked(3, 1);
  }
}
