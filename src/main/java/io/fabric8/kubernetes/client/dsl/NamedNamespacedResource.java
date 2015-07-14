package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;

public interface NamedNamespacedResource<T extends HasMetadata, B extends Builder<T>> {

  T get() throws KubernetesClientException;

  T update(BuilderUpdate<T, B> update) throws KubernetesClientException;

  T update(Update<T> update) throws KubernetesClientException;

  void delete() throws KubernetesClientException;

}
