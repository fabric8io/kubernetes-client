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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.server.mock.crud.crd.Owl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class KubernetesCrudDispatcherFinalizerTest extends KubernetesCrudDispatcherTestBase {

  @BeforeEach
  void setUp() {
    super.setUp();
    client.apiextensions().v1().customResourceDefinitions().resource(Owl.toCrd()).create();
  }

  private Owl createOwlWithFinalizer(String owlName) {
    final Owl owl = new Owl();
    owl.setMetadata(new ObjectMetaBuilder().withName(owlName).withFinalizers("test-finalizer").build());
    return client.resources(Owl.class).resource(owl).create();
  }

  @Test
  @DisplayName("create resource with a deletionTimestamp, resource is created and the timestamp is not persisted")
  void createResourceWithDeletionTimestamp() {
    // Given:
    final Owl owl = new Owl();
    owl.setMetadata(
        new ObjectMetaBuilder().withName("owl-with-deletion-timestamp").withDeletionTimestamp("2020-10-22T21:30:34Z").build());
    client.resources(Owl.class).resource(owl).create();

    // When the created owl is retrieved:
    final Owl result = client.resources(Owl.class).resource(owl).get();

    // Then the owl is not marked for deletion:
    assertNotNull(result);
    assertFalse(result.isMarkedForDeletion());
  }

  @Test
  @DisplayName("when deleting a resource with a deletionTimestamp twice, then the deletionTimestamp doesn't change.")
  void deleteResourceWithFinalizerTwiceSameDeletionTimestamp() {
    // Given:
    final Owl initialOwl = createOwlWithFinalizer("owl-with-finalizer");

    // When deleting the owl with a finalizer for the first time:
    client.resources(Owl.class).resource(initialOwl).delete();

    // Then the owl has a valid deletion timestamp.
    Owl owl1 = client.resources(Owl.class).resource(initialOwl).get();
    assertNotNull(owl1);
    String deletionTimestamp1 = owl1.getMetadata().getDeletionTimestamp();
    assertNotNull(deletionTimestamp1);
    assertDoesNotThrow(() -> DateTimeFormatter.ISO_DATE_TIME.parse(deletionTimestamp1));
    assertNotEquals(initialOwl.getMetadata().getResourceVersion(), owl1.getMetadata().getResourceVersion());

    // When the owl is deleted a second time:
    client.resources(Owl.class).resource(owl1).delete();

    // Then the deletion timestamp stays the same.
    Owl owl2 = client.resources(Owl.class).resource(initialOwl).get();
    String deletionTimestamp2 = owl2.getMetadata().getDeletionTimestamp();
    assertEquals(deletionTimestamp1, deletionTimestamp2);
  }

  @Test
  @DisplayName("create a resource with a finalizer, mark it for deletion, remove the finalizer by replacing the resource, then it should be properly removed")
  void removeFinalizerByReplace() {
    // Given:
    Owl owl = createOwlWithFinalizer("owl-with-finalizer");

    // When owl with finalizer is deleted:
    client.resources(Owl.class).resource(owl).delete();
    Owl owlThatShouldBeMarkedForDeletion = client.resources(Owl.class).resource(owl).get();

    // Then the owl is marked for deletion, but not yet deleted.
    assertNotNull(owlThatShouldBeMarkedForDeletion);
    assertTrue(owlThatShouldBeMarkedForDeletion.isMarkedForDeletion());

    // When all finalizers are removed by a PUT operation:
    owlThatShouldBeMarkedForDeletion.getMetadata().setFinalizers(null);
    client.resources(Owl.class).resource(owlThatShouldBeMarkedForDeletion).replace();

    // Then the owl is actually deleted:
    Owl removedOwl = client.resources(Owl.class).resource(owlThatShouldBeMarkedForDeletion).get();
    assertNull(removedOwl);
  }

  @Test
  @DisplayName("create a resource with a finalizer, mark it for deletion, remove the finalizer by patching the resource, then it should be properly removed")
  void removeFinalizerByPatch() {
    // Given:
    final Owl owl = createOwlWithFinalizer("someOwl");

    // When owl with finalizer is deleted:
    client.resources(Owl.class).resource(owl).delete();
    Owl owlThatShouldBeMarkedForDeletion = client.resources(Owl.class).resource(owl).get();

    // Then the owl is marked for deletion, but not yet deleted.
    assertNotNull(owlThatShouldBeMarkedForDeletion);
    assertTrue(owlThatShouldBeMarkedForDeletion.isMarkedForDeletion());

    // When all finalizers are removed by a PATCH operation:
    owlThatShouldBeMarkedForDeletion.getMetadata().setFinalizers(null);
    client.resources(Owl.class).resource(owlThatShouldBeMarkedForDeletion).patch();

    // Then the owl is actually deleted:
    Owl removedOwl = client.resources(Owl.class).resource(owlThatShouldBeMarkedForDeletion).get();
    assertNull(removedOwl);
  }

  @Test
  @DisplayName("create multiple Owls with a finalizer, delete all Owls (with one API-Call), owls should only be deleted when finalizers have been removed")
  void removeAllOfResourceType() {
    // Given:
    List<String> owlNames = Arrays.asList("owl1", "owl2", "owl3");
    owlNames.forEach(this::createOwlWithFinalizer);

    // When all `Owl`s are deleted (not individually, but by type):
    client.resources(Owl.class).delete();

    // Then all owls are marked as deleted, but are not yet removed.
    List<Owl> owls = client.resources(Owl.class).list().getItems();
    assertTrue(owls.stream().allMatch(HasMetadata::isMarkedForDeletion));
    assertThat(owls.stream().map(o -> o.getMetadata().getName())).hasSameElementsAs(owlNames);

    // When all finalizers of all owls are removed:
    owls.forEach(o -> o.getMetadata().setFinalizers(null));
    owls.forEach(o -> client.resources(Owl.class).resource(o).replace());

    // Then all owls are removed.
    List<Owl> removedOwls = client.resources(Owl.class).list().getItems();
    assertTrue(removedOwls.isEmpty());
  }

}
