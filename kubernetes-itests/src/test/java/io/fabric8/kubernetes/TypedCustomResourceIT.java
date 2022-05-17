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
package io.fabric8.kubernetes;

import io.fabric8.crd.pet.Pet;
import io.fabric8.crd.pet.PetSpec;
import io.fabric8.crd.pet.PetStatus;
import io.fabric8.junit.jupiter.api.RequireK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sVersionAtLeast(majorVersion = 1, minorVersion = 16)
class TypedCustomResourceIT {

  static KubernetesClient client;

  private static MixedOperation<Pet, KubernetesResourceList<Pet>, Resource<Pet>> petClient;

  private static final CustomResourceDefinition petCrd = CustomResourceDefinitionContext
      .v1CRDFromCustomResourceType(Pet.class)
      .editSpec().editVersion(0)
      .withNewSubresources()
      .withNewStatus().endStatus()
      .endSubresources()
      .withNewSchema()
      .withNewOpenAPIV3Schema()
      .withType("object")
      .addToProperties(Collections.singletonMap("spec", new JSONSchemaPropsBuilder()
          .withType("object")
          .withProperties(Collections.singletonMap("type", new JSONSchemaPropsBuilder()
              .withType("string")
              .build()))
          .build()))
      .addToProperties(Collections.singletonMap("status", new JSONSchemaPropsBuilder()
          .withType("object")
          .withProperties(Collections.singletonMap("currentStatus", new JSONSchemaPropsBuilder()
              .withType("string")
              .build()))
          .build()))
      .endOpenAPIV3Schema()
      .endSchema()
      .endVersion()
      .endSpec()
      .build();

  @BeforeAll
  public static void init() {
    client.resource(petCrd).create();
    client.apiextensions().v1().customResourceDefinitions()
        .withName("pets.testing.fabric8.io")
        .waitUntilCondition(
            c -> c.getStatus() != null && c.getStatus().getConditions() != null && c.getStatus().getConditions().stream()
                .anyMatch(crdc -> crdc.getType().equals("Established") && crdc.getStatus().equals("True")),
            10L, TimeUnit.SECONDS);
    petClient = client.resources(Pet.class);
  }

  @AfterAll
  public static void cleanup() {
    client.resource(petCrd).withGracePeriod(0L).delete();
  }

  @Test
  void create() {
    // Given
    Pet pet = createNewPet("pet-create", "Dog", null);
    // When
    Pet createdPet = petClient.create(pet);
    // Then
    assertPet(createdPet, "pet-create", "Dog", null);
  }

  @Test
  void createOrReplace() {
    // Given
    Pet pet = createNewPet("pet-createorreplace", "Dog", null);
    // When
    Pet createdPet = petClient.create(pet);
    createdPet.getSpec().setType("Buffalo");
    Pet replacedPet = petClient.createOrReplace(createdPet);
    // Then
    assertPet(replacedPet, "pet-createorreplace", "Buffalo", null);
  }

  @Test
  void get() {
    // Given
    Pet pet = createNewPet("pet-get", "Cow", null);
    // When
    petClient.create(pet);
    Pet petFromServer = petClient.withName("pet-get").get();
    // Then
    assertPet(petFromServer, "pet-get", "Cow", null);
  }

  @Test
  void list() {
    // Given
    Pet pet = createNewPet("pet-list", "Parrot", null);
    // When
    petClient.create(pet);
    KubernetesResourceList<Pet> petList = petClient.list();
    // Then
    assertNotNull(petList);
    assertNotNull(petList.getItems());
    assertTrue(petList.getItems().size() >= 1);
  }

  @Test
  void update() {
    // Given
    Pet pet = createNewPet("pet-update", "Pigeon", null);
    // When
    petClient.create(pet);
    await().atMost(5, TimeUnit.SECONDS)
        .until(() -> petClient.withName("pet-update").get() != null);
    Pet updatedPet = petClient.withName("pet-update").edit(pet1 -> {
      pet1.getMetadata().setAnnotations(Collections.singletonMap("first", "1"));
      return pet1;
    });
    // Then
    assertPet(updatedPet, "pet-update", "Pigeon", null);
    assertNotNull(updatedPet.getMetadata().getAnnotations());
    assertEquals(1, updatedPet.getMetadata().getAnnotations().size());
    assertEquals("1", updatedPet.getMetadata().getAnnotations().get("first"));
  }

  @Test
  @SuppressWarnings("deprecation")
  void updateStatusSubresource() {
    // Given
    Pet pet = createNewPet("pet-update-status", "Pigeon", null);
    PetStatus petStatusToUpdate = new PetStatus();
    petStatusToUpdate.setCurrentStatus("Sleeping");
    // When
    pet = petClient.create(pet);
    petClient.withName("pet-update-status")
        .waitUntilCondition(Objects::nonNull, 5, TimeUnit.SECONDS);
    pet.getSpec().setType("shouldn't change");
    pet.setStatus(petStatusToUpdate);
    Pet updatedPet = petClient.updateStatus(pet);
    // Then
    assertPet(updatedPet, "pet-update-status", "Pigeon", "Sleeping");
  }

