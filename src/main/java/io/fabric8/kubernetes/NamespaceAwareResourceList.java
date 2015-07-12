package io.fabric8.kubernetes;

import io.fabric8.common.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

public interface NamespaceAwareResourceList<Type extends HasMetadata, TypeList extends KubernetesResourceList, TypeBuilder extends Builder<Type>>
  extends ResourceList<Type, TypeList, TypeBuilder> {

  NamespacedResourceList<Type, TypeList, TypeBuilder> inNamespace(String namespace);

}
