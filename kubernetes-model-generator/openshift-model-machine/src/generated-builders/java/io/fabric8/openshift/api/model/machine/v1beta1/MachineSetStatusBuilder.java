package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineSetStatusBuilder extends MachineSetStatusFluent<MachineSetStatusBuilder> implements VisitableBuilder<MachineSetStatus,MachineSetStatusBuilder>{

  MachineSetStatusFluent<?> fluent;

  public MachineSetStatusBuilder() {
    this(new MachineSetStatus());
  }
  
  public MachineSetStatusBuilder(MachineSetStatusFluent<?> fluent) {
    this(fluent, new MachineSetStatus());
  }
  
  public MachineSetStatusBuilder(MachineSetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineSetStatusBuilder(MachineSetStatusFluent<?> fluent,MachineSetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineSetStatus build() {
    MachineSetStatus buildable = new MachineSetStatus(fluent.getAuthoritativeAPI(), fluent.getAvailableReplicas(), fluent.buildConditions(), fluent.getErrorMessage(), fluent.getErrorReason(), fluent.getFullyLabeledReplicas(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getReplicas(), fluent.getSynchronizedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}