package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControlPlaneMachineSetBuilder extends ControlPlaneMachineSetFluent<ControlPlaneMachineSetBuilder> implements VisitableBuilder<ControlPlaneMachineSet,ControlPlaneMachineSetBuilder>{

  ControlPlaneMachineSetFluent<?> fluent;

  public ControlPlaneMachineSetBuilder() {
    this(new ControlPlaneMachineSet());
  }
  
  public ControlPlaneMachineSetBuilder(ControlPlaneMachineSetFluent<?> fluent) {
    this(fluent, new ControlPlaneMachineSet());
  }
  
  public ControlPlaneMachineSetBuilder(ControlPlaneMachineSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControlPlaneMachineSetBuilder(ControlPlaneMachineSetFluent<?> fluent,ControlPlaneMachineSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControlPlaneMachineSet build() {
    ControlPlaneMachineSet buildable = new ControlPlaneMachineSet(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}