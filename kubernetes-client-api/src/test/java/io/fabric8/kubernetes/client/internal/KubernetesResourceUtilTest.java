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

package io.fabric8.kubernetes.client.internal;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.DefaultKubernetesResourceList;
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.batch.v1beta1.CronJob;
import io.fabric8.kubernetes.api.model.batch.v1beta1.CronJobList;
import io.fabric8.kubernetes.client.Good;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KubernetesResourceUtilTest {
  private ConfigMap configMap1;

  @BeforeEach
  public void createTestResource() {
    configMap1 = new ConfigMapBuilder()
        .withNewMetadata()
        .withName("configmap1")
        .withNamespace("ns1")
        .withAnnotations(Collections.singletonMap("foo", "bar"))
        .withLabels(Collections.singletonMap("foo-label", "bar-label"))
        .endMetadata()
        .addToData("one", "1")
        .build();
  }

  @Test
  void testNullSafeOperationsForName() {
    String resourceName = KubernetesResourceUtil.getName(configMap1);
    assertNotNull(resourceName);
    assertEquals("configmap1", resourceName);
  }

  @Test
  void testNullSafeOperationsForNamespace() {
    String namespace = KubernetesResourceUtil.getNamespace(configMap1);
    assertNotNull(namespace);
    assertEquals("ns1", namespace);
    assertEquals("ns1/configmap1", KubernetesResourceUtil.getQualifiedName(configMap1));
  }

  @Test
  void testNullSafeOperationsForLabels() {
    Map<String, String> labels = KubernetesResourceUtil.getOrCreateLabels(configMap1);
    assertNotNull(labels);
    assertEquals(Collections.singletonMap("foo-label", "bar-label"), labels);
  }

  @Test
  void testNullSafeOperationsForAnnotations() {
    Map<String, String> annos = KubernetesResourceUtil.getOrCreateAnnotations(configMap1);
    assertNotNull(annos);
    assertEquals(Collections.singletonMap("foo", "bar"), annos);
  }

  @Test
  void testNames() {
    assertTrue(KubernetesResourceUtil.isValidName(KubernetesResourceUtil.getName(configMap1)));
    assertFalse(KubernetesResourceUtil.isValidName("test.invalid.name"));
    assertTrue(KubernetesResourceUtil.isValidLabelOrAnnotation(KubernetesResourceUtil.getOrCreateAnnotations(configMap1)));
    assertFalse(KubernetesResourceUtil
        .isValidLabelOrAnnotation(Collections.singletonMap("NoUppercaseOrSpecialCharsLike=Equals", "bar")));

    assertTrue(KubernetesResourceUtil.isValidName(KubernetesResourceUtil.sanitizeName("test.invalid.name")));
    assertTrue(KubernetesResourceUtil.isValidName(KubernetesResourceUtil.sanitizeName("90notcool-n@me")));
    assertTrue(KubernetesResourceUtil.isValidName(
        KubernetesResourceUtil.sanitizeName("90notcool-n@me_______waytoooooooooolooooooooongand should be shorten for sure")));
  }

  @Test
  void testSortEventListBasedOnTimestamp() {
    // Given
    List<Event> eventList = new ArrayList<>();
    eventList.add(new EventBuilder()
        .withNewMetadata().withName("event2").endMetadata()
        .withLastTimestamp("2020-06-12T06:45:16Z")
        .build());
    eventList.add(new EventBuilder()
        .withNewMetadata().withName("event1").endMetadata()
        .withLastTimestamp("2020-06-10T06:45:16Z")
        .build());
    eventList.add(new EventBuilder()
        .withNewMetadata().withName("event3").endMetadata()
        .withLastTimestamp("2020-06-13T06:45:16Z")
        .build());
    eventList.add(new EventBuilder()
        .withNewMetadata().withName("eventWithoutLastTimestamp").endMetadata()
        .build());

    // When
    KubernetesResourceUtil.sortEventListBasedOnTimestamp(eventList);

    // Then
    assertEquals("eventWithoutLastTimestamp", eventList.get(0).getMetadata().getName());
    assertEquals("event3", eventList.get(1).getMetadata().getName());
    assertEquals("event2", eventList.get(2).getMetadata().getName());
    assertEquals("event1", eventList.get(3).getMetadata().getName());
  }

  @Test
  @DisplayName("Should be able to get resource version")
  void testGetResourceVersion() {
    // Given
    Pod pod = new PodBuilder()
        .withNewMetadata().withName("test").withResourceVersion("1001").endMetadata()
        .build();

    // When
    String resourceVersion = KubernetesResourceUtil.getResourceVersion(pod);

    // Then
    assertEquals("1001", resourceVersion);
  }

  @Test
  @DisplayName("Should be able to update resource version")
  void testSetResourceVersion() {
    // Given
    Pod pod = new PodBuilder()
        .withNewMetadata().withName("test").withResourceVersion("1001").endMetadata()
        .build();

    // When
    KubernetesResourceUtil.setResourceVersion(pod, "1002");

    // Then
    assertEquals("1002", pod.getMetadata().getResourceVersion());
  }

  @Test
  void testIsResourceReadyReturnsTrue() {
    // Given
    Deployment deployment = new DeploymentBuilder()
        .withNewMetadata().withName("test").endMetadata()
        .withNewSpec().withReplicas(1).endSpec()
        .withNewStatus()
        .withReplicas(1)
        .withAvailableReplicas(1)
        .endStatus()
        .build();

    // When
    boolean result = KubernetesResourceUtil.isResourceReady(deployment);

    // Then
    assertTrue(result);
  }

  @Test
  void testIsResourceReadyReturnsFalse() {
    // Given
    Deployment deployment = new DeploymentBuilder()
        .withNewMetadata().withName("test").endMetadata()
        .withNewSpec().withReplicas(2).endSpec()
        .withNewStatus()
        .withReplicas(1)
        .withAvailableReplicas(1)
        .endStatus()
        .build();

    // When
    boolean result = KubernetesResourceUtil.isResourceReady(deployment);

    // Then
    assertFalse(result);
  }

  @Test
  void testGetAge() {
    // Given
    Pod pod = new PodBuilder()
        .withNewMetadata().withName("test").withCreationTimestamp("2020-11-03T13:22:22Z").endMetadata()
        .build();

    // When
    Duration duration = KubernetesResourceUtil.getAge(pod);

    // Then
    assertFalse(duration.isNegative());
  }

  @Test
  void testInferListType() {
    assertEquals(PodList.class, KubernetesResourceUtil.inferListType(Pod.class));
    assertEquals(ConfigMapList.class, KubernetesResourceUtil.inferListType(ConfigMap.class));
    assertEquals(CronJobList.class, KubernetesResourceUtil.inferListType(CronJob.class));
    assertEquals(DefaultKubernetesResourceList.class, KubernetesResourceUtil.inferListType(Good.class));
  }

  @Test
  void testcreateDockerRegistrySecret() throws JsonProcessingException {
    Secret secret = KubernetesResourceUtil.createDockerRegistrySecret("http://harbor.inner.com", "SecretAdmin",
        "TestingSecret");

    String header = new String(Base64.getDecoder().decode(secret.getData().get(".dockerconfigjson")));

    assertEquals(
        "{\"auths\":{\"http://harbor.inner.com\":{\"password\":\"TestingSecret\",\"auth\":\"U2VjcmV0QWRtaW46VGVzdGluZ1NlY3JldA==\",\"username\":\"SecretAdmin\"}}}",
        header);
  }
}
