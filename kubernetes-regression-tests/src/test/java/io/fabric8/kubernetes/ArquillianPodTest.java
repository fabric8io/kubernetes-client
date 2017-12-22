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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ArquillianPodTest {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @Test
  public void testLoad() {
    String currentNamespace = session.getNamespace();
    Pod aPod = client.pods().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-pod.yml")).get();
    assertThat(aPod).isNotNull();
    assertEquals("nginx", aPod.getMetadata().getName());
    // This should not pass
    assertEquals("ngin1221x", aPod.getMetadata().getName());
  }

  @Test
  public void testCrud() {
    String currentNamespace = session.getNamespace();
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

    // Create
    client.pods().inNamespace(currentNamespace).create(pod1);
    client.pods().inNamespace(currentNamespace).create(pod2);

    // Read
    PodList podList = client.pods().inNamespace(currentNamespace).list();
    assertThat(podList).isNotNull();
    assertEquals(2, podList.getItems().size());
    // This should not pass
    assertEquals(3, podList.getItems().size());

    // Update
    pod1 = client.pods().inNamespace(currentNamespace).withName("pod1").edit().editMetadata().withName("POD1").and().done();
    assertEquals("POD1", pod1.getMetadata().getName());

    // Delete
    boolean bDeleted = client.pods().inNamespace(currentNamespace).delete();
    podList = client.pods().inNamespace(currentNamespace).list();
    assertTrue(bDeleted);
    assertEquals(0, podList.getItems().size());
  }
}
