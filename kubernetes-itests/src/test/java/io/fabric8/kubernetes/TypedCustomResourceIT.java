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

import io.fabric8.commons.AssumingK8sVersionAtLeast;
import io.fabric8.commons.ClusterEntity;
import io.fabric8.crd.pet.Pet;
import io.fabric8.crd.pet.PetSpec;
import io.fabric8.crd.pet.PetStatus;
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
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class TypedCustomResourceIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private String currentNamespace;

  private static final CustomResourceDefinition petCrd = CustomResourceDefinitionContext.v1CRDFromCustomResourceType(Pet.class)
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

  private MixedOperation<Pet, KubernetesResourceList<Pet>, Resource<Pet>> petClient;

  @ClassRule
  public static final AssumingK8sVersionAtLeast assumingK8sVersion = new AssumingK8sVersionAtLeast("1", "16");

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(petCrd);
  }

  @Before
  public void initPetClientAndCurrentNamespace() {
    petClient = client.customResources(Pet.class);
    currentNamespace = session.getNamespace();
  }

  @Test
  public void create() {
    // Given
    Pet pet = createNewPet("pet-create", "Dog", null);

    // When
    Pet createdPet = petClient.inNamespace(currentNamespace).create(pet);

    // Then
    assertPet(createdPet, "pet-create", "Dog", null);
  }

  @Test
  public void createOrReplace() {
    // Given
    Pet pet = createNewPet("pet-createorreplace", "Dog", null);

    // When
    Pet createdPet = petClient.inNamespace(currentNamespace).create(pet);
    createdPet.getSpec().setType("Buffalo");
    Pet replacedPet = petClient.inNamespace(currentNamespace).createOrReplace(createdPet);

    // Then
    assertPet(replacedPet, "pet-createorreplace", "Buffalo", null);
  }

  @Test
  public void get() {
    // Given
    Pet pet = createNewPet("pet-get", "Cow", null);

    // When
    petClient.inNamespace(currentNamespace).create(pet);
    Pet petFromServer = petClient.inNamespace(currentNamespace).withName("pet-get").get();

    // Then
    assertPet(petFromServer, "pet-get", "Cow", null);
  }

  @Test
  public void list() {
    // Given
    Pet pet = createNewPet("pet-list", "Parrot", null);

    // When
    petClient.inNamespace(currentNamespace).create(pet);
    KubernetesResourceList<Pet> petList = petClient.inNamespace(currentNamespace).list();

    // Then
    assertNotNull(petList);
    assertNotNull(petList.getItems());
    assertTrue(petList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    // Given
    Pet pet = createNewPet("pet-update", "Pigeon", null);

    // When
    petClient.inNamespace(currentNamespace).create(pet);
    await().atMost(5, TimeUnit.SECONDS)
      .until(() -> petClient.inNamespace(currentNamespace).withName("pet-update").get() != null);
    Pet updatedPet = petClient.inNamespace(currentNamespace).withName("pet-update").edit(pet1 -> {
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
  public void updateStatusSubresource() {
    // Given
    Pet pet = createNewPet("pet-updatestatus", "Pigeon", null);
    PetStatus petStatusToUpdate = new PetStatus();
    petStatusToUpdate.setCurrentStatus("Sleeping");

    // When
    pet = petClient.inNamespace(currentNamespace).create(pet);
    await().atMost(5, TimeUnit.SECONDS)
      .until(() -> petClient.inNamespace(currentNamespace).withName("pet-updatestatus").get() != null);
    pet.getSpec().setType("shouldn't change");
    pet.setStatus(petStatusToUpdate);
    Pet updatedPet = petClient.inNamespace(currentNamespace).updateStatus(pet);

    // Then
    assertPet(updatedPet, "pet-updatestatus", "Pigeon", "Sleeping");
  }

  @Test
  public void replaceStatusSubresource() {
    // Given
    Pet pet = createNewPet("pet-replacestatus", "Pigeon", null);
    PetStatus petStatusToUpdate = new PetStatus();
    petStatusToUpdate.setCurrentStatus("Sleeping");

    // When
    petClient.inNamespace(currentNamespace).create(pet);
    await().atMost(5, TimeUnit.SECONDS)
      .until(() -> petClient.inNamespace(currentNamespace).withName("pet-replacestatus").get() != null);
    // use the original pet, no need to pick up the resourceVersion
    pet.getSpec().setType("shouldn't change");
    pet.setStatus(petStatusToUpdate);
    Pet updatedPet = petClient.inNamespace(currentNamespace).withName(pet.getMetadata().getName()).replaceStatus(pet);

    // Then
    assertPet(updatedPet, "pet-replacestatus", "Pigeon", "Sleeping");
  }

  @Test
  public void patchStatusSubresource() {
    // Given
    Pet pet = createNewPet("pet-applystatus", "Pigeon", null);
    PetStatus petStatusToUpdate = new PetStatus();
    petStatusToUpdate.setCurrentStatus("Sleeping");

    // When
    petClient.inNamespace(currentNamespace).create(pet);
    await().atMost(5, TimeUnit.SECONDS)
      .until(() -> petClient.inNamespace(currentNamespace).withName("pet-applystatus").get() != null);
    // use the original pet, no need to pick up the resourceVersion
    pet.getSpec().setType("shouldn't change");
    pet.setStatus(petStatusToUpdate);
    Pet updatedPet = petClient.inNamespace(currentNamespace).withName(pet.getMetadata().getName()).patchStatus(pet);

    // Then
    assertPet(updatedPet, "pet-applystatus", "Pigeon", "Sleeping");
  }

  @Test
  public void editStatusSubresource() {
    // Given
    Pet pet = createNewPet("pet-editstatus", "Pigeon", null);
    PetStatus petStatusToUpdate = new PetStatus();
    petStatusToUpdate.setCurrentStatus("Sleeping");

    // When
    petClient.inNamespace(currentNamespace).create(pet);
    await().atMost(5, TimeUnit.SECONDS)
      .until(() -> petClient.inNamespace(currentNamespace).withName("pet-editstatus").get() != null);
    Pet updatedPet = petClient.inNamespace(currentNamespace).withName("pet-editstatus").editStatus(p->{
      Pet clone = Serialization.clone(pet);
      clone.setStatus(petStatusToUpdate);
      clone.getSpec().setType("shouldn't change");
      return clone;
    });

    // Then
    assertPet(updatedPet, "pet-editstatus", "Pigeon", "Sleeping");
  }

  @Test
  public void watch() throws InterruptedException {
    // Given
    Pet pet = createNewPet("pet-watch", "Hamster", null);

    // When
    CountDownLatch creationEventReceived = new CountDownLatch(1);
    Watch petWatch = petClient.inNamespace(currentNamespace).watch(new Watcher<Pet>() {
      @Override
      public void eventReceived(Action action, Pet resource) {
        if (resource.getMetadata().getName().equals("pet-watch")) {
          creationEventReceived.countDown();
        }
      }

      @Override
      public void onClose(WatcherException cause) { }
    });
    petClient.inNamespace(currentNamespace).createOrReplace(pet);

    // Then
    assertTrue(creationEventReceived.await(1, TimeUnit.SECONDS));
    petWatch.close();
  }

  @Test
  public void delete() {
    // Given
    Pet pet = createNewPet("pet-delete", "Cow", "Eating");

    // When
    petClient.inNamespace(currentNamespace).create(pet);
    Boolean isDeleted = petClient.inNamespace(currentNamespace).withName("pet-delete").delete();

    // Then
    assertNotNull(isDeleted);
    assertTrue(isDeleted);
  }

  @Test
  public void dryRunCreate() {
    // Given
    Pet parrot = createNewPet("dry-run-create", "Parrot", "Chirping");

    // When
    Pet createdParrot = petClient.inNamespace(currentNamespace).dryRun().create(parrot);

    // Then
    assertNotNull(createdParrot);
    assertNotNull(createdParrot.getMetadata());
    assertNotNull(createdParrot.getMetadata().getUid());
    assertNotNull(createdParrot.getMetadata().getCreationTimestamp());
    Pet parrotFromServer = petClient.inNamespace(currentNamespace).withName("dry-run-create").get();
    assertNull(parrotFromServer);
  }

  @Test
  public void dryRunDelete() {
    // Given
    Pet duck = createNewPet("dry-run-delete", "Duck", "Quacking");
    petClient.inNamespace(currentNamespace).createOrReplace(duck);

    // When
    boolean isDeleted = petClient.inNamespace(currentNamespace).withName("dry-run-delete").dryRun().delete();

    // Then
    assertTrue(isDeleted);
    Pet duckFromServer = petClient.inNamespace(currentNamespace).withName("dry-run-delete").get();
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

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(petCrd);
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
