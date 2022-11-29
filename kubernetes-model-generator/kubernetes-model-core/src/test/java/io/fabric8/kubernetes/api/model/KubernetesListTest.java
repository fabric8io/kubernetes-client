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
package io.fabric8.kubernetes.api.model;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class KubernetesListTest {

  @Test
  public void testDefaultValues() {
    Service service = new io.fabric8.kubernetes.api.model.ServiceBuilder()
        .withNewMetadata()
        .withName("test-service")
        .endMetadata()
        .build();
    assertNotNull(service.getApiVersion());
    assertEquals("Service", service.getKind());

    ReplicationController replicationController = new io.fabric8.kubernetes.api.model.ReplicationControllerBuilder()
        .withNewMetadata()
        .withName("test-controller")
        .endMetadata()
        .build();
    assertNotNull(replicationController.getApiVersion());
    assertEquals("ReplicationController", replicationController.getKind());

    KubernetesList kubernetesList;
    kubernetesList = new io.fabric8.kubernetes.api.model.KubernetesListBuilder()
        .addNewServiceItem()
        .withNewMetadata()
        .withName("test-service")
        .endMetadata()
        .and()
        .addNewReplicationControllerItem()
        .withNewMetadata()
        .withName("test-controller")
        .endMetadata()
        .and()
        .build();

    assertNotNull(kubernetesList.getApiVersion());
    assertEquals("v1", kubernetesList.getApiVersion());
    assertEquals("List", kubernetesList.getKind());
    assertThat(kubernetesList.getItems(), CoreMatchers.hasItem(service));
    assertThat(kubernetesList.getItems(), CoreMatchers.hasItem(replicationController));
  }

  @Test
  void testVisitor() {
    KubernetesList list = new io.fabric8.kubernetes.api.model.KubernetesListBuilder()
        .addNewPodItem()
        .withNewSpec()
        .addNewContainer()
        .withName("my-container")
        .withImage("my/image")
        .endContainer()
        .endSpec()
        .and()
        .build();

    final KubernetesList visitedList = new io.fabric8.kubernetes.api.model.KubernetesListBuilder(list).accept(item -> {
      if (item instanceof io.fabric8.kubernetes.api.model.PodSpecBuilder) {
        ((io.fabric8.kubernetes.api.model.PodSpecBuilder) item).addNewContainer()
            .withName("other-container")
            .withImage("other/image")
            .and();
      }
    }).build();
    final Container visitedContainer = ((Pod) visitedList.getItems().get(0)).getSpec().getContainers().get(1);
    assertEquals("other-container", visitedContainer.getName());
    assertEquals("other/image", visitedContainer.getImage());
  }

  @Test
  public void testDefaultNullValues() {
    Container container = new io.fabric8.kubernetes.api.model.ContainerBuilder().build();
    assertNull(container.getLifecycle());
    assertNull(container.getLivenessProbe());

    Pod pod = new io.fabric8.kubernetes.api.model.PodBuilder().build();
    assertNull(pod.getSpec());
    assertNull(pod.getStatus());
  }
}
