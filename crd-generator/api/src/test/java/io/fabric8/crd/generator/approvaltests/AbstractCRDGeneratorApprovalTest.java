package io.fabric8.crd.generator.approvaltests;

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

import io.fabric8.crd.generator.CRDGenerationInfo;
import io.fabric8.crd.generator.CRDGenerator;
import io.fabric8.crd.generator.CRDInfo;
import io.fabric8.kubernetes.client.CustomResource;
import org.approvaltests.Approvals;
import org.approvaltests.approvers.ApprovalApprover;
import org.approvaltests.approvers.FileApprover;
import org.approvaltests.core.Options;
import org.approvaltests.namer.ApprovalNamer;
import org.approvaltests.writers.ApprovalTextWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractCRDGeneratorApprovalTest {

  private static final String[] CRD_VERSIONS = new String[] {
      "v1", "v1beta1"
  };

  protected abstract Class<? extends CustomResource<?, ?>>[] crClasses();

  protected abstract String[] expectedCRDs();

  @BeforeAll
  public void init() {
    // Allow using the same approval files for this class multiple times (required for parallel testing)
    String className = getClass().getName().replace('.', File.separatorChar);
    FileApprover.tracker.addAllowedDuplicates(f -> f.contains(className));
  }

  @Test
  public void test() {
    test(false);
  }

  @Test
  public void testParallel() {
    test(true);
  }

  public void test(boolean parallel) {
    Class<? extends CustomResource<?, ?>>[] crClasses = crClasses();
    assertNotNull(crClasses);
    assertTrue(crClasses.length > 0);

    final File outputDir;
    try {
      outputDir = Files.createTempDirectory("crd-").toFile();
    } catch (IOException e) {
      fail("Could not create temp directory", e);
      throw new RuntimeException(e);
    }

    // generate actual CRDs
    final CRDGenerationInfo crdGenerationInfo = new CRDGenerator()
        .withParallelGenerationEnabled(parallel)
        .inOutputDir(outputDir)
        .customResourceClasses(crClasses)
        .forCRDVersions(CRD_VERSIONS)
        .detailedGenerate();

    for (String crdName : expectedCRDs()) {
      Map<String, Map<String, CRDInfo>> crdDetails = crdGenerationInfo.getCRDDetailsPerNameAndVersion();
      Map<String, CRDInfo> crdInfos = crdDetails.get(crdName);
      assertNotNull(crdInfos, "Could not find expected CRD " + crdName
          + " in results. Found instead: " + crdDetails.keySet());
      for (String crdVersion : CRD_VERSIONS) {
        CRDInfo crdInfo = crdInfos.get(crdVersion);
        final File actualCRDFile = new File(crdInfo.getFilePath());
        String crdFileContent = readFile(actualCRDFile);
        verify(crdName, crdVersion, crdFileContent);
      }
    }

    // only delete the generated files if the test is successful
    deleteDirectory(outputDir);
  }

  private void verify(String crdName, String crdVersion, String crdFileContent) {
    ApprovalTextWriter writer = new ApprovalTextWriter(crdFileContent, new Options()
        .forFile().withExtension(".yml"));
    ApprovalNamer approvalNamer = new CRDGeneratorApprovalNamer(AbstractCRDGeneratorApprovalTest.class, getClass())
        .addAdditionalInformation(crdName)
        .addAdditionalInformation(crdVersion);
    ApprovalApprover approver = new FileApprover(writer, approvalNamer);
    Approvals.verify(approver);
  }

  private String readFile(File file) {
    try {
      return new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())))
          .lines().collect(Collectors.joining("\n"));
    } catch (IOException e) {
      fail(e);
      throw new RuntimeException(e);
    }
  }

  private void deleteDirectory(File dir) {
    try (Stream<Path> fileStream = Files.walk(dir.toPath())) {
      fileStream.sorted(Comparator.reverseOrder())
          .map(Path::toFile)
          .forEach(File::delete);
    } catch (IOException e) {
      fail("Could not delete output directory", e);
    }
  }
}
