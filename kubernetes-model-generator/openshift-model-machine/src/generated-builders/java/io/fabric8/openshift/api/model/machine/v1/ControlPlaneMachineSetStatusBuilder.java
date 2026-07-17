package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControlPlaneMachineSetStatusBuilder extends ControlPlaneMachineSetStatusFluent<ControlPlaneMachineSetStatusBuilder> implements VisitableBuilder<ControlPlaneMachineSetStatus,ControlPlaneMachineSetStatusBuilder>{

  ControlPlaneMachineSetStatusFluent<?> fluent;

  public ControlPlaneMachineSetStatusBuilder() {
    this(new ControlPlaneMachineSetStatus());
  }
  
  public ControlPlaneMachineSetStatusBuilder(ControlPlaneMachineSetStatusFluent<?> fluent) {
    this(fluent, new ControlPlaneMachineSetStatus());
  }
  
  public ControlPlaneMachineSetStatusBuilder(ControlPlaneMachineSetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControlPlaneMachineSetStatusBuilder(ControlPlaneMachineSetStatusFluent<?> fluent,ControlPlaneMachineSetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControlPlaneMachineSetStatus build() {
    ControlPlaneMachineSetStatus buildable = new ControlPlaneMachineSetStatus(fluent.getConditions(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getReplicas(), fluent.getUnavailableReplicas(), fluent.getUpdatedReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}