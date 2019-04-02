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
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class RawCustomResourceIT {
  @ArquillianResource
  public KubernetesClient client;

  @ArquillianResource
  public Session session;

  private String currentNamespace;

  private CustomResourceDefinitionContext customResourceDefinitionContext;

  @Before
  public void initCustomResourceDefinition() {
    currentNamespace = session.getNamespace();

    // Create a Custom Resource Definition Animals:
    CustomResourceDefinition animalCrd = client.customResourceDefinitions().load(getClass().getResourceAsStream("/test-rawcustomresource-definition.yml")).get();
    client.customResourceDefinitions().create(animalCrd);

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
    object = client.customResource(customResourceDefinitionContext).create(currentNamespace, rawJsonCustomResourceObj);
    assertThat(((HashMap<String, String>)object.get("metadata")).get("name")).isEqualTo("walrus");

    // Test Get:
    object = client.customResource(customResourceDefinitionContext).get(currentNamespace, "otter");
    assertThat(((HashMap<String, String>)object.get("metadata")).get("name")).isEqualTo("otter");

    // Test List:
    Map<String, Object> list = client.customResource(customResourceDefinitionContext).list(currentNamespace);
    assertThat(((ArrayList<Object>)list.get("items")).size()).isEqualTo(2);

    // List with labels:
    list = client.customResource(customResourceDefinitionContext).list(currentNamespace, Collections.singletonMap("foo", "bar"));
    assertThat(((ArrayList<Object>)list.get("items")).size()).isEqualTo(1);

    // Test Update
    object = client.customResource(customResourceDefinitionContext).get(currentNamespace, "walrus");
    ((HashMap<String, Object>)object.get("spec")).put("image", "my-updated-awesome-walrus-image");
    object = client.customResource(customResourceDefinitionContext).edit(currentNamespace, "walrus", new ObjectMapper().writeValueAsString(object));
    assertThat(((HashMap<String, Object>)object.get("spec")).get("image")).isEqualTo("my-updated-awesome-walrus-image");

    // Test Delete:
    client.customResource(customResourceDefinitionContext).delete(currentNamespace, "otter");
    client.customResource(customResourceDefinitionContext).delete(currentNamespace);
  }

  @After
  public void cleanup() {
    // Delete Custom Resource Definition Animals:
    client.customResourceDefinitions().withName(customResourceDefinitionContext.getName()).delete();
  }
}
