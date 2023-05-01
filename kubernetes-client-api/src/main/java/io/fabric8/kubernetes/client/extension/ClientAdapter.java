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

import io.fabric8.kubernetes.api.model.APIGroup;
import io.fabric8.kubernetes.api.model.APIGroupList;
import io.fabric8.kubernetes.api.model.APIResourceList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.http.HttpClient;

import java.net.URL;

/**
 * To be used as the base class for creating extension clients
 */
public abstract class ClientAdapter<C extends ClientAdapter<C>> implements Client {

  private Client client;

  public Client getClient() {
    return client;
  }

  public void init(Client client) {
    this.client = client;
  }

  @Override
  public HttpClient getHttpClient() {
    return client.getHttpClient();
  }

  @Override
  public Config getConfiguration() {
    return client.getConfiguration();
  }

  @Override
  public <A extends Client> Boolean isAdaptable(Class<A> type) {
    return client.isAdaptable(type);
  }

  @Override
  public <T extends KubernetesResource> boolean supports(Class<T> type) {
    return client.supports(type);
  }

  @Override
  public boolean supports(String apiVersion, String kind) {
    return client.supports(apiVersion, kind);
  }

  @Override
  public boolean hasApiGroup(String apiGroup, boolean exact) {
    return client.hasApiGroup(apiGroup, exact);
  }

  @Override
  public <A extends Client> A adapt(Class<A> type) {
    return client.adapt(type);
  }

  @Override
  public URL getMasterUrl() {
    return client.getMasterUrl();
  }

  @Override
  public String getApiVersion() {
    return client.getApiVersion();
  }

  @Override
  public String getNamespace() {
    return client.getNamespace();
  }

  @Override
  public RootPaths rootPaths() {
    return client.rootPaths();
  }

  @Override
  public boolean supportsApiPath(String path) {
    return client.supportsApiPath(path);
  }

  @Override
  public void close() {
    client.close();
  }

  @Override
  public APIGroupList getApiGroups() {
    return client.getApiGroups();
  }

  @Override
  public APIGroup getApiGroup(String name) {
    return client.getApiGroup(name);
  }

  @Override
  public APIResourceList getApiResources(String groupVersion) {
    return client.getApiResources(groupVersion);
  }

  @Override
  public <T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>> MixedOperation<T, L, R> resources(
      Class<T> resourceType, Class<L> listClass, Class<R> resourceClass) {
    return client.resources(resourceType, listClass, resourceClass);
  }

  public C inAnyNamespace() {
    C result = newInstance();
    result.init(client.adapt(NamespacedKubernetesClient.class).inAnyNamespace());
    return result;
  }

  public C inNamespace(String namespace) {
    C result = newInstance();
    result.init(client.adapt(NamespacedKubernetesClient.class).inNamespace(namespace));
    return result;
  }

  @Override
  public Client newClient(RequestConfig requestConfig) {
    return client.newClient(requestConfig);
  }

  public abstract C newInstance();

  @Override
  public String raw(String uri, String method, Object payload) {
    return client.raw(uri, method, payload);
  }

}
