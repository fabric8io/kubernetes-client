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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;

import java.net.HttpURLConnection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteAndCreateHelper<T extends HasMetadata> {
  private static final Logger LOG = LoggerFactory.getLogger(DeleteAndCreateHelper.class);
  private static final int MAX_WAIT_SECONDS = 30;
  
  private final UnaryOperator<T> createTask;
  private final Function<T, Boolean> awaitDeleteTask;
  private final Function<T, Boolean> deleteTask;

  public DeleteAndCreateHelper(UnaryOperator<T> createTask, Function<T, Boolean> deleteTask, Function<T, Boolean> awaitDeleteTask) {
    this.createTask = createTask;
    this.awaitDeleteTask = awaitDeleteTask;
    this.deleteTask = deleteTask;
  }

  public T deleteAndCreate(T item) {
    Boolean deleted = deleteTask.apply(item);
    if (!deleted) {
      LOG.debug("did not delete because item did not exist, continuing to create {}", item.getMetadata().getName());
    }

    try {
      return createTask.apply(item);
    } catch (KubernetesClientException e) {
      // depending on the grace period, the object might not actually be deleted by the time we try to create
      // if that's the case, give it some time.
      if (e.getCode() == HttpURLConnection.HTTP_CONFLICT) {
        if (!deleted) {
          LOG.error("there was no item to delete, but received HTTP_CONFLICT response upon creation of item {}", item.getMetadata().getName(), e);
          throw e;
        }

        if (Boolean.FALSE.equals(awaitDeleteTask.apply(item))) {
          throw new KubernetesClientException("Timed out waiting for item to be deleted before recreating: " + item.getMetadata().getName(), e);
        }

        return createTask.apply(item);
      }

      throw e;
    }
  }

  public static HasMetadata deleteAndCreateItem(HasMetadata meta, Resource<HasMetadata> resource) {
    DeleteAndCreateHelper<HasMetadata> deleteAndCreateHelper = new DeleteAndCreateHelper<>(
      m -> resource.create(m),
      m -> resource.delete(),
      waitUntilDeletedOrInterrupted(resource)
    );

    return deleteAndCreateHelper.deleteAndCreate(meta);
  }

  private static <T extends HasMetadata> Function<T, Boolean> waitUntilDeletedOrInterrupted(Resource<HasMetadata> resource) {
    return m -> resource.waitUntilCondition(Objects::isNull, MAX_WAIT_SECONDS , TimeUnit.SECONDS) == null;
  }
}