  @Test
  void replaceStatusSubresource() {
    // Given
    Pet pet = createNewPet("pet-replace-status", "Pigeon", null);
    PetStatus petStatusToUpdate = new PetStatus();
    petStatusToUpdate.setCurrentStatus("Sleeping");
    // When
    petClient.create(pet);
    petClient.withName("pet-replace-status")
        .waitUntilCondition(Objects::nonNull, 5, TimeUnit.SECONDS);
    pet.getSpec().setType("shouldn't change");
    pet.setStatus(petStatusToUpdate);
    Pet updatedPet = petClient.replaceStatus(pet);
    // Then
    assertPet(updatedPet, "pet-replace-status", "Pigeon", "Sleeping");
  }

  @Test
  void patchStatusSubresource() {
    // Given
    Pet pet = createNewPet("pet-apply-status", "Pigeon", null);
    PetStatus petStatusToUpdate = new PetStatus();
    petStatusToUpdate.setCurrentStatus("Sleeping");
    // When
    petClient.create(pet);
    petClient.withName("pet-apply-status")
        .waitUntilCondition(Objects::nonNull, 5, TimeUnit.SECONDS);
    // use the original pet, no need to pick up the resourceVersion
    pet.getSpec().setType("shouldn't change");
    pet.setStatus(petStatusToUpdate);
    Pet updatedPet = petClient.withName(pet.getMetadata().getName()).patchStatus(pet);
    // Then
    assertPet(updatedPet, "pet-apply-status", "Pigeon", "Sleeping");
  }

  @Test
  void editStatusSubresource() {
    // Given
    Pet pet = createNewPet("pet-edit-status", "Pigeon", null);
    PetStatus petStatusToUpdate = new PetStatus();
    petStatusToUpdate.setCurrentStatus("Sleeping");
    // When
    petClient.create(pet);
    petClient.withName("pet-edit-status")
        .waitUntilCondition(Objects::nonNull, 5, TimeUnit.SECONDS);
    Pet updatedPet = petClient.withName("pet-edit-status").editStatus(p -> {
      Pet clone = Serialization.clone(pet);
      clone.setStatus(petStatusToUpdate);
      clone.getSpec().setType("shouldn't change");
      return clone;
    });
    // Then
    assertPet(updatedPet, "pet-edit-status", "Pigeon", "Sleeping");
  }

  @Test
  void watch() throws InterruptedException {
    Pet pet = createNewPet("pet-watch", "Hamster", null);
    CountDownLatch creationEventReceived = new CountDownLatch(1);
    try (Watch ignore = petClient.watch(new Watcher<Pet>() {
      @Override
      public void eventReceived(Action action, Pet resource) {
        if (resource.getMetadata().getName().equals("pet-watch")) {
          creationEventReceived.countDown();
        }
      }

      @Override
      public void onClose(WatcherException cause) {
      }
    })) {
      petClient.createOrReplace(pet);
      assertTrue(creationEventReceived.await(1, TimeUnit.SECONDS));
    }
  }

  @Test
  void delete() {
    // Given
    Pet pet = createNewPet("pet-delete", "Cow", "Eating");
    // When
    petClient.create(pet);
    boolean isDeleted = petClient.withName("pet-delete").delete().size() == 1;
    // Then
    assertTrue(isDeleted);
  }

  @Test
  void dryRunCreate() {
    // Given
    Pet parrot = createNewPet("dry-run-create", "Parrot", "Chirping");
    // When
    Pet createdParrot = petClient.dryRun().create(parrot);
    // Then
    assertNotNull(createdParrot);
    assertNotNull(createdParrot.getMetadata());
    assertNotNull(createdParrot.getMetadata().getUid());
    assertNotNull(createdParrot.getMetadata().getCreationTimestamp());
    Pet parrotFromServer = petClient.withName("dry-run-create").get();
    assertNull(parrotFromServer);
  }

  @Test
  void dryRunDelete() {
    // Given
    Pet duck = createNewPet("dry-run-delete", "Duck", "Quacking");
    petClient.createOrReplace(duck);
    // When
    boolean isDeleted = petClient.withName("dry-run-delete").dryRun().delete().size() == 1;
    // Then
    assertTrue(isDeleted);
    Pet duckFromServer = petClient.withName("dry-run-delete").get();
    assertNotNull(duckFromServer);
  }

  private void assertPet(Pet pet, String name, String type, String currentStatus) {
    assertNotNull(pet);
    assertEquals(name, pet.getMetadata().getName());
    assertEquals(type, pet.getSpec().getType());
    if (currentStatus != null) {
      assertEquals(currentStatus, pet.getStatus().getCurrentStatus());
    }
  }

  private Pet createNewPet(String name, String type, String currentStatus) {
    Pet pet = new Pet();

    PetSpec petSpec = new PetSpec();
    petSpec.setType(type);
    pet.setSpec(petSpec);

    if (currentStatus != null) {
      PetStatus petStatus = new PetStatus();
      petStatus.setCurrentStatus(currentStatus);
      pet.setStatus(petStatus);
    }
    pet.setMetadata(new ObjectMetaBuilder().withName(name).build());
    return pet;
  }
}
