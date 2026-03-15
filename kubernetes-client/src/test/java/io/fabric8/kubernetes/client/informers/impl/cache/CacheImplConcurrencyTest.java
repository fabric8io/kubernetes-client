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

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Verifies that concurrent index reads never observe partially-updated index state.
 *
 * @see <a href="https://github.com/fabric8io/kubernetes-client/issues/7265">Issue 7265</a>
 */
class CacheImplConcurrencyTest {

  private static final String LABEL_INDEX = "label-index";

  @Test
  void byIndexShouldNeverMissObjectDuringConcurrentUpdates() throws InterruptedException {
    CacheImpl<Pod> cache = new CacheImpl<>(Cache.NAMESPACE_INDEX, Cache::metaNamespaceIndexFunc, Cache::metaNamespaceKeyFunc);
    cache.addIndexFunc(LABEL_INDEX, pod -> Collections.singletonList(pod.getMetadata().getLabels().get("app")));

    // Pre-populate a pod that should always be findable by index
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

    // Readers: continuously query byIndex and verify the pod is always found
    for (int r = 0; r < readerThreads; r++) {
      executor.submit(() -> {
        try {
          startLatch.await();
          for (int i = 0; i < iterations; i++) {
            List<Pod> result = cache.byIndex(LABEL_INDEX, "myapp");
            if (result.isEmpty()) {
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
    doneLatch.await(30, TimeUnit.SECONDS);
    executor.shutdown();
    executor.awaitTermination(5, TimeUnit.SECONDS);

    assertThat(missDetected.get())
        .as("byIndex() should never return empty during concurrent updates, but missed %d times", missCount.get())
        .isFalse();
  }

  @Test
  void indexKeysShouldNeverMissObjectDuringConcurrentUpdates() throws InterruptedException {
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

    for (int r = 0; r < readerThreads; r++) {
      executor.submit(() -> {
        try {
          startLatch.await();
          for (int i = 0; i < iterations; i++) {
            List<String> keys = cache.indexKeys(LABEL_INDEX, "myapp");
            if (keys.isEmpty()) {
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
    doneLatch.await(30, TimeUnit.SECONDS);
    executor.shutdown();
    executor.awaitTermination(5, TimeUnit.SECONDS);

    assertThat(missDetected.get())
        .as("indexKeys() should never return empty during concurrent updates, but missed %d times", missCount.get())
        .isFalse();
  }
}
