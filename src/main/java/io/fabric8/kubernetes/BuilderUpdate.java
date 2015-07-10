package io.fabric8.kubernetes;


import io.fabric8.common.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;

public interface BuilderUpdate<ResourceType extends HasMetadata, ResourceBuilder extends Builder<ResourceType>> {
    ResourceType update(ResourceBuilder builder);
}
