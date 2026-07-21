package io.fabric8.openclustermanagement.api.model.search.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageSpecBuilder extends StorageSpecFluent<StorageSpecBuilder> implements VisitableBuilder<StorageSpec,StorageSpecBuilder>{

  StorageSpecFluent<?> fluent;

  public StorageSpecBuilder() {
    this(new StorageSpec());
  }
  
  public StorageSpecBuilder(StorageSpecFluent<?> fluent) {
    this(fluent, new StorageSpec());
  }
  
  public StorageSpecBuilder(StorageSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageSpecBuilder(StorageSpecFluent<?> fluent,StorageSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageSpec build() {
    StorageSpec buildable = new StorageSpec(fluent.getSize(), fluent.getStorageClassName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}