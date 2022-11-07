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

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableKubernetesMockClient(crud = true)
class ConfigMapCrudTest {

  KubernetesClient client;

  @Test
  void testCrud() {

    ConfigMap configmap1 = new ConfigMapBuilder().withNewMetadata().withName("configmap1").endMetadata()
        .addToData("one", "1")
        .build();
    ConfigMap configmap2 = new ConfigMapBuilder()
        .withNewMetadata()
        .addToLabels("foo", "bar")
        .withName("configmap2")
        .endMetadata()
        .addToData("two", "2")
        .build();
    ConfigMap configmap3 = new ConfigMapBuilder()
        .withNewMetadata()
        .addToLabels("foo", "bar")
        .withName("configmap2")
        .endMetadata()
        .addToData("three", "3")
        .build();

    client.configMaps().inNamespace("ns1").create(configmap1);
    client.configMaps().inNamespace("ns1").create(configmap2);
    client.configMaps().inNamespace("ns2").create(configmap3);

    ConfigMapList aConfigMapList = client.configMaps().list();
    assertNotNull(aConfigMapList);
    assertEquals(0, aConfigMapList.getItems().size());

    aConfigMapList = client.configMaps().inAnyNamespace().list();
    assertNotNull(aConfigMapList);
    assertEquals(3, aConfigMapList.getItems().size());

    Set<String> uids = new ConcurrentSkipListSet<>();

    // make sure waitUntilCondition is called on each item
    client.configMaps().inAnyNamespace().waitUntilCondition(c -> {
      uids.add(c.getMetadata().getUid());
      return true;
    }, 10, TimeUnit.SECONDS);

    assertEquals(3, uids.size());

    // make sure that the initial list is used, not the individual add events
    client.configMaps().inAnyNamespace().informOnCondition(l -> {
      if (l.size() != 3) {
        throw new AssertionError();
      }
      return true;
    }).join();

    aConfigMapList = client.configMaps().inAnyNamespace().withLabels(Collections.singletonMap("foo", "bar")).list();
    assertNotNull(aConfigMapList);
    assertEquals(2, aConfigMapList.getItems().size());

    aConfigMapList = client.configMaps().inNamespace("ns1").list();
    assertNotNull(aConfigMapList);
    assertEquals(2, aConfigMapList.getItems().size());

    client.configMaps().inNamespace("ns1").withName("configmap1").delete();
    aConfigMapList = client.configMaps().inNamespace("ns1").list();
    assertNotNull(aConfigMapList);
    assertEquals(1, aConfigMapList.getItems().size());

    configmap2 = client.configMaps().inNamespace("ns1").withName("configmap2")
        .edit(c -> new ConfigMapBuilder(c).addToData("II", "TWO").build());
    assertNotNull(configmap2);
    assertEquals("TWO", configmap2.getData().get("II"));

    configmap2 = client.configMaps().inNamespace("ns1").withName("configmap2").patch(PatchContext.of(PatchType.JSON_MERGE),
        new ConfigMapBuilder(configmap2).addToData("III", "THREE").build());
    assertNotNull(configmap2);
    assertEquals("THREE", configmap2.getData().get("III"));
  }

  @Test
  void testPatchBase() {
    ConfigMap configmap2 = new ConfigMapBuilder()
        .withNewMetadata()
        .addToLabels("foo", "bar")
        .withName("configmap2")
        .endMetadata()
        .addToData("two", "2")
        .build();
    ConfigMap configmap2a = new ConfigMapBuilder()
        .withNewMetadata()
        .addToLabels("foo", "bar")
        .withName("configmap2")
        .endMetadata()
        .addToData("three", "3")
        .build();

    client.configMaps().inNamespace("ns1").resource(configmap2).create();
    client.configMaps().inNamespace("ns1").resource(configmap2a).replace();

    // No-op - base and item are the same
    ConfigMap result = client.configMaps().inNamespace("ns1").resource(configmap2).patch(configmap2);
    assertEquals(Collections.singletonMap("three", "3"), result.getData());

    // this will patch the server value, so the base becomes 2a
    result = client.configMaps().inNamespace("ns1").resource(configmap2).patch();
    assertEquals(Collections.singletonMap("two", "2"), result.getData());

    // this will patch the server value, so the base becomes 2
    result = client.configMaps().inNamespace("ns1").resource(configmap2a).patch(PatchContext.of(PatchType.JSON));
    assertEquals(Collections.singletonMap("three", "3"), result.getData());
  }

  @Test
  @DisplayName("edit, should add and remove data entries")
  void edit() {
    // Given
    final ConfigMap cm = new ConfigMapBuilder()
        .withNewMetadata().withName("config-map").endMetadata()
        .addToData("one", "1")
        .build();
    client.configMaps().create(cm);
    // When
    client.configMaps().withName("config-map")
        .edit(c -> new ConfigMapBuilder(c).removeFromData("one").addToData("two", "2").build());
    // Then
    assertThat(client.configMaps().withName("config-map").get().getData())
        .hasSize(1)
        .containsExactlyInAnyOrderEntriesOf(Collections.singletonMap("two", "2"));
  }
}
