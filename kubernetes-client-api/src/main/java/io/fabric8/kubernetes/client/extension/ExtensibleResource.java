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

package io.fabric8.kubernetes.client.extension;

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Nameable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.TimeoutableScalable;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Provides an interface that is usable by the {@link ExtensibleResourceAdapter} that returns
 * a non-specialized value
 */
public interface ExtensibleResource<T> extends Resource<T>, TimeoutableScalable<T> {

  @Override
  ExtensibleResource<T> lockResourceVersion(String resourceVersion);

  @Override
  ExtensibleResource<T> dryRun(boolean isDryRun);

  @Override
  ExtensibleResource<T> withResourceVersion(String resourceVersion);

  @Override
  ExtensibleResource<T> fromServer();

  @Override
  ExtensibleResource<T> withGracePeriod(long gracePeriodSeconds);

  @Override
  ExtensibleResource<T> withPropagationPolicy(DeletionPropagation propagationPolicy);

  @Override
  ExtensibleResource<T> withIndexers(Map<String, Function<T, List<String>>> indexers);

  /**
   * Should be used to obtain a client in the same write context as the given resource
   * - dryRun, DeletionPropagation, etc.
   *
   * @param clazz client type
   * @return the client in the write context
   */
  <C extends Client> C inWriteContext(Class<C> clazz);

  @Override
  ExtensibleResource<T> withLimit(Long limit);

  @Override
  ExtensibleResource<T> lockResourceVersion();

  /**
   * Return the current item, which may be null if the resource was created
   * using {@link Nameable#withName(String)}
   *
   * @return the item
   */
  T getItem();

  @Override
  ExtensibleResource<T> fieldValidation(Validation fieldValidation);

  @Override
  ExtensibleResource<T> fieldManager(String manager);

  @Override
  ExtensibleResource<T> forceConflicts();

  @Override
  ExtensibleResource<T> withTimeout(long timeout, TimeUnit unit);

  @Override
  default ExtensibleResource<T> withTimeoutInMillis(long timeoutInMillis) {
    return withTimeout(timeoutInMillis, TimeUnit.MILLISECONDS);
  }

  @Override
  default T scale(int count) {
    throw new KubernetesClientException("not implemented");
  }

}
