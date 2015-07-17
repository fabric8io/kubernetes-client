package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;

public interface NamedResource<T extends HasMetadata, B extends Builder<T>, D extends Doneable<T>> {

  T get() throws KubernetesClientException;

  D edit() throws KubernetesClientException;

  T update(BuilderUpdate<T, B> update) throws KubernetesClientException;

  T update(Update<T> update) throws KubernetesClientException;

  void delete() throws KubernetesClientException;

}
