package io.fabric8.openshift.api.model.hive.v1;

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
    MachineSetStatus buildable = new MachineSetStatus(fluent.getErrorMessage(), fluent.getErrorReason(), fluent.getMaxReplicas(), fluent.getMinReplicas(), fluent.getName(), fluent.getReadyReplicas(), fluent.getReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}