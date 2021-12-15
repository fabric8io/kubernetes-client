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

import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.api.model.APIGroup;
import io.fabric8.kubernetes.api.model.APIGroupList;
import io.fabric8.kubernetes.api.model.APIResourceList;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.Utils;

import java.net.URL;
import java.util.List;

public class BaseClient extends SimpleClientContext implements Client {

  public static final String APIS = "/apis";

  private URL masterUrl;
  private String apiVersion;
  private String namespace;

  public BaseClient() {
    this(new ConfigBuilder().build());
  }

  public BaseClient(String masterUrl) {
    this(new ConfigBuilder().withMasterUrl(masterUrl).build());
  }

  public BaseClient(final Config config) {
    this(HttpClientUtils.createHttpClient(config), config);
  }

  public BaseClient(final HttpClient httpClient, Config config) {
    this(new SimpleClientContext(config, httpClient));
  }
  
  public BaseClient(ClientContext clientContext) {
    try {
      this.config = clientContext.getConfiguration();
      this.httpClient = clientContext.getHttpClient();
      adaptState();
      this.namespace = config.getNamespace();
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
    httpClient.close();
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
    return new OperationSupport(httpClient, config).restCall(RootPaths.class);
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

  @Override
  public APIGroupList getApiGroups() {
    return new OperationSupport(httpClient, config).restCall(APIGroupList.class, APIS);
  }

  @Override
  public APIGroup getApiGroup(String name) {
    return new OperationSupport(httpClient, config).restCall(APIGroup.class, APIS, name);
  }

  @Override
  public APIResourceList getApiResources(String groupVersion) {
    return new OperationSupport(httpClient, config).restCall(APIResourceList.class, APIS, groupVersion);
  }

  protected VersionInfo getVersionInfo(String path) {
    return new OperationSupport(this.httpClient, this.getConfiguration()).restCall(VersionInfo.class, path);
  }

  /**
   * For subclasses to adapt the client state
   */
  protected void adaptState() {
    // nothing by default
  }
  
  protected SimpleClientContext newState(Config updated) {
    return new SimpleClientContext(updated, httpClient);
  }
}
