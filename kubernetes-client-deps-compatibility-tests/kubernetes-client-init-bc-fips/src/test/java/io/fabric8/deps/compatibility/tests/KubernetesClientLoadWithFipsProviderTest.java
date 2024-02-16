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

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.Security;
import java.util.Objects;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class KubernetesClientLoadWithFipsProviderTest {
  @BeforeEach
  void setUp() {
    Security.addProvider(new BouncyCastleFipsProvider());
  }

  @AfterEach
  void tearDown() {
    Security.removeProvider(BouncyCastleFipsProvider.PROVIDER_NAME);
  }

  @Test
  @DisplayName("Ensure KubernetesClient loads with EC private keys and a BouncyCastle FIPS provider is set, see https://github.com/fabric8io/kubernetes-client/issues/5296")
  void kubernetesClientLoad() {
    String oldKubeConfigValue = System.getProperty("kubeconfig");
    System.setProperty("kubeconfig",
        Objects.requireNonNull(KubernetesClientLoadWithFipsProviderTest.class.getResource("/kube-config-ec-key")).getFile());
    try (KubernetesClient kubernetesClient = new KubernetesClientBuilder().build()) {
      assertThat(kubernetesClient).isNotNull();
    } finally {
      System.setProperty("kubeconfig", Optional.ofNullable(oldKubeConfigValue).orElse(""));
    }
  }
}
