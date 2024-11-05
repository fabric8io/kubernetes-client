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

import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;
import static org.assertj.core.api.Assertions.assertThat;

class ConfigRefreshTest {

  @TempDir
  private Path tempDir;
  private Path kubeConfigFile;
  private io.fabric8.kubernetes.api.model.Config kubeConfigOriginal;

  @BeforeEach
  void setUp() throws IOException {
    kubeConfigFile = tempDir.resolve("kubeconfig");
    kubeConfigOriginal = new io.fabric8.kubernetes.api.model.ConfigBuilder()
        .addNewCluster()
        .withName("the-cluster")
        .withNewCluster().withServer("https://the-cluster:8443").endCluster()
        .endCluster()
        .addNewUser()
        .withName("the-user")
        .withNewUser().withToken("the-token").endUser()
        .endUser()
        .addNewContext()
        .withName("the-context")
        .withNewContext()
        .withCluster("the-cluster")
        .withUser("the-user")
        .endContext()
        .endContext()
        .withCurrentContext("the-context")
        .build();
    Files.writeString(kubeConfigFile, Serialization.asYaml(kubeConfigOriginal), CREATE);
  }

  @Test
  @DisplayName("When oauthToken manually provided by user, then don't refresh (returns same instance)")
  void oauthTokenProvidedByUser() {
    // Given
    final var config = new ConfigBuilder()
        .withAutoConfigure()
        .withOauthToken("manually-provided")
        .build();
    // When
    final var result = config.refresh();
    // Then
    assertThat(result)
        .isSameAs(config)
        .hasFieldOrPropertyWithValue("autoConfigure", true)
        .hasFieldOrPropertyWithValue("oauthToken", "manually-provided");
  }

  @Test
  @DisplayName("When manually crafted Config, then don't refresh (returns same instance)")
  void manualConfig() {
    // Given
    final var config = new ConfigBuilder().withAutoConfigure(false).build();
    // When
    final var result = config.refresh();
    // Then
    assertThat(result)
        .isSameAs(config)
        .hasFieldOrPropertyWithValue("autoConfigure", false);
  }

  @Test
  @DisplayName("When autoconfigure enabled, then refresh (returns new instance)")
  void autoConfiguredConfig() {
    try {
      // Given
      System.setProperty("kubernetes.master", "https://test.example.com/");
      final var config = new ConfigBuilder().build();
      System.setProperty("kubernetes.master", "https://test-updated.example.com/");
      // When
      final var result = config.refresh();
      // Then
      assertThat(result)
          .isNotSameAs(config)
          .hasFieldOrPropertyWithValue("masterUrl", "https://test-updated.example.com/");
    } finally {
      System.clearProperty("kubernetes.master");
    }
  }

  @Test
  @DisplayName("When config from file, then refresh (returns new instance)")
  void configFromFile() throws IOException {
    // Given
    final var config = Config.fromKubeconfig(kubeConfigFile.toFile());
    final var kubeConfigUpdated = new io.fabric8.kubernetes.api.model.ConfigBuilder(kubeConfigOriginal)
        .editFirstUser().editUser().withToken("the-token-updated").endUser().endUser().build();
    Files.writeString(kubeConfigFile, Serialization.asYaml(kubeConfigUpdated), CREATE);
    // When
    final var result = config.refresh();
    // Then
    assertThat(result)
        .isNotSameAs(config)
        .hasFieldOrPropertyWithValue("masterUrl", "https://the-cluster:8443/")
        .hasFieldOrPropertyWithValue("autoOAuthToken", "the-token-updated");
  }

  @Test
  @DisplayName("When config from file deleted, then don't refresh (returns same instance)")
  void configFromFileEmptied() throws IOException {
    // Given
    final var config = Config.fromKubeconfig(kubeConfigFile.toFile());
    Files.delete(kubeConfigFile);
    // When
    final var result = config.refresh();
    // Then
    assertThat(result)
        .isSameAs(config)
        .hasFieldOrPropertyWithValue("masterUrl", "https://the-cluster:8443/")
        .hasFieldOrPropertyWithValue("autoOAuthToken", "the-token");
  }

}
