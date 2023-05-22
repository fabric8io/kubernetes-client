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
package io.fabric8.kubernetes.client.utils.internal;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;

import java.net.HttpURLConnection;
import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class CreateOrReplaceHelper<T extends HasMetadata> {
  public static final int CREATE_OR_REPLACE_RETRIES = 3;
  private final UnaryOperator<T> createTask;
  private final UnaryOperator<T> replaceTask;
  private final UnaryOperator<T> waitTask;
  private final UnaryOperator<T> reloadTask;
  private final KubernetesSerialization serialization;

  public CreateOrReplaceHelper(UnaryOperator<T> createTask, UnaryOperator<T> replaceTask, UnaryOperator<T> waitTask,
      UnaryOperator<T> reloadTask, KubernetesSerialization serialization) {
    this.createTask = createTask;
    this.replaceTask = replaceTask;
    this.waitTask = waitTask;
    this.reloadTask = reloadTask;
    this.serialization = serialization;
  }

  public T createOrReplace(T item) {
    String resourceVersion = KubernetesResourceUtil.getResourceVersion(item);
    final CompletableFuture<T> future = new CompletableFuture<>();
    int nTries = 0;
    item = serialization.clone(item);
    while (!future.isDone() && nTries < CREATE_OR_REPLACE_RETRIES) {
      try {
        // Create
        KubernetesResourceUtil.setResourceVersion(item, null);
        return createTask.apply(item);
      } catch (KubernetesClientException exception) {
        if (shouldRetry(exception.getCode())) {
          T itemFromServer = reloadTask.apply(item);
          if (itemFromServer == null) {
            waitTask.apply(item);
            nTries++;
            continue;
          }
        } else if (exception.getCode() != HttpURLConnection.HTTP_CONFLICT) {
          throw exception;
        }

        future.complete(replace(item, resourceVersion));
      }
    }
    return future.join();
  }

  private T replace(T item, String resourceVersion) {
    KubernetesResourceUtil.setResourceVersion(item, resourceVersion);
    return replaceTask.apply(item);
  }

  private boolean shouldRetry(int responseCode) {
    return responseCode > 499;
  }
}
