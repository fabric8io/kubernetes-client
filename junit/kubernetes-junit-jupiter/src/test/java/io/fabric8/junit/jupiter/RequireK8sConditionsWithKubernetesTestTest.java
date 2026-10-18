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
package io.fabric8.junit.jupiter;

import io.fabric8.junit.jupiter.api.KubernetesTest;
import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.junit.jupiter.api.RequireK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.APIResourceListBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Optional;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Answers.CALLS_REAL_METHODS;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class RequireK8sConditionsWithKubernetesTestTest {

  private static KubernetesMockServer server;

  @BeforeAll
  static void startServer() {
    server = new KubernetesMockServer(false);
    server.setVersionInfo(new VersionInfo.Builder().withMajor("1").withMinor("99").build());
    server.init();
    server.expect().get().withPath("/api/v1")
        .andReturn(200, new APIResourceListBuilder().withGroupVersion("v1")
            .addNewResource().withKind("Pod").withName("pods").withNamespaced(true).endResource()
            .build())
        .always();
  }

  @AfterAll
  static void stopServer() {
    server.destroy();
  }

  @Test
  @DisplayName("@RequireK8sSupport probes the cluster configured by the @KubernetesTest kubernetesClientBuilderCustomizer")
  void requireK8sSupportUsesKubernetesTestCustomizer() {
    final ConditionEvaluationResult result = new RequireK8sSupportCondition()
        .evaluateExecutionCondition(contextFor(MockServerKubernetesTest.class));
    assertThat(result)
        .returns(false, ConditionEvaluationResult::isDisabled)
        .returns(Optional.of("Kubernetes resource io.fabric8.kubernetes.api.model.Pod IS supported in this cluster"),
            ConditionEvaluationResult::getReason);
  }

  @Test
  @DisplayName("@RequireK8sVersionAtLeast probes the cluster configured by the @KubernetesTest kubernetesClientBuilderCustomizer")
  void requireK8sVersionAtLeastUsesKubernetesTestCustomizer() {
    final ConditionEvaluationResult result = new RequireK8sVersionAtLeastCondition()
        .evaluateExecutionCondition(contextFor(MockServerKubernetesTest.class));
    assertThat(result)
        .returns(false, ConditionEvaluationResult::isDisabled)
        .returns(Optional.of("Kubernetes version is at least 1.99"), ConditionEvaluationResult::getReason);
  }

  private static ExtensionContext contextFor(Class<?> testClass) {
    final ExtensionContext context = mock(ExtensionContext.class, CALLS_REAL_METHODS);
    doReturn(Optional.of(testClass)).when(context).getElement();
    doReturn(Optional.of(testClass)).when(context).getTestClass();
    return context;
  }

  @KubernetesTest(createEphemeralNamespace = false, kubernetesClientBuilderCustomizer = MockServerCustomizer.class)
  @RequireK8sSupport(Pod.class)
  @RequireK8sVersionAtLeast(majorVersion = 1, minorVersion = 99)
  static final class MockServerKubernetesTest {
  }

  static final class MockServerCustomizer implements Consumer<KubernetesClientBuilder> {

    @Override
    public void accept(KubernetesClientBuilder kubernetesClientBuilder) {
      kubernetesClientBuilder.editOrNewConfig()
          .withAutoConfigure(false)
          .withMasterUrl(server.url("/"))
          .endConfig();
    }
  }
}
