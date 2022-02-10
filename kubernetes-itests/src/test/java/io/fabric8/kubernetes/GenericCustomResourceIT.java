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
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
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

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class GenericCustomResourceIT {
  @ArquillianResource
  public KubernetesClient client;

  @ArquillianResource
  public Session session;

  @ClassRule
  public static final AssumingK8sVersionAtLeast assumingK8sVersion =
    new AssumingK8sVersionAtLeast("1", "16");

  private String currentNamespace;

  private CustomResourceDefinitionContext customResourceDefinitionContext;

  private NonNamespaceOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> resourceClient;

  @BeforeClass
  public static void initCrd() {
    // Create a Custom Resource Definition Animals:
    ClusterEntity.apply(GenericCustomResourceIT.class.getResourceAsStream("/test-rawcustomresource-definition.yml"));
  }

  @Before
  public void initCustomResourceDefinitionContextAndNamespace() {
    currentNamespace = session.getNamespace();

    customResourceDefinitionContext = new CustomResourceDefinitionContext.Builder()
      .withName("animals.jungle.example.com")
      .withGroup("jungle.example.com")
      .withVersion("v1")
      .withPlural("animals")
      .withScope("Namespaced")
      .build();

    this.resourceClient = client.genericKubernetesResources(customResourceDefinitionContext).inNamespace(currentNamespace);
  }

  @Test
  public void testCrud() throws IOException {
    // Test Create via file
    GenericKubernetesResource object = resourceClient.load(getClass().getResourceAsStream("/test-rawcustomresource.yml")).create();
    assertThat(object.getMetadata().getName()).isEqualTo("otter");

    // Test Create via raw json string
    String rawJsonCustomResourceObj = "{\"apiVersion\":\"jungle.example.com/v1\"," +
      "\"kind\":\"Animal\",\"metadata\": {\"name\": \"walrus\"}," +
      "\"spec\": {\"image\": \"my-awesome-walrus-image\"}}";
    object = resourceClient.createOrReplace(Serialization.unmarshal(rawJsonCustomResourceObj, GenericKubernetesResource.class));
    assertAnimal(object, "walrus", "my-awesome-walrus-image");

    // Test replace with object
    ((HashMap<String, String>)object.get("spec")).put("image", "new-walrus-image");
    object = resourceClient.createOrReplace(object);
    assertAnimal(object, "walrus", "new-walrus-image");

    // Test Get:
    object = resourceClient.withName("otter").get();
    assertThat(object.getMetadata().getName()).isEqualTo("otter");

    // Test List:
    GenericKubernetesResourceList list = resourceClient.list();
    assertThat(list.getItems().size()).isGreaterThanOrEqualTo(2);

    // List with labels:
    list = resourceClient.withLabel("foo", "bar").list();
    assertThat(list.getItems().size()).isGreaterThanOrEqualTo(1);

    // Test Update
    GenericKubernetesResource updated = resourceClient.withName("walrus").get();
    ((HashMap<String, Object>)updated.get("spec")).put("image", "my-updated-awesome-walrus-image");
    object = resourceClient.withName("walrus").edit(r->updated);
    assertAnimal(object, "walrus", "my-updated-awesome-walrus-image");

    // Test Delete:
    resourceClient.withName("otter").delete();
    resourceClient.delete();
  }

  @Test
  public void testCreateReadDeleteUsingInputStream() throws IOException {
    // Create
    String name = "hippo";
    InputStream hippoInputStream = getClass().getResourceAsStream("/rawcustomresourceit-crud-inputstream.yml");
    GenericKubernetesResource hippoCr = resourceClient.load(hippoInputStream).create();
    assertAnimal(hippoCr, name, "Hippopotamidae");

    // Read
    hippoCr = resourceClient.withName(name).get();
    assertAnimal(hippoCr, name, "Hippopotamidae");

    // Delete
    boolean isDeleted = resourceClient.withName(name).delete();
    assertTrue(isDeleted);
  }

  @Test
  public void testWatch() throws IOException, InterruptedException {
    // Given
    String name = "chital";
    GenericKubernetesResource deer = createNewAnimal(name, "spotted-deer");
    CountDownLatch creationEventReceived = new CountDownLatch(1);

    // When
    resourceClient.watch(new Watcher<GenericKubernetesResource>() {
      @Override
      public void eventReceived(Action action, GenericKubernetesResource resource) {
        if (resource.getMetadata().getName().equals(name)) {
          creationEventReceived.countDown();
        }
      }

      @Override
      public void onClose(WatcherException cause) { }
    });
    resourceClient.create(deer);

    // Then
    assertTrue(creationEventReceived.await(1, TimeUnit.SECONDS));
  }

  @Test
  public void testUpdateStatus() throws IOException {
    // Given
    String name = "black-buck";
    GenericKubernetesResource deer = createNewAnimal(name, "indian-antelope");
    Map<String, Object> status = new HashMap<>();
    status.put("conservationStatus", "endangered");

    // When
    deer = resourceClient.create(deer);
    await().atMost(10, TimeUnit.SECONDS)
      .until(() -> resourceClient.withName(name) != null);
    deer.getAdditionalProperties().put("status", status);
    GenericKubernetesResource updatedDeer = resourceClient.withName(name).updateStatus(deer);

    // Then
    assertNotNull(updatedDeer);
    assertEquals("endangered", deer.get("status", "conservationStatus"));
  }

  @Test
  public void testDeleteNonExistingResource() throws IOException {
    boolean isDeleted = resourceClient.withName("idontexist").delete();
    assertFalse(isDeleted);
  }

  @Test
  public void testDryRunCreate() throws IOException {
    // Given
    GenericKubernetesResource elephant = createNewAnimal("elephant", "indian-elephant");

    // When
    GenericKubernetesResource createdElephant = resourceClient.dryRun().create(elephant);

    // Then
    assertNotNull(createdElephant);
    assertNull(resourceClient.withName("elephant").get());
  }

  @Test
  public void testDryRunDelete() throws IOException {
    // Given
    GenericKubernetesResource dhole = createNewAnimal("dhole", "indian-wild-dog");
    GenericKubernetesResource createdDhole = resourceClient.create(dhole);

    // When
    boolean deletionStatus = resourceClient.withName("dhole").dryRun().delete();

    // Then
    assertTrue(deletionStatus);
    GenericKubernetesResource dholeFromServer = resourceClient.withName("dhole").get();
    assertNotNull(dholeFromServer);
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(GenericCustomResourceIT.class.getResourceAsStream("/test-rawcustomresource-definition.yml"));
  }

  private void assertAnimal(GenericKubernetesResource animal, String name, String image) {
    assertNotNull(animal);
    assertThat(animal.getMetadata().getName()).isEqualTo(name);
    assertThat((String)animal.get("spec", "image")).isEqualTo(image);
  }

  private GenericKubernetesResource createNewAnimal(String name, String image) {
      Map<String, Object> crAsMap = new HashMap<>();
      crAsMap.put("apiVersion", "jungle.example.com/v1");
      crAsMap.put("kind", "Animal");

      Map<String, Object> crMetadata = new HashMap<>();
      crMetadata.put("name", name);
      crMetadata.put("labels", Collections.singletonMap("foo", "bar"));
      Map<String, Object> crSpec = new HashMap<>();
      crSpec.put("image", image);

      crAsMap.put("metadata", crMetadata);
      crAsMap.put("spec", crSpec);

      return Serialization.jsonMapper().convertValue(crAsMap, GenericKubernetesResource.class);
  }
}
