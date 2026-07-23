package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CheckpointStatusBuilder extends CheckpointStatusFluent<CheckpointStatusBuilder> implements VisitableBuilder<CheckpointStatus,CheckpointStatusBuilder>{

  CheckpointStatusFluent<?> fluent;

  public CheckpointStatusBuilder() {
    this(new CheckpointStatus());
  }
  
  public CheckpointStatusBuilder(CheckpointStatusFluent<?> fluent) {
    this(fluent, new CheckpointStatus());
  }
  
  public CheckpointStatusBuilder(CheckpointStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CheckpointStatusBuilder(CheckpointStatusFluent<?> fluent,CheckpointStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CheckpointStatus build() {
    CheckpointStatus buildable = new CheckpointStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}