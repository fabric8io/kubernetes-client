package io.fabric8.kubernetes.client.dsl;

import io.fabric8.common.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;

public interface BuilderUpdate<Type extends HasMetadata, TypeBuilder extends Builder<Type>> {

  Type apply(TypeBuilder builder);

}
