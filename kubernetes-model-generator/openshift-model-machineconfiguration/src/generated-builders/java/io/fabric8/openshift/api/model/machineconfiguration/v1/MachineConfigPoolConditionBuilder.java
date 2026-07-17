package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigPoolConditionBuilder extends MachineConfigPoolConditionFluent<MachineConfigPoolConditionBuilder> implements VisitableBuilder<MachineConfigPoolCondition,MachineConfigPoolConditionBuilder>{

  MachineConfigPoolConditionFluent<?> fluent;

  public MachineConfigPoolConditionBuilder() {
    this(new MachineConfigPoolCondition());
  }
  
  public MachineConfigPoolConditionBuilder(MachineConfigPoolConditionFluent<?> fluent) {
    this(fluent, new MachineConfigPoolCondition());
  }
  
  public MachineConfigPoolConditionBuilder(MachineConfigPoolCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigPoolConditionBuilder(MachineConfigPoolConditionFluent<?> fluent,MachineConfigPoolCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigPoolCondition build() {
    MachineConfigPoolCondition buildable = new MachineConfigPoolCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}