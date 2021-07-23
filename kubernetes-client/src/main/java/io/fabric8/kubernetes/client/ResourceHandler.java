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

package io.fabric8.kubernetes.client;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;

public interface ResourceHandler<T extends HasMetadata, V extends VisitableBuilder<T, V>> {

  /**
   * Create the specified resource
   * @param client        An instance of the http client.
   * @param config        The client config.
   * @param namespace     The target namespace.
   * @param item          The resource to create.
   * @param dryRun        Enable dry run
   * @return              The created resource.
   */
  default T create(OkHttpClient client, Config config, String namespace, T item, boolean dryRun) {
    return resource(client, config, namespace, item).dryRun(dryRun).create(item);
  }

  /**
   * Replace the specified resource
   * @param client        An instance of the http client.
   * @param config        The client config.
   * @param namespace     The target namespace.
   * @param item          The resource to replace.
   * @param dryRun        Enable dry run
   * @return              The replaced resource.
   */
  default T replace(OkHttpClient client, Config config, String namespace, T item, boolean dryRun) {
    return resource(client, config, namespace, item).dryRun(dryRun).replace(item);
  }

  /**
   * Reload the specified resource (if exists).
   * @param client        An instance of the http client.
   * @param config        The client config.
   * @param namespace     The target namespace.
   * @param item          The resource to reload.
   * @return              The reloaded resource.
   */
  default T reload(OkHttpClient client, Config config, String namespace, T item) {
    return resource(client, config, namespace, item).fromServer().get();
  }

  /**
   * Edit the specified resource.
   * @param item          The resource to edit.
   * @return              The resource editor.
   */
  V edit(T item);

  /**
   * Delete the specified resource (if exists).
   * @param client        An instance of the http client.
   * @param config        The client config.
   * @param namespace     The target namespace.
   * @param propagationPolicy  Whether and how garbage collection will be performed.
   * @param gracePeriodSeconds The duration in seconds before the object should be deleted.
   * @param item          The resource to delete.
   * @param dryRun        enable dry run
   * @return              The true if the resource was successfully deleted.
   */
  default Boolean delete(OkHttpClient client, Config config, String namespace, DeletionPropagation propagationPolicy, long gracePeriodSeconds, T item, boolean dryRun) {
    return resource(client, config, namespace, item).dryRun(dryRun).withPropagationPolicy(propagationPolicy).withGracePeriod(gracePeriodSeconds).delete();
  }


    /**
     * Watches the specified resource for changes.
     * @param client        An instance of the http client.
     * @param config        The client config.
     * @param namespace     The target namespace.
     * @param item          The resource to delete.
     * @param watcher       The {@link Watcher} to use.
     * @return              The {@link Watch}
     */
  default Watch watch(OkHttpClient client, Config config, String namespace, T item, Watcher<T> watcher) {
    return resource(client, config, namespace, item).watch(watcher);
  }

  /**
   * Watches the specified resource for changes.
   * @param client          An instance of the http client.
   * @param config          The client config.
   * @param namespace       The target namespace.
   * @param item            The resource to delete.
   * @param resourceVersion The resourceVersion of object
   * @param watcher         The {@link Watcher} to use.
   * @return                The {@link Watch}
   */
  default Watch watch(OkHttpClient client, Config config, String namespace, T item, String resourceVersion, Watcher<T> watcher) {
    return resource(client, config, namespace, item).watch(resourceVersion, watcher);
  }

  /**
   * Watches the specified resource for changes
   *
   * @param client         An instance of http client.
   * @param config         The client config.
   * @param namespace      The target namespace.
   * @param item           The resource to delete.
   * @param listOptions    The {@link io.fabric8.kubernetes.api.model.ListOptions} for available options
   * @param watcher        The {@link Watcher} to use.
   * @return               The {@link Watch}
   */
  default Watch watch(OkHttpClient client, Config config, String namespace, T item, ListOptions listOptions, Watcher<T> watcher) {
    return resource(client, config, namespace, item).watch(listOptions, watcher);
  }

  /**
   * Waits until the specified resource is Ready.
   * For resources that 'readiness' is not applicable the method is equivalent to get.
   * @param client        An instance of the http client.
   * @param config        The client config.
   * @param namespace     The target namespace.
   * @param item          The resource to wait.
   * @param amount        The amount of time to wait
   * @param timeUnit      The wait {@link TimeUnit}.
   * @return              The true if the resource was successfully deleted.
   */
  default T waitUntilReady(OkHttpClient client, Config config, String namespace, T item, long amount, TimeUnit timeUnit) {
    return resource(client, config, namespace, item).waitUntilReady(amount, timeUnit);
  }

  /**
   * Waits until the specified condition is true.
   * @param client        An instance of the http client.
   * @param config        The client config.
   * @param namespace     The target namespace.
   * @param item          The resource to wait.
   * @param amount        The amount of time to wait
   * @param timeUnit      The wait {@link TimeUnit}.
   * @param condition     The condition to wait for
   * @return              The true if the resource was successfully deleted.
   */
  default T waitUntilCondition(OkHttpClient client, Config config, String namespace, T item, Predicate<T> condition, long amount, TimeUnit timeUnit) {
    return resource(client, config, namespace, item).waitUntilCondition(condition, amount, timeUnit);
  }

  /**
   * Gets the Resource for the given item
   * @param client        An instance of the http client.
   * @param config        The client config.
   * @param namespace     The target namespace.
   * @param item          The resource to wait.
   * @return              The true if the resource was successfully deleted.
   */
  Resource<T> resource(OkHttpClient client, Config config, String namespace, T item);
  
  /**
   * Create the operation support for the current resource
   * @param client        An instance of the http client.
   * @param config        The client config.
   * @param listType      The list type
   * @return              The {@link HasMetadataOperation}
   */
  <L extends KubernetesResourceList<T>> HasMetadataOperation<T, L, Resource<T>> operation(OkHttpClient client, Config config, Class<L> listType);

  /**
   * @return true if there is a specialized operation associated with this handler
   */
  boolean hasOperation();

}
