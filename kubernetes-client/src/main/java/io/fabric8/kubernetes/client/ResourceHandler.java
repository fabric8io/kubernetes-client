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

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.ListOptions;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;

public interface ResourceHandler<T, V extends VisitableBuilder<T, V>> {

  class Key {
    private final String kind;
    private final String apiVersion;
    private final String repr;

    public Key(String kind, String apiVersion) {
      this.kind = kind;
      this.apiVersion = apiVersion;
      this.repr = String.format("Key[kind=`%s`, apiVersion=`%s`]", this.kind, this.apiVersion);
    }

    public String getKind() {
      return kind;
    }

    public String getApiVersion() {
      return apiVersion;
    }

    @Override
    public String toString() {
      return this.repr;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.kind, this.apiVersion);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }

      if (!(obj instanceof Key)) {
        return false;
      }

      Key other = (Key) obj;

      return this.getKind().equals(other.getKind())
        && this.getApiVersion().equals(other.getApiVersion());
    }
  }

  String getKind();

  String getApiVersion();

  /**
   * Create the specified resource
   * @param client        An instance of the http client.
   * @param config        The client config.
   * @param namespace     The target namespace.
   * @param item          The resource to create.
   * @param dryRun        Enable dry run
   * @return              The created resource.
   */
  T create(OkHttpClient client, Config config, String namespace, T item, boolean dryRun);

  /**
   * Replace the specified resource
   * @param client        An instance of the http client.
   * @param config        The client config.
   * @param namespace     The target namespace.
   * @param item          The resource to replace.
   * @param dryRun        Enable dry run
   * @return              The replaced resource.
   */
  T replace(OkHttpClient client, Config config, String namespace, T item, boolean dryRun);

  /**
   * Reload the specified resource (if exists).
   * @param client        An instance of the http client.
   * @param config        The client config.
   * @param namespace     The target namespace.
   * @param item          The resource to reload.
   * @return              The reloaded resource.
   */
  T reload(OkHttpClient client, Config config, String namespace, T item);

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
  Boolean delete(OkHttpClient client, Config config, String namespace, DeletionPropagation propagationPolicy, long gracePeriodSeconds, T item, boolean dryRun);


    /**
     * Watches the specified resource for changes.
     * @param client        An instance of the http client.
     * @param config        The client config.
     * @param namespace     The target namespace.
     * @param item          The resource to delete.
     * @param watcher       The {@link Watcher} to use.
     * @return              The {@link Watch}
     */
  Watch watch(OkHttpClient client, Config config, String namespace, T item, Watcher<T> watcher);


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
  Watch watch(OkHttpClient client, Config config, String namespace, T item, String resourceVersion, Watcher<T> watcher);

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
  Watch watch(OkHttpClient client, Config config, String namespace, T item, ListOptions listOptions, Watcher<T> watcher);

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
   * @throws              InterruptedException Interrupted Exception
   */
  T waitUntilReady(OkHttpClient client, Config config, String namespace, T item, long amount, TimeUnit timeUnit) throws InterruptedException;

  T waitUntilCondition(OkHttpClient client, Config config, String namespace, T item, Predicate<T> condition, long amount, TimeUnit timeUnit) throws InterruptedException;
}
