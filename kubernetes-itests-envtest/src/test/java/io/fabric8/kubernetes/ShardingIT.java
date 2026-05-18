/*
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

import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@EnableKubeAPIServer(kubeAPIVersion = "1.36.0", apiServerFlags = "--feature-gates=ShardedListAndWatch=true")
public class ShardingIT {

  public static final String LABEL_SELECTOR = "test=true";
  public static final String SHARD1 = "shardRange(object.metadata.uid, '0x0000000000000000', '0x8000000000000000')";
  public static final String SHARD2 = "shardRange(object.metadata.uid, '0x8000000000000000', '0x10000000000000000')";
  static KubernetesClient client;

  @Test
  void shardedList() {
    var cm = client.resource(configMap()).create();

    var shard1 = client.configMaps()
        .withLabelSelector(LABEL_SELECTOR)
        .withShardSelector(SHARD1).list();
    var shard2 = client.configMaps()
        .withLabelSelector(LABEL_SELECTOR)
        .withShardSelector(SHARD2).list();

    assertThat(shard1.getItems().size() + shard2.getItems().size()).isEqualTo(1);
    client.resource(cm).delete();
  }

  @Test
  void shardedInformer() {
    var cm = client.resource(configMap()).create();
    AtomicInteger eventCounter = new AtomicInteger(0);

    try (var ignored = client.configMaps()
        .withLabelSelector(LABEL_SELECTOR)
        .withShardSelector(SHARD1).inform(getHandler(eventCounter));
        var ignored1 = client.configMaps()
            .withLabelSelector(LABEL_SELECTOR)
            .withShardSelector(SHARD2).inform(getHandler(eventCounter))) {
      await().pollDelay(Duration.ofMillis(150))
          .untilAsserted(() -> assertThat(eventCounter.get()).isEqualTo(1));
      client.resource(cm).delete();
    }
  }

  private static ResourceEventHandler<ConfigMap> getHandler(AtomicInteger eventCounter) {
    return new ResourceEventHandler<>() {
      @Override
      public void onAdd(ConfigMap configMap) {
        eventCounter.getAndAdd(1);
      }

      @Override
      public void onUpdate(ConfigMap configMap, ConfigMap t1) {
        eventCounter.getAndAdd(1);
      }

      @Override
      public void onDelete(ConfigMap configMap, boolean b) {
      }
    };
  }

  private ConfigMap configMap() {
    return new ConfigMapBuilder()
        .withMetadata(new ObjectMetaBuilder()
            .withName("cm1")
            .withLabels(Map.of("test", "true"))
            .withNamespace("default")
            .build())
        .build();
  }

}
