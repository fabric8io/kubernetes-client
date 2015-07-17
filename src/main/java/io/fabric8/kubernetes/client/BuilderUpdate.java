package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;

public interface BuilderUpdate<T extends HasMetadata, B extends Builder<T>> {

  T apply(B builder);

}
