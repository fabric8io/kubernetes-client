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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ListerTest {

  @Test
  void testListerWithEmptyIndex() {
    final Lister<String> namespacedPodLister = new Lister<>(new MapIndexer<>(), "default");
    assertTrue(namespacedPodLister.list().isEmpty());
  }

  @Test
  void testListerWithIndexValues() {
    // Given
    final MapIndexer<Integer> indexer = new MapIndexer<>();
    indexer.put("default", "key1", 1);
    indexer.put("other", "key2", 1);
    indexer.put("other", "key3", 1);
    // When
    final Lister<Integer> result = new Lister<>(indexer, "default");
    // Then
    assertEquals(1, result.list().size());
  }

  @Test
  void testListerWithIndexValuesInOther() {
    // Given
    final MapIndexer<Integer> indexer = new MapIndexer<>();
    indexer.put("default", "key1", 1);
    indexer.put("other", "key2", 1);
    indexer.put("other", "key3", 1);
    // When
    final Lister<Integer> result = new Lister<>(indexer, "default");
    // Then
    assertEquals(2, result.namespace("other").list().size());
  }

}
