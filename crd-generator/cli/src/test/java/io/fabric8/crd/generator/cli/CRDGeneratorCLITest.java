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
package io.fabric8.crd.generator.cli;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import picocli.CommandLine;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CRDGeneratorCLITest {

  @Test
  void givenVersion_thenOutputVersionAndGenerateNoCRDs() {
    CRDGeneratorCLI cliApp = new CRDGeneratorCLI();
    CommandLine cmd = new CommandLine(cliApp);
    String[] args = new String[] {
        "--version"
    };

    int exitCode = cmd.execute(args);

    assertEquals(CRDGeneratorExitCode.OK, exitCode);
    assertEquals(0, cliApp.getCrdGenerationInfo().numberOfGeneratedCRDs());
  }

  @Test
  void givenSingleCRClassNameFromSameClasspath_thenGenerate(@TempDir Path tempDir) {
    CRDGeneratorCLI cliApp = new CRDGeneratorCLI();
    CommandLine cmd = CRDGeneratorCLI.createCommandLine(cliApp);
    String[] args = new String[] {
        "-o", tempDir.toString(),
        "io.fabric8.crd.generator.cli.examples.basic.Basic"
    };

    int exitCode = cmd.execute(args);

    assertEquals(CRDGeneratorExitCode.OK, exitCode);
    assertEquals(1, cliApp.getCrdGenerationInfo().numberOfGeneratedCRDs());
    assertTrue(Paths.get(tempDir.toString(), "basics.sample.fabric8.io-v1.yml").toFile().exists());
  }

  @Test
  void givenSingleCRClassNameFromExternalClasspath_thenGenerate(@TempDir Path tempDir) {
    CRDGeneratorCLI cliApp = new CRDGeneratorCLI();
    CommandLine cmd = CRDGeneratorCLI.createCommandLine(cliApp);
    String[] args = new String[] {
        "--classpath", "../api-v2/target/test-classes/",
        "-o", tempDir.toString(),
        "io.fabric8.crdv2.example.basic.Basic"
    };

    int exitCode = cmd.execute(args);

    assertEquals(CRDGeneratorExitCode.OK, exitCode);
    assertEquals(1, cliApp.getCrdGenerationInfo().numberOfGeneratedCRDs());
    assertTrue(Paths.get(tempDir.toString(), "basics.sample.fabric8.io-v1.yml").toFile().exists());
  }

  @Test
  void givenClassesDirectory_thenScanAndGenerate(@TempDir Path tempDir) {
    CRDGeneratorCLI cliApp = new CRDGeneratorCLI();
    CommandLine cmd = CRDGeneratorCLI.createCommandLine(cliApp);
    String[] args = new String[] {
        "-o", tempDir.toString(),
        "target/test-classes/"
    };

    int exitCode = cmd.execute(args);

    assertEquals(CRDGeneratorExitCode.OK, exitCode);
    assertEquals(1, cliApp.getCrdGenerationInfo().numberOfGeneratedCRDs());
    assertTrue(Paths.get(tempDir.toString(), "basics.sample.fabric8.io-v1.yml").toFile().exists());
  }

  @Test
  void givenNoInput_thenFailAndGenerateNoCRDs() {
    CRDGeneratorCLI cliApp = new CRDGeneratorCLI();
    CommandLine cmd = CRDGeneratorCLI.createCommandLine(cliApp);
    String[] args = new String[] {};

    int exitCode = cmd.execute(args);

    assertEquals(CRDGeneratorExitCode.USAGE, exitCode);
    assertEquals(0, cliApp.getCrdGenerationInfo().numberOfGeneratedCRDs());
  }

  @Test
  void givenNotExistingCRClassName_thenFailAndGenerateNoCRDs() {
    CRDGeneratorCLI cliApp = new CRDGeneratorCLI();
    CommandLine cmd = CRDGeneratorCLI.createCommandLine(cliApp);
    String[] args = new String[] {
        // There is also no file named like that!
        "com.example.NotExisting"
    };

    int exitCode = cmd.execute(args);

    assertEquals(CRDGeneratorExitCode.CR_CLASS_LOADING, exitCode);
    assertEquals(0, cliApp.getCrdGenerationInfo().numberOfGeneratedCRDs());
  }

  @Test
  void givenClassesDirectoryButFilterByPackageInclusion_thenScanAndFail(@TempDir Path tempDir) {
    CRDGeneratorCLI cliApp = new CRDGeneratorCLI();
    CommandLine cmd = CRDGeneratorCLI.createCommandLine(cliApp);
    String[] args = new String[] {
        "-o", tempDir.toString(),
        "--include-package", "not.existingpackage",
        "target/test-classes/"
    };

    int exitCode = cmd.execute(args);

    assertEquals(CRDGeneratorExitCode.NO_CR_CLASSES_RETAINED, exitCode);
    assertEquals(0, cliApp.getCrdGenerationInfo().numberOfGeneratedCRDs());
  }

  @Test
  void givenClassesDirectoryButFilterByPackageExclusion_thenScanAndFail(@TempDir Path tempDir) {
    CRDGeneratorCLI cliApp = new CRDGeneratorCLI();
    CommandLine cmd = CRDGeneratorCLI.createCommandLine(cliApp);
    String[] args = new String[] {
        "-o", tempDir.toString(),
        // package contains a Custom Resource class
        "--exclude-package", "io.fabric8.crd.generator.cli.examples",
        "target/test-classes/"
    };

    int exitCode = cmd.execute(args);

    assertEquals(CRDGeneratorExitCode.NO_CR_CLASSES_RETAINED, exitCode);
    assertEquals(0, cliApp.getCrdGenerationInfo().numberOfGeneratedCRDs());
  }

  @Test
  void givenHelp_whenExec_thenHelp() {
    int exitCode = CRDGeneratorCLI.exec(new String[] { "--help" });
    assertEquals(CRDGeneratorExitCode.OK, exitCode);
  }
}
