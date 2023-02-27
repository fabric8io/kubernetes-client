/**
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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.ServiceToURLProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;

class URLFromEnvVarsImplTest {
  private URLFromEnvVarsImpl urlFromEnvVars;
  private KubernetesClient kubernetesClient;

  @BeforeEach
  void setup() {
    this.urlFromEnvVars = new URLFromEnvVarsImpl();
    this.kubernetesClient = mock(KubernetesClient.class);
  }

  @Test
  void getURL_whenNothingProvided_thenReturnNull() {
    // Given
    Service svc = createNewServiceBuilder().build();

    // When
    String url = urlFromEnvVars.getURL(svc, "test", "default", kubernetesClient);

    // Then
    assertThat(url).isNull();
  }

  @Test
  void getURL_whenServicePropertyProvided_thenReturnServiceUrl() {
    final String hostProperty = "SVC1_SERVICE_HOST";
    final String portProperty = "SVC1_SERVICE_PORT";
    final String protocolProperty = "SVC1_SERVICE_PORT_80_TCP_PROTO";
    try {
      // Given
      System.setProperty(hostProperty, "10.111.30.220");
      System.setProperty(portProperty, "80");
      System.setProperty(protocolProperty, "tcp");
      Service svc = createNewServiceBuilder().build();

      // When
      String url = urlFromEnvVars.getURL(svc, "test", "default", kubernetesClient);

      // Then
      assertThat(url).isEqualTo("tcp://10.111.30.220:80");
    } finally {
      System.clearProperty(hostProperty);
      System.clearProperty(portProperty);
      System.clearProperty(protocolProperty);
    }
  }

  @Test
  void getURL_whenServiceExposeAnnotationProvided_thenReturnServiceUrl() {
    // Given
    Service svc = createNewServiceBuilder()
        .editMetadata()
        .addToAnnotations("fabric8.io/exposeUrl", "http://example.com/svc1")
        .endMetadata()
        .build();

    // When
    String url = urlFromEnvVars.getURL(svc, "test", "default", kubernetesClient);

    // Then
    assertThat(url).isEqualTo("http://example.com/svc1");
  }

  @Test
  void getPriority_whenInvoked_shouldReturnThird() {
    assertThat(urlFromEnvVars.getPriority()).isEqualTo(ServiceToURLProvider.ServiceToUrlImplPriority.THIRD.getValue());
  }

  private ServiceBuilder createNewServiceBuilder() {
    return new ServiceBuilder()
        .withNewMetadata().withName("svc1").endMetadata()
        .withNewSpec()
        .addNewPort()
        .withName("test")
        .withProtocol("TCP")
        .withPort(80)
        .endPort()
        .endSpec();
  }
}
