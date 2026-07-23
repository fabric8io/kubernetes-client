package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

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
    MachineStatus buildable = new MachineStatus(fluent.buildAddresses(), fluent.getBootstrapReady(), fluent.getCertificatesExpiryDate(), fluent.buildConditions(), fluent.buildDeletion(), fluent.getFailureMessage(), fluent.getFailureReason(), fluent.getInfrastructureReady(), fluent.getLastUpdated(), fluent.buildNodeInfo(), fluent.buildNodeRef(), fluent.getObservedGeneration(), fluent.getPhase(), fluent.buildV1beta2());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}