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
package io.fabric8.kubernetes.client;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class ConfigAutoConfigureTest {

  @TempDir
  private Path tempDir;

  @AfterEach
  void tearDown() {
    System.clearProperty("kubeconfig");
  }

  @Nested
  class FromKubeconfig {
    @Test
    void withNoKubeConfigFiles() {
      System.setProperty("kubeconfig", "/dev/null");
      final var result = new ConfigBuilder().withAutoConfigure().build();
      assertThat(result)
          .hasFieldOrPropertyWithValue("autoConfigure", true)
          .returns(null, Config::getFile);
    }

    @Test
    void withNonExistentConfigFile() {
      System.setProperty("kubeconfig", tempDir.resolve("non-existent").toFile().getAbsolutePath());
      final var result = new ConfigBuilder().withAutoConfigure().build();
      assertThat(result)
          .hasFieldOrPropertyWithValue("autoConfigure", true)
          .returns(null, Config::getFile);
    }

    @Test
    void withEmptyConfigFile() throws IOException {
      final var emptyFile = Files.createFile(tempDir.resolve("empty"));
      System.setProperty("kubeconfig", emptyFile.toFile().getAbsolutePath());
      final var result = new ConfigBuilder().withAutoConfigure().build();
      assertThat(result)
          .hasFieldOrPropertyWithValue("autoConfigure", true)
          .returns(null, Config::getFile);
    }

    @Test
    void withSingleConfigFile() {
      System.setProperty("kubeconfig", resolveFile("/config-auto-configure/config-2.yaml").getAbsolutePath());
      final var result = new ConfigBuilder().withAutoConfigure().build();
      assertThat(result)
          .hasFieldOrPropertyWithValue("autoConfigure", true)
          .returns(resolveFile("/config-auto-configure/config-2.yaml"), Config::getFile)
          .hasFieldOrPropertyWithValue("masterUrl", "https://config-2.example.com/")
          .hasFieldOrPropertyWithValue("currentContext.name", "context-in-all-configs");

    }

    @Test
    void withMultipleConfigFiles() {
      System.setProperty("kubeconfig",
          resolveFile("/config-auto-configure/config-1.yaml").getAbsolutePath() + File.pathSeparator +
              resolveFile("/config-auto-configure/config-2.yaml").getAbsolutePath() + File.pathSeparator +
              resolveFile("/config-auto-configure/config-3.yaml").getAbsolutePath() + File.pathSeparator);
      final var result = new ConfigBuilder().withAutoConfigure().build();
      assertThat(result)
          .hasFieldOrPropertyWithValue("autoConfigure", true)
          .returns(resolveFile("/config-auto-configure/config-1.yaml"), Config::getFile)
          .hasFieldOrPropertyWithValue("masterUrl", "https://config-1.example.com/")
          .hasFieldOrPropertyWithValue("currentContext.name", "context-in-all-configs");

    }

    @Test
    void withMultipleConfigFilesAndContext() {
      System.setProperty("kubeconfig",
          resolveFile("/config-auto-configure/just-current-context.yaml").getAbsolutePath() + File.pathSeparator +
              resolveFile("/config-auto-configure/config-1.yaml").getAbsolutePath() + File.pathSeparator +
              resolveFile("/config-auto-configure/config-2.yaml").getAbsolutePath() + File.pathSeparator +
              resolveFile("/config-auto-configure/config-3.yaml").getAbsolutePath() + File.pathSeparator);
      final var result = new ConfigBuilder().withAutoConfigure().build();
      assertThat(result)
          .hasFieldOrPropertyWithValue("autoConfigure", true)
          .returns(resolveFile("/config-auto-configure/config-3.yaml"), Config::getFile)
          .hasFieldOrPropertyWithValue("masterUrl", "https://config-3-special-cluster.example.com/")
          .hasFieldOrPropertyWithValue("currentContext.name", "context-in-config-3");

    }

    // TODO: What if the user info is in a different file
  }

  private static File resolveFile(String path) {
    return new File(Objects.requireNonNull(ConfigAutoConfigureTest.class.getResource(path)).getFile());
  }
}
