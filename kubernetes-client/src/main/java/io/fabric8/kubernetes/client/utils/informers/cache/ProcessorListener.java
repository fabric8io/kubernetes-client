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
package io.fabric8.kubernetes.client.utils.informers.cache;

import io.fabric8.kubernetes.client.utils.informers.ResourceEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ProcessorListener implements Runnable interface. It's supposed to run in background
 * and actually executes its event handler on notification. Note that it allows 1000
 * pending notification at maximum.
 *
 * @param <T>
 */
public class ProcessorListener<T> implements Runnable {
  private static final Logger log = LoggerFactory.getLogger(ProcessorListener.class);

  private static final int DEFAULT_QUEUE_CAPACITY = 1000;

  private long resyncPeriod;
  private ZonedDateTime nextResync;

  private BlockingQueue<Notification> queue;

  private ResourceEventHandler<T> handler;

  public ProcessorListener(ResourceEventHandler<T> handler, long resyncPeriod) {
    this.resyncPeriod = resyncPeriod;
    this.handler = handler;
    this.queue = new ArrayBlockingQueue<>(DEFAULT_QUEUE_CAPACITY);

    determineNextResync(ZonedDateTime.now());
  }

  @Override
  public void run() {
    while (true) {
      try {
        Notification obj = queue.take();
        if (obj instanceof UpdateNotification) {
          UpdateNotification notification = (UpdateNotification) obj;
          this.handler.onUpdate((T) notification.getOldObj(), (T) notification.getNewObj());
        } else if (obj instanceof AddNotification) {
          AddNotification notification = (AddNotification) obj;
          System.out.println(this.handler.getClass().getName() + ".onAdd()");
          this.handler.onAdd((T) notification.getNewObj());
        } else if (obj instanceof DeleteNotification) {
          Object deletedObj = ((DeleteNotification) obj).getOldObj();
          if (deletedObj instanceof  DeltaFIFO.DeletedFinalStateUnknown) {
            this.handler.onDelete(((DeltaFIFO.DeletedFinalStateUnknown<T>) deletedObj).getObj(), true);
          } else {
            this.handler.onDelete((T) deletedObj, false);
          }
        } else {
          throw new RuntimeException("unrecognized notification");
        }
      } catch (InterruptedException e) {
        log.error("processor interrupted: {}", e.getMessage());
        return;
      }
    }
  }

  public void add(Notification<T> obj) {
    if (obj == null) {
      return;
    }
    this.queue.add(obj);
  }

  public void determineNextResync(ZonedDateTime now) {
    this.nextResync = now.plusSeconds(this.resyncPeriod);
  }

  public boolean shouldResync(ZonedDateTime now) {
    return this.resyncPeriod != 0 && (now.isAfter(this.nextResync) || now.equals(this.nextResync));
  }

  public static class Notification<T> {}

  public static final class UpdateNotification<T> extends Notification<T> {
    private T oldObj;
    private T newObj;

    public UpdateNotification(T oldObj, T newObj) {
      this.oldObj = oldObj;
      this.newObj = newObj;
    }

    T getOldObj() {
      return oldObj;
    }

    T getNewObj() {
      return newObj;
    }
  }

  public static final class AddNotification<T> extends Notification<T> {
    private T newObj;

    public AddNotification(T newObj) {
      this.newObj = newObj;
    }

    T getNewObj() { return newObj; }
  }

  public static final class DeleteNotification<T> extends Notification<T> {
    private T oldObj;

    public DeleteNotification(T oldObj) {
      this.oldObj = oldObj;
    }

    T getOldObj() {
      return oldObj;
    }
  }
}
