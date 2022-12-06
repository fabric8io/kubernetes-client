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

import io.fabric8.crd.example.basic.Basic;
import io.fabric8.crd.example.basic.BasicSpec;
import io.fabric8.crd.example.basic.BasicStatus;
import io.fabric8.crd.example.cyclic.Cyclic;
import io.fabric8.crd.example.cyclic.CyclicList;
import io.fabric8.crd.example.inherited.*;
import io.fabric8.crd.example.joke.Joke;
import io.fabric8.crd.example.joke.JokeRequest;
import io.fabric8.crd.example.joke.JokeRequestSpec;
import io.fabric8.crd.example.joke.JokeRequestStatus;
import io.fabric8.crd.example.map.ContainingMaps;
import io.fabric8.crd.example.map.ContainingMapsSpec;
import io.fabric8.crd.example.multiple.v1.Multiple;
import io.fabric8.crd.example.multiple.v1.MultipleSpec;
import io.fabric8.crd.example.nocyclic.NoCyclic;
import io.fabric8.crd.example.simplest.Simplest;
import io.fabric8.crd.example.simplest.SimplestSpec;
import io.fabric8.crd.example.simplest.SimplestStatus;
import io.fabric8.crd.generator.CRDGenerator.AbstractCRDOutput;
import io.fabric8.crd.generator.utils.Types;
import io.fabric8.kubernetes.api.model.apiextensions.v1.*;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.model.Scope;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

class CRDGeneratorTest {

  private final TestCRDOutput output = new TestCRDOutput();
  protected boolean parallelCRDGeneration;

