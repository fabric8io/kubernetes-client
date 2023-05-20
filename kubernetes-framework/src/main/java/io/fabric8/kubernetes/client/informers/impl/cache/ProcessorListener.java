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

import io.fabric8.kubernetes.client.informers.ResourceEventHandler;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * ProcessorListener implements Runnable interface. It's supposed to run in background
 * and actually executes its event handler on notification.
 *
 * This has been taken from official client:
 * https://github.com/kubernetes-client/java/blob/master/util/src/main/java/io/kubernetes/client/informer/cache/ProcessorListener.java
 * which has been ported from official go client:
 * https://github.com/kubernetes/client-go/blob/master/tools/cache/shared_informer.go#L570
 *
 * <br>
 * Modified to execute loosely coupled from its processing thread
 *
 * @param <T> type of ProcessorListener
 */
public class ProcessorListener<T> {
  private long resyncPeriodInMillis;
  private ZonedDateTime nextResync;
  private ResourceEventHandler<? super T> handler;

  public ProcessorListener(ResourceEventHandler<? super T> handler, long resyncPeriodInMillis) {
    this.resyncPeriodInMillis = resyncPeriodInMillis;
    this.handler = handler;

    determineNextResync(ZonedDateTime.now());
  }

  public void add(Notification<T> notification) {
    notification.handle(handler);
  }

  public void determineNextResync(ZonedDateTime now) {
    this.nextResync = now.plus(this.resyncPeriodInMillis, ChronoUnit.MILLIS);
  }

  public boolean isReSync() {
    return resyncPeriodInMillis != 0;
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

    public abstract void handle(ResourceEventHandler<? super T> resourceEventHandler);
  }

  public static final class UpdateNotification<T> extends Notification<T> {
    public UpdateNotification(T oldObject, T newObject) {
      super(oldObject, newObject);
    }

    @Override
    public void handle(ResourceEventHandler<? super T> resourceEventHandler) {
      resourceEventHandler.onUpdate(getOldObject(), getNewObject());
    }
  }

  public static final class AddNotification<T> extends Notification<T> {
    public AddNotification(T newObject) {
      super(null, newObject);
    }

    @Override
    public void handle(ResourceEventHandler<? super T> resourceEventHandler) {
      resourceEventHandler.onAdd(getNewObject());
    }
  }

  public static final class DeleteNotification<T> extends Notification<T> {

    private boolean unknownFinalState;

    public DeleteNotification(T oldObject) {
      this(oldObject, false);
    }

    public DeleteNotification(T oldObject, boolean unknownFinalState) {
      super(oldObject, null);
      this.unknownFinalState = unknownFinalState;
    }

    @Override
    public void handle(ResourceEventHandler<? super T> resourceEventHandler) {
      resourceEventHandler.onDelete(getOldObject(), unknownFinalState);
    }
  }

  public ResourceEventHandler<? super T> getHandler() {
    return handler;
  }

}
