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
package io.fabric8.crd.generator.approvaltests;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.spun.util.tests.TestUtils;
import io.fabric8.crd.generator.CRDGenerator;
import io.fabric8.crd.generator.CRDInfo;
import io.fabric8.crd.generator.approvaltests.annotated.Annotated;
import io.fabric8.crd.generator.approvaltests.complex.Complex;
import io.fabric8.crd.generator.approvaltests.inherited.Child;
import io.fabric8.crd.generator.approvaltests.json.ContainingJson;
import io.fabric8.crd.generator.approvaltests.k8svalidation.K8sValidation;
import io.fabric8.crd.generator.approvaltests.map.ContainingMaps;
import io.fabric8.crd.generator.approvaltests.nocyclic.NoCyclic;
import io.fabric8.crd.generator.approvaltests.validation.Validation;
import io.fabric8.kubernetes.client.CustomResource;
import io.sundr.utils.Strings;
import org.approvaltests.Approvals;
import org.approvaltests.namer.StackTraceNamer;
import org.approvaltests.writers.FileApprovalWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.CleanupMode;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CRDGeneratorApprovalTest {

  @TempDir(cleanup = CleanupMode.ON_SUCCESS)
  File tempDir;

  private boolean minimizeQuotes;

  @BeforeEach
  void setUp() {
    Approvals.settings().allowMultipleVerifyCallsForThisClass();
    minimizeQuotes = ((YAMLFactory) CRDGenerator.YAML_MAPPER.getFactory()).isEnabled(YAMLGenerator.Feature.MINIMIZE_QUOTES);
    ((YAMLFactory) CRDGenerator.YAML_MAPPER.getFactory()).disable(YAMLGenerator.Feature.MINIMIZE_QUOTES);
  }

  @AfterEach
  void tearDown() {
    if (minimizeQuotes) {
      ((YAMLFactory) CRDGenerator.YAML_MAPPER.getFactory()).enable(YAMLGenerator.Feature.MINIMIZE_QUOTES);
    }
  }

  @ParameterizedTest(name = "{1}.{2} parallel={3}")
  @MethodSource("crdApprovalTestsApiV1")
  @DisplayName("CRD Generator V1 Approval Tests")
  void apiV1ApprovalTest(
      Class<? extends CustomResource<?, ?>>[] crClasses, String expectedCrd, String version, boolean parallel) {
    final Map<String, Map<String, CRDInfo>> result = new CRDGenerator()
        .withParallelGenerationEnabled(parallel)
        .inOutputDir(tempDir)
        .customResourceClasses(crClasses)
        .forCRDVersions(version)
        .detailedGenerate()
        .getCRDDetailsPerNameAndVersion();

    assertThat(result)
        .withFailMessage(() -> "Could not find expected CRD " + expectedCrd
            + " in results. Found instead: " + result.keySet())
        .containsKey(expectedCrd)
        .extractingByKey(expectedCrd)
        .isNotNull();

    Approvals.verify(
        new FileApprovalWriter(new File(result.get(expectedCrd).get(version).getFilePath())),
        new Namer(expectedCrd, version));
  }

  @ParameterizedTest(name = "{1}.{2} parallel={3}")
  @MethodSource("crdApprovalTestsApiV2")
  @DisplayName("CRD Generator V2 Approval Tests")
  void apiV2ApprovalTest(
      Class<? extends CustomResource<?, ?>>[] crClasses, String expectedCrd, String version, boolean parallel) {
    Approvals.settings().allowMultipleVerifyCallsForThisMethod();
    final Map<String, Map<String, io.fabric8.crdv2.generator.CRDInfo>> result = new io.fabric8.crdv2.generator.CRDGenerator()
        .withParallelGenerationEnabled(parallel)
        .inOutputDir(tempDir)
        .customResourceClasses(crClasses)
        .forCRDVersions(version)
        .detailedGenerate()
        .getCRDDetailsPerNameAndVersion();

    assertThat(result)
        .withFailMessage(() -> "Could not find expected CRD " + expectedCrd
            + " in results. Found instead: " + result.keySet())
        .containsKey(expectedCrd)
        .extractingByKey(expectedCrd)
        .isNotNull();

    Approvals.verify(
        new FileApprovalWriter(new File(result.get(expectedCrd).get(version).getFilePath())),
        new Namer(expectedCrd, version));
  }

  static Stream<Arguments> crdApprovalTestsApiV1() {
    return Stream.concat(
        crdApprovalBaseCases("v1"),
        crdApprovalBaseCases("v1beta1")).map(tc -> Arguments.of(tc.crClasses, tc.expectedCrd, tc.version, tc.parallel));
  }

  static Stream<Arguments> crdApprovalTestsApiV2() {
    return Stream.concat(
        crdApprovalBaseCases("v1"),
        crdApprovalCasesApiV2("v1"))
        .map(tc -> Arguments.of(tc.crClasses, tc.expectedCrd, tc.version, tc.parallel));
  }

  static Stream<TestCase> crdApprovalBaseCases(String crdVersion) {
    final List<TestCase> cases = new ArrayList<>();
    for (boolean parallel : new boolean[] { false, true }) {
      cases.add(new TestCase("annotateds.samples.fabric8.io", crdVersion, parallel, Annotated.class));
      cases.add(new TestCase("complexkinds.samples.fabric8.io", crdVersion, parallel, Complex.class));
      cases.add(new TestCase("children.sample.fabric8.io", crdVersion, parallel, Child.class));
      cases.add(new TestCase("containingjsons.sample.fabric8.io", crdVersion, parallel, ContainingJson.class));
      cases.add(new TestCase("k8svalidations.samples.fabric8.io", crdVersion, parallel, K8sValidation.class));
      cases.add(new TestCase("containingmaps.sample.fabric8.io", crdVersion, parallel, ContainingMaps.class));
      cases.add(new TestCase("multiples.sample.fabric8.io", crdVersion, parallel,
          io.fabric8.crd.generator.approvaltests.multipleversions.v1.Multiple.class,
          io.fabric8.crd.generator.approvaltests.multipleversions.v2.Multiple.class));
      cases.add(new TestCase("nocyclics.sample.fabric8.io", crdVersion, parallel, NoCyclic.class));
    }
    return cases.stream();
  }

  static Stream<TestCase> crdApprovalCasesApiV2(String crdVersion) {
    final List<TestCase> cases = new ArrayList<>();
    for (boolean parallel : new boolean[] { false, true }) {
      cases.add(new TestCase("validations.samples.fabric8.io", crdVersion, parallel, Validation.class));
    }
    return cases.stream();
  }

  private static final class TestCase {
    private final Class<? extends CustomResource<?, ?>>[] crClasses;
    private final String expectedCrd;
    private final String version;
    private final boolean parallel;

    @SafeVarargs
    public TestCase(String expectedCrd, String version, boolean parallel, Class<? extends CustomResource<?, ?>>... crClasses) {
      this.expectedCrd = expectedCrd;
      this.version = version;
      this.parallel = parallel;
      this.crClasses = crClasses;
    }
  }

  private static final class Namer extends StackTraceNamer {
    private final String additionalInformation;

    public Namer(String... parameters) {
      super(TestUtils.getCurrentFileForMethod(0), null);
      additionalInformation = Strings.join(parameters, ".");
    }

    @Override
    public String getApprovalName() {
      return String.format("%s.approvalTest.%s", CRDGeneratorApprovalTest.class.getSimpleName(), additionalInformation);
    }
  }

}
