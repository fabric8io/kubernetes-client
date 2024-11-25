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
package io.fabric8.kubernetes.client.behavior;

import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.http.TestStandardHttpClient;
import io.fabric8.kubernetes.client.http.TestStandardHttpClientFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Pod Log Behavior")
class LogTest {

  private TestStandardHttpClientFactory factory;
  private KubernetesClient client;
  private TestStandardHttpClient httpClient;

  @BeforeEach
  void setUp() {
    factory = new TestStandardHttpClientFactory();
    client = new KubernetesClientBuilder().withHttpClientFactory(factory).build();
    httpClient = factory.getInstances().iterator().next();
  }

  @Nested
  class WithReadyPod {

    private String namespace = "default";
    private String podName = "pod-get-log";

    @BeforeEach
    void setUp() {
      namespace = "default";
      podName = "with-ready-pod";
      factory.expect("/api/v1/namespaces/" + namespace + "/pods", 200, client.getKubernetesSerialization().asJson(
          new PodListBuilder()
              .withNewMetadata().endMetadata()
              .addToItems(new PodBuilder()
                  .withNewMetadata().withName(podName).endMetadata()
                  .withNewStatus().withPhase("Running").endStatus()
                  .build())
              .build()));
    }

    @Test
    void getLog() {
      factory.expect("/api/v1/namespaces/" + namespace + "/pods/" + podName + "/log", 200, "log contents");
      final var result = client.pods().inNamespace(namespace).withName(podName).getLog();
      assertThat(result).isEqualTo("log contents");
    }

    @Test
    // https://github.com/fabric8io/kubernetes-client/issues/6459
    void getLogSinceTimeEncodesParameter() {
      factory.expect("/api/v1/namespaces/" + namespace + "/pods/" + podName + "/log", 200, "log contents");
      final var result = client.pods().inNamespace(namespace).withName(podName).sinceTime("2024-10-16T14:36:58+02:00").getLog();
      assertThat(result).isEqualTo("log contents");
      assertThat(httpClient.getRecordedConsumeBytesDirects())
          .last()
          .extracting(r -> r.getRequest().uri().getRawQuery())
          .asString()
          .contains("sinceTime=2024-10-16T14:36:58%2B02:00");
    }

  }
}
