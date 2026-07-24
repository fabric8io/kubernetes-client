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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Precedence between TLS trust sources during auto-configuration. The documented order is
 * system properties &gt; environment variables &gt; kube config file. Higher-priority CA material
 * must therefore suppress a lower-priority {@code insecure-skip-tls-verify} (trust-all) flag,
 * otherwise the pinned CA would be silently ignored by a trust-all {@code TrustManager}.
 */
@RestoreSystemProperties({ "kubeconfig", "kubernetes.certs.ca.file", "kubernetes.certs.ca.data" })
class ConfigTlsSourcePrecedenceTest {

  @TempDir
  private Path tempDir;

  @Test
  void higherPriorityCaFileSuppressesLowerPriorityInsecureSkipTlsVerify() throws Exception {
    // Lower-priority source (kube config) turns on trust-all via insecure-skip-tls-verify.
    final Path kubeConfig = tempDir.resolve("insecure.yaml");
    Files.writeString(kubeConfig, String.join("\n",
        "apiVersion: v1",
        "kind: Config",
        "clusters:",
        "- name: cluster",
        "  cluster:",
        "    server: https://api.example",
        "    insecure-skip-tls-verify: true",
        "contexts:",
        "- name: context",
        "  context:",
        "    cluster: cluster",
        "current-context: context",
        "users: []",
        ""), StandardCharsets.UTF_8);
    System.setProperty("kubeconfig", kubeConfig.toString());

    // Higher-priority source (system property) pins a CA file.
    final Path caFile = tempDir.resolve("operator-ca.pem");
    Files.writeString(caFile, "placeholder CA material", StandardCharsets.UTF_8);
    System.setProperty("kubernetes.certs.ca.file", caFile.toString());

    final Config config = new ConfigBuilder().build();

    // The higher-priority CA file is applied, and because it outranks the trust-all flag the
    // lower-priority insecure-skip-tls-verify is cleared, so the pinned CA is actually honored.
    assertThat(config.getCaCertFile()).isEqualTo(caFile.toString());
    assertThat(config.isTrustCerts()).isFalse();
  }
}
