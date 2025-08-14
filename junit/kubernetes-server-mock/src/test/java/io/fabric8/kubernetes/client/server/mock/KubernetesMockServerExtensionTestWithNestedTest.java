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

import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(crud = true)
public class KubernetesMockServerExtensionTestWithNestedTest {

  KubernetesMockServer mockServer;
  KubernetesClient kubernetesClient;

  @Nested
  class TheNestedClass {

    KubernetesMockServer nestedMockServer;
    KubernetesClient nestedKubernetesClient;

    @Test
    void shouldInjectMockServer() {
      assertThat(mockServer).isNotNull();
    }

    @Test
    void shouldInjectKubernetesClient() {
      assertThat(kubernetesClient).isNotNull();
    }

    @Test
    void shouldInjectNestedMockServer() {
      assertThat(nestedMockServer).isNotNull();
    }

    @Test
    void shouldInjectNestedKubernetesClient() {
      assertThat(nestedKubernetesClient).isNotNull();
    }
  }

}
