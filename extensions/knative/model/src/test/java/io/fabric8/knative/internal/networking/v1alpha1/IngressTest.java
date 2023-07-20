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

import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class IngressTest {
  @Test
  void apiVersion() {
    assertThat(new Ingress().getApiVersion()).isEqualTo("networking.internal.knative.dev/v1alpha1");
  }

  @Test
  void isNamespaceScoped() {
    assertThat(new Ingress()).isInstanceOf(Namespaced.class);
  }

  @Test
  void builder() {
    // Given
    IngressBuilder ingressBuilder = new IngressBuilder()
        .withNewMetadata()
        .withName("test-ingress")
        .endMetadata()
        .withNewSpec()
        .addNewRule()
        .addToHosts("dashboard.tekton-pipelines.knative.dev")
        .withNewHttp()
        .addNewPath()
        .addNewSplit()
        .withAppendHeaders(Collections.emptyMap())
        .withServiceName("tekton-dashboard")
        .withServiceNamespace("tekton-pipelines")
        .withServicePort(new IntOrString(9097))
        .endSplit()
        .endPath()
        .endHttp()
        .withVisibility("ExternalIP")
        .endRule()
        .endSpec();

    // When
    Ingress ingress = ingressBuilder.build();

    // Then
    assertThat(ingress)
        .hasFieldOrPropertyWithValue("metadata.name", "test-ingress")
        .hasFieldOrPropertyWithValue("spec.rules", Collections.singletonList(new IngressRuleBuilder()
            .addToHosts("dashboard.tekton-pipelines.knative.dev")
            .withNewHttp()
            .addNewPath()
            .addNewSplit()
            .withAppendHeaders(Collections.emptyMap())
            .withServiceName("tekton-dashboard")
            .withServiceNamespace("tekton-pipelines")
            .withServicePort(new IntOrString(9097))
            .endSplit()
            .endPath()
            .endHttp()
            .withVisibility("ExternalIP")
            .build()));
  }
}
