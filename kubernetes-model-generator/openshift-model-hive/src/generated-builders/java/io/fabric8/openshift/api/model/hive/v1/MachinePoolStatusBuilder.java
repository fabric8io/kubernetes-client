package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachinePoolStatusBuilder extends MachinePoolStatusFluent<MachinePoolStatusBuilder> implements VisitableBuilder<MachinePoolStatus,MachinePoolStatusBuilder>{

  MachinePoolStatusFluent<?> fluent;

  public MachinePoolStatusBuilder() {
    this(new MachinePoolStatus());
  }
  
  public MachinePoolStatusBuilder(MachinePoolStatusFluent<?> fluent) {
    this(fluent, new MachinePoolStatus());
  }
  
  public MachinePoolStatusBuilder(MachinePoolStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachinePoolStatusBuilder(MachinePoolStatusFluent<?> fluent,MachinePoolStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachinePoolStatus build() {
    MachinePoolStatus buildable = new MachinePoolStatus(fluent.buildConditions(), fluent.getControlledByReplica(), fluent.buildMachineSets(), fluent.getOwnedLabels(), fluent.getOwnedMachineLabels(), fluent.buildOwnedTaints(), fluent.getReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}