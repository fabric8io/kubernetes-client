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

import io.fabric8.kubernetes.api.model.Config;
import io.fabric8.kubernetes.api.model.ConfigBuilder;
import io.fabric8.kubernetes.api.model.ExecConfig;
import io.fabric8.kubernetes.api.model.ExecConfigBuilder;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class KubeConfigUtilsTest {

  @TempDir
  private Path tempDir;

  @Test
  void testParseConfig() {
    // Given
    File configFile = new File(getClass().getResource("/test-kubeconfig").getPath());
    // When
    Config config = KubeConfigUtils.parseConfig(configFile);
    // Then
    assertNotNull(config);
    assertEquals(1, config.getClusters().size());
    assertEquals(3, config.getContexts().size());
    assertEquals(3, config.getUsers().size());
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

  private Config getTestKubeConfig() {
    return new ConfigBuilder()
        .withCurrentContext("test-context")
        .addNewCluster()
        .withName("api-testing:6334")
        .withNewCluster()
        .withServer("https://api-testing:6334")
        .withInsecureSkipTlsVerify(true)
        .endCluster()
        .endCluster()
        .addNewContext()
        .withName("test-context")
        .withNewContext()
        .withCluster("api-testing:6334")
        .withNamespace("ns1")
        .withUser("system:admin/api-testing:6334")
        .endContext()
        .endContext()
        .addNewContext()
        .withNewContext()
        .withCluster("minikube")
        .withUser("minikube")
        .endContext()
        .withName("minikube")
        .endContext()
        .addNewUser()
        .withName("test/api-test-com:443")
        .withNewUser()
        .withToken("token")
        .endUser()
        .endUser()
        .addNewUser()
        .withName("minikube")
        .withNewUser()
        .withClientCertificate("/home/.minikube/profiles/minikube/client.crt")
        .withClientKey("/home/.minikube/profiles/minikube/client.key")
        .endUser()
        .endUser()
        .addNewUser()
        .withName("test/test-cluster:443")
        .withNewUser()
        .withNewAuthProvider()
        .withConfig(Collections.singletonMap("id-token", "token"))
        .endAuthProvider()
        .endUser()
        .endUser()
        .addNewUser()
        .withName("system:admin/api-testing:6334")
        .withNewUser()
        .withToken("test-token-2")
        .endUser()
        .endUser()
        .build();
  }
}
