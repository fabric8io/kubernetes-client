package io.fabric8.kubernetes.client.dsl;

import io.fabric8.common.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;

public interface NamedResource<Type extends HasMetadata, TypeBuilder extends Builder<Type>> {

  Type get() throws KubernetesClientException;

  Type update(BuilderUpdate<Type, TypeBuilder> update) throws KubernetesClientException;

  Type update(Update<Type> update) throws KubernetesClientException;

  void delete() throws KubernetesClientException;

}
