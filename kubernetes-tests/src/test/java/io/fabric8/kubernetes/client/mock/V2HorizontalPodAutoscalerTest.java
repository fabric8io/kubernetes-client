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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.StatusDetails;
import io.fabric8.kubernetes.api.model.autoscaling.v2.HorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.autoscaling.v2.HorizontalPodAutoscalerBuilder;
import io.fabric8.kubernetes.api.model.autoscaling.v2.HorizontalPodAutoscalerList;
import io.fabric8.kubernetes.api.model.autoscaling.v2.HorizontalPodAutoscalerListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class V2HorizontalPodAutoscalerTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void load() {
    List<HasMetadata> itemsList = client.load(getClass().getResourceAsStream("/test-v2-hpa.yml")).items();

    assertThat(itemsList)
        .hasSize(1)
        .singleElement(InstanceOfAssertFactories.type(HorizontalPodAutoscaler.class))
        .hasFieldOrPropertyWithValue("metadata.name", "php-apache")
        .hasFieldOrPropertyWithValue("spec.maxReplicas", 10)
        .hasFieldOrPropertyWithValue("spec.minReplicas", 1);
  }

  @Test
  void list() {
    server.expect().withPath("/apis/autoscaling/v2/namespaces/test/horizontalpodautoscalers")
        .andReturn(200, new HorizontalPodAutoscalerListBuilder().build()).once();
    server.expect().withPath("/apis/autoscaling/v2/namespaces/ns1/horizontalpodautoscalers")
        .andReturn(200, new HorizontalPodAutoscalerListBuilder()
            .addNewItem().and()
            .addNewItem().and()
            .build())
        .once();

    HorizontalPodAutoscalerList horizontalPodAutoscalerList = client.autoscaling().v2().horizontalPodAutoscalers()
        .inNamespace("test").list();
    assertThat(horizontalPodAutoscalerList)
        .extracting(HorizontalPodAutoscalerList::getItems)
        .asList()
        .isEmpty();

    horizontalPodAutoscalerList = client.autoscaling().v2().horizontalPodAutoscalers().inNamespace("ns1").list();
    assertThat(horizontalPodAutoscalerList)
        .extracting(HorizontalPodAutoscalerList::getItems)
        .asList()
        .hasSize(2);
  }

  @Test
  void listWithLabels() {
    server.expect()
        .withPath("/apis/autoscaling/v2/namespaces/test/horizontalpodautoscalers?labelSelector="
            + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3"))
        .andReturn(200, new HorizontalPodAutoscalerListBuilder().build()).once();
    server.expect()
        .withPath("/apis/autoscaling/v2/namespaces/ns1/horizontalpodautoscalers?labelSelector="
            + Utils.toUrlEncoded("key1=value1,key2=value2"))
        .andReturn(200, new HorizontalPodAutoscalerListBuilder()
            .addNewItem().and()
            .addNewItem().and()
            .addNewItem().and()
            .build())
        .once();

    HorizontalPodAutoscalerList horizontalPodAutoscalerList = client.autoscaling().v2().horizontalPodAutoscalers()
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .withLabel("key3", "value3")
        .list();
    assertThat(horizontalPodAutoscalerList)
        .extracting(HorizontalPodAutoscalerList::getItems)
        .asList()
        .isEmpty();

    horizontalPodAutoscalerList = client.autoscaling().v2().horizontalPodAutoscalers().inNamespace("ns1")
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .list();
    assertThat(horizontalPodAutoscalerList)
        .extracting(HorizontalPodAutoscalerList::getItems)
        .asList()
        .hasSize(3);
  }

  @Test
  void get() {
    server.expect().withPath("/apis/autoscaling/v2/namespaces/test/horizontalpodautoscalers/horizontalpodautoscaler1")
        .andReturn(200, new HorizontalPodAutoscalerBuilder().build()).once();
    server.expect().withPath("/apis/autoscaling/v2/namespaces/ns1/horizontalpodautoscalers/horizontalpodautoscaler2")
        .andReturn(200, new HorizontalPodAutoscalerBuilder().build()).once();

    HorizontalPodAutoscaler horizontalPodAutoscaler = client.autoscaling().v2().horizontalPodAutoscalers().inNamespace("test")
        .withName("horizontalpodautoscaler1").get();
    assertThat(horizontalPodAutoscaler).isNotNull();

    horizontalPodAutoscaler = client.autoscaling().v2().horizontalPodAutoscalers().withName("horizontalpodautoscaler2").get();
    assertThat(horizontalPodAutoscaler).isNull();

    horizontalPodAutoscaler = client.autoscaling().v2().horizontalPodAutoscalers().inNamespace("ns1")
        .withName("horizontalpodautoscaler2").get();
    assertThat(horizontalPodAutoscaler).isNotNull();
  }

  @Test
  void editMissing() {
    // Given
    server.expect().withPath("/apis/autoscaling/v2/namespaces/test/horizontalpodautoscalers/horizontalpodautoscaler")
        .andReturn(404, "error message from kubernetes").always();
    Resource<HorizontalPodAutoscaler> hpaResource = client.autoscaling()
        .v2()
        .horizontalPodAutoscalers()
        .inNamespace("test")
        .withName("horizontalpodautoscaler");
    // When + Then
    assertThatThrownBy(() -> hpaResource.edit(h -> h))
        .isInstanceOf(KubernetesClientException.class);
  }

  @Test
  void delete() {
    server.expect().withPath("/apis/autoscaling/v2/namespaces/test/horizontalpodautoscalers/horizontalpodautoscaler1")
        .andReturn(200, new HorizontalPodAutoscalerBuilder().build()).once();
    server.expect().withPath("/apis/autoscaling/v2/namespaces/ns1/horizontalpodautoscalers/horizontalpodautoscaler2")
        .andReturn(200, new HorizontalPodAutoscalerBuilder().build()).once();

    Boolean deleted = client.autoscaling().v2().horizontalPodAutoscalers().inNamespace("test")
        .withName("horizontalpodautoscaler1").delete().size() == 1;
    assertThat(deleted).isTrue();

    deleted = client.autoscaling().v2().horizontalPodAutoscalers().withName("horizontalpodautoscaler2").delete().size() == 1;
    assertThat(deleted).isFalse();

    deleted = client.autoscaling().v2().horizontalPodAutoscalers().inNamespace("ns1").withName("horizontalpodautoscaler2")
        .delete().size() == 1;
    assertThat(deleted).isTrue();
  }

  @Test
  void deleteMulti() {
    HorizontalPodAutoscaler horizontalPodAutoscaler1 = new HorizontalPodAutoscalerBuilder().withNewMetadata()
        .withName("horizontalpodautoscaler1").withNamespace("test").endMetadata().build();
    HorizontalPodAutoscaler horizontalPodAutoscaler2 = new HorizontalPodAutoscalerBuilder().withNewMetadata()
        .withName("horizontalpodautoscaler2").withNamespace("ns1").endMetadata().build();
    HorizontalPodAutoscaler horizontalPodAutoscaler3 = new HorizontalPodAutoscalerBuilder().withNewMetadata()
        .withName("horizontalpodautoscaler3").withNamespace("any").endMetadata().build();

    server.expect().withPath("/apis/autoscaling/v2/namespaces/test/horizontalpodautoscalers/horizontalpodautoscaler1")
        .andReturn(200, horizontalPodAutoscaler1).once();
    server.expect().withPath("/apis/autoscaling/v2/namespaces/ns1/horizontalpodautoscalers/horizontalpodautoscaler2")
        .andReturn(200, horizontalPodAutoscaler2).once();

    List<StatusDetails> deleteStatusDetails = client.resourceList(horizontalPodAutoscaler1, horizontalPodAutoscaler2)
        .inAnyNamespace()
        .delete();
    assertThat(deleteStatusDetails).hasSize(2);

    Boolean deleted = client.autoscaling().v2().horizontalPodAutoscalers().inAnyNamespace().resource(horizontalPodAutoscaler3)
        .delete()
        .size() == 1;
    assertThat(deleted).isFalse();
  }

  @Test
  void createWithNameMismatch() {
    // Given
    HorizontalPodAutoscaler horizontalPodAutoscaler1 = new HorizontalPodAutoscalerBuilder().withNewMetadata()
        .withName("horizontalpodautoscaler1").withNamespace("test").endMetadata().build();
    Resource<HorizontalPodAutoscaler> hpaResource = client.autoscaling().v2()
        .horizontalPodAutoscalers()
        .inNamespace("test")
        .resource(horizontalPodAutoscaler1);
    // When + Then
    assertThatThrownBy(hpaResource::create)
        .isInstanceOf(KubernetesClientException.class);
  }

  @Test
  void loadFromFile() {
    HorizontalPodAutoscaler horizontalPodAutoscaler = client.autoscaling().v2().horizontalPodAutoscalers()
        .load(getClass().getResourceAsStream("/test-v2-hpa.yml")).item();
    assertThat(horizontalPodAutoscaler)
        .hasFieldOrPropertyWithValue("metadata.name", "php-apache");
  }

  @Test
  void builder() {
    HorizontalPodAutoscaler horizontalPodAutoscaler = new HorizontalPodAutoscalerBuilder()
        .withNewMetadata().withName("test-hpa").withNamespace("test").endMetadata()
        .withNewSpec()
        .withNewScaleTargetRef()
        .withApiVersion("apps/v2")
        .withKind("Deployment")
        .withName("the-deployment")
        .endScaleTargetRef()
        .withMinReplicas(1)
        .withMaxReplicas(10)
        .endSpec()
        .build();

    server.expect().withPath("/apis/autoscaling/v2/namespaces/test/horizontalpodautoscalers/test-hpa")
        .andReturn(200, horizontalPodAutoscaler).once();

    horizontalPodAutoscaler = client.autoscaling().v2().horizontalPodAutoscalers().inNamespace("test").withName("test-hpa")
        .get();
    assertThat(horizontalPodAutoscaler).isNotNull();
  }

}
