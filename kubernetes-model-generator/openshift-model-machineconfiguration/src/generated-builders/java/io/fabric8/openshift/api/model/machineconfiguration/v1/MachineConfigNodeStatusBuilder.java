package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigNodeStatusBuilder extends MachineConfigNodeStatusFluent<MachineConfigNodeStatusBuilder> implements VisitableBuilder<MachineConfigNodeStatus,MachineConfigNodeStatusBuilder>{

  MachineConfigNodeStatusFluent<?> fluent;

  public MachineConfigNodeStatusBuilder() {
    this(new MachineConfigNodeStatus());
  }
  
  public MachineConfigNodeStatusBuilder(MachineConfigNodeStatusFluent<?> fluent) {
    this(fluent, new MachineConfigNodeStatus());
  }
  
  public MachineConfigNodeStatusBuilder(MachineConfigNodeStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigNodeStatusBuilder(MachineConfigNodeStatusFluent<?> fluent,MachineConfigNodeStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigNodeStatus build() {
    MachineConfigNodeStatus buildable = new MachineConfigNodeStatus(fluent.getConditions(), fluent.buildConfigVersion(), fluent.buildIrreconcilableChanges(), fluent.getObservedGeneration(), fluent.buildPinnedImageSets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}