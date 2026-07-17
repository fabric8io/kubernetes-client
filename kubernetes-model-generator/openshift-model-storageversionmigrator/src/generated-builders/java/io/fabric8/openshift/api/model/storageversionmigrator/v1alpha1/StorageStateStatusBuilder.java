package io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageStateStatusBuilder extends StorageStateStatusFluent<StorageStateStatusBuilder> implements VisitableBuilder<StorageStateStatus,StorageStateStatusBuilder>{

  StorageStateStatusFluent<?> fluent;

  public StorageStateStatusBuilder() {
    this(new StorageStateStatus());
  }
  
  public StorageStateStatusBuilder(StorageStateStatusFluent<?> fluent) {
    this(fluent, new StorageStateStatus());
  }
  
  public StorageStateStatusBuilder(StorageStateStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageStateStatusBuilder(StorageStateStatusFluent<?> fluent,StorageStateStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageStateStatus build() {
    StorageStateStatus buildable = new StorageStateStatus(fluent.getCurrentStorageVersionHash(), fluent.getLastHeartbeatTime(), fluent.getPersistedStorageVersionHashes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}