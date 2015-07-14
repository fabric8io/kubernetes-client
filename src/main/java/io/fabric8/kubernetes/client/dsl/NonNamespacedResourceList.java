package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

public interface NonNamespacedResourceList<T extends HasMetadata, L extends KubernetesResourceList, B extends Builder<T>, U extends Updateable<T>>
  extends ResourceList<T, L, B> {

  T create(T resource) throws KubernetesClientException;

  NamedResource<T, B, U> withName(String name) throws KubernetesClientException;

}
