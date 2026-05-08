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
package io.fabric8.kubernetes.client.informers.impl.cache;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.informers.cache.Cache;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Verifies that concurrent index reads never observe partially-updated index state.
 *
 * @see <a href="https://github.com/fabric8io/kubernetes-client/issues/7265">Issue 7265</a>
 */
class CacheImplConcurrencyTest {

  private static final String LABEL_INDEX = "label-index";

  @ParameterizedTest(name = "{0} should never miss object during concurrent updates")
  @ValueSource(strings = { "byIndex", "indexKeys" })
  void indexReadShouldNeverMissObjectDuringConcurrentUpdates(String readMethod) throws InterruptedException {
    CacheImpl<Pod> cache = new CacheImpl<>(Cache.NAMESPACE_INDEX, Cache::metaNamespaceIndexFunc, Cache::metaNamespaceKeyFunc);
    cache.addIndexFunc(LABEL_INDEX, pod -> Collections.singletonList(pod.getMetadata().getLabels().get("app")));

    Pod pod = new PodBuilder()
        .withNewMetadata()
        .withName("test-pod")
        .withNamespace("default")
        .withResourceVersion("1")
        .addToLabels("app", "myapp")
        .endMetadata()
        .build();
    cache.put(pod);

    int writerThreads = 4;
    int readerThreads = 8;
    int iterations = 5000;
    AtomicBoolean missDetected = new AtomicBoolean(false);
    AtomicInteger missCount = new AtomicInteger(0);
    CountDownLatch startLatch = new CountDownLatch(1);
    CountDownLatch doneLatch = new CountDownLatch(writerThreads + readerThreads);

    ExecutorService executor = Executors.newFixedThreadPool(writerThreads + readerThreads);

    // Writers: continuously update the pod (same index key "myapp") to trigger remove+re-add in updateIndices
    for (int w = 0; w < writerThreads; w++) {
      final int writerId = w;
      executor.submit(() -> {
        try {
          startLatch.await();
          for (int i = 0; i < iterations; i++) {
            Pod updated = new PodBuilder()
                .withNewMetadata()
                .withName("test-pod")
                .withNamespace("default")
                .withResourceVersion(String.valueOf(writerId * iterations + i + 2))
                .addToLabels("app", "myapp")
                .endMetadata()
                .build();
            cache.put(updated);
          }
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        } finally {
          doneLatch.countDown();
        }
      });
    }

    // Readers: continuously query the index and verify the pod is always found
    for (int r = 0; r < readerThreads; r++) {
      executor.submit(() -> {
        try {
          startLatch.await();
          for (int i = 0; i < iterations; i++) {
            boolean empty = readIndex(cache, readMethod);
            if (empty) {
              missDetected.set(true);
              missCount.incrementAndGet();
            }
          }
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        } finally {
          doneLatch.countDown();
        }
      });
    }

    // Start all threads simultaneously
    startLatch.countDown();
    assertThat(doneLatch.await(30, TimeUnit.SECONDS))
        .as("All threads should complete within timeout")
        .isTrue();
    executor.shutdown();
    assertThat(executor.awaitTermination(5, TimeUnit.SECONDS))
        .as("Executor should terminate within timeout")
        .isTrue();

    assertThat(missDetected.get())
        .as("%s() should never return empty during concurrent updates, but missed %d times", readMethod, missCount.get())
        .isFalse();
  }

  private boolean readIndex(CacheImpl<Pod> cache, String method) {
    if ("byIndex".equals(method)) {
      List<Pod> result = cache.byIndex(LABEL_INDEX, "myapp");
      return result.isEmpty();
    } else {
      List<String> keys = cache.indexKeys(LABEL_INDEX, "myapp");
      return keys.isEmpty();
    }
  }

  /**
   * Verifies that {@link CacheImpl#index(String, io.fabric8.kubernetes.api.model.HasMetadata)} never misses a
   * legitimate match across multiple index buckets while updates are in flight. Without per-entry consistency
   * checking before deduplication, a stale entry in the first iterated bucket would mark the key visited and
   * prevent the legitimate match in a later bucket from being recorded.
   */
  @Test
  void indexAcrossMultipleBucketsShouldNeverMissObjectDuringConcurrentUpdates() throws InterruptedException {
    CacheImpl<Pod> cache = new CacheImpl<>(Cache.NAMESPACE_INDEX, Cache::metaNamespaceIndexFunc, Cache::metaNamespaceKeyFunc);
    // Sorted to make iteration order deterministic: [A, B] for pods carrying both labels.
    cache.addIndexFunc(LABEL_INDEX, pod -> {
      Map<String, String> labels = pod.getMetadata().getLabels();
      if (labels == null) {
        return Collections.emptyList();
      }
      return labels.values().stream().sorted().collect(Collectors.toList());
    });

    // Query object asks for items matching either of two index values; "B" is the one the pod always carries.
    Pod queryObj = new PodBuilder()
        .withNewMetadata()
        .addToLabels("a", "A")
        .addToLabels("b", "B")
        .endMetadata()
        .build();

    // Initial state populates both bucket A and bucket B.
    cache.put(new PodBuilder()
        .withNewMetadata()
        .withName("test-pod")
        .withNamespace("default")
        .withResourceVersion("1")
        .addToLabels("a", "A")
        .addToLabels("b", "B")
        .endMetadata()
        .build());

    int writerThreads = 4;
    int readerThreads = 8;
    int iterations = 5000;
    AtomicBoolean missDetected = new AtomicBoolean(false);
    AtomicInteger missCount = new AtomicInteger(0);
    CountDownLatch startLatch = new CountDownLatch(1);
    CountDownLatch doneLatch = new CountDownLatch(writerThreads + readerThreads);

    ExecutorService executor = Executors.newFixedThreadPool(writerThreads + readerThreads);

    // Writers alternate between [A, B] and [B] so the pod's presence in bucket A churns
    // while it permanently belongs in bucket B.
    for (int w = 0; w < writerThreads; w++) {
      final int writerId = w;
      executor.submit(() -> {
        try {
          startLatch.await();
          for (int i = 0; i < iterations; i++) {
            Map<String, String> labels = new HashMap<>();
            labels.put("b", "B");
            if (i % 2 == 0) {
              labels.put("a", "A");
            }
            cache.put(new PodBuilder()
                .withNewMetadata()
                .withName("test-pod")
                .withNamespace("default")
                .withResourceVersion(String.valueOf(writerId * iterations + i + 2))
                .withLabels(labels)
                .endMetadata()
                .build());
          }
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        } finally {
          doneLatch.countDown();
        }
      });
    }

    for (int r = 0; r < readerThreads; r++) {
      executor.submit(() -> {
        try {
          startLatch.await();
          for (int i = 0; i < iterations; i++) {
            if (cache.index(LABEL_INDEX, queryObj).isEmpty()) {
              missDetected.set(true);
              missCount.incrementAndGet();
            }
          }
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        } finally {
          doneLatch.countDown();
        }
      });
    }

    startLatch.countDown();
    assertThat(doneLatch.await(30, TimeUnit.SECONDS))
        .as("All threads should complete within timeout")
        .isTrue();
    executor.shutdown();
    assertThat(executor.awaitTermination(5, TimeUnit.SECONDS))
        .as("Executor should terminate within timeout")
        .isTrue();

    assertThat(missDetected.get())
        .as("index() should never return empty during concurrent updates, but missed %d times", missCount.get())
        .isFalse();
  }
}
