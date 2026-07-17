package io.fabric8.openshift.api.model.config.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageBuilder extends StorageFluent<StorageBuilder> implements VisitableBuilder<Storage,StorageBuilder>{

  StorageFluent<?> fluent;

  public StorageBuilder() {
    this(new Storage());
  }
  
  public StorageBuilder(StorageFluent<?> fluent) {
    this(fluent, new Storage());
  }
  
  public StorageBuilder(Storage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageBuilder(StorageFluent<?> fluent,Storage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Storage build() {
    Storage buildable = new Storage(fluent.buildPersistentVolume(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}