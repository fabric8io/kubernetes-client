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
package io.fabric8.bom.plugin;

import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration test that simulates the actual workflow:
 * 1. Install the bom-manipulator-plugin
 * 2. Run sundr:generate-bom (if available)
 * 3. Run bom-manipulator:copy-plugins
 * 4. Verify the BOMs have the correct plugins
 * <p>
 * This test only runs when explicitly requested via command line.
 * Run with: mvn verify -Dit.test.bom=true
 */
@EnabledIfSystemProperty(named = "it.test.bom", matches = "true")
class CopyPluginsToBomMojoIT {

  @Test
  void testActualWorkflowScenario() throws Exception {
    // Get project root directory
    Path projectRoot = Paths.get("").toAbsolutePath().getParent();
    File projectRootDir = projectRoot.toFile();

    System.out.println("Project root: " + projectRootDir.getAbsolutePath());

    // Step 1: Install the bom-manipulator-plugin
    System.out.println("\n=== Step 1: Installing bom-manipulator-plugin ===");
    int installResult = runMavenCommand(projectRootDir,
        "clean", "install", "-pl", "bom-manipulator-plugin", "-DskipTests");
    assertThat(installResult).isZero();

    // Step 2: Generate BOM using sundr and copy plugins
    System.out.println("\n=== Step 2: Generating BOM and copying plugins ===");
    int bomResult = runMavenCommand(projectRootDir,
        "-Pbom", "clean", "sundr:generate-bom", "bom-manipulator:copy-plugins");
    assertThat(bomResult).isZero();

    // Step 3: Verify the generated BOMs
    System.out.println("\n=== Step 3: Verifying generated BOMs ===");

    // Check kubernetes-client-bom
    File bomFile1 = new File(projectRootDir, "target/classes/kubernetes-client-bom/pom.xml");
    if (bomFile1.exists()) {
      verifyBomPlugins(bomFile1, "kubernetes-client-bom");
    } else {
      System.out.println("Skipping kubernetes-client-bom verification (file not found)");
    }

    // Check kubernetes-client-bom-with-deps
    File bomFile2 = new File(projectRootDir, "target/classes/kubernetes-client-bom-with-deps/pom.xml");
    if (bomFile2.exists()) {
      verifyBomPlugins(bomFile2, "kubernetes-client-bom-with-deps");
    } else {
      System.out.println("Skipping kubernetes-client-bom-with-deps verification (file not found)");
    }
  }

  private void verifyBomPlugins(File bomFile, String bomName) throws Exception {
    System.out.println("\nVerifying " + bomName + "...");

    MavenXpp3Reader reader = new MavenXpp3Reader();
    Model bomModel;
    try (FileReader fileReader = new FileReader(bomFile)) {
      bomModel = reader.read(fileReader);
    }

    assertThat(bomModel).isNotNull();
    assertThat(bomModel.getBuild()).isNotNull();
    assertThat(bomModel.getBuild().getPlugins())
        .as("BOM should have plugins from release profile")
        .isNotEmpty();

    // Verify all plugins have groupId and version
    for (Plugin plugin : bomModel.getBuild().getPlugins()) {
      assertThat(plugin.getGroupId())
          .as("Plugin " + plugin.getArtifactId() + " must have groupId")
          .isNotNull()
          .isNotEmpty();

      assertThat(plugin.getVersion())
          .as("Plugin " + plugin.getArtifactId() + " must have version")
          .isNotNull()
          .isNotEmpty();

      // Version should not contain unresolved properties
      assertThat(plugin.getVersion())
          .as("Plugin " + plugin.getArtifactId() + " version must be resolved (no ${...})")
          .doesNotContain("${");

      System.out.printf("  - %s:%s:%s%n",
          plugin.getGroupId(), plugin.getArtifactId(), plugin.getVersion());
    }

    System.out.println("✓ " + bomName + " verified successfully (" + bomModel.getBuild().getPlugins().size() + " plugins)");
  }

  private int runMavenCommand(File workingDir, String... args) throws Exception {
    List<String> command = new ArrayList<>();

    // Determine Maven executable (cross-platform)
    String mavenExecutable = getMavenExecutable(workingDir);
    command.add(mavenExecutable);

    // Add arguments
    command.addAll(Arrays.asList(args));

    System.out.println("Running: " + String.join(" ", command));

    ProcessBuilder pb = new ProcessBuilder(command);
    pb.directory(workingDir);
    pb.redirectErrorStream(true);

    Process process = pb.start();

    // Read and print output
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    }

    int exitCode = process.waitFor();
    System.out.println("Exit code: " + exitCode);
    return exitCode;
  }

  private String getMavenExecutable(File workingDir) {
    boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");

    if (isWindows) {
      // On Windows, check for mvnw.cmd
      File mvnwCmd = new File(workingDir, "mvnw.cmd");
      if (mvnwCmd.exists()) {
        return mvnwCmd.getAbsolutePath();
      }
    } else {
      // On Unix-like systems, check for mvnw
      File mvnw = new File(workingDir, "mvnw");
      if (mvnw.exists() && mvnw.canExecute()) {
        return mvnw.getAbsolutePath();
      }
    }

    // Fallback to system maven
    return "mvn";
  }
}
