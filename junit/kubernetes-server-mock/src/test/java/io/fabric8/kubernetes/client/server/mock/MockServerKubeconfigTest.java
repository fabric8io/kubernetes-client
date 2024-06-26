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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class MockServerKubeconfigTest {

  @BeforeEach
  void setKubeConfigProperty() {
    System.setProperty("kubeconfig", Objects.requireNonNull(getClass().getResource("/testkubeconfig")).getFile());
  }

  @Test
  void mockServerShouldNotPickTokenAndNameContextIfKubeConfigFound() {
    // Given
    KubernetesMockServer server = new KubernetesMockServer();

    // When
    KubernetesClient client = server.createClient();

    // Then
    assertThat(client).isNotNull();
    assertThat(client.getConfiguration())
        .isNotNull()
        .satisfies(c -> assertThat(c.getCurrentContext().getName()).isNotEqualTo("default/api-crc-testing:6443/kubeadmin"))
        .satisfies(c -> assertThat(c.getOauthToken()).isNotEqualTo("sha256~iYtvbJNJEE0_QSxYE0Wl1MJJxpSvDUsNyYfzkCIoDkw"))
        .satisfies(c -> assertThat(c.getContexts())
            .hasSize(1)
            .singleElement(InstanceOfAssertFactories.type(NamedContext.class))
            .extracting(NamedContext::getName)
            .isNotEqualTo("default/api-crc-testing:6443/kubeadmin"));
  }

  @AfterEach
  public void cleanup() {
    System.clearProperty("kubeconfig");
  }
}
