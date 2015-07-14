package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.dsl.BuilderUpdate;
import io.fabric8.kubernetes.client.dsl.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.NamedNamespacedResource;
import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class NamedResource<T extends HasMetadata, B extends Builder<T>, U extends Updateable<T>>
  extends BaseResource<T, B, U>
  implements io.fabric8.kubernetes.client.dsl.NamedResource<T, B, U>,
  NamedNamespacedResource<T, B, U> {

  private URL resourceUrl;

  NamedResource(String name, DefaultResourceList<T, ?, B, U> resourceList) throws MalformedURLException {
    super(resourceList.getHttpClient(), resourceList.getRootUrl(), resourceList.getResourceT(), resourceList.getClazz(), resourceList.getBuilderClazz());
    URL requestUrl = getNamespacedUrl();
    this.resourceUrl = new URL(requestUrl, name);
  }

  NamedResource(String name, NamespacedResourceList<T, ?, B, U> resourceList) throws MalformedURLException {
    super(resourceList.getHttpClient(), resourceList.getRootUrl(), resourceList.getResourceT(), resourceList.getClazz(), resourceList.getBuilderClazz());
    setNamespace(resourceList.getNamespace());
    URL requestUrl = getNamespacedUrl();
    this.resourceUrl = new URL(requestUrl, name);
  }

  @Override
  public T get() throws KubernetesClientException {
    try {
      return handleGet(resourceUrl);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to get resource", e);
    }
  }

  @Override
  public T edit() {
    return null;
  }

  @Override
  public T update(BuilderUpdate<T, B> update) throws KubernetesClientException {
    try {
      T current = this.get();
      T updated = update.apply(getBuilderClazz().getDeclaredConstructor(getClazz()).newInstance(current));
      return handleUpdate(resourceUrl, updated);
    } catch (InterruptedException | ExecutionException | IOException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw new KubernetesClientException("Unable to update resource", e);
    }
  }

  @Override
  public T update(Update<T> update) throws KubernetesClientException {
    try {
      T current = this.get();
      T updated = update.apply(current);
      return handleUpdate(resourceUrl, updated);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to update resource", e);
    }
  }

  @Override
  public void delete() throws KubernetesClientException {
    try {
      handleDelete(resourceUrl);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to delete resource", e);
    }
  }
}
