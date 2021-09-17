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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CacheTest {
  private static Cache cache = new Cache(CacheTest::mockKeyFunction, false).addIndexFunc("mock", CacheTest::mockIndexFunction);

  @Test
  void testCacheIndex() {
    Pod testPodObj = new PodBuilder().withNewMetadata().withName("test-pod").endMetadata().build();

    cache.put(testPodObj);
    cache.replace(Arrays.asList(testPodObj));

    String index = mockIndexFunction(testPodObj).get(0);
    String key = mockKeyFunction(testPodObj);

    List indexedObjectList = cache.byIndex("mock", index);
    assertEquals(testPodObj, indexedObjectList.get(0));

    indexedObjectList = cache.index("mock", testPodObj);
    assertEquals(testPodObj, indexedObjectList.get(0));

    List<String> allExistingKeys = cache.listKeys();
    assertEquals(1, allExistingKeys.size());
    assertEquals(key, allExistingKeys.get(0));
    
    cache.replace(Collections.emptyList());
    assertEquals(0, cache.byIndex("mock", "y").size());
  }

  @Test
  void testCacheStore() {
    Pod testPodObj = new PodBuilder().withNewMetadata().withName("test-pod2").endMetadata().build();
    String index = mockIndexFunction(testPodObj).get(0);

    cache.replace(Arrays.asList(testPodObj));
    cache.remove(testPodObj);

    List indexedObjectList = cache.byIndex("mock", index);
    assertEquals(0, indexedObjectList.size());

    cache.put(testPodObj);

    // replace cached object with null value
    String newClusterName = "test_cluster";
    testPodObj.getMetadata().setClusterName(newClusterName);
    cache.put(testPodObj);

    assertEquals(1, cache.list().size());
    assertEquals(newClusterName, testPodObj.getMetadata().getClusterName());
  }

  @Test
  void testDefaultNamespaceIndex() {
    Pod testPodObj = new PodBuilder().withNewMetadata().withName("test-pod3").withNamespace("default").endMetadata().build();

    cache.put(testPodObj);
    List<String> indices = Cache.metaNamespaceIndexFunc(testPodObj);
    assertEquals(testPodObj.getMetadata().getNamespace(), indices.get(0));
  }

  @Test
  void testDefaultNamespaceKey() {
    Pod testPodObj = new PodBuilder().withNewMetadata().withName("test-pod4").withNamespace("default").endMetadata().build();

    cache.put(testPodObj);
    assertEquals("", Cache.metaNamespaceKeyFunc(null));
    assertEquals("default/test-pod4", Cache.metaNamespaceKeyFunc(testPodObj));
    assertEquals("default/test-pod4", Cache.namespaceKeyFunc("default", "test-pod4"));
  }

  @Test
  void testEmptyNamespaceKey() {
    assertEquals("test-pod4", Cache.namespaceKeyFunc("", "test-pod4"));
    assertEquals("test-pod4", Cache.namespaceKeyFunc(null, "test-pod4"));
  }

  @Test
  void testAddIndexers() {
    Cache<Pod> podCache = new Cache<>();
    String nodeIndex = "node-index";
    String clusterIndex = "cluster-index";

    Map<String, Function<Pod, List<String>>> indexers = new HashMap<>();
    indexers.put(nodeIndex, (Pod pod) -> Arrays.asList(pod.getSpec().getNodeName()));
    indexers.put(clusterIndex, (Pod pod) -> Arrays.asList(pod.getMetadata().getClusterName()));

    podCache.addIndexers(indexers);

    Pod testPod = new PodBuilder()
      .withNewMetadata().withNamespace("test").withName("test-pod").withClusterName("test-cluster").endMetadata()
      .withNewSpec().withNodeName("test-node").endSpec()
      .build();
    podCache.put(testPod);

    List<Pod> namespaceIndexedPods = podCache.byIndex(Cache.NAMESPACE_INDEX, "test");
    assertEquals(1, namespaceIndexedPods.size());

    List<Pod> nodeNameIndexedPods = podCache.byIndex(nodeIndex, "test-node");
    assertEquals(1, nodeNameIndexedPods.size());

    List<Pod> clusterNameIndexedPods = podCache.byIndex(clusterIndex, "test-cluster");
    assertEquals(1, clusterNameIndexedPods.size());
  }
  
  @Test
  void testAlternatives() {
    Cache<Pod> cache = new Cache<Pod>(p -> p.getMetadata().getUid(), false);
    assertTrue(cache.getIndexers().isEmpty());
    
    assertEquals("uid", cache.getKey(new PodBuilder().withNewMetadata().withUid("uid").endMetadata().build()));
  }

  private static List<String> mockIndexFunction(Object obj) {
    if (obj == null) {
      return Arrays.asList("null");
    }
    return Arrays.asList(obj.getClass().getName());
  }

  private static String mockKeyFunction(Object obj)  {
    if (obj == null) {
      return "null";
    }
    return String.valueOf(System.identityHashCode(obj));
  }
}
