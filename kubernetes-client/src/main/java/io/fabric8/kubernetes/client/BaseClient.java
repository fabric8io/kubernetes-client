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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.Utils;

import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;


public abstract class BaseClient implements Client, HttpClientAware {

  private static final Logger LOGGER = LoggerFactory.getLogger(BaseClient.class);

  protected OkHttpClient httpClient;
  private URL masterUrl;
  private String apiVersion;
  private String namespace;
  private Config configuration;

  public BaseClient() throws KubernetesClientException {
    this(new ConfigBuilder().build());
  }

  public BaseClient(String masterUrl) throws KubernetesClientException {
    this(new ConfigBuilder().withMasterUrl(masterUrl).build());
  }

  public BaseClient(final Config config) throws KubernetesClientException {
    this(HttpClientUtils.createHttpClient(config), config);
  }

  public BaseClient(final OkHttpClient httpClient, Config config) throws KubernetesClientException {
    try {
      this.httpClient = httpClient;
      this.namespace = config.getNamespace();
      this.configuration = config;
      this.apiVersion = config.getApiVersion();
      if (config.getMasterUrl() == null) {
        throw new KubernetesClientException("Unknown Kubernetes master URL - " +
          "please set with the builder, or set with either system property \"" + Config.KUBERNETES_MASTER_SYSTEM_PROPERTY + "\"" +
          " or environment variable \"" + Utils.convertSystemPropertyNameToEnvVar(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY) + "\"");
      }
      this.masterUrl = new URL(config.getMasterUrl());
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public void close() {
    ConnectionPool connectionPool = httpClient.connectionPool();
    Dispatcher dispatcher = httpClient.dispatcher();
    ExecutorService executorService = httpClient.dispatcher() != null ? httpClient.dispatcher().executorService() : null;

    if (dispatcher != null) {
      dispatcher.cancelAll();
    }

    if (connectionPool != null) {
      connectionPool.evictAll();
    }

    Utils.shutdownExecutorService(executorService);
  }

  @Override
  public URL getMasterUrl() {
    return masterUrl;
  }

  @Override
  public String getApiVersion() {
    return apiVersion;
  }

  @Override
  public String getNamespace() {
    return namespace;
  }


  @Override
  public Config getConfiguration() {
    return configuration;
  }

  @Override
  public OkHttpClient getHttpClient() {
    return httpClient;
  }

  @Override
  public <C> Boolean isAdaptable(Class<C> type) {
    ExtensionAdapter<C> adapter = Adapters.get(type);
    if (adapter != null) {
      return adapter.isAdaptable(this);
    } else {
      return false;
    }
  }

  @Override
  public <C> C adapt(Class<C> type) {
    ExtensionAdapter<C> adapter = Adapters.get(type);
    if (adapter != null) {
      return adapter.adapt(this);
    }
    throw new IllegalStateException("No adapter available for type:" + type);
  }

  @Override
  public RootPaths rootPaths() {
    return new BaseOperation(httpClient, configuration, null, null, "", null, null, false, null, null, false, RootPaths.class, null, null) {
    }.getRootPaths();
  }

  @Override
  public boolean supportsApiPath(String apiPath) {
    RootPaths rootPaths = rootPaths();
    if (rootPaths != null) {
      List<String> paths = rootPaths.getPaths();
      if (paths != null) {
        for (String path : paths) {
          if (path.equals(apiPath)) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
