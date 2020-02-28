/**
 * Copyright (C) 2015 Fabric8 Authors.
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

import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ProcessorListener implements Runnable interface. It's supposed to run in background
 * and actually executes its event handler on notification. Note that it allows 1000
 * pending notification at maximum.
 *
 * This has been taken from official client: https://github.com/kubernetes-client/java/blob/master/util/src/main/java/io/kubernetes/client/informer/cache/ProcessorListener.java
 * which has been ported from official go client: https://github.com/kubernetes/client-go/blob/master/tools/cache/shared_informer.go#L570
 *
 * @param <T> type of ProcessorListener
 */
public class ProcessorListener<T> implements Runnable {
  private static final Logger log = LoggerFactory.getLogger(ProcessorListener.class);
  private long resyncPeriodInMillis;
  private ZonedDateTime nextResync;
  private BlockingQueue<Notification> queue;
  private ResourceEventHandler<T> handler;

  public ProcessorListener(ResourceEventHandler<T> handler, long resyncPeriodInMillis) {
    this.resyncPeriodInMillis = resyncPeriodInMillis;
    this.handler = handler;
    this.queue = new LinkedBlockingQueue<>();

    determineNextResync(ZonedDateTime.now());
  }

  @Override
  public void run() {
    while (true) {
      Boolean isValidNotification = Boolean.FALSE;
      String operationType = "";
      try {
        Notification obj = queue.take();
        if (obj instanceof UpdateNotification) {
          isValidNotification = Boolean.TRUE;
          operationType = "UPDATE";
          UpdateNotification notification = (UpdateNotification) obj;
          this.handler.onUpdate((T) notification.getOldObj(), (T) notification.getNewObj());
        } else if (obj instanceof AddNotification) {
          isValidNotification = Boolean.TRUE;
          operationType = "ADD";
          AddNotification notification = (AddNotification) obj;
          this.handler.onAdd((T) notification.getNewObj());
        } else if (obj instanceof DeleteNotification) {
          isValidNotification = Boolean.TRUE;
          operationType = "DELETE";
          Object deletedObj = ((DeleteNotification) obj).getOldObj();
          if (deletedObj instanceof  DeltaFIFO.DeletedFinalStateUnknown) {
            this.handler.onDelete(((DeltaFIFO.DeletedFinalStateUnknown<T>) deletedObj).getObj(), true);
          } else {
            this.handler.onDelete((T) deletedObj, false);
          }
        }
      } catch (InterruptedException e) {
        log.error("processor interrupted: {}", e.getMessage());
        return;
      } catch (Throwable t) {
        log.error("Failed invoking " + operationType + " event handler: {}", t.getMessage());
      }

      if (Boolean.FALSE.equals(isValidNotification)) {
        throw new RuntimeException("Unrecognized notification.");
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
    this.nextResync = now.plus(this.resyncPeriodInMillis, ChronoUnit.MILLIS);
  }

  public boolean shouldResync(ZonedDateTime now) {
    return this.resyncPeriodInMillis != 0 && (now.isAfter(this.nextResync) || now.equals(this.nextResync));
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
