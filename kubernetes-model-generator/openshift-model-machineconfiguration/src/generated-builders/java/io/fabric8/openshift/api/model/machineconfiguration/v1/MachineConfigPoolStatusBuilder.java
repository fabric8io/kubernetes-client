package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigPoolStatusBuilder extends MachineConfigPoolStatusFluent<MachineConfigPoolStatusBuilder> implements VisitableBuilder<MachineConfigPoolStatus,MachineConfigPoolStatusBuilder>{

  MachineConfigPoolStatusFluent<?> fluent;

  public MachineConfigPoolStatusBuilder() {
    this(new MachineConfigPoolStatus());
  }
  
  public MachineConfigPoolStatusBuilder(MachineConfigPoolStatusFluent<?> fluent) {
    this(fluent, new MachineConfigPoolStatus());
  }
  
  public MachineConfigPoolStatusBuilder(MachineConfigPoolStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigPoolStatusBuilder(MachineConfigPoolStatusFluent<?> fluent,MachineConfigPoolStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigPoolStatus build() {
    MachineConfigPoolStatus buildable = new MachineConfigPoolStatus(fluent.buildCertExpirys(), fluent.buildConditions(), fluent.buildConfiguration(), fluent.getDegradedMachineCount(), fluent.getMachineCount(), fluent.getObservedGeneration(), fluent.buildPoolSynchronizersStatus(), fluent.getReadyMachineCount(), fluent.getUnavailableMachineCount(), fluent.getUpdatedMachineCount());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}