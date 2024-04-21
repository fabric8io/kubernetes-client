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
package io.fabric8.crd.generator;

import io.fabric8.kubernetes.client.CustomResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class CRDGeneratorAssertions {

  private CRDGeneratorAssertions() {
  }

  /**
   * Generates CRD files for v1 and v1beta1 and compares them with files in classpath.
   *
   * @param crClasses custom resource classes under test
   * @param crdGenerator a CRDGenerator instance
   */
  @SafeVarargs
  public static void assertCRDOutputEquals(CRDGenerator crdGenerator,
      Class<? extends CustomResource<?, ?>>... crClasses) {

    assertCRDOutputEquals(crdGenerator, null, crClasses);
  }

  /**
   * Generates CRD files for v1 and v1beta1 and compares them with files in classpath.
   *
   * @param crClasses custom resource classes under test
   * @param crdGenerator a CRDGenerator instance
   * @param classPathExpectedCRDsNullable the class path to the directory which contains the expected CRDs. Defaults to "/" if
   *        null.
   */
  @SafeVarargs
  public static void assertCRDOutputEquals(CRDGenerator crdGenerator,
      String classPathExpectedCRDsNullable,
      Class<? extends CustomResource<?, ?>>... crClasses) {
    assertNotNull(crClasses);
    assertTrue(crClasses.length > 0);
    assertEquals(1, Arrays.stream(crClasses)
        .map(CustomResource::getCRDName).distinct().count(),
        "all crClasses must be of the same kind");

    final String crdName = CustomResource.getCRDName(crClasses[0]);
    final File outputDir;
    try {
      outputDir = Files.createTempDirectory("crd-").toFile();
    } catch (IOException e) {
      fail("Could not create temp directory", e);
      throw new RuntimeException(e);
    }

    final String classPathExpectedCRDs = Optional.ofNullable(classPathExpectedCRDsNullable)
        .map(s -> s.endsWith("/") ? s : s + "/")
        .orElse("/");

    // generate actual CRDs
    final CRDGenerationInfo crdInfo = crdGenerator
        .inOutputDir(outputDir)
        .customResourceClasses(crClasses)
        .forCRDVersions("v1", "v1beta1")
        .detailedGenerate();
    final File actualCRDFile = new File(crdInfo.getCRDInfos(crdName).get("v1").getFilePath());
    final File actualCRDFileV1Beta1 = new File(crdInfo.getCRDInfos(crdName).get("v1beta1").getFilePath());

    // expected CRDs
    final URL expectedCRDResource = CRDGeneratorTest.class.getResource(classPathExpectedCRDs + actualCRDFile.getName());
    final URL expectedCRDResourceV1Beta1 = CRDGeneratorTest.class
        .getResource(classPathExpectedCRDs + actualCRDFileV1Beta1.getName());
    assertNotNull(expectedCRDResource);
    assertNotNull(expectedCRDResourceV1Beta1);
    final File expectedCrdFile = new File(expectedCRDResource.getFile());
    final File expectedCrdFileV1Beta1 = new File(expectedCRDResourceV1Beta1.getFile());

    // compare
    assertFileEquals(expectedCrdFile, actualCRDFile);
    assertFileEquals(expectedCrdFileV1Beta1, actualCRDFileV1Beta1);

    // only delete the generated files if the test is successful
    assertTrue(actualCRDFile.delete());
    assertTrue(actualCRDFileV1Beta1.delete());
    assertTrue(outputDir.delete());
  }

  /**
   * Compares two YAML files and fails if they are not equal.
   * Comments and empty lines are ignored.
   *
   * @param expectedFile the file which contains the expected content
   * @param actualFile the file which contains the content to test
   */
  public static void assertFileEquals(final File expectedFile, final File actualFile) {
    try (final BufferedReader expectedReader = new BufferedReader(new FileReader(expectedFile));
        final BufferedReader actualReader = new BufferedReader(new FileReader(actualFile))) {
      // skip license headers
      String expectedLine = skipCommentsAndEmptyLines(expectedReader);
      String actualLine = skipCommentsAndEmptyLines(actualReader);

      // compare both files
      final String message = String.format("Expected %s and actual %s files are not equal", expectedFile, actualFile);
      while (expectedLine != null || actualLine != null) {
        assertEquals(expectedLine, actualLine, message);
        expectedLine = expectedReader.readLine();
        actualLine = actualReader.readLine();
      }
    } catch (final IOException e) {
      fail(String.format("Cannot compare files %s and %s: %s", expectedFile, actualFile, e.getMessage()));
    }
  }

  private static String skipCommentsAndEmptyLines(final BufferedReader reader) throws IOException {
    String line = reader.readLine();
    while (line.startsWith("#") || line.isEmpty()) {
      line = reader.readLine();
    }
    return line;
  }

}
