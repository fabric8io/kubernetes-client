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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListerTest {
  @Test
  void testListerBasic() {
    CacheImpl<Pod> podCache = new CacheImpl<>();

    Lister<Pod> namespacedPodLister = new Lister<>(podCache, "default");
    List<Pod> emptyPodList = namespacedPodLister.list();
    assertEquals(0, emptyPodList.size());

    podCache.replace(
      Arrays.asList(
        new PodBuilder().withNewMetadata().withName("foo1").withNamespace("default").endMetadata().build(),
        new PodBuilder().withNewMetadata().withName("foo2").withNamespace("default").endMetadata().build(),
        new PodBuilder().withNewMetadata().withName("foo3").withNamespace("default").endMetadata().build()
      ));

    List<Pod> namespacedPodList = namespacedPodLister.list();
    assertEquals(3, namespacedPodList.size());

    Lister<Pod> allNamespacedPodLister = new Lister<>(podCache);
    List<Pod> allPodList = allNamespacedPodLister.list();
    assertEquals(3, allPodList.size());

    namespacedPodList = allNamespacedPodLister.namespace("default").list();
    assertEquals(3, namespacedPodList.size());
  }
}
