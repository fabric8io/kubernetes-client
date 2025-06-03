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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableKubernetesMockClient(crud = true)
class DeploymentCrudTest {

  KubernetesClient client;
  KubernetesMockServer server;

  @Test
  void listInAnyNamespace() {
    for (var i = 1; i < 4; i++) {
      var deployment = new DeploymentBuilder().withNewMetadata()
          .withName("deployment-" + i)
          .withNamespace("ns-" + i)
          .addToLabels("testKey", "testValue-" + i)
          .endMetadata()
          .withNewSpec()
          .endSpec()
          .build();
      client.apps().deployments().resource(deployment).create();
    }
    assertThat(client.apps().deployments().inAnyNamespace().list().getItems())
        .hasSize(3)
        .extracting("metadata.name", "metadata.namespace")
        .containsExactlyInAnyOrder(
            tuple("deployment-1", "ns-1"),
            tuple("deployment-2", "ns-2"),
            tuple("deployment-3", "ns-3"));
  }

  @Test
  void listInNamespace() {
    for (var i = 1; i < 4; i++) {
      var deployment = new DeploymentBuilder().withNewMetadata()
          .withName("deployment-" + i)
          .withNamespace("ns-" + i)
          .addToLabels("testKey", "testValue-" + i)
          .endMetadata()
          .withNewSpec()
          .endSpec()
          .build();
      client.apps().deployments().resource(deployment).create();
    }
    assertThat(client.apps().deployments().inNamespace("ns-1").list().getItems())
        .hasSize(1)
        .extracting("metadata.name", "metadata.namespace")
        .containsExactlyInAnyOrder(
            tuple("deployment-1", "ns-1"));
  }

  @Test
  void listWithLabels() {
    for (var i = 1; i < 4; i++) {
      var deployment = new DeploymentBuilder().withNewMetadata()
          .withName("deployment-" + i)
          .withNamespace("ns-" + i)
          .addToLabels("testKey", "testValue-" + i)
          .endMetadata()
          .withNewSpec()
          .endSpec()
          .build();
      client.apps().deployments().resource(deployment).create();
    }
    assertThat(client.apps().deployments().inAnyNamespace().withLabel("testKey", "testValue-2").list().getItems())
        .hasSize(1)
        .extracting("metadata.name", "metadata.namespace")
        .containsExactlyInAnyOrder(
            tuple("deployment-2", "ns-2"));
  }

  @Test
  void delete() {
    client.apps().deployments()
        .resource(new DeploymentBuilder().withNewMetadata().withName("deployment-to-delete").endMetadata().build())
        .create();
    assertThat(client.apps().deployments().withName("deployment-to-delete").withTimeoutInMillis(100).delete())
        .singleElement()
        .extracting("name").isEqualTo("deployment-to-delete");
  }

  @Test
  void edit() {
    client.apps().deployments()
        .resource(new DeploymentBuilder().withNewMetadata().withName("deployment-to-edit").endMetadata().build())
        .create();
    var edited = client.apps().deployments().withName("deployment-to-edit").edit(d -> new DeploymentBuilder(d)
        .editMetadata().addToLabels("key1", "value1").endMetadata()
        .build());
    assertThat(edited).extracting("metadata.labels").isEqualTo(Map.of("key1", "value1"));
  }

  @Test
  @DisplayName("Should replace Deployment in CRUD server")
  void testUpdate() {
    // Given
    var deployment = client.apps().deployments().inNamespace("ns1").resource(new DeploymentBuilder().withNewMetadata()
        .withName("d1")
        .withNamespace("ns1")
        .addToLabels("testKey", "testValue")
        .endMetadata()
        .withNewSpec()
        .endSpec()
        .build())
        .create();

    // When
    deployment.getMetadata().getLabels().put("testKey", "one");
    client.apps().deployments().resource(deployment).update();

    // Then
    Deployment replacedDeployment = client.apps().deployments().inNamespace("ns1").withName("d1").get();
    assertNotNull(replacedDeployment);
    assertFalse(replacedDeployment.getMetadata().getLabels().isEmpty());
    assertEquals("one", replacedDeployment.getMetadata().getLabels().get("testKey"));
  }

