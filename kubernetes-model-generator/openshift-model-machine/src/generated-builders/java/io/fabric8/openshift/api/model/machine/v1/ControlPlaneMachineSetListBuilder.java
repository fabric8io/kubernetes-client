package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControlPlaneMachineSetListBuilder extends ControlPlaneMachineSetListFluent<ControlPlaneMachineSetListBuilder> implements VisitableBuilder<ControlPlaneMachineSetList,ControlPlaneMachineSetListBuilder>{

  ControlPlaneMachineSetListFluent<?> fluent;

  public ControlPlaneMachineSetListBuilder() {
    this(new ControlPlaneMachineSetList());
  }
  
  public ControlPlaneMachineSetListBuilder(ControlPlaneMachineSetListFluent<?> fluent) {
    this(fluent, new ControlPlaneMachineSetList());
  }
  
  public ControlPlaneMachineSetListBuilder(ControlPlaneMachineSetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControlPlaneMachineSetListBuilder(ControlPlaneMachineSetListFluent<?> fluent,ControlPlaneMachineSetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControlPlaneMachineSetList build() {
    ControlPlaneMachineSetList buildable = new ControlPlaneMachineSetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}