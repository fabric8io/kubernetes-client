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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscalerBuilder;
import io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscalerList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(ArquillianConditionalRunner.class)
@Ignore
@RequiresKubernetes
public class HorizontalPodAutoscalerIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(HorizontalPodAutoscalerIT.class.getResourceAsStream("/horizontalpodautoscaler-it.yml"));
  }

  @Test
  public void get() {
    HorizontalPodAutoscaler horizontalPodAutoscaler = client.autoscaling().v1().horizontalPodAutoscalers().inNamespace(session.getNamespace()).withName("horizontalpodautoscaler-get").get();
    assertThat(horizontalPodAutoscaler).isNotNull();
  }

  @Test
  public void list() {
    HorizontalPodAutoscalerList aEndpointList = client.autoscaling().v1().horizontalPodAutoscalers().inNamespace(session.getNamespace()).list();
    assertNotNull(aEndpointList);
    assertTrue(aEndpointList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    HorizontalPodAutoscaler horizontalPodAutoscaler = client.autoscaling().v1().horizontalPodAutoscalers().inNamespace(session.getNamespace()).withName("horizontalpodautoscaler-update").edit(c -> new HorizontalPodAutoscalerBuilder(c)
      .editOrNewMetadata().addToAnnotations("foo", "bar").endMetadata().build());

    assertNotNull(horizontalPodAutoscaler);
    assertEquals("bar", horizontalPodAutoscaler.getMetadata().getAnnotations().get("foo"));
  }

  @Test
  public void delete() {
    assertTrue(client.autoscaling().v1().horizontalPodAutoscalers().inNamespace(session.getNamespace()).withName("horizontalpodautoscaler-delete").delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(HorizontalPodAutoscalerIT.class.getResourceAsStream("/horizontalpodautoscaler-it.yml"));
  }
}
