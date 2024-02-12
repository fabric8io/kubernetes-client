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
package io.fabric8.ovn.client.mock;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.ovn.client.OpenVirtualNetworkingClient;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class AdaptTest {
  private KubernetesClient client;
  private KubernetesMockServer server;

  @ParameterizedTest(name = "when server does not support {0}, then adapt = {1}")
  @CsvSource(value = {
      "example.k8s.io,true",
      "k8s.ovn.org,false"
  })
  void shouldAdaptOnlyWhenOvnApiGroupSupported(String unsupportedApiGroup, boolean expectedResult) {
    // Given
    server.setUnsupported(unsupportedApiGroup);

    // When
    OpenVirtualNetworkingClient ovnClient = client.adapt(OpenVirtualNetworkingClient.class);

    // Then
    assertThat(Optional.ofNullable(ovnClient).isPresent()).isEqualTo(expectedResult);
  }
}
