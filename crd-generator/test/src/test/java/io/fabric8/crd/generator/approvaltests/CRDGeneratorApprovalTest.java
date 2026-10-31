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

import com.spun.util.tests.TestUtils;
import io.fabric8.crd.generator.approvaltests.annotated.Annotated;
import io.fabric8.crd.generator.approvaltests.complex.Complex;
import io.fabric8.crd.generator.approvaltests.described.Described;
import io.fabric8.crd.generator.approvaltests.inherited.Child;
import io.fabric8.crd.generator.approvaltests.jackson3.Jackson3;
import io.fabric8.crd.generator.approvaltests.jdktypes.JdkTypes;
import io.fabric8.crd.generator.approvaltests.json.ContainingJson;
import io.fabric8.crd.generator.approvaltests.k8svalidation.K8sValidation;
import io.fabric8.crd.generator.approvaltests.map.ContainingMaps;
import io.fabric8.crd.generator.approvaltests.nocyclic.NoCyclic;
import io.fabric8.crd.generator.approvaltests.printercolum.PrinterColumn;
import io.fabric8.crd.generator.approvaltests.replica.Replica;
import io.fabric8.crd.generator.approvaltests.required.Required;
import io.fabric8.crd.generator.approvaltests.selectablefield.SelectableField;
import io.fabric8.crd.generator.approvaltests.shapes.Shapes;
import io.fabric8.crd.generator.approvaltests.validation.Validation;
import io.fabric8.crdv2.generator.CRDGenerator;
import io.fabric8.crdv2.generator.CRDInfo;
import io.fabric8.kubernetes.client.CustomResource;
import org.approvaltests.Approvals;
import org.approvaltests.namer.StackTraceNamer;
import org.approvaltests.writers.FileApprovalWriter;
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

  /**
   * The CRD Generator only emits {@code apiextensions.k8s.io/v1} CRDs.
   */
  private static final String CRD_VERSION = "v1";

  @TempDir(cleanup = CleanupMode.ON_SUCCESS)
  File tempDir;

  @BeforeEach
  void setUp() {
    Approvals.settings().allowMultipleVerifyCallsForThisClass();
  }

  @ParameterizedTest(name = "{1}")
  @MethodSource("crdApprovalTests")
  @DisplayName("Generated CRDs match their approved contents")
  void approvalTest(Class<? extends CustomResource<?, ?>>[] crClasses, String expectedCrd) {
    final Map<String, Map<String, CRDInfo>> result = new CRDGenerator()
        .inOutputDir(tempDir)
        .customResourceClasses(crClasses)
        .forCRDVersions(CRD_VERSION)
        .detailedGenerate()
        .getCRDDetailsPerNameAndVersion();

    assertThat(result)
        .withFailMessage(() -> "Could not find expected CRD " + expectedCrd
            + " in results. Found instead: " + result.keySet())
        .containsKey(expectedCrd)
        .extractingByKey(expectedCrd)
        .isNotNull();

    Approvals.verify(
        new FileApprovalWriter(new File(result.get(expectedCrd).get(CRD_VERSION).getFilePath())),
        new Namer(expectedCrd, CRD_VERSION));
  }

  static Stream<Arguments> crdApprovalTests() {
    return crdApprovalCases()
        .map(tc -> Arguments.of(tc.crClasses, tc.expectedCrd));
  }

  /**
   * Parallel generation is not covered here: it forks one task per CRD version and v1 is the only
   * version, so it cannot produce a different CRD. See ParallelCRDGeneratorTest in crd-generator-api-v2.
   *
   * @return the test cases
   */
  static Stream<TestCase> crdApprovalCases() {
    final List<TestCase> cases = new ArrayList<>();
    cases.add(new TestCase("annotateds.samples.fabric8.io", Annotated.class));
    cases.add(new TestCase("complexkinds.samples.fabric8.io", Complex.class));
    cases.add(new TestCase("children.sample.fabric8.io", Child.class));
    cases.add(new TestCase("containingjsons.sample.fabric8.io", ContainingJson.class));
    cases.add(new TestCase("jackson3s.samples.fabric8.io", Jackson3.class));
    cases.add(new TestCase("jdktypes.samples.fabric8.io", JdkTypes.class));
    cases.add(new TestCase("k8svalidations.samples.fabric8.io", K8sValidation.class));
    cases.add(new TestCase("containingmaps.sample.fabric8.io", ContainingMaps.class));
    cases.add(new TestCase("replicas.samples.fabric8.io", Replica.class));
    cases.add(new TestCase("shapes.samples.fabric8.io", Shapes.class));
    cases.add(new TestCase("multiples.sample.fabric8.io",
        io.fabric8.crd.generator.approvaltests.multipleversions.v1.Multiple.class,
        io.fabric8.crd.generator.approvaltests.multipleversions.v2.Multiple.class));
    cases.add(new TestCase("nocyclics.sample.fabric8.io", NoCyclic.class));
    cases.add(new TestCase("describeds.samples.fabric8.io", Described.class));
    cases.add(new TestCase("printercolumns.sample.fabric8.io", PrinterColumn.class));
    cases.add(new TestCase("requireds.samples.fabric8.io", Required.class));
    cases.add(new TestCase("selectablefields.sample.fabric8.io", SelectableField.class));
    cases.add(new TestCase("validations.sample.fabric8.io", Validation.class));
    return cases.stream();
  }

  private static final class TestCase {
    private final Class<? extends CustomResource<?, ?>>[] crClasses;
    private final String expectedCrd;

    @SafeVarargs
    public TestCase(String expectedCrd, Class<? extends CustomResource<?, ?>>... crClasses) {
      this.expectedCrd = expectedCrd;
      this.crClasses = crClasses;
    }
  }

  private static final class Namer extends StackTraceNamer {
    private final String additionalInformation;

    public Namer(String... parameters) {
      super(TestUtils.getCurrentFileForMethod(0), null);
      additionalInformation = String.join(".", parameters);
    }

    @Override
    public String getApprovalName() {
      return String.format("%s.approvalTest.%s", CRDGeneratorApprovalTest.class.getSimpleName(), additionalInformation);
    }
  }

}
