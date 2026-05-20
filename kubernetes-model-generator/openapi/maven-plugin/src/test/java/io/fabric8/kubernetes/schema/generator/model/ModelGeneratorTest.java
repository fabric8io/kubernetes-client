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
package io.fabric8.kubernetes.schema.generator.model;

import io.fabric8.kubernetes.schema.generator.GeneratorSettings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

class ModelGeneratorTest {

  private GeneratorSettings.GeneratorSettingsBuilder settingsBuilder;

  @BeforeEach
  void setUp(@TempDir File tempDir) {
    settingsBuilder = GeneratorSettings.builder()
        .logger(Logger.getLogger(ModelGeneratorTest.class.getName()))
        .outputDirectory(tempDir)
        .schema(new File("../schemas/kubernetes-1.33.0.json"))
        .packageName("io.fabric8.kubernetes.api.model")
        .packageMapping("io.k8s.api.core.v1", "io.fabric8.kubernetes.api.model")
        .packageMapping("io.k8s.apimachinery.pkg.apis.meta.v1", "io.fabric8.kubernetes.api.model")
        .builderPackage("io.fabric8.kubernetes.api.builder")
        .includeGenerationRegex("^io\\.k8s\\.api\\.core\\.v1\\.(Pod|Service|ConfigMap)$")
        .skipGenerationRegex("^io\\.k8s\\.apimachinery\\.pkg\\.runtime\\.RawExtension$");
  }

  @Nested
  class WriteKubernetesResourceServiceFile {

    private Path serviceFile;

    @BeforeEach
    void setUp() {
      final GeneratorSettings settings = settingsBuilder.build();
      new ModelGenerator(settings).generate();
      serviceFile = settings.getGeneratedResourcesDirectory().toPath()
          .resolve("META-INF").resolve("services")
          .resolve("io.fabric8.kubernetes.api.model.KubernetesResource");
    }

    @Test
    void isWrittenAtExpectedPath() {
      assertThat(serviceFile).exists();
    }

    @Test
    void containsGeneratedKubernetesResources() throws IOException {
      assertThat(linesOf(serviceFile))
          .contains(
              "io.fabric8.kubernetes.api.model.ConfigMap",
              "io.fabric8.kubernetes.api.model.Pod",
              "io.fabric8.kubernetes.api.model.Service");
    }

    @Test
    void fileIsLfSeparatedUtf8WithTrailingNewline() throws IOException {
      final byte[] bytes = Files.readAllBytes(serviceFile);
      final String content = new String(bytes, StandardCharsets.UTF_8);
      assertThat(content).doesNotContain("\r");
      assertThat(bytes[bytes.length - 1]).isEqualTo((byte) '\n');
    }
  }

  @Nested
  class AdditionalKubernetesResources {

    private Path serviceFile;

    @BeforeEach
    void setUp() {
      final GeneratorSettings settings = settingsBuilder
          .additionalKubernetesResource("io.fabric8.kubernetes.api.model.KubernetesList")
          .additionalKubernetesResource("io.fabric8.kubernetes.api.model.Pod")
          .build();
      new ModelGenerator(settings).generate();
      serviceFile = settings.getGeneratedResourcesDirectory().toPath()
          .resolve("META-INF").resolve("services")
          .resolve("io.fabric8.kubernetes.api.model.KubernetesResource");
    }

    @Test
    void areMergedIntoServiceFile() throws IOException {
      assertThat(linesOf(serviceFile))
          .contains("io.fabric8.kubernetes.api.model.KubernetesList");
    }

    @Test
    void deduplicateOverlapWithGenerated() throws IOException {
      assertThat(linesOf(serviceFile))
          .filteredOn("io.fabric8.kubernetes.api.model.Pod"::equals)
          .hasSize(1);
    }
  }

  @Nested
  class AdditionalKubernetesResourcesOnlyNoGenerated {

    private Path serviceFile;

    @BeforeEach
    void setUp() {
      final GeneratorSettings settings = settingsBuilder
          .clearIncludeGenerationRegexes()
          .includeGenerationRegex("^io\\.k8s\\.this\\.matches\\.nothing$")
          .additionalKubernetesResource("io.fabric8.kubernetes.api.model.KubernetesList")
          .build();
      new ModelGenerator(settings).generate();
      serviceFile = settings.getGeneratedResourcesDirectory().toPath()
          .resolve("META-INF").resolve("services")
          .resolve("io.fabric8.kubernetes.api.model.KubernetesResource");
    }

    @Test
    void writesServiceFileWithOnlyAdditionalEntries() throws IOException {
      assertThat(linesOf(serviceFile))
          .containsExactly("io.fabric8.kubernetes.api.model.KubernetesList");
    }
  }

  @Nested
  class NoKubernetesResources {

    @Test
    void deletesPreExistingServiceFile() throws IOException {
      final GeneratorSettings settings = settingsBuilder
          .clearIncludeGenerationRegexes()
          .includeGenerationRegex("^io\\.k8s\\.this\\.matches\\.nothing$")
          .build();
      final Path serviceFile = settings.getGeneratedResourcesDirectory().toPath()
          .resolve("META-INF").resolve("services")
          .resolve("io.fabric8.kubernetes.api.model.KubernetesResource");
      Files.createDirectories(serviceFile.getParent());
      Files.write(serviceFile, "io.fabric8.stale.Entry\n".getBytes(StandardCharsets.UTF_8));
      new ModelGenerator(settings).generate();
      assertThat(serviceFile).doesNotExist();
    }
  }

  @Nested
  class CustomGeneratedResourcesDirectory {

    @Test
    void honoursExplicitDirectory(@TempDir File explicit) {
      final GeneratorSettings settings = settingsBuilder
          .generatedResourcesDirectory(explicit)
          .build();
      new ModelGenerator(settings).generate();
      assertThat(explicit.toPath()
          .resolve("META-INF").resolve("services")
          .resolve("io.fabric8.kubernetes.api.model.KubernetesResource"))
          .exists();
      assertThat(settings.getOutputDirectory().toPath()
          .resolve("src").resolve("generated").resolve("resources"))
          .doesNotExist();
    }
  }

  private static List<String> linesOf(Path path) throws IOException {
    return Files.readAllLines(path, StandardCharsets.UTF_8);
  }
}
