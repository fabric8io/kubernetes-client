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

package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscalerList;
import io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscalerBuilder;
import io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscalerListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@EnableRuleMigrationSupport
public class HorizontalPodAutoscalerTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testList() {
    server.expect().withPath("/apis/autoscaling/v2beta2/namespaces/test/horizontalpodautoscalers").andReturn(200, new HorizontalPodAutoscalerListBuilder().build()).once();
    server.expect().withPath("/apis/autoscaling/v2beta2/namespaces/ns1/horizontalpodautoscalers").andReturn(200, new HorizontalPodAutoscalerListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

    KubernetesClient client = server.getClient();
    HorizontalPodAutoscalerList horizontalPodAutoscalerList = client.autoscaling().horizontalPodAutoscalers().inNamespace("test").list();
    assertNotNull(horizontalPodAutoscalerList);
    assertEquals(0, horizontalPodAutoscalerList.getItems().size());

    horizontalPodAutoscalerList = client.autoscaling().horizontalPodAutoscalers().inNamespace("ns1").list();
    assertNotNull(horizontalPodAutoscalerList);
    assertEquals(2, horizontalPodAutoscalerList.getItems().size());
  }

  @Test
  public void testListWithLabels() {
    server.expect().withPath("/apis/autoscaling/v2beta2/namespaces/test/horizontalpodautoscalers?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3")).andReturn(200, new HorizontalPodAutoscalerListBuilder().build()).once();
    server.expect().withPath("/apis/autoscaling/v2beta2/namespaces/ns1/horizontalpodautoscalers?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2")).andReturn(200, new HorizontalPodAutoscalerListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

    KubernetesClient client = server.getClient();
    HorizontalPodAutoscalerList horizontalPodAutoscalerList = client.autoscaling().horizontalPodAutoscalers()
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .withLabel("key3","value3")
      .list();
    assertNotNull(horizontalPodAutoscalerList);
    assertEquals(0, horizontalPodAutoscalerList.getItems().size());

    horizontalPodAutoscalerList = client.autoscaling().horizontalPodAutoscalers().inNamespace("ns1")
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .list();
    assertNotNull(horizontalPodAutoscalerList);
    assertEquals(3, horizontalPodAutoscalerList.getItems().size());
  }

  @Test
  public void testGet() {
    server.expect().withPath("/apis/autoscaling/v2beta2/namespaces/test/horizontalpodautoscalers/horizontalpodautoscaler1").andReturn(200, new HorizontalPodAutoscalerBuilder().build()).once();
    server.expect().withPath("/apis/autoscaling/v2beta2/namespaces/ns1/horizontalpodautoscalers/horizontalpodautoscaler2").andReturn(200, new HorizontalPodAutoscalerBuilder().build()).once();

    KubernetesClient client = server.getClient();
    HorizontalPodAutoscaler horizontalPodAutoscaler = client.autoscaling().horizontalPodAutoscalers().inNamespace("test").withName("horizontalpodautoscaler1").get();
    assertNotNull(horizontalPodAutoscaler);

    horizontalPodAutoscaler = client.autoscaling().horizontalPodAutoscalers().withName("horizontalpodautoscaler2").get();
    assertNull(horizontalPodAutoscaler);

    horizontalPodAutoscaler = client.autoscaling().horizontalPodAutoscalers().inNamespace("ns1").withName("horizontalpodautoscaler2").get();
    assertNotNull(horizontalPodAutoscaler);
  }

  @Test
  public void testEditMissing() {

    Assertions.assertThrows(KubernetesClientException.class, () -> {
      server.expect().withPath("/apis/autoscaling/v2beta2/namespaces/test/horizontalpodautoscalers/horizontalpodautoscaler").andReturn(404, "error message from kubernetes").always();
      KubernetesClient client = server.getClient();

      client.autoscaling().horizontalPodAutoscalers().inNamespace("test").withName("horizontalpodautoscaler").edit();
    });
  }

  @Test
  public void testDelete() {
    server.expect().withPath("/apis/autoscaling/v2beta2/namespaces/test/horizontalpodautoscalers/horizontalpodautoscaler1").andReturn(200, new HorizontalPodAutoscalerBuilder().build()).once();
    server.expect().withPath("/apis/autoscaling/v2beta2/namespaces/ns1/horizontalpodautoscalers/horizontalpodautoscaler2").andReturn(200, new HorizontalPodAutoscalerBuilder().build()).once();

    KubernetesClient client = server.getClient();
    Boolean deleted = client.autoscaling().horizontalPodAutoscalers().inNamespace("test").withName("horizontalpodautoscaler1").delete();
    assertTrue(deleted);

    deleted = client.autoscaling().horizontalPodAutoscalers().withName("horizontalpodautoscaler2").delete();
    assertFalse(deleted);

    deleted = client.autoscaling().horizontalPodAutoscalers().inNamespace("ns1").withName("horizontalpodautoscaler2").delete();
    assertTrue(deleted);
  }

  @Test
  public void testDeleteMulti() {
    HorizontalPodAutoscaler horizontalPodAutoscaler1 = new HorizontalPodAutoscalerBuilder().withNewMetadata().withName("horizontalpodautoscaler1").withNamespace("test").endMetadata().build();
    HorizontalPodAutoscaler horizontalPodAutoscaler2 = new HorizontalPodAutoscalerBuilder().withNewMetadata().withName("horizontalpodautoscaler2").withNamespace("ns1").endMetadata().build();
    HorizontalPodAutoscaler horizontalPodAutoscaler3 = new HorizontalPodAutoscalerBuilder().withNewMetadata().withName("horizontalpodautoscaler3").withNamespace("any").endMetadata().build();

    server.expect().withPath("/apis/autoscaling/v2beta2/namespaces/test/horizontalpodautoscalers/horizontalpodautoscaler1").andReturn(200, horizontalPodAutoscaler1).once();
    server.expect().withPath("/apis/autoscaling/v2beta2/namespaces/ns1/horizontalpodautoscalers/horizontalpodautoscaler2").andReturn(200, horizontalPodAutoscaler2).once();

    KubernetesClient client = server.getClient();
    Boolean deleted = client.autoscaling().horizontalPodAutoscalers().inAnyNamespace().delete(horizontalPodAutoscaler1, horizontalPodAutoscaler2);
    assertTrue(deleted);

    deleted = client.autoscaling().horizontalPodAutoscalers().inAnyNamespace().delete(horizontalPodAutoscaler3);
    assertFalse(deleted);
  }

  @Test
  public void testCreateWithNameMismatch() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      HorizontalPodAutoscaler horizontalPodAutoscaler1 = new HorizontalPodAutoscalerBuilder().withNewMetadata().withName("horizontalpodautoscaler1").withNamespace("test").endMetadata().build();
      KubernetesClient client = server.getClient();
      client.autoscaling().horizontalPodAutoscalers().inNamespace("test").withName("horizontalpodautoscaler1").create(horizontalPodAutoscaler1);
    });
  }

  @Test
  public void testLoadFromFile() {
    KubernetesClient client = server.getClient();
    HorizontalPodAutoscaler horizontalPodAutoscaler = client.autoscaling().horizontalPodAutoscalers().load(getClass().getResourceAsStream("/test-horizontalpodautoscaler.yml")).get();
    assertEquals("php-apache", horizontalPodAutoscaler.getMetadata().getName());
  }

  @Test
  public void testBuild() {
    HorizontalPodAutoscaler horizontalPodAutoscaler = new HorizontalPodAutoscalerBuilder()
      .withNewMetadata().withName("test-hpa").withNamespace("test").endMetadata()
      .withNewSpec()
      .withNewScaleTargetRef()
      .withApiVersion("apps/v1")
      .withKind("Deployment")
      .withName("the-deployment")
      .endScaleTargetRef()
      .withMinReplicas(1)
      .withMaxReplicas(10)
      .endSpec()
      .build();

    server.expect().withPath("/apis/autoscaling/v2beta2/namespaces/test/horizontalpodautoscalers/test-hpa").andReturn(200, horizontalPodAutoscaler).once();

    KubernetesClient client = server.getClient();
    horizontalPodAutoscaler = client.autoscaling().horizontalPodAutoscalers().inNamespace("test").withName("test-hpa").get();
    assertNotNull(horizontalPodAutoscaler);
  }

}
