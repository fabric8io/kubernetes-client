package io.fabric8.kubernetes.api.model.storage;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageHealthBuilder extends StorageHealthFluent<StorageHealthBuilder> implements VisitableBuilder<StorageHealth,StorageHealthBuilder>{

  StorageHealthFluent<?> fluent;

  public StorageHealthBuilder() {
    this(new StorageHealth());
  }
  
  public StorageHealthBuilder(StorageHealthFluent<?> fluent) {
    this(fluent, new StorageHealth());
  }
  
  public StorageHealthBuilder(StorageHealth instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageHealthBuilder(StorageHealthFluent<?> fluent,StorageHealth instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageHealth build() {
    StorageHealth buildable = new StorageHealth(fluent.buildHealthConditions(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}