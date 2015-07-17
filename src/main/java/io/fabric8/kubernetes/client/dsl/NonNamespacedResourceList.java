package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

public interface NonNamespacedResourceList<T extends HasMetadata, L extends KubernetesResourceList, B extends Builder<T>, D extends Doneable<T>>
  extends ResourceList<T, L, B> {

  T create(T resource) throws KubernetesClientException;

  D createNew() throws KubernetesClientException;

  NamedResource<T, B, D> withName(String name) throws KubernetesClientException;

}
