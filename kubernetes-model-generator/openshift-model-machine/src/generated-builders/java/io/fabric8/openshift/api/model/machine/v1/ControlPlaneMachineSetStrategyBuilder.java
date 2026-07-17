package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControlPlaneMachineSetStrategyBuilder extends ControlPlaneMachineSetStrategyFluent<ControlPlaneMachineSetStrategyBuilder> implements VisitableBuilder<ControlPlaneMachineSetStrategy,ControlPlaneMachineSetStrategyBuilder>{

  ControlPlaneMachineSetStrategyFluent<?> fluent;

  public ControlPlaneMachineSetStrategyBuilder() {
    this(new ControlPlaneMachineSetStrategy());
  }
  
  public ControlPlaneMachineSetStrategyBuilder(ControlPlaneMachineSetStrategyFluent<?> fluent) {
    this(fluent, new ControlPlaneMachineSetStrategy());
  }
  
  public ControlPlaneMachineSetStrategyBuilder(ControlPlaneMachineSetStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControlPlaneMachineSetStrategyBuilder(ControlPlaneMachineSetStrategyFluent<?> fluent,ControlPlaneMachineSetStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControlPlaneMachineSetStrategy build() {
    ControlPlaneMachineSetStrategy buildable = new ControlPlaneMachineSetStrategy(fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}