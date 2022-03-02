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

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * To be used as a base for overriding or adding Resource methods
 *
 * @param <T> the resource type
 */
public class ExtensibleResourceAdapter<T> extends ResourceAdapter<T> implements ExtensibleResource<T> {

  protected ExtensibleResource<T> resource;
  protected Client client;

  public ExtensibleResourceAdapter() {

  }

  public ExtensibleResourceAdapter(ExtensibleResource<T> resource, Client client) {
    init(resource, client);
  }

  public void init(ExtensibleResource<T> resource, Client client) {
    super.resource = resource;
    this.resource = resource;
    this.client = client;
  }

  @Override
  public ExtensibleResource<T> lockResourceVersion(String resourceVersion) {
    return new ExtensibleResourceAdapter<>(resource.lockResourceVersion(resourceVersion), client);
  }

  @Override
  public ExtensibleResource<T> cascading(boolean enabled) {
    return new ExtensibleResourceAdapter<>(resource.cascading(enabled), client);
  }

  @Override
  public ExtensibleResource<T> withResourceVersion(String resourceVersion) {
    return new ExtensibleResourceAdapter<>(resource.withResourceVersion(resourceVersion), client);
  }

  @Override
  public ExtensibleResource<T> fromServer() {
    return new ExtensibleResourceAdapter<>(resource.fromServer(), client);
  }

  @Override
  public ExtensibleResource<T> withGracePeriod(long gracePeriodSeconds) {
    return new ExtensibleResourceAdapter<>(resource.withGracePeriod(gracePeriodSeconds), client);
  }

  @Override
  public ExtensibleResource<T> withPropagationPolicy(DeletionPropagation propagationPolicy) {
    return new ExtensibleResourceAdapter<>(resource.withPropagationPolicy(propagationPolicy), client);
  }

  @Override
  public ExtensibleResource<T> withWaitRetryBackoff(long initialBackoff, TimeUnit backoffUnit, double backoffMultiplier) {
    return new ExtensibleResourceAdapter<>(resource.withWaitRetryBackoff(initialBackoff, backoffUnit, backoffMultiplier), client);
  }

  @Override
  public ExtensibleResource<T> withIndexers(Map<String, Function<T, List<String>>> indexers) {
    return new ExtensibleResourceAdapter<>(resource.withIndexers(indexers), client);
  }

  @Override
  public ExtensibleResource<T> dryRun(boolean isDryRun) {
    return new ExtensibleResourceAdapter<>(resource.dryRun(isDryRun), client);
  }

  @Override
  public ExtensibleResource<T> withLimit(Long limit) {
    return new ExtensibleResourceAdapter<>(resource.withLimit(limit), client);
  }

}
