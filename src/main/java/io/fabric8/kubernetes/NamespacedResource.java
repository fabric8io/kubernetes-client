package io.fabric8.kubernetes;

import io.fabric8.common.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

public class NamespacedResource<ResourceListType extends KubernetesResourceList, ResourceType extends HasMetadata, ResourceBuilder extends Builder<ResourceType>>
  extends ResourceList<ResourceListType, ResourceType, ResourceBuilder> {

  public NamespacedResource(String namespace, ResourceList<ResourceListType, ResourceType, ResourceBuilder> resource) {
    super(namespace, resource);
  }

  public NamedResource<ResourceListType, ResourceType, ResourceBuilder> withName(String resourceName) {
    return new NamedResource<>(resourceName, this);
  }

}
