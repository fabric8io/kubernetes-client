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

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.Serialization;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * If no {@link Executor} or {@link ExecutorSupplier} is specified, a default {@link ExecutorSupplier} will
 * be used which creates an unbounded cached thread pool per client.
 */
public class KubernetesClientBuilder {

  @FunctionalInterface
  public interface ExecutorSupplier extends Supplier<Executor> {

    default void onClose(Executor executor) {

    }

  }

  private Config config;
  private HttpClient.Factory factory;
  private Class<KubernetesClient> clazz;
  private ExecutorSupplier executorSupplier;
  private Consumer<HttpClient.Builder> builderConsumer;

  public KubernetesClientBuilder() {
    // basically the same logic as in KubernetesResourceUtil for finding list types
    // we're not guarding against a null context class loader
    String className = "io.fabric8.kubernetes.client.impl.KubernetesClientImpl";
    try {
      clazz = (Class<KubernetesClient>) Thread.currentThread().getContextClassLoader().loadClass(className);
    } catch (ClassNotFoundException | ClassCastException e) {
      try {
        clazz = (Class<KubernetesClient>) KubernetesClient.class.getClassLoader().loadClass(className);
      } catch (Exception ex) {
        throw KubernetesClientException.launderThrowable(ex);
      }
    }
  }

  KubernetesClientBuilder(Class<KubernetesClient> clazz) {
    this.clazz = clazz;
  }

  public KubernetesClient build() {
    if (config == null) {
      config = new ConfigBuilder().build();
    }
    try {
      if (factory == null) {
        this.factory = HttpClientUtils.getHttpClientFactory();
      }
      HttpClient client = getHttpClient();
      return clazz.getConstructor(HttpClient.class, Config.class, ExecutorSupplier.class).newInstance(client, config,
          executorSupplier);
    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
        | NoSuchMethodException | SecurityException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  HttpClient getHttpClient() {
    HttpClient.Builder builder = factory.newBuilder(config);
    if (this.builderConsumer != null) {
      this.builderConsumer.accept(builder);
    }
    return builder.build();
  }

  public KubernetesClientBuilder withConfig(Config config) {
    this.config = config;
    return this;
  }

  public KubernetesClientBuilder withConfig(String config) {
    this.config = Serialization.unmarshal(config, Config.class);
    return this;
  }

  public KubernetesClientBuilder withConfig(InputStream config) {
    this.config = Serialization.unmarshal(config, Config.class);
    return this;
  }

  public KubernetesClientBuilder withHttpClientFactory(HttpClient.Factory factory) {
    this.factory = factory;
    return this;
  }

  /**
   * Configure the client to use the given executor for async tasks, such as {@link ResourceEventHandler}
   * calls and writing to streams.
   * <p>
   * Only override if you need more control over the number of task threads used by the kubernetes client.
   *
   * @return this builder
   */
  public KubernetesClientBuilder withTaskExecutor(Executor executor) {
    this.executorSupplier = () -> executor;
    return this;
  }

  /**
   * Configure the client to use the given {@link ExecutorSupplier} for async tasks, such as {@link ResourceEventHandler}
   * calls and writing to streams.
   * <p>
   * There will be a call to {@link ExecutorSupplier#onClose(Executor)} when a client is closed.
   * <p>
   * Only override if you need more control over the number of task threads used by the kubernetes client.
   *
   * @return this builder
   */
  public KubernetesClientBuilder withTaskExecutorSupplier(ExecutorSupplier executorSupplier) {
    this.executorSupplier = executorSupplier;
    return this;
  }

  /**
   * Provide additional configuration for the {@link HttpClient} that is created for this {@link KubernetesClient}.
   *
   * @param consumer to modify the {@link HttpClient.Builder}
   * @return this builder
   */
  public KubernetesClientBuilder withHttpClientBuilderConsumer(Consumer<HttpClient.Builder> consumer) {
    this.builderConsumer = consumer;
    return this;
  }

}
