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

import com.squareup.okhttp.OkHttpClient;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.Utils;

import java.net.URL;


public abstract class BaseClient implements Client {

  protected OkHttpClient httpClient;
  private URL masterUrl;
  private String apiVersion;
  private String namespace;
  private Config configuration;

  public BaseClient() throws KubernetesClientException {
    this(new ConfigBuilder().build());
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

      Adapters.register(new ExtensionAdapter<OkHttpClient>() {
        @Override
        public Class<OkHttpClient> getExtensionType() {
          return OkHttpClient.class;
        }

        @Override
        public Boolean isAdaptable(Client client) {
          return client instanceof BaseClient;
        }

        @Override
        public OkHttpClient adapt(Client client) {
          return httpClient.clone();
        }
      });

    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }



  public BaseClient(String masterUrl) throws KubernetesClientException {
    this(new ConfigBuilder().withMasterUrl(masterUrl).build());
  }

  @Override
  public void close() {
    if (httpClient.getConnectionPool() != null) {
      httpClient.getConnectionPool().evictAll();
    }
    if (httpClient.getDispatcher() != null &&
      httpClient.getDispatcher().getExecutorService() != null &&
      !httpClient.getDispatcher().getExecutorService().isShutdown()
      ) {
      httpClient.getDispatcher().getExecutorService().shutdown();
    }
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
}
