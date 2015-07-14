package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.dsl.BuilderUpdate;
import io.fabric8.kubernetes.client.dsl.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.NamedNamespacedResource;
import io.fabric8.kubernetes.client.dsl.Update;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class NamedResource<Type extends HasMetadata, TypeBuilder extends Builder<Type>>
  extends BaseResource<Type, TypeBuilder>
  implements io.fabric8.kubernetes.client.dsl.NamedResource<Type, TypeBuilder>,
  NamedNamespacedResource<Type, TypeBuilder> {

  private URL resourceUrl;

  NamedResource(String name, DefaultResourceList<Type, ?, TypeBuilder> resourceList) throws MalformedURLException {
    super(resourceList.getHttpClient(), resourceList.getRootUrl(), resourceList.getResourceType(), resourceList.getClazz(), resourceList.getBuilderClazz());
    URL requestUrl = getNamespacedUrl();
    this.resourceUrl = new URL(requestUrl, name);
  }

  NamedResource(String name, NamespacedResourceList<Type, ?, TypeBuilder> resourceList) throws MalformedURLException {
    super(resourceList.getHttpClient(), resourceList.getRootUrl(), resourceList.getResourceType(), resourceList.getClazz(), resourceList.getBuilderClazz());
    setNamespace(resourceList.getNamespace());
    URL requestUrl = getNamespacedUrl();
    this.resourceUrl = new URL(requestUrl, name);
  }

  @Override
  public Type get() throws KubernetesClientException {
    try {
      return handleGet(resourceUrl);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to get resource", e);
    }
  }

  @Override
  public Type update(BuilderUpdate<Type, TypeBuilder> update) throws KubernetesClientException {
    try {
      Type current = this.get();
      Type updated = update.apply(getBuilderClazz().getDeclaredConstructor(getClazz()).newInstance(current));
      return handleUpdate(resourceUrl, updated);
    } catch (InterruptedException | ExecutionException | IOException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw new KubernetesClientException("Unable to update resource", e);
    }
  }

  @Override
  public Type update(Update<Type> update) throws KubernetesClientException {
    try {
      Type current = this.get();
      Type updated = update.apply(current);
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
