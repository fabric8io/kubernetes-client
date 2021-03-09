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

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class RawCustomResourceIT {
  @ArquillianResource
  public KubernetesClient client;

  @ArquillianResource
  public Session session;

  private String currentNamespace;

  private CustomResourceDefinitionContext customResourceDefinitionContext;

  @BeforeClass
  public static void initCrd() {
    // Create a Custom Resource Definition Animals:
    ClusterEntity.apply(RawCustomResourceIT.class.getResourceAsStream("/test-rawcustomresource-definition.yml"));
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
  }

  @Test
  public void testCrud() throws IOException {
    // Test Create via file
    Map<String, Object> object = client.customResource(customResourceDefinitionContext).create(currentNamespace, getClass().getResourceAsStream("/test-rawcustomresource.yml"));
    assertThat(((HashMap<String, String>)object.get("metadata")).get("name")).isEqualTo("otter");

    // Test Create via raw json string
    String rawJsonCustomResourceObj = "{\"apiVersion\":\"jungle.example.com/v1\"," +
      "\"kind\":\"Animal\",\"metadata\": {\"name\": \"walrus\"}," +
      "\"spec\": {\"image\": \"my-awesome-walrus-image\"}}";
    object = client.customResource(customResourceDefinitionContext).createOrReplace(currentNamespace, rawJsonCustomResourceObj);
    assertAnimal(object, "walrus", "my-awesome-walrus-image");

    // Test replace with object
    ((HashMap<String, String>)object.get("spec")).put("image", "new-walrus-image");
    object = client.customResource(customResourceDefinitionContext).createOrReplace(currentNamespace, object);
    assertAnimal(object, "walrus", "new-walrus-image");

    // Test Get:
    object = client.customResource(customResourceDefinitionContext).get(currentNamespace, "otter");
    assertThat(((HashMap<String, String>)object.get("metadata")).get("name")).isEqualTo("otter");

    // Test List:
    Map<String, Object> list = client.customResource(customResourceDefinitionContext).list(currentNamespace);
    assertThat(((ArrayList<Object>)list.get("items")).size()).isGreaterThanOrEqualTo(2);

    // List with labels:
    list = client.customResource(customResourceDefinitionContext).list(currentNamespace, Collections.singletonMap("foo", "bar"));
    assertThat(((ArrayList<Object>)list.get("items")).size()).isGreaterThanOrEqualTo(1);

    // Test Update
    object = client.customResource(customResourceDefinitionContext).get(currentNamespace, "walrus");
    ((HashMap<String, Object>)object.get("spec")).put("image", "my-updated-awesome-walrus-image");
    object = client.customResource(customResourceDefinitionContext).edit(currentNamespace, "walrus", new ObjectMapper().writeValueAsString(object));
    assertAnimal(object, "walrus", "my-updated-awesome-walrus-image");

    // Test Delete:
    client.customResource(customResourceDefinitionContext).delete(currentNamespace, "otter");
    client.customResource(customResourceDefinitionContext).delete(currentNamespace);
  }

  @Test
  public void testCrudUsingMap() throws IOException {
    // Create
    String name = "bison";
    Map<String, Object> bison = createNewAnimal(name, "wisent");
    bison = client.customResource(customResourceDefinitionContext).create(currentNamespace, bison);
    assertAnimal(bison, "bison", "wisent");

    // Read
    bison = client.customResource(customResourceDefinitionContext).get(currentNamespace, name);
    assertAnimal(bison, "bison", "wisent");

    // Update
    ((Map<String, Object>)bison.get("spec")).put("image", "bison-bonasus");
    bison = client.customResource(customResourceDefinitionContext).edit(currentNamespace, name, bison);
    assertAnimal(bison, "bison", "bison-bonasus");

    // Delete
    boolean isDeleted = client.customResource(customResourceDefinitionContext).delete(currentNamespace, name);
    assertTrue(isDeleted);
  }

  @Test
  public void testCreateReadDeleteUsingInputStream() throws IOException {
    // Create
    String name = "hippo";
    InputStream hippoInputStream = getClass().getResourceAsStream("/rawcustomresourceit-crud-inputstream.yml");
    Map<String, Object> hippoCr = client.customResource(customResourceDefinitionContext).create(currentNamespace, hippoInputStream);
    assertAnimal(hippoCr, name, "Hippopotamidae");

    // Read
    hippoCr = client.customResource(customResourceDefinitionContext).get(currentNamespace, name);
    assertAnimal(hippoCr, name, "Hippopotamidae");

    // Delete
    boolean isDeleted = client.customResource(customResourceDefinitionContext).delete(currentNamespace, name);
    assertTrue(isDeleted);
  }

  @Test
  public void testCrudUsingString() throws IOException {
    // Create
    String name = "rhino";
    String rhino = "{\"apiVersion\": \"jungle.example.com/v1\"," +
      "    \"kind\": \"Animal\"," +
      "    \"metadata\": {\"name\": \"rhino\"}," +
      "    \"spec\": {\"image\": \"Rhinocerotidae\"}}";
    Map<String, Object> rhinoCr = client.customResource(customResourceDefinitionContext).create(currentNamespace, rhino);
    assertAnimal(rhinoCr, name, "Rhinocerotidae");

    // Read
    rhinoCr = client.customResource(customResourceDefinitionContext).get(currentNamespace, name);
    assertAnimal(rhinoCr, name, "Rhinocerotidae");

    // Update
    ((Map<String, Object>)rhinoCr.get("spec")).put("image", "rhinoceros");
    String rhinoCrAsStr = Serialization.jsonMapper().writeValueAsString(rhinoCr);
    rhinoCr = client.customResource(customResourceDefinitionContext).edit(currentNamespace, name, rhinoCrAsStr);
    assertAnimal(rhinoCr, name, "rhinoceros");

    // Delete
    boolean isDeleted = client.customResource(customResourceDefinitionContext).delete(currentNamespace, name);
    assertTrue(isDeleted);
  }

  @Test
  public void testWatch() throws IOException, InterruptedException {
    // Given
    String name = "chital";
    Map<String, Object> deer = createNewAnimal(name, "spotted-deer");
    CountDownLatch creationEventReceived = new CountDownLatch(1);

    // When
    client.customResource(customResourceDefinitionContext).watch(currentNamespace, new Watcher<String>() {
      @Override
      public void eventReceived(Action action, String resource) {
        if (resource.contains(name)) {
          creationEventReceived.countDown();
        }
      }

      @Override
      public void onClose(WatcherException cause) { }
    });
    client.customResource(customResourceDefinitionContext).create(currentNamespace, deer);

    // Then
    assertTrue(creationEventReceived.await(1, TimeUnit.SECONDS));
  }

  @Test
  public void testUpdateStatus() throws IOException {
    // Given
    String name = "black-buck";
    Map<String, Object> deer = createNewAnimal(name, "indian-antelope");
    Map<String, Object> status = new HashMap<>();
    status.put("conservationStatus", "endangered");

    // When
    deer = client.customResource(customResourceDefinitionContext).create(currentNamespace, deer);
    await().atMost(5, TimeUnit.SECONDS)
      .until(() -> client.customResource(customResourceDefinitionContext).get(currentNamespace, name) != null);
    deer.put("status", status);
    Map<String, Object> updatedDeer = client.customResource(customResourceDefinitionContext).updateStatus(currentNamespace, name, deer);

    // Then
    assertNotNull(updatedDeer);
    assertEquals("endangered", ((Map<String, Object>)deer.get("status")).get("conservationStatus").toString());
  }

  @Test
  public void testDeleteNonExistingResource() throws IOException {
    boolean isDeleted = client.customResource(customResourceDefinitionContext).delete(currentNamespace, "idontexist");
    assertFalse(isDeleted);
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(RawCustomResourceIT.class.getResourceAsStream("/test-rawcustomresource-definition.yml"));
  }

  private void assertAnimal(Map<String, Object> animal, String name, String image) {
    assertNotNull(animal);
    assertFalse(animal.isEmpty());
    assertThat(((HashMap<String, String>)animal.get("metadata")).get("name")).isEqualTo(name);
    assertThat(((HashMap<String, String>)animal.get("spec")).get("image")).isEqualTo(image);
  }

  private Map<String, Object> createNewAnimal(String name, String image) {
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

      return crAsMap;
  }
}
