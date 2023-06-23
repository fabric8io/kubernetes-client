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
import io.fabric8.kubernetes.client.dsl.NamespaceableResource;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import io.fabric8.kubernetes.client.server.mock.crud.crd.Owl;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KubernetesCrudDispatcherPatchTest extends KubernetesCrudDispatcherTestBase {

  @Test
  @DisplayName("patch, not existing, should return not found")
  void patchNotFound() {
    // Given
    final Resource<Pod> podResource = client.resources(Pod.class)
        .resource(new PodBuilder().withNewMetadata().withName("not-found").endMetadata().build());
    // When
    final KubernetesClientException result = assertThrows(KubernetesClientException.class, podResource::patchStatus);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("code", 404)
        .hasMessageContaining("Not Found");
    assertLocked(1, 0);
  }

  @Test
  @DisplayName("patch, strategic-merge, should return unsupported")
  void patchUnsupported() {
    // Given
    final Resource<Pod> podResource = client.resources(Pod.class)
        .resource(new PodBuilder().withNewMetadata().withName("unsupported").endMetadata().build());
    podResource.create();
    final PatchContext patchContext = PatchContext.of(PatchType.STRATEGIC_MERGE);
    // When
    final KubernetesClientException result = assertThrows(KubernetesClientException.class,
        () -> podResource.patch(patchContext));
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("code", 415)
        .hasMessageContaining("Unsupported Media Type");
    assertLocked(2, 0);
  }

  @Test
  @DisplayName("patch, name mismatch, should return bad request")
  void patchNameMismatch() {
    // Given
    client.resources(Pod.class).resource(
        new PodBuilder().withNewMetadata().withName("mismatched-name").endMetadata().build()).create();
    final Resource<Pod> podResource = client.pods().withName("mismatched-name");
    final PatchContext patchContext = PatchContext.of(PatchType.JSON);
    final Pod patch = new PodBuilder().withNewMetadata().withName("different").endMetadata().build();
    // When
    final KubernetesClientException result = assertThrows(KubernetesClientException.class,
        () -> podResource.patch(patchContext, patch));
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("code", 400)
        .hasMessageContaining("the name of the object (different) does not match the name on the URL (mismatched-name)");
    // Patch reads before write
    assertLocked(2, 1);
  }

  @Test
  @DisplayName("patch, namespace mismatch, should return bad request")
  void patchNamespaceMismatch() {
    // Given
    client.resources(Pod.class).resource(
        new PodBuilder().withNewMetadata().withName("name").endMetadata().build()).create();
    final Resource<Pod> podResource = client.pods().withName("name");
    final PatchContext patchContext = PatchContext.of(PatchType.JSON);
    final Pod patch = new PodBuilder().withNewMetadata().withNamespace("different").endMetadata().build();
    // When
    final KubernetesClientException result = assertThrows(KubernetesClientException.class,
        () -> podResource.patch(patchContext, patch));
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("code", 400)
        .hasMessageContaining("the namespace of the object (different) does not match the namespace on the URL (test)");
    // Patch reads before write
    assertLocked(2, 1);
  }

  @Test
  @DisplayName("patch, JSON+Merge and namespaced, updates affected values ignoring other fields and incrementing generation")
  void patchJsonMergeNamespacedUpdatesFieldsWithGenerationIncrement() {
    // Given
    final Pod created = client.resources(Pod.class).inNamespace("a-namespace")
        .resource(new PodBuilder()
            .withNewSpec().withDnsPolicy("always-dns").withHostname("change-me").endSpec()
            .withNewMetadata().withName("foo").addToLabels("app", "bar").endMetadata()
            .build())
        .create();
    final Pod patch = new PodBuilder()
        .editOrNewMetadata().withName("foo").endMetadata()
        .editOrNewSpec().withHostname("changed").endSpec()
        .build();
    // When
    final Pod patched = client.resources(Pod.class).inNamespace("a-namespace").withName("foo")
        .patch(PatchContext.of(PatchType.JSON_MERGE), patch);
    // Then
    assertThat(patched)
        .hasFieldOrPropertyWithValue("metadata.namespace", "a-namespace")
        .hasFieldOrPropertyWithValue("metadata.resourceVersion", "2")
        .hasFieldOrPropertyWithValue("metadata.generation", created.getMetadata().getGeneration() + 1)
        .hasFieldOrPropertyWithValue("spec.dnsPolicy", "always-dns")
        .hasFieldOrPropertyWithValue("spec.hostname", "changed");
    assertLocked(2, 0);
  }

  @Test
  @DisplayName("patch, JSON and namespaced, updates values incrementing generation preserving creation metadata")
  void patchJsonNamespacedUpdatesFieldsWithGenerationIncrement() {
    // Given
    final Pod created = client.resources(Pod.class).inNamespace("a-namespace")
        .resource(new PodBuilder()
            .withNewSpec().withDnsPolicy("always-dns").withHostname("change-me").endSpec()
            .withNewMetadata().withName("foo").addToLabels("app", "bar").endMetadata()
            .build())
        .create();
    final Pod patch = new PodBuilder(created)
        .editOrNewMetadata().withNamespace(null).endMetadata()
        .editOrNewSpec().withHostname("changed").endSpec()
        .build();
    // When
    final Pod patched = client.resources(Pod.class).inNamespace("a-namespace").withName("foo")
        .patch(PatchContext.of(PatchType.JSON), patch);
    // Then
    assertThat(patched)
        .hasFieldOrPropertyWithValue("metadata.name", "foo")
        .hasFieldOrPropertyWithValue("metadata.namespace", "a-namespace")
        .hasFieldOrPropertyWithValue("metadata.uid", created.getMetadata().getUid())
        .hasFieldOrPropertyWithValue("metadata.creationTimestamp",
            created.getMetadata().getCreationTimestamp())
        .hasFieldOrPropertyWithValue("metadata.resourceVersion", "2")
        .hasFieldOrPropertyWithValue("metadata.generation", 2L)
        .hasFieldOrPropertyWithValue("spec.dnsPolicy", "always-dns")
        .hasFieldOrPropertyWithValue("spec.hostname", "changed");
  }

  @Test
  @DisplayName("patch, JSON+Merge and cluster scoped, updates affected values ignoring other fields, incrementing generation, and preserving creation metadata")
  void patchClusterScopedUpdatesFieldsWithGenerationIncrement() {
    // Given
    final ClusterRole created = client.resources(ClusterRole.class).resource(
        new ClusterRoleBuilder().withNewMetadata().withName("name").endMetadata()
            .addNewRule().withResourceNames("Resource").endRule().build())
        .create();
    final ClusterRole patch = new ClusterRoleBuilder()
        .editOrNewMetadata().withName("name").endMetadata()
        .addNewRule().withResourceNames("Other").endRule().build();
    // When
    final ClusterRole patched = client.resources(ClusterRole.class).withName("name")
        .patch(PatchContext.of(PatchType.JSON_MERGE), patch);
    // Then
    assertThat(patched)
        .hasFieldOrPropertyWithValue("metadata.uid", created.getMetadata().getUid())
        .hasFieldOrPropertyWithValue("metadata.creationTimestamp",
            created.getMetadata().getCreationTimestamp())
        .hasFieldOrPropertyWithValue("metadata.resourceVersion", "2")
        .hasFieldOrPropertyWithValue("metadata.generation", created.getMetadata().getGeneration() + 1)
        .extracting(ClusterRole::getRules).asList().flatExtracting("resourceNames")
        .containsExactlyInAnyOrder("Resource", "Other");
  }

  @Test
  @DisplayName("editStatus, updates status values ignoring other fields and leaving generation unchanged")
  void editStatusUpdatesOnlyStatusWithNoGenerationIncrement() {
    // Given
    final Pod created = client.resources(Pod.class)
        .resource(new PodBuilder()
            .withNewSpec().withDnsPolicy("always-dns").endSpec()
            .withNewMetadata().withName("foo").addToLabels("app", "bar").endMetadata()
            .build())
        .create();
    // When
    final Pod patched = client.resources(Pod.class).withName("foo").editStatus(p -> new PodBuilder(p)
        .editOrNewSpec().withDnsPolicy("come-on").endSpec()
        .withNewStatus().withMessage("changed").endStatus()
        .build());
    // Then
    assertThat(patched)
        .returns(created.getMetadata().getGeneration(), p -> p.getMetadata().getGeneration())
        .hasFieldOrPropertyWithValue("spec.dnsPolicy", "always-dns")
        .hasFieldOrPropertyWithValue("status.message", "changed");
  }

  @Test
  @DisplayName("patchStatus, updates status values ignoring other fields and leaving generation unchanged")
  void patchStatusUpdatesOnlyStatusWithNoGenerationIncrement() {
    // Given
    final Pod created = client.resources(Pod.class)
        .resource(new PodBuilder()
            .withNewSpec().withDnsPolicy("always-dns").endSpec()
            .withNewMetadata().withName("foo").addToLabels("app", "bar").endMetadata()
            .build())
        .create();
    final Pod patch = new PodBuilder()
        .editOrNewMetadata().withName("foo").endMetadata()
        .editOrNewSpec().withDnsPolicy("come-on").endSpec()
        .withNewStatus().withMessage("changed").endStatus()
        .build();
    // When
    final Pod patched = client.resources(Pod.class).resource(patch).patchStatus();
    // Then
    assertThat(patched)
        .returns(created.getMetadata().getGeneration(), p -> p.getMetadata().getGeneration())
        .hasFieldOrPropertyWithValue("spec.dnsPolicy", "always-dns")
        .hasFieldOrPropertyWithValue("status.message", "changed");
  }

  @Test
  @DisplayName("editStatus, not existing, should return not found")
  void editStatusNotFound() {
    // Given
    final Resource<Pod> resource = client.resources(Pod.class).withName("not-found");
    final UnaryOperator<Pod> func = pod -> {
      pod.getStatus().setMessage("other");
      return pod;
    };
    // When
    final KubernetesClientException result = assertThrows(KubernetesClientException.class, () -> resource.editStatus(func));
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("code", 404)
        .hasMessageContaining("Not Found");
  }

  @Test
  @DisplayName("patch, custom resource with status, ignores changes to the status stanza")
  // PATCH requests to the custom resource ignore changes to the status stanza.
  void patchCrIgnoreStatusChanges() {
    // Given
    client.apiextensions().v1().customResourceDefinitions().resource(Owl.toCrd()).create();
    final Owl owl = new Owl();
    owl.setMetadata(new ObjectMetaBuilder().withName("lincoln-march").build());
    owl.getSpec().setSpecies("Barn owl");
    client.resources(Owl.class).resource(owl).create();
    owl.getSpec().setSpecies("Snowy owl");
    owl.getStatus().setNotes("updated");
    // When
    final Owl result = client.resources(Owl.class).withName("lincoln-march")
        .patch(PatchContext.of(PatchType.JSON), owl);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("spec.species", "Snowy owl")
        .hasFieldOrPropertyWithValue("status.notes", null);
  }

  @Test
  @DisplayName("patch, custom resource with status, ignores all changes except the status stanza")
  // PATCH requests to the /status subresource take a custom resource object and ignore changes to anything except the status stanza.
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
    final Owl result = client.resources(Owl.class).resource(owl).patchStatus();
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("spec.species", "Barn owl")
        .hasFieldOrPropertyWithValue("status.notes", "updated");
  }

  @Nested
  @DisplayName("Resource version validation")
  class ResourceVersion {

    @Test
    @DisplayName("JSON patch, with different resource version, should throw conflict exception")
    void differentResourceVersionConflictEdit() {
      // Given
      client.resource(new ConfigMapBuilder()
          .withNewMetadata().withName("json-different-resource-version").endMetadata()
          .addToData("key", "value")
          .build())
          .create();
      // When
      final NamespaceableResource<ConfigMap> patchedCmOp = client.resource(new ConfigMapBuilder()
          .withNewMetadata().withName("json-different-resource-version").withResourceVersion("different").endMetadata()
          .addToData("key", "changed")
          .build());
      // Then
      assertThatThrownBy(patchedCmOp::patch)
          .asInstanceOf(InstanceOfAssertFactories.type(KubernetesClientException.class))
          .hasFieldOrPropertyWithValue("code", 409)
          .extracting(KubernetesClientException::getMessage).asString()
          .contains("the object has been modified;");
    }

    @Test
    @DisplayName("JSON patch (list of operations), with different resource version, should throw conflict exception")
    void differentResourceVersionConflict() {
      // Given
      client.resource(new ConfigMapBuilder()
          .withNewMetadata().withName("json-different-resource-version-conflict").endMetadata()
          .addToData("key", "value")
          .build())
          .create();
      final Resource<ConfigMap> resourceOperation = client.configMaps()
          .withName("json-different-resource-version-conflict");
      final PatchContext json = PatchContext.of(PatchType.JSON);
      // When + Then
      assertThatThrownBy(() -> resourceOperation.patch(json,
          "[{\"op\": \"replace\", \"path\":\"/metadata/resourceVersion\", \"value\":\"diff\"}]"))
          .asInstanceOf(InstanceOfAssertFactories.type(KubernetesClientException.class))
          .hasFieldOrPropertyWithValue("code", 409)
          .extracting(KubernetesClientException::getMessage).asString()
          .contains("the object has been modified;");
    }

    @Test
    @DisplayName("JSON Merge patch, with different resource version, should throw conflict exception")
    void mergeDifferentResourceVersionConflict() {
      // Given
      client.resource(new ConfigMapBuilder()
          .withNewMetadata().withName("json-different-resource-version-merge").endMetadata()
          .addToData("key", "value")
          .build())
          .create();
      final Resource<ConfigMap> resourceOperation = client.resource(new ConfigMapBuilder()
          .withNewMetadata().withName("json-different-resource-version-merge").withResourceVersion("different").endMetadata()
          .addToData("key", "changed")
          .build());
      final PatchContext jsonMerge = PatchContext.of(PatchType.JSON_MERGE);
      // When + Then
      assertThatThrownBy(() -> resourceOperation.patch(jsonMerge))
          .asInstanceOf(InstanceOfAssertFactories.type(KubernetesClientException.class))
          .hasFieldOrPropertyWithValue("code", 409)
          .extracting(KubernetesClientException::getMessage).asString()
          .contains("the object has been modified;");
    }

    @Test
    @DisplayName("JSON Merge patch, with same resource version, should patch the resource")
    void mergeSameResourceVersionOk() {
      // Given
      final ConfigMap initialCm = client.resource(new ConfigMapBuilder()
          .withNewMetadata().withName("json-same-resource-version-merge").endMetadata()
          .addToData("key", "value")
          .build())
          .create();
      // When
      final ConfigMap patchedCm = client.resource(new ConfigMapBuilder()
          .withNewMetadata().withName("json-same-resource-version-merge")
          .withResourceVersion(initialCm.getMetadata().getResourceVersion()).endMetadata()
          .addToData("key", "changed")
          .build())
          .patch(PatchContext.of(PatchType.JSON_MERGE));
      // Then
      assertThat(patchedCm)
          .hasFieldOrPropertyWithValue("metadata.name", "json-same-resource-version-merge")
          .hasFieldOrPropertyWithValue("data.key", "changed")
          .extracting("metadata.resourceVersion")
          .isNotNull()
          .isNotEqualTo(initialCm.getMetadata().getResourceVersion());
    }
  }

}
