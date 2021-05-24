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

/**
 * ProcessorListener implements Runnable interface. It's supposed to run in background
 * and actually executes its event handler on notification. 
 *
 * This has been taken from official client: https://github.com/kubernetes-client/java/blob/master/util/src/main/java/io/kubernetes/client/informer/cache/ProcessorListener.java
 * which has been ported from official go client: https://github.com/kubernetes/client-go/blob/master/tools/cache/shared_informer.go#L570
 * 
 * <br>Modified to execute loosely coupled from its processing thread
 *
 * @param <T> type of ProcessorListener
 */
public class ProcessorListener<T> {
  private static final Logger log = LoggerFactory.getLogger(ProcessorListener.class);
  private ResourceEventHandler<T> handler;
  
  public ProcessorListener(ResourceEventHandler<T> handler) {
    this.handler = handler;
  }

  public void add(Notification<T> notification) {
    try {
      notification.handle(handler);
    } catch (Exception ex) {
      log.error("Failed invoking {} event handler: {}", handler, ex.getMessage(), ex);
    }
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
      
    private boolean unknownFinalState;
    
    public DeleteNotification(T oldObject) {
        this(oldObject, false);
    }
    
    public DeleteNotification(T oldObject, boolean unknownFinalState) {
      super(oldObject, null);
      this.unknownFinalState = unknownFinalState;
    }

    @Override
    public void handle(ResourceEventHandler<T> resourceEventHandler) {
      resourceEventHandler.onDelete(getOldObject(), unknownFinalState);
    }
  }
}
