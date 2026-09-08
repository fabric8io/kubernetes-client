package io.fabric8.kubernetes.api.model.storage;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageHealthConditionBuilder extends StorageHealthConditionFluent<StorageHealthConditionBuilder> implements VisitableBuilder<StorageHealthCondition,StorageHealthConditionBuilder>{

  StorageHealthConditionFluent<?> fluent;

  public StorageHealthConditionBuilder() {
    this(new StorageHealthCondition());
  }
  
  public StorageHealthConditionBuilder(StorageHealthConditionFluent<?> fluent) {
    this(fluent, new StorageHealthCondition());
  }
  
  public StorageHealthConditionBuilder(StorageHealthCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageHealthConditionBuilder(StorageHealthConditionFluent<?> fluent,StorageHealthCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageHealthCondition build() {
    StorageHealthCondition buildable = new StorageHealthCondition(fluent.getAccessMode(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getVolumeMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}