package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachinePoolConditionBuilder extends MachinePoolConditionFluent<MachinePoolConditionBuilder> implements VisitableBuilder<MachinePoolCondition,MachinePoolConditionBuilder>{

  MachinePoolConditionFluent<?> fluent;

  public MachinePoolConditionBuilder() {
    this(new MachinePoolCondition());
  }
  
  public MachinePoolConditionBuilder(MachinePoolConditionFluent<?> fluent) {
    this(fluent, new MachinePoolCondition());
  }
  
  public MachinePoolConditionBuilder(MachinePoolCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachinePoolConditionBuilder(MachinePoolConditionFluent<?> fluent,MachinePoolCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachinePoolCondition build() {
    MachinePoolCondition buildable = new MachinePoolCondition(fluent.getLastProbeTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}