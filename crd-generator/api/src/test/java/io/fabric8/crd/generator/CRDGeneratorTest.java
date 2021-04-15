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
package io.fabric8.crd.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.fabric8.crd.example.basic.Basic;
import io.fabric8.crd.example.inherited.Child;
import io.fabric8.crd.example.joke.Joke;
import io.fabric8.crd.example.joke.JokeRequest;
import io.fabric8.crd.example.simplest.Simplest;
import io.fabric8.crd.generator.CRDGenerator.AbstractCRDOutput;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionNames;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpec;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceValidation;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.model.Scope;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class CRDGeneratorTest {

  @Test
  void choosingCRDVersionsShouldWork() {
    CRDGenerator generator = new CRDGenerator();
    assertTrue(generator.getHandlers().isEmpty());

    generator.forCRDVersions("v2");
    assertTrue(generator.getHandlers().isEmpty());

    String version = "v1";
    generator.forCRDVersions(version);
    Map<String, AbstractCustomResourceHandler> handlers = generator.getHandlers();
    assertEquals(1, handlers.size());
    assertTrue(handlers.containsKey(version));

    generator.forCRDVersions(version, "v1beta1", version, "v3", null);
    handlers = generator.getHandlers();
    assertEquals(2, handlers.size());
    assertTrue(handlers.containsKey(version));
    assertTrue(handlers.containsKey("v1beta1"));
  }

  @Test
  void addingCustomResourceInfosShouldWork() {
    CRDGenerator generator = new CRDGenerator();
    assertTrue(generator.getCustomResourceInfos().isEmpty());

    generator.customResourceClasses();
    assertTrue(generator.getCustomResourceInfos().isEmpty());

    generator.customResources();
    assertTrue(generator.getCustomResourceInfos().isEmpty());

    generator.customResources(null);
    assertTrue(generator.getCustomResourceInfos().isEmpty());

    generator.customResources(null, null);
    assertTrue(generator.getCustomResourceInfos().isEmpty());

    generator.customResourceClasses(Simplest.class);
    assertEquals(1, generator.getCustomResourceInfos().size());
    assertTrue(generator.getCustomResourceInfos().stream().allMatch(cri -> cri.crClassName().equals(Simplest.class.getName())));

    generator.customResourceClasses(Child.class);
    assertEquals(2, generator.getCustomResourceInfos().size());
    CustomResourceInfo simplest = CustomResourceInfo.fromClass(Simplest.class);
    assertTrue(generator.getCustomResourceInfos().contains(simplest));
    CustomResourceInfo child = CustomResourceInfo.fromClass(Child.class);
    assertTrue(generator.getCustomResourceInfos().contains(child));

    generator.customResources(CustomResourceInfo.fromClass(Child.class));
    assertEquals(2, generator.getCustomResourceInfos().size());

    CustomResourceInfo joke = CustomResourceInfo.fromClass(Joke.class);
    CustomResourceInfo jr = CustomResourceInfo.fromClass(JokeRequest.class);
    generator.customResources(joke, jr);
    Set<CustomResourceInfo> infos = generator.getCustomResourceInfos();
    assertEquals(4, infos.size());
    assertTrue(infos.contains(simplest));
    assertTrue(infos.contains(child));
    assertTrue(infos.contains(joke));
    assertTrue(infos.contains(jr));
  }

  @Test
  void simplestCRDShouldWork() {
    final CustomResourceDefinitionVersion version = checkCRD(Simplest.class, "Simplest", "simplests",
      Scope.CLUSTER);
    assertNotNull(version.getSubresources());
  }

  @Test
  void inheritedCRDShouldWork() {
    final CustomResourceDefinitionVersion version = checkCRD(Child.class, "Child", "children", Scope.NAMESPACED);
    assertNotNull(version.getSubresources());
  }

  @Test
  void jokeCRDShouldWork() {
    CustomResourceDefinitionVersion version = checkCRD(Joke.class, "Joke", "jokes",
      Scope.NAMESPACED);
    assertNull(version.getSubresources());
  }

  @Test
  void jokerequestCRDShouldWork() {
    CustomResourceDefinitionVersion version = checkCRD(JokeRequest.class, "JokeRequest", "jokerequests", Scope.NAMESPACED);
    assertNotNull(version.getSubresources());
    CustomResourceValidation schema = version.getSchema();
    assertNotNull(schema);
    Map<String, JSONSchemaProps> properties = schema.getOpenAPIV3Schema().getProperties();
    assertEquals(2, properties.size());
    Map<String, JSONSchemaProps> specProps = properties.get("spec").getProperties();
    assertEquals(3, specProps.size());
    assertEquals("boolean", specProps.get("safe").getType());
    JSONSchemaProps category = specProps.get("category");
    assertEquals("string", category.getType());
    assertEquals(7, category.getEnum().size());
    JSONSchemaProps excluded = specProps.get("excluded");
    assertEquals("array", excluded.getType());
    assertEquals("string", excluded.getItems().getSchema().getType());
    assertEquals(6, excluded.getItems().getSchema().getEnum().size());
  }

  @Test
  void checkCRDGenerator() {
    final CustomResourceDefinitionVersion version = checkCRD(Basic.class, "Basic", "basics",
      Scope.NAMESPACED);
    assertNotNull(version.getSubresources());
    CustomResourceValidation schema = version.getSchema();
    assertNotNull(schema);
    Map<String, JSONSchemaProps> properties = schema.getOpenAPIV3Schema().getProperties();
    assertEquals(2, properties.size());
    Map<String, JSONSchemaProps> specProps = properties.get("spec").getProperties();
    assertEquals("integer", specProps.get("myInt").getType());
    Map<String, JSONSchemaProps> status = properties.get("status").getProperties();
    assertEquals("string", status.get("message").getType());
  }

  private CustomResourceDefinitionVersion checkCRD(Class<? extends CustomResource> customResource, String kind, String plural,
    Scope scope) {
    CRDGenerator generator = new CRDGenerator();
    TestCRDOutput output = new TestCRDOutput();
    generator.withOutput(output)
      .forCRDVersions("v1")
      .customResourceClasses(customResource)
      .generate();

    String outputName = CRDGenerator.getOutputName(CustomResource.getCRDName(customResource), "v1");
    CustomResourceDefinition definition = output.definition(outputName);
    assertNotNull(definition);
    CustomResourceDefinitionSpec spec = definition.getSpec();
    CustomResourceDefinitionNames names = spec.getNames();

    assertEquals("apiextensions.k8s.io/v1", definition.getApiVersion());
    assertEquals(kind, names.getKind());
    assertEquals(plural, names.getPlural());
    assertEquals(scope.toString(), spec.getScope());
    CustomResourceDefinitionVersion version = spec.getVersions().get(0);
    assertTrue(version.getServed());
    assertTrue(version.getStorage());
    return version;
  }

  private static class TestCRDOutput extends AbstractCRDOutput<ByteArrayOutputStream> {

    private final static Class<CustomResourceDefinition> crdClass = CustomResourceDefinition.class;

    @Override
    protected ByteArrayOutputStream createStreamFor(String crdName) throws IOException {
      return new ByteArrayOutputStream();
    }

    CustomResourceDefinition definition(String outputName) {
      return Serialization.unmarshal(new ByteArrayInputStream(getStreamFor(outputName).toByteArray()), crdClass);
    }
  }
}
