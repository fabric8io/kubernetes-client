package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineStatusBuilder extends MachineStatusFluent<MachineStatusBuilder> implements VisitableBuilder<MachineStatus,MachineStatusBuilder>{

  MachineStatusFluent<?> fluent;

  public MachineStatusBuilder() {
    this(new MachineStatus());
  }
  
  public MachineStatusBuilder(MachineStatusFluent<?> fluent) {
    this(fluent, new MachineStatus());
  }
  
  public MachineStatusBuilder(MachineStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineStatusBuilder(MachineStatusFluent<?> fluent,MachineStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineStatus build() {
    MachineStatus buildable = new MachineStatus(fluent.getAddresses(), fluent.getAuthoritativeAPI(), fluent.buildConditions(), fluent.getErrorMessage(), fluent.getErrorReason(), fluent.buildLastOperation(), fluent.getLastUpdated(), fluent.buildNodeRef(), fluent.getPhase(), fluent.getProviderStatus(), fluent.getSynchronizedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}