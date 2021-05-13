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
import io.fabric8.crd.generator.utils.Types;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceColumnDefinition;
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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CRDGeneratorTest {

  private final TestCRDOutput output = new TestCRDOutput();

  @Test
  void choosingCRDVersionsShouldWork() {
    CRDGenerator generator = new CRDGenerator();
    assertTrue(generator.getHandlers().isEmpty());

    generator.forCRDVersions();
    assertTrue(generator.getHandlers().isEmpty());

    generator.forCRDVersions((List<String>) null);
    assertTrue(generator.getHandlers().isEmpty());

    generator.forCRDVersions((String[]) null);
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

  @Test void notDefiningOutputShouldNotGenerateAnything() {
    CRDGenerator generator = new CRDGenerator();
    assertEquals(0, generator.generate());

    CustomResourceInfo joke = CustomResourceInfo.fromClass(Joke.class);
    CustomResourceInfo jr = CustomResourceInfo.fromClass(JokeRequest.class);
    generator.customResources(joke, jr);
    assertEquals(0, generator.generate());
  }


  @FunctionalInterface
  private interface CRTest {
    void test(Class<? extends CustomResource<?, ?>> customResource);
  }

  private void outputCRDIfFailed(Class<? extends CustomResource<?, ?>> customResource, CRTest test) {
    try {
      test.test(customResource);
    } catch (AssertionFailedError e) {
      // output type def and crd
      Types.output(output.get(keyFor(customResource)).definition());
      output.outputCRD(customResource);
      throw e;
    }
  }
  @Test
  void simplestCRDShouldWork() {
    outputCRDIfFailed(Simplest.class, (customResource) -> {
      final CustomResourceDefinitionVersion version = checkCRD(customResource, "Simplest", "simplests",
        Scope.CLUSTER);
      assertNotNull(version.getSubresources());
    });

  }

  @Test
  void inheritedCRDShouldWork() {
    outputCRDIfFailed(Child.class, (customResource) -> {
      final CustomResourceDefinitionVersion version = checkCRD(customResource, "Child", "children",
        Scope.NAMESPACED);
      assertNotNull(version.getSubresources());
      final Map<String, JSONSchemaProps> specProps = version.getSchema().getOpenAPIV3Schema()
        .getProperties().get("spec").getProperties();
      assertEquals(3, specProps.size());
      checkMapProp(specProps, "unsupported");
      checkMapProp(specProps, "unsupported2");
      checkMapProp(specProps, "supported");
    });
  }

  private void checkMapProp(Map<String, JSONSchemaProps> specProps, String name) {
    final JSONSchemaProps props = specProps.get(name);
    assertEquals("object", props.getType());
    assertEquals("string", props.getAdditionalProperties().getSchema().getType());
  }

  @Test
  void jokeCRDShouldWork() {
    outputCRDIfFailed(Joke.class, (customResource) -> {
      CustomResourceDefinitionVersion version = checkCRD(Joke.class, "Joke", "jokes",
        Scope.NAMESPACED);
      assertNull(version.getSubresources());
    });
  }

  @Test
  void jokerequestCRDShouldWork() {
    outputCRDIfFailed(JokeRequest.class, (customResource) -> {
      final CustomResourceDefinitionSpec spec = checkSpec(customResource, Scope.NAMESPACED);

      final CustomResourceDefinitionNames names = checkNames("JokeRequest",
        "jokerequests", spec);
      assertEquals(1, names.getShortNames().size());
      assertTrue(names.getShortNames().contains("jr"));

      final CustomResourceDefinitionVersion version = checkVersion(spec);
      assertNotNull(version.getSubresources());
      // printer columns should be ordered in the alphabetical order of their json path
      final List<CustomResourceColumnDefinition> printerColumns = version
        .getAdditionalPrinterColumns();
      assertEquals(2, printerColumns.size());
      CustomResourceColumnDefinition columnDefinition = printerColumns.get(0);
      assertEquals("string", columnDefinition.getType());
      assertEquals(".spec.category", columnDefinition.getJsonPath());
      assertEquals("jokeCategory", columnDefinition.getName());
      columnDefinition = printerColumns.get(1);
      assertEquals("string", columnDefinition.getType());
      assertEquals(".spec.excluded", columnDefinition.getJsonPath());
      assertEquals("excludedTopics", columnDefinition.getName());
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
    });
  }

  @Test
  void checkCRDGenerator() {
    outputCRDIfFailed(Basic.class, (customResource) -> {
      final CustomResourceDefinitionVersion version = checkCRD(customResource, "Basic", "basics",
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
    });
  }

  private CustomResourceDefinitionVersion checkCRD(Class<? extends CustomResource<?,?>> customResource, String kind, String plural,
    Scope scope) {
    CustomResourceDefinitionSpec spec = checkSpec(customResource, scope);
    checkNames(kind, plural, spec);

    return checkVersion(spec);
  }

  private CustomResourceDefinitionVersion checkVersion(CustomResourceDefinitionSpec spec) {
    CustomResourceDefinitionVersion version = spec.getVersions().get(0);
    assertTrue(version.getServed());
    assertTrue(version.getStorage());
    return version;
  }

  private CustomResourceDefinitionNames checkNames(String kind, String plural, CustomResourceDefinitionSpec spec) {
    CustomResourceDefinitionNames names = spec.getNames();
    assertEquals(kind, names.getKind());
    assertEquals(plural, names.getPlural());
    return names;
  }

  private CustomResourceDefinitionSpec checkSpec(
    Class<? extends CustomResource<?, ?>> customResource, Scope scope) {
    CRDGenerator generator = new CRDGenerator();

    // record info to be able to output it if the test fails
    final String outputName = keyFor(customResource);
    final CustomResourceInfo info = CustomResourceInfo.fromClass(customResource);
    output.put(outputName, info);
    assertEquals(1, generator.withOutput(output)
      .forCRDVersions("v1")
      .customResources(info)
      .generate());

    CustomResourceDefinition definition = output.definition(outputName);
    assertNotNull(definition);
    assertEquals("apiextensions.k8s.io/v1", definition.getApiVersion());

    CustomResourceDefinitionSpec spec = definition.getSpec();
    assertEquals(scope.toString(), spec.getScope());
    return spec;
  }

  private static String keyFor(Class<? extends CustomResource<?, ?>> customResource) {
    return CRDGenerator.getOutputName(CustomResource.getCRDName(customResource), "v1");
  }

  private static class TestCRDOutput extends AbstractCRDOutput<ByteArrayOutputStream> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestCRDOutput.class);
    private final static Class<CustomResourceDefinition> crdClass = CustomResourceDefinition.class;
    private final Map<String, CustomResourceInfo> infos = new ConcurrentHashMap<>();
    @Override
    protected ByteArrayOutputStream createStreamFor(String crdName) throws IOException {
      return new ByteArrayOutputStream();
    }

    CustomResourceDefinition definition(String outputName) {
      return Serialization.unmarshal(new ByteArrayInputStream(getStreamFor(outputName).toByteArray()), crdClass);
    }

    void put(String outputName, CustomResourceInfo info) {
      infos.put(outputName, info);
    }

    CustomResourceInfo get(String outputName) {
      return infos.get(outputName);
    }

    void outputCRD(Class<? extends CustomResource<?, ?>> customResource) {
      String s = getStreamFor(keyFor(customResource)).toString();
      LOGGER.debug(s);
    }
  }
}
