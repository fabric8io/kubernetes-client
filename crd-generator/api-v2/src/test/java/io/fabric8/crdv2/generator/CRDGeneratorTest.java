/*
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
package io.fabric8.crdv2.generator;

import io.fabric8.crdv2.example.annotated.AnnotationsAndLabels;
import io.fabric8.crdv2.example.basic.Basic;
import io.fabric8.crdv2.example.complex.Complex;
import io.fabric8.crdv2.example.cyclic.Cyclic;
import io.fabric8.crdv2.example.cyclic.CyclicList;
import io.fabric8.crdv2.example.deprecated.v2.DeprecationExample;
import io.fabric8.crdv2.example.inherited.Child;
import io.fabric8.crdv2.example.joke.Joke;
import io.fabric8.crdv2.example.joke.JokeRequest;
import io.fabric8.crdv2.example.k8svalidation.K8sValidation;
import io.fabric8.crdv2.example.map.ContainingMaps;
import io.fabric8.crdv2.example.multiple.v1.Multiple;
import io.fabric8.crdv2.example.nocyclic.NoCyclic;
import io.fabric8.crdv2.example.simplest.Simplest;
import io.fabric8.crdv2.generator.CRDGenerator.AbstractCRDOutput;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceColumnDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionNames;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpec;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceValidation;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.model.Scope;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.opentest4j.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static io.fabric8.crdv2.generator.CRDGeneratorAssertions.assertFileEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CRDGeneratorTest {

  protected boolean parallelCRDGeneration;
  @TempDir
  private File tempDir;
  private TestCRDOutput output;

  @BeforeEach
  void setUp() {
    output = new TestCRDOutput();
  }

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

    // v1beta1 not supported
    generator.forCRDVersions(version, version, "v3", null);
    handlers = generator.getHandlers();
    assertEquals(1, handlers.size());
    assertTrue(handlers.containsKey(version));
  }

  @Test
  void addingCustomResourceInfosShouldWork() {
    CRDGenerator generator = newCRDGenerator();

    assertTrue(generator.getCustomResourceInfos().isEmpty());

    generator.customResourceClasses();
    assertTrue(generator.getCustomResourceInfos().isEmpty());

    generator.customResources();
    assertTrue(generator.getCustomResourceInfos().isEmpty());

    generator.customResources((CustomResourceInfo[]) null);
    assertTrue(generator.getCustomResourceInfos().isEmpty());

    generator.customResources((CustomResourceInfo) null);
    assertTrue(generator.getCustomResourceInfos().isEmpty());

    generator.customResources((Collection<CustomResourceInfo>) null);
    assertTrue(generator.getCustomResourceInfos().isEmpty());

    generator.customResources(null, null);
    assertTrue(generator.getCustomResourceInfos().isEmpty());

    generator.customResourceClasses((Class<? extends HasMetadata>[]) null);
    assertTrue(generator.getCustomResourceInfos().isEmpty());

    generator.customResourceClasses((Class<? extends HasMetadata>) null);
    assertTrue(generator.getCustomResourceInfos().isEmpty());

    generator.customResourceClasses((Collection<Class<? extends HasMetadata>>) null);
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

    final List<String> versions = new ArrayList<>(2);
    versions.add("v1");

    final CRDGenerationInfo info = generator
        .customResourceClasses(Simplest.class, Child.class, Joke.class, JokeRequest.class)
        .forCRDVersions(versions)
        .withOutput(output).detailedGenerate();

    assertEquals(4, info.numberOfGeneratedCRDs());
    final Map<String, Map<String, CRDInfo>> details = info.getCRDDetailsPerNameAndVersion();
    assertEquals(4, details.size());
    assertTrue(details.containsKey(CustomResource.getCRDName(Simplest.class)));
    assertTrue(details.containsKey(CustomResource.getCRDName(Child.class)));
    assertTrue(details.containsKey(CustomResource.getCRDName(Joke.class)));
    final String crdName = CustomResource.getCRDName(JokeRequest.class);
    assertTrue(details.containsKey(crdName));
    final Map<String, CRDInfo> jokeRequestInfos = info.getCRDInfos(crdName);
    assertEquals(1, jokeRequestInfos.size());
    assertTrue(jokeRequestInfos.containsKey("v1"));
  }

  @Test
  void checkDeprecated() {
    CRDGenerator generator = newCRDGenerator();
    final String specVersion = "v1";
    final CRDGenerationInfo info = generator
        .customResourceClasses(
            io.fabric8.crdv2.example.deprecated.v1beta1.DeprecationExample.class,
            io.fabric8.crdv2.example.deprecated.v1.DeprecationExample.class,
            DeprecationExample.class)
        .forCRDVersions(specVersion)
        .withOutput(output)
        .detailedGenerate();

    assertEquals(1, info.numberOfGeneratedCRDs());
    final Map<String, Map<String, CRDInfo>> details = info.getCRDDetailsPerNameAndVersion();
    assertEquals(1, details.size());
    // check multiple versions for same CR
    final String crdName = CustomResource.getCRDName(DeprecationExample.class);
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
    assertEquals(3, versions.size());
    assertEquals(1, versions.stream().filter(v -> v.getName().equals("v1beta1")).count());
    assertEquals(1, versions.stream().filter(v -> v.getName().equals("v1")).count());
    assertEquals(1, versions.stream().filter(v -> v.getName().equals("v2")).count());

    CustomResourceDefinitionVersion v1Beta1 = versions.stream().filter(v -> v.getName().equals("v1beta1")).findFirst().get();
    CustomResourceDefinitionVersion v1 = versions.stream().filter(v -> v.getName().equals("v1")).findFirst().get();
    CustomResourceDefinitionVersion v2 = versions.stream().filter(v -> v.getName().equals("v2")).findFirst().get();
    assertTrue(v1Beta1.getDeprecated());
    assertEquals("sample.fabric8.io/v1beta1 DeprecationExample is deprecated; Migrate to sample.fabric8.io/v2",
        v1Beta1.getDeprecationWarning());
    assertTrue(v1.getDeprecated());
    assertNull(v1.getDeprecationWarning());
    assertNull(v2.getDeprecated());
    assertNull(v2.getDeprecationWarning());
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
        .forCRDVersions("v1")
        .withOutput(output);

    assertThrows(
        IllegalArgumentException.class,
        generator::detailedGenerate,
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
        .forCRDVersions("v1")
        .withOutput(output);

    assertThrows(
        IllegalArgumentException.class,
        generator::detailedGenerate,
        "An IllegalArgument Exception hasn't been thrown when generating a CRD with cyclic references");
  }

  @Test
  void notGeneratingACycleShouldSucceed() {
    final CRDGenerator generator = newCRDGenerator()
        .customResourceClasses(NoCyclic.class)
        .forCRDVersions("v1")
        .withOutput(output);

    CRDGenerationInfo info = generator.detailedGenerate();
    assertEquals(1, info.numberOfGeneratedCRDs());
  }

  @FunctionalInterface
  private interface CRTest {
    void test(Class<? extends CustomResource<?, ?>> customResource);
  }

  private void outputCRDIfFailed(Class<? extends CustomResource<?, ?>> customResource, CRTest test) {
    try {
      test.test(customResource);
    } catch (AssertionFailedError e) {
      // output crd
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
          Scope.CLUSTER);
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
      final CustomResourceDefinitionSpec spec = checkSpec(customResource, Scope.NAMESPACED);

      final CustomResourceDefinitionNames names = checkNames("JokeRequest",
          "jokerequests", spec);
      assertEquals(1, names.getShortNames().size());
      assertTrue(names.getShortNames().contains("jr"));
      assertEquals(2, names.getCategories().size());
      assertTrue(names.getCategories().contains("cat1"));
      assertTrue(names.getCategories().contains("cat2"));

      final CustomResourceDefinitionVersion version = checkVersion(spec);
      assertNotNull(version.getSubresources());
      // printer columns should be ordered in the alphabetical order of their json path
      final List<CustomResourceColumnDefinition> printerColumns = version
          .getAdditionalPrinterColumns();
      assertEquals(5, printerColumns.size());
      CustomResourceColumnDefinition columnDefinition = printerColumns.get(0);
      assertEquals("date", columnDefinition.getType());
      assertEquals(".metadata.creationTimestamp", columnDefinition.getJsonPath());
      assertEquals("Age", columnDefinition.getName());
      assertEquals(0, columnDefinition.getPriority());
      columnDefinition = printerColumns.get(1);
      assertEquals("string", columnDefinition.getType());
      assertEquals(".spec.category", columnDefinition.getJsonPath());
      assertEquals("jokeCategory", columnDefinition.getName());
      assertEquals(1, columnDefinition.getPriority());
      columnDefinition = printerColumns.get(2);
      assertEquals("string", columnDefinition.getType());
      assertEquals(".spec.createdAt", columnDefinition.getJsonPath());
      assertEquals("CREATEDAT", columnDefinition.getName());
      assertEquals("date-time", columnDefinition.getFormat());
      assertEquals(0, columnDefinition.getPriority());
      columnDefinition = printerColumns.get(3);
      assertEquals("string", columnDefinition.getType());
      assertEquals(".spec.excluded", columnDefinition.getJsonPath());
      assertEquals("excludedTopics", columnDefinition.getName());
      assertEquals(0, columnDefinition.getPriority());
      columnDefinition = printerColumns.get(4);
      assertEquals("string", columnDefinition.getType());
      assertEquals(".status.category", columnDefinition.getJsonPath());
      assertEquals("jokeCategory", columnDefinition.getName());
      assertEquals(0, columnDefinition.getPriority());
      assertEquals(".spec.category", version.getSelectableFields().get(0).getJsonPath());
      CustomResourceValidation schema = version.getSchema();
      assertNotNull(schema);
      Map<String, JSONSchemaProps> properties = schema.getOpenAPIV3Schema().getProperties();
      assertEquals(2, properties.size());
      Map<String, JSONSchemaProps> specProps = properties.get("spec").getProperties();
      assertEquals(4, specProps.size());
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

  @Test
  void checkGenerationIsDeterministic() {
    // generated CRD
    final String crdName = CustomResourceInfo.fromClass(Complex.class).crdName();
    final CRDGenerationInfo crdInfo = newCRDGenerator()
        .inOutputDir(tempDir)
        .forCRDVersions("v1")
        .customResourceClasses(Complex.class)
        .detailedGenerate();
    final File crdFile = new File(crdInfo.getCRDInfos(crdName).get("v1").getFilePath());

    // expected CRD
    final URL crdResource = CRDGeneratorTest.class.getResource("/" + crdFile.getName());

    assertNotNull(crdResource);
    final File expectedCrdFile = new File(crdResource.getFile());
    assertFileEquals(expectedCrdFile, crdFile);
  }

  @Test
  void checkMinQuotesDefault() throws Exception {
    final String crdName = CustomResourceInfo.fromClass(Complex.class).crdName();
    CRDGenerationInfo crdInfo = newCRDGenerator()
        .inOutputDir(tempDir)
        .forCRDVersions("v1")
        .customResourceClasses(Complex.class)
        .detailedGenerate();

    File crdFile = new File(crdInfo.getCRDInfos(crdName).get("v1").getFilePath());
    String crd = Files.readString(crdFile.toPath());
    assertTrue(crd.contains("\"complexkinds.example.com\""));
  }

  @Test
  void checkMinQuotesFalse() throws Exception {
    final String crdName = CustomResourceInfo.fromClass(Complex.class).crdName();
    CRDGenerationInfo crdInfo = newCRDGenerator()
        .inOutputDir(tempDir)
        .forCRDVersions("v1")
        .customResourceClasses(Complex.class)
        .withMinQuotes(false)
        .detailedGenerate();

    File crdFile = new File(crdInfo.getCRDInfos(crdName).get("v1").getFilePath());
    String crd = Files.readString(crdFile.toPath());
    assertTrue(crd.contains("\"complexkinds.example.com\""));
  }

  @Test
  void checkMinQuotesTrue() throws Exception {
    final String crdName = CustomResourceInfo.fromClass(Complex.class).crdName();
    CRDGenerationInfo crdInfo = newCRDGenerator()
        .inOutputDir(tempDir)
        .forCRDVersions("v1")
        .customResourceClasses(Complex.class)
        .withMinQuotes(true)
        .detailedGenerate();

    File crdFile = new File(crdInfo.getCRDInfos(crdName).get("v1").getFilePath());
    String crd = Files.readString(crdFile.toPath());
    assertTrue(crd.contains("complexkinds.example.com"));
    assertFalse(crd.contains("\"complexkinds.example.com\""));
  }

  @RepeatedTest(value = 10)
  void checkGenerationMultipleVersionsOfCRDsIsDeterministic() throws Exception {
    // generated CRD
    final CustomResourceInfo infoV1 = CustomResourceInfo.fromClass(Multiple.class);
    final CustomResourceInfo infoV2 = CustomResourceInfo.fromClass(io.fabric8.crdv2.example.multiple.v2.Multiple.class);
    assertEquals(infoV1.crdName(), infoV2.crdName());
    final String crdName = infoV1.crdName();

    final CRDGenerationInfo crdInfo = newCRDGenerator()
        .inOutputDir(tempDir)
        .customResourceClasses(Multiple.class,
            io.fabric8.crdv2.example.multiple.v2.Multiple.class)
        .forCRDVersions("v1")
        .detailedGenerate();

    final File crdFile = new File(crdInfo.getCRDInfos(crdName).get("v1").getFilePath());

    // expected CRD
    final URL crdResource = CRDGeneratorTest.class.getResource("/" + crdFile.getName());
    assertNotNull(crdResource);

    final File expectedCrdFile = new File(crdResource.getFile());
    assertFileEquals(expectedCrdFile, crdFile);
  }

  @Test
  void checkK8sValidationRules() throws Exception {
    // generated CRD
    final String crdName = CustomResourceInfo.fromClass(K8sValidation.class).crdName();

    final CRDGenerationInfo crdInfo = newCRDGenerator()
        .inOutputDir(tempDir)
        .customResourceClasses(K8sValidation.class)
        .forCRDVersions("v1")
        .detailedGenerate();

    final File crdFile = new File(crdInfo.getCRDInfos(crdName).get("v1").getFilePath());

    // expected CRD
    final URL crdResource = CRDGeneratorTest.class.getResource("/" + crdFile.getName());
    assertNotNull(crdResource);

    final File expectedCrdFile = new File(crdResource.getFile());
    assertFileEquals(expectedCrdFile, crdFile);
  }

  @Test
  void checkPostProcessing() throws Exception {
    // generated CRD
    final String crdName = CustomResourceInfo.fromClass(Simplest.class).crdName();

    final CRDGenerationInfo crdInfo = newCRDGenerator()
        .inOutputDir(tempDir)
        .customResourceClasses(Simplest.class)
        .forCRDVersions("v1")
        .withPostProcessor(new CRDPostProcessor() {
          @Override
          public HasMetadata process(HasMetadata crd, String crdSpecVersion) {
            final var meta = crd.getMetadata().edit().addToLabels("foo", "bar").build();
            crd.setMetadata(meta);
            return crd;
          }
        })
        .detailedGenerate();

    assertThat(new KubernetesSerialization().unmarshal(
        Files.newInputStream(Path.of(crdInfo.getCRDInfos(crdName).get("v1").getFilePath())), HasMetadata.class))
        .hasFieldOrPropertyWithValue("metadata.name", crdName)
        .hasFieldOrPropertyWithValue("metadata.labels.foo", "bar");
  }

  @Test
  void nullPostProcessorShouldNotFailGeneration() throws Exception {
    // generated CRD
    final String crdName = CustomResourceInfo.fromClass(Simplest.class).crdName();

    final CRDGenerationInfo crdInfo = newCRDGenerator()
        .inOutputDir(tempDir)
        .customResourceClasses(Simplest.class)
        .forCRDVersions("v1")
        .withPostProcessor(null)
        .detailedGenerate();

    assertThat(new KubernetesSerialization().unmarshal(
        Files.newInputStream(Path.of(crdInfo.getCRDInfos(crdName).get("v1").getFilePath())), HasMetadata.class))
        .isNotNull();
  }

  @Test
  void shouldIncludeClassAnnotationsAndLabelsInGeneratedCRD() throws Exception {
    final String crdName = CustomResourceInfo.fromClass(AnnotationsAndLabels.class).crdName();

    final CRDGenerationInfo crdInfo = newCRDGenerator()
        .inOutputDir(tempDir)
        .customResourceClasses(AnnotationsAndLabels.class)
        .forCRDVersions("v1")
        .detailedGenerate();

    CustomResourceDefinition definition = new KubernetesSerialization().unmarshal(
        Files.newInputStream(Path.of(crdInfo.getCRDInfos(crdName).get("v1").getFilePath())),
        CustomResourceDefinition.class);

    assertNotNull(definition.getMetadata().getAnnotations());
    assertNotNull(definition.getMetadata().getLabels());

    assertEquals("fabric8", definition.getMetadata().getAnnotations().get("example.io/processed-by"));
    assertEquals("v1.0.0", definition.getMetadata().getAnnotations().get("example.io/version"));

    assertEquals("fabric8", definition.getMetadata().getLabels().get("app.kubernetes.io/managed-by"));
    assertEquals("crd", definition.getMetadata().getLabels().get("app.kubernetes.io/component"));
  }

  private CustomResourceDefinitionVersion checkCRD(Class<? extends CustomResource<?, ?>> customResource, String kind,
      String plural,
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
    protected ByteArrayOutputStream createStreamFor(String crdName) {
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
