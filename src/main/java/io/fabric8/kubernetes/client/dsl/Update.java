package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.HasMetadata;

public interface Update<Type extends HasMetadata> {

  Type apply(Type resource);

}