  @Test
  void choosingCRDVersionsShouldWork() {
    CRDGenerator generator = newCRDGenerator();
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
    CRDGenerator generator = newCRDGenerator();
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
  void shouldProperlyRecordNumberOfGeneratedCRDs() {
    CRDGenerator generator = newCRDGenerator();
    assertEquals(0, generator.generate());
    assertEquals(0, generator.detailedGenerate().numberOfGeneratedCRDs());

    final CRDGenerationInfo info = generator
        .customResourceClasses(Simplest.class, Child.class, Joke.class, JokeRequest.class)
        .forCRDVersions("v1", "v1beta1")
        .withOutput(output).detailedGenerate();

    assertEquals(4 * 2, info.numberOfGeneratedCRDs());
    final Map<String, Map<String, CRDInfo>> details = info.getCRDDetailsPerNameAndVersion();
    assertEquals(4, details.size());
    assertTrue(details.containsKey(CustomResource.getCRDName(Simplest.class)));
    assertTrue(details.containsKey(CustomResource.getCRDName(Child.class)));
    assertTrue(details.containsKey(CustomResource.getCRDName(Joke.class)));
    final String crdName = CustomResource.getCRDName(JokeRequest.class);
    assertTrue(details.containsKey(crdName));
    final Map<String, CRDInfo> jokeRequestInfos = info.getCRDInfos(crdName);
    assertEquals(2, jokeRequestInfos.size());
    assertTrue(jokeRequestInfos.containsKey("v1"));
    assertTrue(jokeRequestInfos.containsKey("v1beta1"));
  }

  @Test
  void shouldProperlyGenerateMultipleVersionsOfCRDs() {
    CRDGenerator generator = newCRDGenerator();
    final String specVersion = "v1beta1";
    final CRDGenerationInfo info = generator
        .customResourceClasses(Multiple.class, io.fabric8.crd.example.multiple.v2.Multiple.class)
        .forCRDVersions(specVersion)
        .withOutput(output).detailedGenerate();

    assertEquals(1, info.numberOfGeneratedCRDs());
    final Map<String, Map<String, CRDInfo>> details = info.getCRDDetailsPerNameAndVersion();
    assertEquals(1, details.size());
    // check multiple versions for same CR
    final String crdName = CustomResource.getCRDName(Multiple.class);
    assertTrue(details.containsKey(crdName));
    final Map<String, CRDInfo> infos = info.getCRDInfos(crdName);
    assertEquals(1, infos.size());
    assertTrue(infos.containsKey(specVersion));

    final String outputName = CRDGenerator.getOutputName(crdName, specVersion);
    CustomResourceDefinition definition = output.definition(outputName);
    assertNotNull(definition);
    assertEquals("apiextensions.k8s.io/" + specVersion, definition.getApiVersion());

    CustomResourceDefinitionSpec spec = definition.getSpec();
    final List<CustomResourceDefinitionVersion> versions = spec.getVersions();
    assertEquals(2, versions.size());
    assertTrue(versions.stream().filter(v -> v.getName().equals("v1")).count() == 1);
    assertTrue(versions.stream().filter(v -> v.getName().equals("v2")).count() == 1);

    Class<?>[] mustContainTraversedClasses = { Multiple.class, MultipleSpec.class,
        io.fabric8.crd.example.multiple.v2.Multiple.class, io.fabric8.crd.example.multiple.v2.MultipleSpec.class };
    final Set<String> dependentClassNames = infos.get(specVersion).getDependentClassNames();
    Arrays.stream(mustContainTraversedClasses).map(Class::getCanonicalName)
        .forEach(c -> assertTrue(dependentClassNames.contains(c), "should contain " + c));
  }

  @Test
  void notDefiningOutputShouldNotGenerateAnything() {
    CRDGenerator generator = newCRDGenerator();
    assertEquals(0, generator.generate());

    CustomResourceInfo joke = CustomResourceInfo.fromClass(Joke.class);
    CustomResourceInfo jr = CustomResourceInfo.fromClass(JokeRequest.class);
    generator.customResources(joke, jr);
    assertEquals(0, generator.generate());
  }

  @Test
  void generatingACycleShouldFail() {
    final CRDGenerator generator = newCRDGenerator()
        .customResourceClasses(Cyclic.class)
        .forCRDVersions("v1", "v1beta1")
        .withOutput(output);

    assertThrows(
        IllegalArgumentException.class,
        () -> generator.detailedGenerate(),
        "An IllegalArgument Exception hasn't been thrown when generating a CRD with cyclic references");
  }

  private CRDGenerator newCRDGenerator() {
    return new CRDGenerator()
        .withParallelGenerationEnabled(parallelCRDGeneration);
  }

  @Test
  void generatingACycleInListShouldFail() {
    final CRDGenerator generator = newCRDGenerator()
        .customResourceClasses(CyclicList.class)
        .forCRDVersions("v1", "v1beta1")
        .withOutput(output);

    assertThrows(
        IllegalArgumentException.class,
        () -> generator.detailedGenerate(),
        "An IllegalArgument Exception hasn't been thrown when generating a CRD with cyclic references");
  }

  @Test
  void notGeneratingACycleShouldSucceed() {
    final CRDGenerator generator = newCRDGenerator()
        .customResourceClasses(NoCyclic.class)
        .forCRDVersions("v1", "v1beta1")
        .withOutput(output);

    CRDGenerationInfo info = generator.detailedGenerate();
    assertEquals(2, info.numberOfGeneratedCRDs());
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
          Scope.CLUSTER, SimplestSpec.class, SimplestStatus.class);
      assertNotNull(version.getSubresources());
    });

  }

  @Test
  void inheritedCRDShouldWork() {
    outputCRDIfFailed(Child.class, (customResource) -> {
      final CustomResourceDefinitionVersion version = checkCRD(customResource, "Child", "children",
          Scope.NAMESPACED, ChildSpec.class, ChildStatus.class, BaseSpec.class, BaseStatus.class);
      assertNotNull(version.getSubresources());
      final Map<String, JSONSchemaProps> specProps = version.getSchema().getOpenAPIV3Schema()
          .getProperties().get("spec").getProperties();
      assertEquals(4, specProps.size());
      assertEquals("integer", specProps.get("baseInt").getType());
      checkMapProp(specProps, "unsupported", "object");
      checkMapProp(specProps, "unsupported2", "object");
      checkMapProp(specProps, "supported", "string");
    });
  }

  @Test
  void mapPropertyShouldHaveCorrectValueType() {
    outputCRDIfFailed(ContainingMaps.class, (customResource) -> {
      final CustomResourceDefinitionVersion version = checkCRD(customResource, "ContainingMaps", "containingmaps",
          Scope.CLUSTER, ContainingMapsSpec.class);
      assertNotNull(version.getSchema());

      final Map<String, JSONSchemaProps> specProps = version.getSchema().getOpenAPIV3Schema()
          .getProperties().get("spec").getProperties();

      assertEquals(9, specProps.size());

      JSONSchemaProps testSchema = checkMapProp(specProps, "test", "array");
      assertEquals("string", testSchema.getItems().getSchema().getType());

      JSONSchemaProps test2Schema = checkMapProp(specProps, "test2", "object");
      JSONSchemaProps valueSchema = test2Schema.getAdditionalProperties().getSchema();
      String valueType = valueSchema.getType();
      assertEquals("array", valueType);
      assertEquals("boolean", valueSchema.getItems().getSchema().getType());

      for (int i = 1; i <= 7; i++) {
        String name = "stringToIntMultiMap" + i;
        JSONSchemaProps schema = checkMapProp(specProps, name, "array");
        assertEquals("integer", schema.getItems().getSchema().getType(), name + "'s array item type should be integer");
      }
    });
  }

  private JSONSchemaProps checkMapProp(Map<String, JSONSchemaProps> specProps, String name, String valueType) {
    final JSONSchemaProps props = specProps.get(name);
    assertNotNull(props, name + " should be contained in spec");
    assertEquals("object", props.getType(), name + "'s type should be object");
    assertEquals(valueType, props.getAdditionalProperties().getSchema().getType(),
        name + "'s value type should be " + valueType);
    return props.getAdditionalProperties().getSchema();
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
      final CustomResourceDefinitionSpec spec = checkSpec(customResource, Scope.NAMESPACED,
          JokeRequestSpec.class, JokeRequestStatus.class, JokeRequestSpec.Category.class, JokeRequestSpec.ExcludedTopic.class,
          JokeRequestStatus.State.class);

      final CustomResourceDefinitionNames names = checkNames("JokeRequest",
          "jokerequests", spec);
      assertEquals(1, names.getShortNames().size());
      assertTrue(names.getShortNames().contains("jr"));

      final CustomResourceDefinitionVersion version = checkVersion(spec);
      assertNotNull(version.getSubresources());
      // printer columns should be ordered in the alphabetical order of their json path
      final List<CustomResourceColumnDefinition> printerColumns = version
          .getAdditionalPrinterColumns();
      assertEquals(3, printerColumns.size());
      CustomResourceColumnDefinition columnDefinition = printerColumns.get(0);
      assertEquals("string", columnDefinition.getType());
      assertEquals(".spec.category", columnDefinition.getJsonPath());
      assertEquals("jokeCategory", columnDefinition.getName());
      columnDefinition = printerColumns.get(1);
      assertEquals("string", columnDefinition.getType());
      assertEquals(".spec.excluded", columnDefinition.getJsonPath());
      assertEquals("excludedTopics", columnDefinition.getName());
      columnDefinition = printerColumns.get(2);
      assertEquals("string", columnDefinition.getType());
      assertEquals(".status.category", columnDefinition.getJsonPath());
      assertEquals("jokeCategory", columnDefinition.getName());
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
      assertEquals("category-description", category.getDescription());
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
          Scope.NAMESPACED, BasicSpec.class, BasicStatus.class);
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

  private CustomResourceDefinitionVersion checkCRD(Class<? extends CustomResource<?, ?>> customResource, String kind,
      String plural,
      Scope scope, Class<?>... traversedClasses) {
    CustomResourceDefinitionSpec spec = checkSpec(customResource, scope, traversedClasses);
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
      Class<? extends CustomResource<?, ?>> customResource, Scope scope, Class<?>... mustContainTraversedClasses) {
    CRDGenerator generator = newCRDGenerator();

    // record info to be able to output it if the test fails
    final String outputName = keyFor(customResource);
    final CustomResourceInfo info = CustomResourceInfo.fromClass(customResource);
    output.put(outputName, info);
    final String v1 = "v1";
    final CRDGenerationInfo generatedInfo = generator.withOutput(output)
        .forCRDVersions(v1)
        .customResources(info)
        .detailedGenerate();
    assertEquals(1, generatedInfo.numberOfGeneratedCRDs());
    final String crdName = info.crdName();
    final Map<String, CRDInfo> crdInfos = generatedInfo.getCRDInfos(crdName);
    assertEquals(1, crdInfos.size());
    final CRDInfo crdInfo = crdInfos.get(v1);
    assertEquals(crdName, crdInfo.getCrdName());
    assertEquals(v1, crdInfo.getCrdSpecVersion());
    assertTrue(crdInfo.getFilePath().endsWith(CRDGenerator.getOutputName(crdName, v1))); // test output uses the CRD name as URI
    if (mustContainTraversedClasses != null && mustContainTraversedClasses.length > 0) {
      final Set<String> dependentClassNames = crdInfo.getDependentClassNames();
      Arrays.stream(mustContainTraversedClasses).map(Class::getCanonicalName)
          .forEach(c -> assertTrue(dependentClassNames.contains(c), "should contain " + c));
    }

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
