package io.fabric8.kubernetes.client.extension;

import io.fabric8.kubernetes.api.model.APIGroup;
import io.fabric8.kubernetes.api.model.APIGroupList;
import io.fabric8.kubernetes.api.model.APIResourceList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.http.HttpClient;

import java.net.URL;
import java.util.function.Function;

public abstract class ClientAdapter<T extends Client> implements Client {

  protected Client client;
  private Function<Client, T> newInstance;

  public ClientAdapter(Client client, Function<Client, T> newInstance) {
    this.client = client;
    this.newInstance = newInstance;
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
  public <C> Boolean isAdaptable(Class<C> type) {
    return client.isAdaptable(type);
  }

  @Override
  public <C> C adapt(Class<C> type) {
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

  public <T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>> MixedOperation<T, L, R> resources(
      Class<T> resourceType, Class<L> listClass, Class<R> resourceClass) {
  }

  public <T extends HasMetadata, L extends KubernetesResourceList<T>> MixedOperation<T, L, Resource<T>> resources(
      Class<T> resourceType, Class<L> listClass) {
  }

  public T inAnyNamespace() {
    return inNamespace(null);
  }

  public T inNamespace(String namespace) {
    return newInstance.apply(client.adapt(NamespacedKubernetesClient.class).inNamespace(namespace));
  }

}
