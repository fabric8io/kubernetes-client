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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ClusterDomainClaimTest {
  @Test
  void apiVersion() {
    assertThat(new ClusterDomainClaim().getApiVersion()).isEqualTo("networking.internal.knative.dev/v1alpha1");
  }

  @Test
  void isClusterScoped() {
    assertThat(new ClusterDomainClaim()).isNotInstanceOf(Namespaced.class);
  }

  @Test
  void builder() {
    // Given
    ClusterDomainClaimBuilder clusterDomainClaimBuilder = new ClusterDomainClaimBuilder()
        .withNewMetadata()
        .withName("broker-ingress.knative-eventing.knative.dev")
        .endMetadata()
        .withNewSpec()
        .withNamespace("knative-eventing")
        .endSpec();

    // When
    ClusterDomainClaim clusterDomainClaim = clusterDomainClaimBuilder.build();

    // Then
    assertThat(clusterDomainClaim)
        .hasFieldOrPropertyWithValue("metadata.name", "broker-ingress.knative-eventing.knative.dev")
        .hasFieldOrPropertyWithValue("spec.namespace", "knative-eventing");
  }
}
