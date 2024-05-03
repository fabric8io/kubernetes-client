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
package io.fabric8.crdv2.generator.approvaltests;

import io.fabric8.crdv2.generator.CRDGenerator;
import io.fabric8.crdv2.generator.CRDInfo;
import io.fabric8.crdv2.generator.approvaltests.annotated.Annotated;
import io.fabric8.crdv2.generator.approvaltests.complex.Complex;
import io.fabric8.crdv2.generator.approvaltests.inherited.Child;
import io.fabric8.crdv2.generator.approvaltests.json.ContainingJson;
import io.fabric8.crdv2.generator.approvaltests.k8svalidation.K8sValidation;
import io.fabric8.crdv2.generator.approvaltests.map.ContainingMaps;
import io.fabric8.crdv2.generator.approvaltests.nocyclic.NoCyclic;
import io.fabric8.kubernetes.client.CustomResource;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CRDGeneratorApprovalTest {

  @TempDir
  File tempDir;

  @ParameterizedTest(name = "{1}.{2} parallel={3}")
  @MethodSource("crdApprovalTests")
  void approvalTest(
      Class<? extends CustomResource<?, ?>>[] crClasses, String expectedCrd, String version, boolean parallel)
      throws IOException {
    Approvals.settings().allowMultipleVerifyCallsForThisMethod();
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
        new String(Files.readAllBytes(new File(result.get(expectedCrd).get(version).getFilePath()).toPath())),
        Approvals.NAMES.withParameters(expectedCrd, version));
  }

  static Stream<Arguments> crdApprovalTests() {
    final List<TestCase> cases = new ArrayList<>();
    for (String crdVersion : new String[] { "v1" }) {
      for (boolean parallel : new boolean[] { false, true }) {
        cases.add(new TestCase("annotateds.samples.fabric8.io", crdVersion, parallel, Annotated.class));
        cases.add(new TestCase("complexkinds.samples.fabric8.io", crdVersion, parallel, Complex.class));
        cases.add(new TestCase("children.sample.fabric8.io", crdVersion, parallel, Child.class));
        cases.add(new TestCase("containingjsons.sample.fabric8.io", crdVersion, parallel, ContainingJson.class));
        cases.add(new TestCase("k8svalidations.samples.fabric8.io", crdVersion, parallel, K8sValidation.class));
        cases.add(new TestCase("containingmaps.sample.fabric8.io", crdVersion, parallel, ContainingMaps.class));
        cases.add(new TestCase("multiples.sample.fabric8.io", crdVersion, parallel,
            io.fabric8.crdv2.generator.approvaltests.multipleversions.v1.Multiple.class,
            io.fabric8.crdv2.generator.approvaltests.multipleversions.v2.Multiple.class));
        cases.add(new TestCase("nocyclics.sample.fabric8.io", crdVersion, parallel, NoCyclic.class));
      }
    }
    return cases.stream().map(tc -> Arguments.of(tc.crClasses, tc.expectedCrd, tc.version, tc.parallel));
  }

  private static final class TestCase {
    private Class<? extends CustomResource<?, ?>>[] crClasses;
    private String expectedCrd;
    private String version;
    private boolean parallel;

    public TestCase(String expectedCrd, String version, boolean parallel, Class<? extends CustomResource<?, ?>>... crClasses) {
      this.expectedCrd = expectedCrd;
      this.version = version;
      this.parallel = parallel;
      this.crClasses = crClasses;
    }
  }

}
