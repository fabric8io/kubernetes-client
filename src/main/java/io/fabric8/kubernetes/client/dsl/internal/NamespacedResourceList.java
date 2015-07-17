package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.FilteredNamespacedResourceList;
import io.fabric8.kubernetes.client.dsl.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.NamedNamespacedResource;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class NamespacedResourceList<T extends HasMetadata, L extends KubernetesResourceList, B extends Builder<T>, D extends Doneable<T>>
  extends BaseResourceList<T, L, B, D>
  implements io.fabric8.kubernetes.client.dsl.NamespacedResourceList<T, L, B, D>,
  FilteredNamespacedResourceList<T, L> {

  NamespacedResourceList(String namespace, DefaultResourceList resourceList) {
    super(resourceList.getHttpClient(), resourceList.getRootUrl(), resourceList.getResourceT(), resourceList.getClazz(), resourceList.getListClazz(), resourceList.getBuilderClazz(), resourceList.getDoneableClazz());
    setNamespace(namespace);
  }

  @Override
  public T create(T resource) throws KubernetesClientException {
    try {
      return handleCreate(resource);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to create resource", e);
    }
  }

  @Override
  public D create() throws KubernetesClientException {
    final Visitor<T> visitor = new Visitor<T>() {
      @Override
      public void visit(T resource) {
        try {
          create(resource);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    };

    try {
      return getDoneableClazz().getDeclaredConstructor(Visitor.class).newInstance(visitor);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw new KubernetesClientException("Unable create doneable.", e);
    }
  }

  @Override
  public FilteredNamespacedResourceList<T, L> withLabels(Map<String, String> labels) {
    getLabels().putAll(labels);
    return this;
  }

  @Override
  public FilteredNamespacedResourceList<T, L> withLabel(String key, String value) {
    getLabels().put(key, value);
    return this;
  }

  @Override
  public FilteredNamespacedResourceList<T, L> withFields(Map<String, String> labels) {
    getFields().putAll(labels);
    return this;
  }

  @Override
  public FilteredNamespacedResourceList<T, L> withField(String key, String value) {
    getFields().put(key, value);
    return this;
  }

  @Override
  public NamedNamespacedResource<T, B, D> withName(String name) throws KubernetesClientException {
    try {
      return new NamedResource<>(name, this);
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Malformed resource URL", e);
    }
  }

}
