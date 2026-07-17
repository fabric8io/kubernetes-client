package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CheckpointSpecBuilder extends CheckpointSpecFluent<CheckpointSpecBuilder> implements VisitableBuilder<CheckpointSpec,CheckpointSpecBuilder>{

  CheckpointSpecFluent<?> fluent;

  public CheckpointSpecBuilder() {
    this(new CheckpointSpec());
  }
  
  public CheckpointSpecBuilder(CheckpointSpecFluent<?> fluent) {
    this(fluent, new CheckpointSpec());
  }
  
  public CheckpointSpecBuilder(CheckpointSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CheckpointSpecBuilder(CheckpointSpecFluent<?> fluent,CheckpointSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CheckpointSpec build() {
    CheckpointSpec buildable = new CheckpointSpec(fluent.getLastBackupChecksum(), fluent.buildLastBackupRef(), fluent.getLastBackupTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}