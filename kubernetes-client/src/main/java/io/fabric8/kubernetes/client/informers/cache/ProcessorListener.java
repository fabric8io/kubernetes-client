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

import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
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
  private BlockingQueue<Notification<T>> queue;
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
      try {
        queue.take().handle(handler);
      } catch(InterruptedException ex) {
        log.warn("Processor thread interrupted: {}", ex.getMessage());
        Thread.currentThread().interrupt();
        return;
      } catch (Exception ex) {
        log.error("Failed invoking {} event handler: {}", handler, ex.getMessage(), ex);
      }
    }
  }

  public void add(Notification<T> obj) {
    Optional.ofNullable(obj).ifPresent(this.queue::add);
  }

  public void determineNextResync(ZonedDateTime now) {
    this.nextResync = now.plus(this.resyncPeriodInMillis, ChronoUnit.MILLIS);
  }

  public boolean shouldResync(ZonedDateTime now) {
    return this.resyncPeriodInMillis != 0 && (now.isAfter(this.nextResync) || now.equals(this.nextResync));
  }

  public abstract static class Notification<T> {
    private final T oldObject;
    private final T newObject;

    public Notification(T oldObject, T newObject) {
      this.oldObject = oldObject;
      this.newObject = newObject;
    }

    public T getOldObject() {
      return oldObject;
    }

    public T getNewObject() {
      return newObject;
    }

    public abstract void handle(ResourceEventHandler<T> resourceEventHandler);
  }

  public static final class UpdateNotification<T> extends Notification<T> {
    public UpdateNotification(T oldObject, T newObject) {
      super(oldObject, newObject);
    }

    @Override
    public void handle(ResourceEventHandler<T> resourceEventHandler) {
      resourceEventHandler.onUpdate(getOldObject(), getNewObject());
    }
  }

  public static final class AddNotification<T> extends Notification<T> {
    public AddNotification(T newObject) {
      super(null, newObject);
    }

    @Override
    public void handle(ResourceEventHandler<T> resourceEventHandler) {
      resourceEventHandler.onAdd(getNewObject());
    }
  }

  public static final class DeleteNotification<T> extends Notification<T> {
    public DeleteNotification(T oldObject) {
      super(oldObject, null);
    }

    @Override
    public void handle(ResourceEventHandler<T> resourceEventHandler) {
      if (getOldObject() instanceof  DeltaFIFO.DeletedFinalStateUnknown) {
        resourceEventHandler.onDelete(((DeltaFIFO.DeletedFinalStateUnknown<T>) getOldObject()).getObj(), true);
      } else {
        resourceEventHandler.onDelete(getOldObject(), false);
      }
    }
  }
}
