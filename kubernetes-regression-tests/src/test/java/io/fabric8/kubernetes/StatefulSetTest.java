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

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.extensions.StatefulSet;
import io.fabric8.kubernetes.api.model.extensions.StatefulSetBuilder;
import io.fabric8.kubernetes.api.model.extensions.StatefulSetList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StatefulSetTest {
  public static KubernetesClient client;

  public static String currentNamespace;

  @BeforeClass
  public static void init() {
    client = new DefaultKubernetesClient();
    currentNamespace = "rt-" + RandomStringUtils.randomAlphanumeric(6).toLowerCase();
    Namespace aNamespace = new NamespaceBuilder().withNewMetadata().withName(currentNamespace).and().build();
    client.namespaces().create(aNamespace);
  }

  @AfterClass
  public static void cleanup() {
    client.namespaces().withName(currentNamespace).delete();
    client.close();
  }

  @Test
  public void testLoad() {
    StatefulSet aStatefulSet = client.apps().statefulSets().load(getClass().getResourceAsStream("/test-statefulset.yml")).get();
    assertThat(aStatefulSet).isNotNull();
    assertEquals("web", aStatefulSet.getMetadata().getName());
  }

  @Test
  public void testCrud() {
    StatefulSet ss1 = new StatefulSetBuilder()
      .withNewMetadata().withName("ss1").endMetadata()
      .withNewSpec()
      .withReplicas(2)
      .withNewSelector().withMatchLabels(Collections.singletonMap("app", "nginx")).endSelector()
      .withNewTemplate()
      .withNewMetadata()
      .addToLabels("app", "nginx")
      .endMetadata()
      .withNewSpec()
      .addNewContainer()
      .withName("nginx")
      .withImage("nginx")
      .addNewPort()
      .withContainerPort(80)
      .withName("web")
      .endPort()
      .addNewVolumeMount()
      .withName("www")
      .withMountPath("/usr/share/nginx/html")
      .endVolumeMount()
      .endContainer()
      .endSpec()
      .endTemplate()
      .addNewVolumeClaimTemplate()
      .withNewMetadata()
      .withName("www")
      .endMetadata()
      .withNewSpec()
      .addToAccessModes("ReadWriteOnce")
      .withNewResources()
      .withRequests(Collections.singletonMap("storage", new Quantity("1Gi")))
      .endResources()
      .endSpec()
      .endVolumeClaimTemplate()
      .endSpec()
      .build();

    client.apps().statefulSets().inNamespace(currentNamespace).create(ss1);

    StatefulSetList statefulSetList = client.apps().statefulSets().inNamespace(currentNamespace).list();
    assertThat(statefulSetList).isNotNull();
    assertEquals(1, statefulSetList.getItems().size());

    ss1 = client.apps().statefulSets().inNamespace(currentNamespace).withName("ss1").scale(5);
    assertEquals(5, ss1.getSpec().getReplicas().intValue());

    boolean bDeleted = client.apps().statefulSets().inNamespace(currentNamespace).withName("ss1").delete();
    assertTrue(bDeleted);
  }
}
