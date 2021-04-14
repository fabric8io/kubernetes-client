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
import org.junit.jupiter.api.Test;

public class CRDGeneratorTest {

  private final static Class<CustomResourceDefinition> crdClass = CustomResourceDefinition.class;

  @Test
  public void simplestCRDShouldWork() {
    final CustomResourceDefinitionVersion version = checkCRD(Simplest.class, "Simplest", "simplests",
      Scope.CLUSTER);
    assertNotNull(version.getSubresources());
  }

  @Test
  public void inheritedCRDShouldWork() {
    final CustomResourceDefinitionVersion version = checkCRD(Child.class, "Child", "children", Scope.NAMESPACED);
    assertNotNull(version.getSubresources());
  }

  @Test
  public void jokeCRDShouldWork() {
    CustomResourceDefinitionVersion version = checkCRD(Joke.class, "Joke", "jokes",
      Scope.NAMESPACED);
    assertNull(version.getSubresources());
  }

  @Test
  public void jokerequestCRDShouldWork() {
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
  public void checkCRDGenerator() {
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
      .customResources(CustomResourceInfo.fromClass(customResource))
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
    @Override
    protected ByteArrayOutputStream createStreamFor(String crdName) throws IOException {
      return new ByteArrayOutputStream();
    }

    CustomResourceDefinition definition(String outputName) {
      return Serialization.unmarshal(new ByteArrayInputStream(getStreamFor(outputName).toByteArray()), crdClass);
    }
  }
}
