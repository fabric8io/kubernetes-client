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
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.RequestConfigBuilder;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.Listable;
import io.fabric8.kubernetes.client.dsl.base.ShardField;
import io.fabric8.kubernetes.client.dsl.base.ShardSelector;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.awaitility.Awaitility.await;

@EnableKubeAPIServer(kubeAPIVersion = "1.36.*", apiServerFlags = "--feature-gates=ShardedListAndWatch=true")
public class ShardingIT {

  public static final String LABEL_SELECTOR = "test=true";
  public static final String SHARD1 = "shardRange(object.metadata.uid, '0x0000000000000000', '0x8000000000000000')";
  public static final String SHARD2 = "shardRange(object.metadata.uid, '0x8000000000000000', '0x10000000000000000')";
  public static final Duration EVENT_SETTLE_WINDOW = Duration.ofMillis(500);
  private static final List<String> NAMESPACES = List.of("shard-a", "shard-b", "shard-c");
  static KubernetesClient client;

  // The apiserver is class-scoped, so labelled ConfigMaps from one method would otherwise
  // leak into the next and turn create() into AlreadyExists, masking the original failure.
  // They are deleted one by one because they can live in any of the namespaces below.
  @AfterEach
  void cleanup() {
    client.configMaps().inAnyNamespace().withLabelSelector(LABEL_SELECTOR).list().getItems()
        .forEach(configMap -> client.resource(configMap).delete());
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

  // The expressions rendered by ShardSelector must be accepted by the apiserver as-is, including the
  // zero padded bounds and the 17 digit '0x10000000000000000' upper bound of the last shard, and the
  // shards it computes must really partition the objects.
  @Test
  void typedShardSelectorPartitionsTheObjects() {
    var names = createConfigMaps(20);

    var shards = IntStream.range(0, 4)
        .mapToObj(shard -> namesIn(ShardSelector.ofShard(shard, 4)))
        .collect(Collectors.toList());

    // Every object in exactly one shard: a duplicate or a missing one fails the count.
    assertThat(shards.stream().flatMap(Set::stream).collect(Collectors.toList()))
        .containsExactlyInAnyOrderElementsOf(names);
  }

  // A selector with more than one range is sent as 'shardRange(...) || shardRange(...)', which no other
  // test exercises against a real apiserver.
  @Test
  void typedShardSelectorCombinesRangesWithOr() {
    var names = createConfigMaps(20);

    var evenShards = namesIn(ShardSelector.builder().addShard(0, 4).addShard(2, 4).build());
    var oddShards = namesIn(ShardSelector.builder().addShard(1, 4).addShard(3, 4).build());

    assertThat(evenShards).doesNotContainAnyElementsOf(oddShards);
    assertThat(Stream.concat(evenShards.stream(), oddShards.stream()).collect(Collectors.toList()))
        .containsExactlyInAnyOrderElementsOf(names);
  }

  // Sharding on the namespace hashes a value the objects share, so a namespace must never be split
  // across shards - which is the point of sharding on it.
  @Test
  void typedShardSelectorShardsByNamespace() {
    for (String namespace : NAMESPACES) {
      client.namespaces().resource(namespace(namespace)).createOr(r -> r.update());
      createConfigMaps(3, namespace);
    }

    var shard1 = namesIn(ShardSelector.ofShard(ShardField.NAMESPACE, 0, 2));
    var shard2 = namesIn(ShardSelector.ofShard(ShardField.NAMESPACE, 1, 2));

    for (String namespace : NAMESPACES) {
      var namespaceNames = namesIn(namespace);
      assertThat(namespaceNames).hasSize(3);
      assertThat(shard1.containsAll(namespaceNames) || shard2.containsAll(namespaceNames))
          .withFailMessage("namespace %s was split across shards: %s vs %s", namespace, shard1, shard2)
          .isTrue();
    }
  }

  // The client rejects a selector mixing fields on construction; this pins the server-side rule it
  // mirrors, so the two cannot drift apart.
  @Test
  void mixedFieldExpressionIsRejectedByTheApiServer() {
    var mixed = SHARD1 + " || shardRange(object.metadata.namespace, "
        + "'0x8000000000000000', '0x10000000000000000')";

    // The apiserver reports the parse failure as a 500, which the client would otherwise retry.
    assertThatExceptionOfType(KubernetesClientException.class)
        .isThrownBy(() -> client.adapt(NamespacedKubernetesClient.class)
            .withRequestConfig(new RequestConfigBuilder().withRequestRetryBackoffLimit(0).build())
            .call(c -> c.configMaps()
                .inNamespace("default")
                .withLabelSelector(LABEL_SELECTOR)
                .withShardSelector(mixed)
                .list()))
        .satisfies(e -> assertThat(e.getMessage()).contains("same field"));

    assertThatIllegalArgumentException()
        .isThrownBy(() -> ShardSelector.builder()
            .addShard(ShardField.UID, 0, 2)
            .addShard(ShardField.NAMESPACE, 1, 2)
            .build());
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
    return configMap(name, "default");
  }

  private static ConfigMap configMap(String name, String namespace) {
    return new ConfigMapBuilder()
        .withMetadata(new ObjectMetaBuilder()
            .withName(name)
            .withLabels(Map.of("test", "true"))
            .withNamespace(namespace)
            .build())
        .build();
  }

  private static Namespace namespace(String name) {
    return new NamespaceBuilder()
        .withMetadata(new ObjectMetaBuilder().withName(name).build())
        .build();
  }

  private static Set<String> createConfigMaps(int count) {
    return createConfigMaps(count, "default");
  }

  // Names are unique across namespaces, so a cluster-wide listing can be compared by name alone.
  private static Set<String> createConfigMaps(int count, String namespace) {
    Set<String> names = new HashSet<>();
    for (int i = 0; i < count; i++) {
      String name = namespace + "-cm-" + i;
      client.resource(configMap(name, namespace)).create();
      names.add(name);
    }
    return names;
  }

  private static Set<String> namesIn(ShardSelector shardSelector) {
    return names(client.configMaps().inAnyNamespace()
        .withLabelSelector(LABEL_SELECTOR)
        .withShardSelector(shardSelector));
  }

  private static Set<String> namesIn(String namespace) {
    return names(client.configMaps().inNamespace(namespace).withLabelSelector(LABEL_SELECTOR));
  }

  private static Set<String> names(Listable<ConfigMapList> listable) {
    return listable.list().getItems().stream()
        .map(configMap -> configMap.getMetadata().getName())
        .collect(Collectors.toSet());
  }

}
