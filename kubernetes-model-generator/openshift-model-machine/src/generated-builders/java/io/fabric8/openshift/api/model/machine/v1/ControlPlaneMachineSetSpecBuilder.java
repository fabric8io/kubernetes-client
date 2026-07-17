package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControlPlaneMachineSetSpecBuilder extends ControlPlaneMachineSetSpecFluent<ControlPlaneMachineSetSpecBuilder> implements VisitableBuilder<ControlPlaneMachineSetSpec,ControlPlaneMachineSetSpecBuilder>{

  ControlPlaneMachineSetSpecFluent<?> fluent;

  public ControlPlaneMachineSetSpecBuilder() {
    this(new ControlPlaneMachineSetSpec());
  }
  
  public ControlPlaneMachineSetSpecBuilder(ControlPlaneMachineSetSpecFluent<?> fluent) {
    this(fluent, new ControlPlaneMachineSetSpec());
  }
  
  public ControlPlaneMachineSetSpecBuilder(ControlPlaneMachineSetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControlPlaneMachineSetSpecBuilder(ControlPlaneMachineSetSpecFluent<?> fluent,ControlPlaneMachineSetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControlPlaneMachineSetSpec build() {
    ControlPlaneMachineSetSpec buildable = new ControlPlaneMachineSetSpec(fluent.getMachineNamePrefix(), fluent.getReplicas(), fluent.buildSelector(), fluent.getState(), fluent.buildStrategy(), fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}