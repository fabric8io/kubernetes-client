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
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;

public interface ResourceHandler<T, V extends VisitableBuilder<T, V>> {

  String getKind();

  /**
   * Create the specified resource.
   * @param client        An instance of the http client.
   * @param config        The client config.
   * @param namespace     The target namespace.
   * @param item          The resource to create.
   * @return              The created resource.
   */
  T create(OkHttpClient client, Config config, String namespace, T item);

  /**
   * Replace the specified resource.
   * @param client        An instance of the http client.
   * @param config        The client config.
   * @param namespace     The target namespace.
   * @param item          The resource to replace.
   * @return              The created resource.
   */
  T replace(OkHttpClient client, Config config, String namespace, T item);

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
   * @param item          The resource to delete.
   * @return              The true if the resource was successfully deleted.
   */
  Boolean delete(OkHttpClient client, Config config, String namespace, T item);


    /**
     * Watches the specified resource for changes.
     * @param client        An instance of the http client.
     * @param config        The client config.
     * @param namespace     The target namespace.
     * @param item          The resource to delete.
     * @param watcher       The {@link Watcher} to use.
     * @return              The true if the resource was successfully deleted.
     */
  Watch watch(OkHttpClient client, Config config, String namespace, T item, Watcher<T> watcher);


  /**
   * Watches the specified resource for changes.
   * @param client        An instance of the http client.
   * @param config        The client config.
   * @param namespace     The target namespace.
   * @param item          The resource to delete.
   * @param watcher       The {@link Watcher} to use.
   * @return              The true if the resource was successfully deleted.
   */
  Watch watch(OkHttpClient client, Config config, String namespace, T item, String resourceVersion, Watcher<T> watcher);

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
   * @throws              InterruptedException
   */
  T waitUntilReady(OkHttpClient client, Config config, String namespace, T item, long amount, TimeUnit timeUnit) throws InterruptedException;
}
