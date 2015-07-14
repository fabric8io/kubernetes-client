package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;

public interface NamedResource<T extends HasMetadata, B extends Builder<T>, U extends Updateable<T>> {

  T get() throws KubernetesClientException;

  T edit();

  T update(BuilderUpdate<T, B> update) throws KubernetesClientException;

  T update(Update<T> update) throws KubernetesClientException;

  void delete() throws KubernetesClientException;

}
