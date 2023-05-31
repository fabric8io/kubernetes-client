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
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ReducedStateItemStoreTest {

  @Test
  void testStoreRestore() {
    ReducedStateItemStore<Pod> store = new ReducedStateItemStore<>(ReducedStateItemStore.UID_KEY_STATE,
        Pod.class, new KubernetesSerialization(), "metadata.labels", "foo.bar");

    Pod pod = new PodBuilder().withNewSpec().endSpec().withNewMetadata().withUid("x").withName("y").addToLabels("one", "1")
        .addToLabels("two", "2").withResourceVersion("2").endMetadata().withNewStatus().endStatus().build();

    Object[] values = store.store(pod);

    assertEquals(3, values.length);
    assertEquals("2", values[0]); // always the resourceVersion
    assertEquals(pod.getMetadata().getLabels(), values[1]);
    assertNull(values[2]);

    Pod restored = store.restore("x", values);

    assertNull(restored.getSpec());
    assertNull(restored.getStatus());
    assertEquals("x", restored.getMetadata().getUid());
    assertEquals(pod.getMetadata().getLabels(), restored.getMetadata().getLabels());

    assertNull(store.put("x", pod));
    assertNotNull(store.get("x"));
    assertEquals("2", store.getResourceVersion("x"));
    assertEquals(1, store.size());
    assertNotNull(store.remove("x"));
  }

}
