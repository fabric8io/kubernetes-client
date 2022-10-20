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

class SharedProcessorTest {
  @Test
  void testListenerAddition() {
    SharedProcessor<Pod> sharedProcessor = new SharedProcessor<>();

    Pod foo1 = new PodBuilder().withNewMetadata().withName("foo1").withNamespace("default").endMetadata().build();
    ProcessorListener.Notification<Pod> addNotification = new ProcessorListener.AddNotification<>(foo1);
    ProcessorListener.Notification<Pod> updateNotification = new ProcessorListener.UpdateNotification<>(null, foo1);
    ProcessorListener.Notification<Pod> deleteNotification = new ProcessorListener.DeleteNotification<>(foo1);

    ExpectingNotificationHandler<Pod> expectAddHandler = new ExpectingNotificationHandler<>(addNotification);
    ExpectingNotificationHandler<Pod> expectUpdateHandler = new ExpectingNotificationHandler<>(updateNotification);
    ExpectingNotificationHandler<Pod> expectDeleteHandler = new ExpectingNotificationHandler<>(deleteNotification);

    sharedProcessor.addListener(expectAddHandler);
    sharedProcessor.addListener(expectUpdateHandler);
    sharedProcessor.addListener(expectDeleteHandler);

    sharedProcessor.distribute(addNotification, false);
    sharedProcessor.distribute(updateNotification, false);
    sharedProcessor.distribute(deleteNotification, false);

    assertTrue(expectAddHandler.isSatisfied());
    assertTrue(expectUpdateHandler.isSatisfied());
    assertTrue(expectDeleteHandler.isSatisfied());
  }

  @Test
  void testDistributeAfterStop() {
    SharedProcessor<Pod> sharedProcessor = new SharedProcessor<>();

    sharedProcessor.stop();

    Pod foo1 = new PodBuilder().withNewMetadata().withName("foo1").withNamespace("default").endMetadata().build();
    ProcessorListener.Notification<Pod> addNotification = new ProcessorListener.AddNotification<>(foo1);

    // nothing should happen
    sharedProcessor.distribute(addNotification, false);
  }

  private static class ExpectingNotificationHandler<T> extends ProcessorListener<T> {
    ExpectingNotificationHandler(Notification<T> notification) {
      this(new ResourceEventHandler<T>() {
        @Override
        public void onAdd(T obj) {
        }

        @Override
        public void onUpdate(T oldObj, T newObj) {
        }

        @Override
        public void onDelete(T obj, boolean deletedFinalStateUnknown) {
        }
      }, 0);
      this.expectingNotification = notification;
    }

    ExpectingNotificationHandler(ResourceEventHandler<T> handler, long resyncPeriod) {
      super(handler, resyncPeriod);
    }

    private ProcessorListener.Notification<T> expectingNotification;

    private boolean satisfied;

    @Override
    public void add(Notification<T> obj) {
      super.add(obj);
      if (!satisfied) {
        satisfied = obj.equals(expectingNotification);
      }
    }

    boolean isSatisfied() {
      return satisfied;
    }
  }
}
