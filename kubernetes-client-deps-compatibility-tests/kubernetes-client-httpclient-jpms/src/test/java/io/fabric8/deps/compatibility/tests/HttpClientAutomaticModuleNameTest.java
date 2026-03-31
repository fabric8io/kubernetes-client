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
package io.fabric8.deps.compatibility.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HttpClientAutomaticModuleNameTest {

  private static final Map<String, String> EXPECTED_MODULE_NAMES = new LinkedHashMap<>();

  static {
    EXPECTED_MODULE_NAMES.put("kubernetes-httpclient-jdk", "io.fabric8.kubernetes.client.jdkhttp");
    EXPECTED_MODULE_NAMES.put("kubernetes-httpclient-jetty", "io.fabric8.kubernetes.client.jetty");
    EXPECTED_MODULE_NAMES.put("kubernetes-httpclient-okhttp", "io.fabric8.kubernetes.client.okhttp");
    EXPECTED_MODULE_NAMES.put("kubernetes-httpclient-vertx-5", "io.fabric8.kubernetes.client.vertx5");
    EXPECTED_MODULE_NAMES.put("kubernetes-httpclient-vertx", "io.fabric8.kubernetes.client.vertx");
  }

  private static Path jarsDir;

  @BeforeAll
  static void setUp() {
    String jarsDirProperty = System.getProperty("httpclient.jars.dir");
    assertThat(jarsDirProperty)
        .as("System property 'httpclient.jars.dir' must be set")
        .isNotNull();
    jarsDir = Paths.get(jarsDirProperty);
    assertThat(jarsDir).isDirectory();
  }

  @Test
  void httpClientModulesHaveCorrectAutomaticModuleName() throws IOException {
    try (Stream<Path> jarFiles = Files.list(jarsDir)) {
      Map<String, String> actualModuleNames = new LinkedHashMap<>();
      jarFiles.filter(p -> p.toString().endsWith(".jar")).forEach(jarPath -> {
        String fileName = jarPath.getFileName().toString();
        Map.Entry<String, String> match = findMatchingArtifact(fileName);
        if (match != null) {
          try (JarFile jarFile = new JarFile(jarPath.toFile())) {
            Manifest manifest = jarFile.getManifest();
            assertThat(manifest)
                .as("Manifest for %s", fileName)
                .isNotNull();
            String actualModuleName = manifest.getMainAttributes().getValue("Automatic-Module-Name");
            assertThat(actualModuleName)
                .as("Automatic-Module-Name in %s", fileName)
                .isEqualTo(match.getValue());
            actualModuleNames.put(match.getKey(), actualModuleName);
          } catch (IOException e) {
            throw new RuntimeException("Failed to read JAR: " + jarPath, e);
          }
        }
      });
      assertThat(actualModuleNames)
          .as("All httpclient modules should have been verified")
          .hasSize(EXPECTED_MODULE_NAMES.size());
    }
  }

  @Test
  void httpClientModulesHaveValidJpmsModuleNames() throws IOException {
    try (Stream<Path> jarFiles = Files.list(jarsDir)) {
      Map<String, String> resolvedModuleNames = new LinkedHashMap<>();
      jarFiles.filter(p -> p.toString().endsWith(".jar")).forEach(jarPath -> {
        String fileName = jarPath.getFileName().toString();
        Map.Entry<String, String> match = findMatchingArtifact(fileName);
        if (match != null) {
          ModuleFinder finder = ModuleFinder.of(jarPath);
          assertThat(finder.findAll())
              .as("ModuleFinder should resolve module from %s", fileName)
              .hasSize(1);
          ModuleReference moduleRef = finder.findAll().iterator().next();
          String resolvedName = moduleRef.descriptor().name();
          assertThat(resolvedName)
              .as("JPMS module name resolved from %s", fileName)
              .isEqualTo(match.getValue());
          resolvedModuleNames.put(match.getKey(), resolvedName);
        }
      });
      assertThat(resolvedModuleNames)
          .as("All httpclient modules should have been verified via ModuleFinder")
          .hasSize(EXPECTED_MODULE_NAMES.size());
    }
  }

  /**
   * Finds the best matching artifact prefix for the given filename.
   * Uses longest-prefix matching to distinguish e.g. "kubernetes-httpclient-vertx-5" from "kubernetes-httpclient-vertx".
   */
  private static Map.Entry<String, String> findMatchingArtifact(String fileName) {
    return EXPECTED_MODULE_NAMES.entrySet().stream()
        .filter(entry -> fileName.startsWith(entry.getKey() + "-"))
        .max(Comparator.comparingInt(entry -> entry.getKey().length()))
        .orElse(null);
  }
}