  @Test
  @DisplayName("Should pause resource")
  void testPause() {
    // Given
    client.apps().deployments().inNamespace("ns1").resource(new DeploymentBuilder().withNewMetadata()
        .withName("d1")
        .withNamespace("ns1")
        .addToLabels("testKey", "testValue")
        .endMetadata()
        .withNewSpec()
        .endSpec()
        .build())
        .create();

    // When
    client.apps()
        .deployments()
        .inNamespace("ns1")
        .withName("d1")
        .rolling()
        .pause();
    Deployment updatedDeployment = client.apps().deployments().inNamespace("ns1").withName("d1").get();

    // Then
    assertNotNull(updatedDeployment);
    assertEquals(true, updatedDeployment.getSpec().getPaused());
  }

  @Test
  @DisplayName("Should resume rollout")
  void testRolloutResume() {
    // Given
    client.apps().deployments().inNamespace("ns1").resource(new DeploymentBuilder().withNewMetadata()
        .withName("d1")
        .withNamespace("ns1")
        .addToLabels("testKey", "testValue")
        .endMetadata()
        .withNewSpec()
        .endSpec()
        .build())
        .create();

    // When
    client.apps()
        .deployments()
        .inNamespace("ns1")
        .withName("d1")
        .rolling()
        .resume();
    Deployment updatedDeployment = client.apps().deployments().inNamespace("ns1").withName("d1").get();

    // Then
    assertNotNull(updatedDeployment);
    assertNull(updatedDeployment.getSpec().getPaused());
  }

  @Test
  @DisplayName("Should restart rollout")
  void rolloutRestart() {
    // Given
    client.apps().deployments()
        .resource(new DeploymentBuilder().withNewMetadata().withName("deployment-to-restart").endMetadata().build())
        .create();
    // When
    client.apps().deployments().withName("deployment-to-restart").rolling().restart();
    // Then
    assertThat(client.apps().deployments().withName("deployment-to-restart").get())
        .extracting(d -> d.getSpec().getTemplate().getMetadata().getAnnotations().get("kubectl.kubernetes.io/restartedAt"))
        .asString().isNotBlank();
  }

  @Test
  @DisplayName("Should restart rollout preserving annotations")
  void rolloutRestartPreservesAnnotations() {
    // Given
    client.apps().deployments()
        .resource(new DeploymentBuilder().withNewMetadata().withName("deployment-to-restart").endMetadata()
            .withNewSpec().withNewTemplate().withNewMetadata().addToAnnotations("original", "annotation").endMetadata()
            .endTemplate().endSpec()
            .build())
        .create();
    // When
    client.apps().deployments().withName("deployment-to-restart").rolling().restart();
    // Then
    assertThat(client.apps().deployments().withName("deployment-to-restart").get())
        .extracting("spec.template.metadata.annotations")
        .asInstanceOf(InstanceOfAssertFactories.map(String.class, String.class))
        .hasFieldOrPropertyWithValue("original", "annotation")
        .extracting(annotations -> annotations.get("kubectl.kubernetes.io/restartedAt"))
        .asString().isNotBlank();
  }

  @Test
  @DisplayName("Should retry rollout restart if annotations are missing")
  void testRolloutRestartWithRetry() {
    // Given
    client.apps().deployments()
        .resource(new DeploymentBuilder().withNewMetadata().withName("deployment-to-restart").endMetadata().build())
        .create();
    // Simulate PATCH returning 422 on first attempt
    server.expect()
        .patch()
        .withPath("/apis/apps/v1/namespaces/test/deployments/deployment-to-restart")
        .andReturn(422, new StatusBuilder()
            .withCode(422)
            .withMessage("Unprocessable Entity")
            .build())
        .once();
    // When
    client.apps().deployments().withName("deployment-to-restart").rolling().restart();
    // Then
    assertThat(client.apps().deployments().withName("deployment-to-restart").get())
        .extracting(d -> d.getSpec().getTemplate().getMetadata().getAnnotations().get("kubectl.kubernetes.io/restartedAt"))
        .asString().isNotBlank();
  }
}
