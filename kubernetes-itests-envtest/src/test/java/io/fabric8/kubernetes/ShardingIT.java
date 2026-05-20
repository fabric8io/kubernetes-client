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
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@EnableKubeAPIServer(kubeAPIVersion = "1.36.*", apiServerFlags = "--feature-gates=ShardedListAndWatch=true")
public class ShardingIT {

  public static final String LABEL_SELECTOR = "test=true";
  public static final String SHARD1 = "shardRange(object.metadata.uid, '0x0000000000000000', '0x8000000000000000')";
  public static final String SHARD2 = "shardRange(object.metadata.uid, '0x8000000000000000', '0x10000000000000000')";
  public static final Duration EVENT_SETTLE_WINDOW = Duration.ofMillis(500);
  static KubernetesClient client;

  // The apiserver is class-scoped, so labelled ConfigMaps from one method would otherwise
  // leak into the next and turn create() into AlreadyExists, masking the original failure.
  @AfterEach
  void cleanup() {
    client.configMaps().inNamespace("default").withLabelSelector(LABEL_SELECTOR).delete();
  }

  @Test
  void shardedList() {
    client.resource(configMap()).create();

    var shard1 = client.configMaps()
        .withLabelSelector(LABEL_SELECTOR)
        .withShardSelector(SHARD1).list();
    var shard2 = client.configMaps()
        .withLabelSelector(LABEL_SELECTOR)
        .withShardSelector(SHARD2).list();

    assertThat(shard1.getItems().size() + shard2.getItems().size()).isEqualTo(1);
  }

  @Test
  void shardedInformer() {
    client.resource(configMap()).create();
    AtomicInteger eventCounter = new AtomicInteger(0);

    try (var ignored = client.configMaps()
        .withLabelSelector(LABEL_SELECTOR)
        .withShardSelector(SHARD1).inform(getHandler(eventCounter));
        var ignored1 = client.configMaps()
            .withLabelSelector(LABEL_SELECTOR)
            .withShardSelector(SHARD2).inform(getHandler(eventCounter))) {
      await().during(EVENT_SETTLE_WINDOW)
          .untilAsserted(() -> assertThat(eventCounter.get()).isEqualTo(1));
    }
  }

  @Test
  void shardedWatch() {
    client.resource(configMap()).create();
    AtomicInteger eventCounter = new AtomicInteger(0);

    try (var ignored = client.configMaps()
        .withLabelSelector(LABEL_SELECTOR)
        .withShardSelector(SHARD1).watch(getWatcher(eventCounter));
        var ignored1 = client.configMaps()
            .withLabelSelector(LABEL_SELECTOR)
            .withShardSelector(SHARD2).watch(getWatcher(eventCounter))) {
      await().during(EVENT_SETTLE_WINDOW)
          .untilAsserted(() -> assertThat(eventCounter.get()).isEqualTo(1));
    }
  }

  @Test
  void shardedDelete() {
    for (int i = 0; i < 10; i++) {
      client.resource(configMap("cm-" + i)).create();
    }

    int totalBefore = client.configMaps().withLabelSelector(LABEL_SELECTOR).list().getItems().size();
    int shard1Before = client.configMaps()
        .withLabelSelector(LABEL_SELECTOR).withShardSelector(SHARD1).list().getItems().size();
    int shard2Before = client.configMaps()
        .withLabelSelector(LABEL_SELECTOR).withShardSelector(SHARD2).list().getItems().size();
    assertThat(shard1Before + shard2Before).isEqualTo(totalBefore);
    Assumptions.assumeTrue(shard1Before > 0 && shard2Before > 0,
        "UID hashing didn't populate both shards — re-run");

    client.configMaps()
        .withLabelSelector(LABEL_SELECTOR).withShardSelector(SHARD1).delete();

    // SHARD1 must be empty and SHARD2 untouched — guards against the apiserver ignoring
    // shardSelector on DELETECOLLECTION (which would silently delete the whole label set).
    assertThat(client.configMaps().withLabelSelector(LABEL_SELECTOR)
        .withShardSelector(SHARD1).list().getItems()).isEmpty();
    assertThat(client.configMaps().withLabelSelector(LABEL_SELECTOR)
        .withShardSelector(SHARD2).list().getItems()).hasSize(shard2Before);
  }

  private static Watcher<ConfigMap> getWatcher(AtomicInteger eventCounter) {
    return new Watcher<>() {
      @Override
      public void eventReceived(Action action, ConfigMap configMap) {
        // Only count ADDED so server-side managedFields bumps (MODIFIED) don't inflate the counter.
        if (action == Action.ADDED) {
          eventCounter.getAndAdd(1);
        }
      }

      @Override
      public void onClose(WatcherException cause) {
      }
    };
  }

  private static ResourceEventHandler<ConfigMap> getHandler(AtomicInteger eventCounter) {
    return new ResourceEventHandler<>() {
      @Override
      public void onAdd(ConfigMap configMap) {
        eventCounter.getAndAdd(1);
      }

      @Override
      public void onUpdate(ConfigMap configMap, ConfigMap t1) {
        // Intentionally not counted: managedFields churn can fire onUpdate without a sharding bug.
      }

      @Override
      public void onDelete(ConfigMap configMap, boolean b) {
      }
    };
  }

  private ConfigMap configMap() {
    return configMap("cm1");
  }

  private ConfigMap configMap(String name) {
    return new ConfigMapBuilder()
        .withMetadata(new ObjectMetaBuilder()
            .withName(name)
            .withLabels(Map.of("test", "true"))
            .withNamespace("default")
            .build())
        .build();
  }

}
