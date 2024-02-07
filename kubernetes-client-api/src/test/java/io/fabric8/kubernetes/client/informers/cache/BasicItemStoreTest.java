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
package io.fabric8.kubernetes.client.informers.cache;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class BasicItemStoreTest {

  @Test
  void testEmptyStore() {
    Pod pod = new PodBuilder().withNewMetadata().withName("test-pod").withResourceVersion("1").endMetadata().build();

    ItemStore<Pod> itemStore = new BasicItemStore<>(BasicItemStoreTest::podToKey);

    assertThat(itemStore.size()).isZero();
    assertThat(itemStore.keySet()).isEmpty();
    assertThat(itemStore.values()).isEmpty();
    assertThat(itemStore.getKey(pod)).isEqualTo("pods/test-pod/1");
    assertThat(itemStore.get("pods/test-pod/1")).isNull();
    assertThat(itemStore.remove("pods/test-pod/1")).isNull();
    assertThat(itemStore.size()).isZero();
  }

  @Test
  void testPopulateStore() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("test-pod").withResourceVersion("1").endMetadata().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("test-pod").withResourceVersion("2").endMetadata().build();

    ItemStore<Pod> itemStore = new BasicItemStore<>(BasicItemStoreTest::podToKey);
    itemStore.put("pods/test-pod/1", pod1);

    assertThat(itemStore.size()).isOne();
    assertThat(itemStore.keySet()).hasSize(1).containsExactly("pods/test-pod/1");
    assertThat(itemStore.values()).hasSize(1).containsExactly(pod1);
    assertThat(itemStore.get("pods/test-pod/1")).isNotNull().isEqualTo(pod1);
    assertThat(itemStore.put(itemStore.getKey(pod2), pod2)).isNull();
    assertThat(itemStore.size()).isEqualTo(2);
    assertThat(itemStore.remove("pods/test-pod/1")).isEqualTo(pod1);
    assertThat(itemStore.get("pods/test-pod/1")).isNull();
    assertThat(itemStore.size()).isOne();
    assertThat(itemStore.remove("pods/test-pod/2")).isEqualTo(pod2);
    assertThat(itemStore.get("pods/test-pod/2")).isNull();
    assertThat(itemStore.size()).isZero();
  }

  @Test
  void parallelStore() throws InterruptedException {
    ItemStore<Pod> itemStore = new BasicItemStore<>(BasicItemStoreTest::podToKey);

    int tasks = 1000;
    CountDownLatch latch = new CountDownLatch(tasks);
    IntStream.range(0, tasks).<Runnable> mapToObj(i -> () -> {
      Pod pod = new PodBuilder().withNewMetadata().withName("test-pod").withResourceVersion(Integer.toString(i)).endMetadata()
          .build();
      String key = itemStore.getKey(pod);
      assertThat(itemStore.put(key, pod)).isNull();
      assertThat(key).isEqualTo("pods/test-pod/" + i);
      latch.countDown();
    }).forEach(ForkJoinPool.commonPool()::execute);

    assertThat(latch.await(15, TimeUnit.SECONDS)).isTrue();
    assertThat(itemStore.size()).isEqualTo(tasks);
    assertThat(itemStore.keySet()).hasSize(tasks).containsExactlyInAnyOrderElementsOf(
        IntStream.range(0, tasks).mapToObj(i -> "pods/test-pod/" + i).collect(Collectors.toList()));
    assertThat(itemStore.values()).hasSize(tasks);
    assertThat(itemStore.get("pods/test-pod/123")).isNotNull().extracting(pod -> pod.getMetadata().getResourceVersion())
        .isEqualTo("123");
  }

  private static String podToKey(Pod pod) {
    return pod.getFullResourceName() + "/" + pod.getMetadata().getName() + "/" + pod.getMetadata().getResourceVersion();
  }
}
