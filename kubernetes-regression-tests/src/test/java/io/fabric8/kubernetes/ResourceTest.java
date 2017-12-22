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

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class ResourceTest {
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
  public void testCrud() throws InterruptedException {
    Pod pod1 = new PodBuilder()
      .withNewMetadata().withName("pod1").endMetadata()
      .withNewSpec()
      .addNewContainer().withName("nginx").withImage("nginx").endContainer()
      .endSpec()
      .build();
    Pod pod2 = new PodBuilder()
      .withNewMetadata().withName("pod2").endMetadata()
      .withNewSpec()
      .addNewContainer().withName("httpd").withImage("httpd").endContainer()
      .endSpec()
      .build();

    // Wait for service account token to be auto-generated.
    Thread.sleep(3000);
    client.resource(pod1).inNamespace(currentNamespace).createOrReplace();
    client.resource(pod2).inNamespace(currentNamespace).createOrReplace();

    assertThat(client.pods().inNamespace(currentNamespace).withName("pod1")).isNotNull();
    assertThat(client.pods().inNamespace(currentNamespace).withName("pod2")).isNotNull();

    boolean bDeleted = client.resource(pod1).inNamespace(currentNamespace).delete();
    assertTrue(bDeleted);
  }

  @Test
  public void testList() {
    Pod pod1 = new PodBuilder()
      .withNewMetadata().withName("pod3").endMetadata()
      .withNewSpec()
      .addNewContainer().withName("nginx").withImage("nginx").endContainer()
      .endSpec()
      .build();
    Pod pod2 = new PodBuilder()
      .withNewMetadata().withName("pod4").endMetadata()
      .withNewSpec()
      .addNewContainer().withName("httpd").withImage("httpd").endContainer()
      .endSpec()
      .build();

    client.resourceList(new PodListBuilder().withItems(pod1, pod2).build())
      .inNamespace(currentNamespace)
      .apply();

    assertTrue(client.pods().inNamespace(currentNamespace).withName("pod3") != null);
    assertTrue(client.pods().inNamespace(currentNamespace).withName("pod4") != null);

    boolean bDeleted = client.resourceList(new PodListBuilder().withItems(pod1, pod2).build())
      .inNamespace(currentNamespace)
      .delete();
    assertTrue(bDeleted);
  }
}
