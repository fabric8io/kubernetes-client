package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageStatusBuilder extends StorageStatusFluent<StorageStatusBuilder> implements VisitableBuilder<StorageStatus,StorageStatusBuilder>{

  StorageStatusFluent<?> fluent;

  public StorageStatusBuilder() {
    this(new StorageStatus());
  }
  
  public StorageStatusBuilder(StorageStatusFluent<?> fluent) {
    this(fluent, new StorageStatus());
  }
  
  public StorageStatusBuilder(StorageStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageStatusBuilder(StorageStatusFluent<?> fluent,StorageStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageStatus build() {
    StorageStatus buildable = new StorageStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}