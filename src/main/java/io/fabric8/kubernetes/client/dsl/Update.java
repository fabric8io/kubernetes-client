package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.HasMetadata;

public interface Update<T extends HasMetadata> {

  T apply(T resource);

}
