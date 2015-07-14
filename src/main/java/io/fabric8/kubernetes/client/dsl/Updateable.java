package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.HasMetadata;

public interface Updateable<T extends HasMetadata> {

  T update();
}
