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

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventBuilder;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class KubernetesResourceUtilTest {
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
  public void testNullSafeOperationsForName() {
    String resourceName = KubernetesResourceUtil.getName(configMap1);
    assertNotNull(resourceName);
    assertEquals("configmap1", resourceName);
  }

  @Test
  public void testNullSafeOperationsForNamespace() {
    String namespace = KubernetesResourceUtil.getNamespace(configMap1);
    assertNotNull(namespace);
    assertEquals("ns1", namespace);
    assertEquals("ns1/configmap1", KubernetesResourceUtil.getQualifiedName(configMap1));
  }

  @Test
  public void testNullSafeOperationsForLabels() {
    Map<String, String> labels = KubernetesResourceUtil.getOrCreateLabels(configMap1);
    assertNotNull(labels);
    assertEquals(Collections.singletonMap("foo-label", "bar-label"), labels);
  }

  @Test
  public void testNullSafeOperationsForAnnotations() {
    Map<String, String> annos = KubernetesResourceUtil.getOrCreateAnnotations(configMap1);
    assertNotNull(annos);
    assertEquals(Collections.singletonMap("foo", "bar"), annos);
  }

  @Test
  public void testNames() {
    assertTrue(KubernetesResourceUtil.isValidName(KubernetesResourceUtil.getName(configMap1)));
    assertFalse(KubernetesResourceUtil.isValidName("test.invalid.name"));
    assertTrue(KubernetesResourceUtil.isValidLabelOrAnnotation(KubernetesResourceUtil.getOrCreateAnnotations(configMap1)));
    assertFalse(KubernetesResourceUtil.isValidLabelOrAnnotation(Collections.singletonMap("NoUppercaseOrSpecialCharsLike=Equals", "bar")));

    assertTrue(KubernetesResourceUtil.isValidName(KubernetesResourceUtil.sanitizeName("test.invalid.name")));
    assertTrue(KubernetesResourceUtil.isValidName(KubernetesResourceUtil.sanitizeName("90notcool-n@me")));
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

    // When
    KubernetesResourceUtil.sortEventListBasedOnTimestamp(eventList);

    // Then
    assertEquals("event3", eventList.get(0).getMetadata().getName());
    assertEquals("event2", eventList.get(1).getMetadata().getName());
    assertEquals("event1", eventList.get(2).getMetadata().getName());
  }
}
