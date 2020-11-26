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

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.HasMetadataVisitiableBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.ResourceHandler;
import okhttp3.OkHttpClient;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DeleteAndCreateHelper<T extends HasMetadata> {
  private final UnaryOperator<T> createTask;
  private final Function<T, Boolean> deleteTask;

  public DeleteAndCreateHelper(UnaryOperator<T> createTask, Function<T, Boolean> deleteTask) {
    this.createTask = createTask;
    this.deleteTask = deleteTask;
  }

  public T deleteAndCreate(T item) {
    Boolean deleted = deleteTask.apply(item);
    if (Boolean.FALSE.equals(deleted)) {
      throw new KubernetesClientException("Failed to delete existing item:" + item.getMetadata().getName());
    }
    return createTask.apply(item);
  }

  public static HasMetadata deleteAndCreateItem(OkHttpClient client, Config config, HasMetadata meta, ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h, String namespaceToUse, DeletionPropagation propagationPolicy) {
    DeleteAndCreateHelper<HasMetadata> deleteAndCreateHelper = new DeleteAndCreateHelper<>(
      m -> h.create(client, config, namespaceToUse, m),
      m -> h.delete(client, config, namespaceToUse, propagationPolicy, m)
    );

    return deleteAndCreateHelper.deleteAndCreate(meta);
  }
}
