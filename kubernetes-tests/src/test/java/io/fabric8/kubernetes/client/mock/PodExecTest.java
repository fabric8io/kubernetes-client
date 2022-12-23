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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ContainerResource;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.internal.WebSocketMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("unused")
@EnableKubernetesMockClient(crud = true)
class PodExecTest {

  private KubernetesMockServer server;
  private KubernetesClient client;

  @BeforeEach
  void setUp() {
    client.pods().inAnyNamespace().delete();
  }

  @Test
  @DisplayName("With no containers, should throw exception")
  void withNoContainers() {
    client.pods().resource(new PodBuilder().withNewMetadata().withName("no-containers").endMetadata().build())
        .createOrReplace();
    final PodResource pr = client.pods().withName("no-containers");
    assertThatThrownBy(() -> pr.exec("sh", "-c", "echo Greetings Professor Falken"))
        .isInstanceOf(KubernetesClientException.class)
        .hasMessage("Pod has no containers!");
  }

  @Test
  @DisplayName("With single container, should exec in the single container")
  void withSingleContainer() throws Exception {
    client.pods().resource(new PodBuilder().withNewMetadata().withName("single-container").endMetadata()
        .withNewSpec()
        .addNewContainer()
        .withName("the-single-container")
        .endContainer()
        .endSpec()
        .build())
        .createOrReplace();
    server.expect()
        .get()
        .withPath(
            "/api/v1/namespaces/test/pods/single-container/exec?command=sleep%201&container=the-single-container&stderr=true")
        .andUpgradeToWebSocket()
        .open()
        .immediately().andEmit(exitZeroEvent())
        .done()
        .always();
    final ExecWatch result = client.pods().withName("single-container").redirectingError().exec("sleep 1");
    assertThat(result.exitCode().get(1, TimeUnit.SECONDS)).isZero();
  }

  @Test
  @DisplayName("With single container and inContainer with non-existent name, should throw exception")
  void withSingleContainerAndInContainer() {
    client.pods().resource(new PodBuilder().withNewMetadata().withName("single-container").endMetadata()
        .withNewSpec()
        .addNewContainer()
        .withName("the-single-container")
        .endContainer()
        .endSpec()
        .build())
        .createOrReplace();
    final ContainerResource cr = client.pods().withName("single-container").inContainer("non-existent");
    assertThatThrownBy(() -> cr.exec("exit 0"))
        .isInstanceOf(KubernetesClientException.class)
        .hasMessage("container non-existent not found in pod single-container");
  }

  @Test
  void execNoStreams() throws Exception {
    client.pods().resource(new PodBuilder().withNewMetadata().withName("name").endMetadata()
        .withNewSpec()
        .addNewContainer()
        .withName("the-first-container")
        .endContainer()
        .endSpec()
        .build())
        .createOrReplace();
    PodResource op = client.pods().withName("name");
    assertThrows(KubernetesClientException.class, () -> op.exec("sleep 1"));
  }

  @Test
  @DisplayName("With multiple containers, should exec in the first container")
  void withMultipleContainers() throws Exception {
    client.pods().resource(new PodBuilder().withNewMetadata().withName("multiple-containers").endMetadata()
        .withNewSpec()
        .addNewContainer()
        .withName("the-first-container")
        .endContainer()
        .addNewContainer()
        .withName("the-second-container")
        .endContainer()
        .endSpec()
        .build())
        .createOrReplace();
    server.expect()
        .get()
        .withPath(
            "/api/v1/namespaces/test/pods/multiple-containers/exec?command=sleep%201&container=the-first-container&stderr=true")
        .andUpgradeToWebSocket()
        .open()
        .immediately().andEmit(exitZeroEvent())
        .done()
        .always();
    final ExecWatch result = client.pods().withName("multiple-containers").redirectingError().exec("sleep 1");
    assertThat(result.exitCode().get(1, TimeUnit.SECONDS)).isZero();
  }

  @Test
  @DisplayName("With multiple containers and inContainer with existent name, should exec in the selected container")
  void withMultipleContainersAndInContainer() throws Exception {
    client.pods().resource(new PodBuilder().withNewMetadata().withName("multiple-containers").endMetadata()
        .withNewSpec()
        .addNewContainer()
        .withName("the-first-container")
        .endContainer()
        .addNewContainer()
        .withName("the-second-container")
        .endContainer()
        .endSpec()
        .build())
        .createOrReplace();
    server.expect()
        .get()
        .withPath(
            "/api/v1/namespaces/test/pods/multiple-containers/exec?command=sleep%201&container=the-second-container&stderr=true")
        .andUpgradeToWebSocket()
        .open()
        .immediately().andEmit(exitZeroEvent())
        .done()
        .always();
    final ExecWatch result = client.pods().withName("multiple-containers").inContainer("the-second-container")
        .redirectingError().exec("sleep 1");
    assertThat(result.exitCode().get(1, TimeUnit.SECONDS)).isZero();
  }

  private static WebSocketMessage exitZeroEvent() {
    final Status success = new StatusBuilder().withStatus("Success").build();
    return new WebSocketMessage(0L, "\u0003" + Serialization.asJson(success), false, true);
  }
}
