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

package io.fabric8.kubernetes;

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.readiness.Readiness;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/deployment-it.yml")
class DeploymentIT {

  KubernetesClient client;

  Namespace namespace;

  @Test
  void load() {
    Deployment aDeployment = client.apps().deployments().load(getClass().getResourceAsStream("/test-deployments.yml")).item();
    assertThat(aDeployment).isNotNull();
    assertEquals("nginx-deployment", aDeployment.getMetadata().getName());
  }

  @Test
  void get() {
    Deployment deployment1 = client.apps().deployments()
        .withName("deployment-standard").get();
    assertNotNull(deployment1);
  }

  @Test
  void list() {
    DeploymentList aDeploymentList = client.apps().deployments().list();
    assertThat(aDeploymentList).isNotNull();
    assertTrue(aDeploymentList.getItems().size() >= 1);
  }

  @Test
  void update() {
    Deployment deployment1 = client.apps().deployments().withName("deployment-standard")
        .edit(d -> new DeploymentBuilder(d)
            .editMetadata().withResourceVersion(null).addToAnnotations("updated", "true").endMetadata().build());
    assertThat(deployment1).isNotNull();
    assertEquals("true", deployment1.getMetadata().getAnnotations().get("updated"));
  }

  @Test
  void scale() {
    Deployment deployment1 = client.apps().deployments().withName("deployment-standard").scale(5, true);
    assertEquals(5, deployment1.getStatus().getReplicas());
    deployment1 = client.apps().deployments().withName("deployment-standard").scale(1, true);
    assertEquals(1, deployment1.getStatus().getReplicas());
    // ensure scale to 0 as some replica fields can flip to null
    deployment1 = client.apps().deployments().withName("deployment-standard").scale(0, true);
    assertEquals(0, Optional.ofNullable(deployment1.getStatus().getReplicas()).orElse(0));

    // will only work on clusters older than 1.16
    if (client.supports(io.fabric8.kubernetes.api.model.extensions.Deployment.class)) {
      client.extensions().deployments().withName("deployment-standard").scale(5, true);
      Scale scale = client.extensions().deployments().withName("deployment-standard").scale();
      assertEquals(5, scale.getStatus().getReplicas());
    }
  }

  @Test
  void waitTest() {
    // Wait for resources to get ready
    client.apps().deployments().withName("deployment-wait")
        .waitUntilReady(120, TimeUnit.SECONDS);
    Deployment deploymentOne = client.apps().deployments()
        .withName("deployment-wait").get();
    assertTrue(Readiness.isDeploymentReady(deploymentOne));
  }

  @Test
  void listFromServer() {
    Deployment deployment1 = client.apps().deployments().withName("deployment-standard").get();
    List<HasMetadata> resources = client.resourceList(deployment1).get();

    assertNotNull(resources);
    assertEquals(1, resources.size());
    assertNotNull(resources.get(0));

    HasMetadata fromServerPod = resources.get(0);

    assertEquals(deployment1.getKind(), fromServerPod.getKind());
    assertEquals(namespace.getMetadata().getName(), fromServerPod.getMetadata().getNamespace());
    assertEquals(deployment1.getMetadata().getName(), fromServerPod.getMetadata().getName());
  }

  @Test
  void delete() {
    assertTrue(client.apps().deployments().withName("deployment-delete").delete().size() == 1);
  }
}
