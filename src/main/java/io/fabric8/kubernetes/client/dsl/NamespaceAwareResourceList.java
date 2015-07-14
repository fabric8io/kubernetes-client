package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

public interface NamespaceAwareResourceList<T extends HasMetadata, L extends KubernetesResourceList, B extends Builder<T>, U extends Updateable<T>>
  extends ResourceList<T, L, B> {

  NamespacedResourceList<T, L, B, U> inNamespace(String namespace);

}
