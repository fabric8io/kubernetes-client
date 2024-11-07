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
package io.fabric8.kubernetes.client.internal;

import io.fabric8.kubernetes.api.model.ConfigBuilder;
import io.fabric8.kubernetes.api.model.ExecConfig;
import io.fabric8.kubernetes.api.model.ExecConfigBuilder;
import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.nio.file.StandardOpenOption.CREATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class KubeConfigUtilsTest {

  @TempDir
  private Path tempDir;

  @Nested
  class ParseConfig {

    @Test
    void throwsExceptionIfNullFile() {
      assertThatExceptionOfType(KubernetesClientException.class)
          .isThrownBy(() -> KubeConfigUtils.parseConfig(null))
          .withMessage("kubeconfig (File) cannot be null");
    }

    @Test
    void throwsExceptionIfInvalidFile() throws IOException {
      final var file = tempDir.resolve("invalid-file");
      Files.writeString(file, "invalid-yaml-content", CREATE);
      assertThatIllegalArgumentException()
          .isThrownBy(() -> KubeConfigUtils.parseConfig(file.toFile()))
          .withMessageContaining("Cannot construct instance of `io.fabric8.kubernetes.api.model.Config`");
    }

    @Test
    void addsNamedContextAdditionalPropertyWithFileLocation() {
      final var file = new File(Objects
          .requireNonNull(KubeConfigUtilsTest.class.getResource("/internal/kube-config-utils-parse/config-1.yaml")).getPath());
      final var config = KubeConfigUtils.parseConfig(file);
      assertThat(config.getContexts())
          .singleElement()
          .hasFieldOrPropertyWithValue("additionalProperties.KUBERNETES_CONFIG_CONTEXT_FILE_KEY", file);
    }

    @Test
    void addsNamedClusterAdditionalPropertyWithFileLocation() {
      final var file = new File(Objects
          .requireNonNull(KubeConfigUtilsTest.class.getResource("/internal/kube-config-utils-parse/config-1.yaml")).getPath());
      final var config = KubeConfigUtils.parseConfig(file);
      assertThat(config.getClusters())
          .singleElement()
          .hasFieldOrPropertyWithValue("additionalProperties.KUBERNETES_CONFIG_CLUSTER_FILE_KEY", file);
    }

    @Test
    void addsNamedAuthInfoAdditionalPropertyWithFileLocation() {
      final var file = new File(Objects
          .requireNonNull(KubeConfigUtilsTest.class.getResource("/internal/kube-config-utils-parse/config-1.yaml")).getPath());
      final var config = KubeConfigUtils.parseConfig(file);
      assertThat(config.getUsers())
          .singleElement()
          .hasFieldOrPropertyWithValue("additionalProperties.KUBERNETES_CONFIG_AUTH_INFO_FILE_KEY", file);
    }

    @Test
    void parsesConfiguration() {
      final var result = KubeConfigUtils.parseConfig(new File(Objects
          .requireNonNull(KubeConfigUtilsTest.class.getResource("/internal/kube-config-utils-parse/config-1.yaml")).getPath()));
      assertThat(result)
          .isNotNull()
          .hasFieldOrPropertyWithValue("currentContext", "selected-context")
          .returns(1, c -> c.getClusters().size())
          .returns(1, c -> c.getContexts().size())
          .returns(1, c -> c.getUsers().size());
    }

  }

  @Nested
  class PersistKubeConfigIntoFile {

    @Test
    void writesTheKubeconfigIntoFile() throws IOException {
      // Given
      final var file = tempDir.resolve("kubeconfig");
      final var config = new ConfigBuilder()
          .withCurrentContext("selected-context")
          .build();
      // When
      KubeConfigUtils.persistKubeConfigIntoFile(config, file.toFile());
      // Then
      assertThat(file)
          .content()
          .contains("---")
          .contains("current-context: \"selected-context\"");
    }

    @Test
    void doesntPersistAdditionalProperties() throws IOException {
      // Given
      final var file = new File(Objects
          .requireNonNull(KubeConfigUtilsTest.class.getResource("/internal/kube-config-utils-parse/config-1.yaml")).getPath());
      final var config = KubeConfigUtils.parseConfig(file);
      // Should already be set by the parser, but just to test reassurance
      config.getContexts().iterator().next().getAdditionalProperties()
          .put("KUBERNETES_CONFIG_CONTEXT_FILE_KEY", file);
      config.getClusters().iterator().next().getAdditionalProperties()
          .put("KUBERNETES_CONFIG_CLUSTER_FILE_KEY", file);
      config.getUsers().iterator().next().getAdditionalProperties()
          .put("KUBERNETES_CONFIG_AUTH_INFO_FILE_KEY", file);
      // When
      KubeConfigUtils.persistKubeConfigIntoFile(config, file);
      // Then
      assertThat(file)
          .content()
          .doesNotContain("KUBERNETES_CONFIG_CONTEXT_FILE_KEY")
          .doesNotContain("KUBERNETES_CONFIG_CLUSTER_FILE_KEY")
          .doesNotContain("KUBERNETES_CONFIG_AUTH_INFO_FILE_KEY")
          .doesNotContain("KUBERNETES_CONFIG");
    }
  }

  @Nested
  @DisplayName("getFileWithNamedContextInfo")
  class GetFileWithNamedContextInfo {

    @Test
    void withNullNamedContext() {
      assertThat(KubeConfigUtils.getFileWithNamedContext(null)).isNull();
    }

    @Test
    void withNullAdditionalProperties() {
      final var context = new NamedContext();
      context.setAdditionalProperties(null);
      assertThat(KubeConfigUtils.getFileWithNamedContext(context)).isNull();
    }

    @Test
    void withEmptyAdditionalProperties() {
      final var context = new NamedContext();
      assertThat(KubeConfigUtils.getFileWithNamedContext(context)).isNull();
    }

    @Test
    void withNullValue() {
      final var context = new NamedContext();
      context.setAdditionalProperty("KUBERNETES_CONFIG_CONTEXT_FILE_KEY", null);
      assertThat(KubeConfigUtils.getFileWithNamedContext(context)).isNull();
    }

    @Test
    void withInvalidValue() {
      final var context = new NamedContext();
      context.setAdditionalProperty("KUBERNETES_CONFIG_CONTEXT_FILE_KEY", "not-file");
      assertThat(KubeConfigUtils.getFileWithNamedContext(context)).isNull();
    }

    @Test
    void withValidValue() {
      final var context = new NamedContext();
      context.setAdditionalProperty("KUBERNETES_CONFIG_CONTEXT_FILE_KEY", new File("."));
      assertThat(KubeConfigUtils.getFileWithNamedContext(context)).isEqualTo(new File("."));
    }

  }

  @Test
  @DisplayName("should create expected authenticator command for aws")
  void getAuthenticatorCommandFromExecConfig_whenAwsCommandUsed_thenUseCommandLineArgsInExecCommand() throws IOException {
    // Given
    Path commandFile = Files.createFile(tempDir.resolve("aws"));
    String systemPathValue = getTestPathValue(tempDir.toFile());
    ExecConfig execConfig = new ExecConfigBuilder()
        .withApiVersion("client.authentication.k8s.io/v1alpha1")
        .addToArgs("--region", "us-west2", "eks", "get-token", "--cluster-name", "api-eks.example.com")
        .withCommand("aws")
        .build();

    // When
    List<String> processBuilderArgs = KubeConfigUtils.getAuthenticatorCommandFromExecConfig(execConfig,
        new File("~/.kube/config"),
        systemPathValue);

    // Then
    assertThat(processBuilderArgs)
        .isNotNull()
        .hasSize(3);
    assertPlatformPrefixes(processBuilderArgs);
    List<String> commandParts = Arrays.asList(processBuilderArgs.get(2).split(" "));
    assertThat(commandParts)
        .containsExactly(commandFile.toFile().getAbsolutePath(), "--region", "us-west2", "eks",
            "get-token", "--cluster-name", "api-eks.example.com");
  }

  @Test
  @DisplayName("should generate expected authenticator command for gke-gcloud-auth-plugin")
  void getAuthenticatorCommandFromExecConfig_whenGkeAuthPluginCommandProvided_thenUseCommandLineArgs() throws IOException {
    // Given
    Path commandFile = Files.createFile(tempDir.resolve("gke-gcloud-auth-plugin"));
    String systemPathValue = getTestPathValue(tempDir.toFile());
    ExecConfig execConfigNoArgs = new ExecConfigBuilder()
        .withApiVersion("client.authentication.k8s.io/v1alpha1")
        .withCommand(commandFile.toFile().getPath())
        .build();
    // Simulate "user.exec.args: null" like e.g. in the configuration for the gke-gcloud-auth-plugin.
    execConfigNoArgs.setArgs(null);

    // When
    List<String> processBuilderArgs = KubeConfigUtils.getAuthenticatorCommandFromExecConfig(
        execConfigNoArgs, null, systemPathValue);

    // Then
    assertThat(processBuilderArgs)
        .isNotNull()
        .hasSize(3)
        .satisfies(pb -> assertThat(pb.get(2)).isEqualTo(commandFile.toFile().getPath()));
    assertPlatformPrefixes(processBuilderArgs);
  }

  private void assertPlatformPrefixes(List<String> processBuilderArgs) {
    List<String> platformArgsExpected = Utils.getCommandPlatformPrefix();
    assertThat(processBuilderArgs)
        .satisfies(p -> assertThat(p.get(0)).isEqualTo(platformArgsExpected.get(0)))
        .satisfies(p -> assertThat(p.get(1)).isEqualTo(platformArgsExpected.get(1)));
  }

  private String getTestPathValue(File commandFolder) {
    if (Utils.isWindowsOperatingSystem()) {
      return "C:\\Program Files\\Java\\jdk14.0_23\\bin" + File.pathSeparator +
          commandFolder.getAbsolutePath() + File.pathSeparator +
          "C:\\Program Files\\Apache Software Foundation\\apache-maven-3.3.1";
    } else {
      return "/usr/java/jdk-14.0.1/bin" + File.pathSeparator +
          commandFolder.getAbsolutePath() + File.pathSeparator +
          "/opt/apache-maven/bin";
    }
  }
}
