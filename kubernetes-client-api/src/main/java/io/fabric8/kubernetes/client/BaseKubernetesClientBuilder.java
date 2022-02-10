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
import io.fabric8.kubernetes.client.utils.Serialization;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class BaseKubernetesClientBuilder<T extends BaseKubernetesClientBuilder<T>> {

  private Config config;
  private HttpClient.Factory factory;
  private Class<KubernetesClient> clazz;

  protected BaseKubernetesClientBuilder(String className) {
    try {
      this.clazz = (Class<KubernetesClient>) Class.forName(className);
    } catch (ClassNotFoundException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public KubernetesClient build() {
    if (config == null) {
      config = new ConfigBuilder().build();
    }
    try {
      if (factory == null) {
        return clazz.getConstructor(Config.class).newInstance(config);
      }
      HttpClient client = factory.createHttpClient(config);
      return clazz.getConstructor(HttpClient.class, Config.class).newInstance(client, config);
    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
        | NoSuchMethodException | SecurityException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public BaseKubernetesClientBuilder<T> withConfig(Config config) {
    this.config = config;
    return this;
  }

  public BaseKubernetesClientBuilder<T> withConfig(String config) {
    this.config = Serialization.unmarshal(config);
    return this;
  }

  public BaseKubernetesClientBuilder<T> withConfig(InputStream config) {
    this.config = Serialization.unmarshal(config);
    return this;
  }

  public BaseKubernetesClientBuilder<T> withHttpClientFactory(HttpClient.Factory factory) {
    this.factory = factory;
    return this;
  }

}
