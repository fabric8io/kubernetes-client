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
package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CertificateTest {
  @Test
  void apiVersion() {
    assertThat(new Certificate().getApiVersion()).isEqualTo("networking.internal.knative.dev/v1alpha1");
  }

  @Test
  void isNamespaceScoped() {
    assertThat(new Certificate()).isInstanceOf(Namespaced.class);
  }

  @Test
  void builder() {
    // Given
    CertificateBuilder certificateBuilder = new CertificateBuilder()
        .withNewMetadata()
        .withName("test-certificate")
        .endMetadata()
        .withNewSpec()
        .withDnsNames("helloworld.default", "helloworld.default.svc", "helloworld.default.svc.cluster.local")
        .withDomain("svc.cluster.local")
        .withSecretName("route-ba07ea4e-2548-4632-9187-e615c876cffc-internal")
        .endSpec();

    // When
    Certificate certificate = certificateBuilder.build();

    // Then
    assertThat(certificate)
        .hasFieldOrPropertyWithValue("metadata.name", "test-certificate")
        .hasFieldOrPropertyWithValue("spec.dnsNames",
            Arrays.asList("helloworld.default", "helloworld.default.svc", "helloworld.default.svc.cluster.local"))
        .hasFieldOrPropertyWithValue("spec.domain", "svc.cluster.local")
        .hasFieldOrPropertyWithValue("spec.secretName", "route-ba07ea4e-2548-4632-9187-e615c876cffc-internal");
  }
}
