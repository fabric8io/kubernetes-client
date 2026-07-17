package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachinePoolNameLeaseStatusBuilder extends MachinePoolNameLeaseStatusFluent<MachinePoolNameLeaseStatusBuilder> implements VisitableBuilder<MachinePoolNameLeaseStatus,MachinePoolNameLeaseStatusBuilder>{

  MachinePoolNameLeaseStatusFluent<?> fluent;

  public MachinePoolNameLeaseStatusBuilder() {
    this(new MachinePoolNameLeaseStatus());
  }
  
  public MachinePoolNameLeaseStatusBuilder(MachinePoolNameLeaseStatusFluent<?> fluent) {
    this(fluent, new MachinePoolNameLeaseStatus());
  }
  
  public MachinePoolNameLeaseStatusBuilder(MachinePoolNameLeaseStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachinePoolNameLeaseStatusBuilder(MachinePoolNameLeaseStatusFluent<?> fluent,MachinePoolNameLeaseStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachinePoolNameLeaseStatus build() {
    MachinePoolNameLeaseStatus buildable = new MachinePoolNameLeaseStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}