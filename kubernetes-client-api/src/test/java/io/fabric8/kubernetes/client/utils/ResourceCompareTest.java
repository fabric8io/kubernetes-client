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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResourceCompareTest {

  private Pod pod;
  private Service service;
  private KubernetesList kubeList;

  @BeforeEach
  public void setup() {
    pod = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test")
        .withLabels(Collections.singletonMap("label", "value")).and().build();
    service = new ServiceBuilder()
        .withNewMetadata().withName("service1").withNamespace("test").and()
        .build();
    final ReplicationController rc = new ReplicationControllerBuilder()
        .withNewMetadata().withName("repl1").withNamespace("test").endMetadata()
        .withNewSpec().withReplicas(1).endSpec()
        .build();

    kubeList = new KubernetesListBuilder().withItems(pod, service, rc).build();
  }

  @Test
  void testResourceCompareEqualsTrue() {
    assertThat(ResourceCompare.equals(kubeList, kubeList), is(true));
  }

  @Test
  void testResourceCompareEqualsFalse() {
    final ReplicationController rc = new ReplicationControllerBuilder()
        .withNewMetadata().withName("repl1").withNamespace("test").endMetadata()
        .withNewSpec().withReplicas(2).endSpec()
        .build();
    final KubernetesList kubeList2 = new KubernetesListBuilder(kubeList).withItems(pod, service, rc).build();
    assertThat(ResourceCompare.equals(kubeList, kubeList2), is(false));
  }

  @Test
  void testPodResourceCompareEqualsTrueNoLabels() {
    Pod podNoLabels = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    assertThat(ResourceCompare.equals(pod, podNoLabels), is(true));
  }

  @Test
  void testPodResourceCompareEqualsTrueMatchingLabels() {
    Pod podWithLabels = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test")
        .withLabels(Collections.singletonMap("label", "value")).and().build();
    assertThat(ResourceCompare.equals(pod, podWithLabels), is(true));
  }

  @Test
  void testPodResourceCompareEqualsFalseDifferentLabels() {
    Pod podWithLabels = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test")
        .withLabels(Collections.singletonMap("label", "another value")).and().build();
    assertThat(ResourceCompare.equals(pod, podWithLabels), is(false));
  }

  @Test
  void testServiceDifferenceFromClusterAndAsObject() {
    // Given
    Service serviceFromCluster = new ServiceBuilder()
        .withNewMetadata()
        .withCreationTimestamp("2020-07-27T10:36:33Z")
        .withName("my-service")
        .withNamespace("default")
        .withResourceVersion("202998")
        .withSelfLink("/api/v1/namespaces/default/services/my-service")
        .withUid("99fe3964-b53b-473f-b1d8-bdb0390d1634")
        .endMetadata()
        .withNewSpec()
        .withClusterIP("10.110.153.70")
        .addNewPort()
        .withPort(80)
        .withProtocol("TCP")
        .withTargetPort(new IntOrString("9376"))
        .endPort()
        .addToSelector(Collections.singletonMap("app", "MyApp"))
        .withType("ClusterIP")
        .endSpec()
        .build();

    Service serviceAsObj = new ServiceBuilder()
        .withNewMetadata().withName("my-service").endMetadata()
        .withNewSpec()
        .addToSelector(Collections.singletonMap("app", "MyApp"))
        .addNewPort()
        .withPort(80)
        .withProtocol("TCP")
        .withTargetPort(new IntOrString("9376"))
        .endPort()
        .endSpec()
        .build();

    // When
    boolean result = ResourceCompare.equals(serviceFromCluster, serviceAsObj);

    // Then
    assertTrue(result);
  }

  @Test
  void testEqualsWhenOneResourceIsNull() {
    // Given
    Pod pod2 = new PodBuilder().withNewMetadata().withName("foo").endMetadata().build();

    // When
    boolean result = ResourceCompare.equals(null, pod2);

    // Then
    assertFalse(result);
  }

  @Test
  void testEqualsWhenBothNull() {
    assertTrue(ResourceCompare.equals(null, null));
  }
}
