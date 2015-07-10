package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.HasMetadata;

public interface Update<ResourceType extends HasMetadata> {
    ResourceType update(ResourceType resource);
}
