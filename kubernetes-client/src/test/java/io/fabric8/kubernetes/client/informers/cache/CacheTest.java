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
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CacheTest {
  private static Cache cache = new Cache("mock", CacheTest::mockIndexFunction, CacheTest::mockKeyFunction);

  @Test
  public void testCacheIndex() {
    Pod testPodObj = new PodBuilder().withNewMetadata().withName("test-pod").endMetadata().build();

    cache.add(testPodObj);
    cache.replace(Arrays.asList(testPodObj), "0");

    String index = mockIndexFunction(testPodObj).get(0);
    String key = mockKeyFunction(testPodObj);

    List indexedObjectList = cache.byIndex("mock", index);
    assertEquals(testPodObj, indexedObjectList.get(0));

    indexedObjectList = cache.index("mock", testPodObj);
    assertEquals(testPodObj, indexedObjectList.get(0));

    List<String> allExistingKeys = cache.listKeys();
    assertEquals(1, allExistingKeys.size());
    assertEquals(key, allExistingKeys.get(0));
  }

  @Test
  public void testCacheStore() {
    Pod testPodObj = new PodBuilder().withNewMetadata().withName("test-pod2").endMetadata().build();
    String index = mockIndexFunction(testPodObj).get(0);

    cache.replace(Arrays.asList(testPodObj), "0");
    cache.delete(testPodObj);

    List indexedObjectList = cache.byIndex("mock", index);
    assertEquals(0, indexedObjectList.size());

    cache.add(testPodObj);

    // replace cached object with null value
    String newClusterName = "test_cluster";
    testPodObj.getMetadata().setClusterName(newClusterName);
    cache.update(testPodObj);

    assertEquals(1, cache.list().size());
    assertEquals(newClusterName, testPodObj.getMetadata().getClusterName());
  }

  @Test
  public void testDefaultNamespaceIndex() {
    Pod testPodObj = new PodBuilder().withNewMetadata().withName("test-pod3").withNamespace("default").endMetadata().build();

    cache.add(testPodObj);
    List<String> indices = Cache.metaNamespaceIndexFunc(testPodObj);
    assertEquals(testPodObj.getMetadata().getNamespace(), indices.get(0));
  }

  @Test
  public void testDefaultNamespaceKey() {
    Pod testPodObj = new PodBuilder().withNewMetadata().withName("test-pod4").withNamespace("default").endMetadata().build();

    cache.add(testPodObj);
    assertEquals("default/test-pod4", Cache.metaNamespaceKeyFunc(testPodObj));
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
