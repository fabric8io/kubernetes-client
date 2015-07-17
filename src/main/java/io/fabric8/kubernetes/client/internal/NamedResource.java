package io.fabric8.kubernetes.client.internal;

import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.BuilderUpdate;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.NamedNamespacedResource;
import io.fabric8.kubernetes.client.Update;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class NamedResource<T extends HasMetadata, B extends Builder<T>, D extends Doneable<T>>
  extends BaseResource<T, B, D>
  implements io.fabric8.kubernetes.client.NamedResource<T, B, D>,
  NamedNamespacedResource<T, B, D> {

  private URL resourceUrl;

  NamedResource(String name, DefaultResourceList<T, ?, B, D> resourceList) throws MalformedURLException {
    super(resourceList.getHttpClient(), resourceList.getRootUrl(), resourceList.getResourceT(), resourceList.getClazz(), resourceList.getBuilderClazz(), resourceList.getDoneableClazz());
    URL requestUrl = getNamespacedUrl();
    this.resourceUrl = new URL(requestUrl, name);
  }

  NamedResource(String name, NamespacedResourceList<T, ?, B, D> resourceList) throws MalformedURLException {
    super(resourceList.getHttpClient(), resourceList.getRootUrl(), resourceList.getResourceT(), resourceList.getClazz(), resourceList.getBuilderClazz(), resourceList.getDoneableClazz());
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
  public D edit() throws KubernetesClientException {

    final Visitor<T> visitor = new Visitor<T>() {
      @Override
      public void visit(T resource) {
        try {
          handleUpdate(resourceUrl, resource);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    };

    try {

      return getDoneableClazz().getDeclaredConstructor(getClazz(), Visitor.class).newInstance(get(), visitor);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw new KubernetesClientException("Unable create doneable.", e);
    }
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
