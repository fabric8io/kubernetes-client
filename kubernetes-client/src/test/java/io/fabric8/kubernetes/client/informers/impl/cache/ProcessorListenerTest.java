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
package io.fabric8.kubernetes.client.informers.impl.cache;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessorListenerTest {

  private boolean addNotificationReceived, updateNotificationReceived, deleteNotificationReceived;

  @Test
  void testNotificationHandling() {
    Pod pod = new PodBuilder().withNewMetadata().withName("foo").withNamespace("default").endMetadata().build();

    ProcessorListener<Pod> listener = new ProcessorListener<>(
        new ResourceEventHandler<Pod>() {
          @Override
          public void onAdd(Pod obj) {
            assertEquals(pod, obj);
            addNotificationReceived = true;
          }

          @Override
          public void onUpdate(Pod oldObj, Pod newObj) {
            assertEquals(pod, newObj);
            updateNotificationReceived = true;
          }

          @Override
          public void onDelete(Pod obj, boolean deletedFinalStateUnknown) {
            assertEquals(pod, obj);
            deleteNotificationReceived = true;
          }
        }, 0);

    listener.add(new ProcessorListener.AddNotification<>(pod));
    listener.add(new ProcessorListener.UpdateNotification<>(null, pod));
    listener.add(new ProcessorListener.DeleteNotification<>(pod));

    assertTrue(addNotificationReceived);
    assertTrue(updateNotificationReceived);
    assertTrue(deleteNotificationReceived);

  }
}
