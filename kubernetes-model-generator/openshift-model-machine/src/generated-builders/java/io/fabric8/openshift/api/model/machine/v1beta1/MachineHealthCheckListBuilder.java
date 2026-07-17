package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineHealthCheckListBuilder extends MachineHealthCheckListFluent<MachineHealthCheckListBuilder> implements VisitableBuilder<MachineHealthCheckList,MachineHealthCheckListBuilder>{

  MachineHealthCheckListFluent<?> fluent;

  public MachineHealthCheckListBuilder() {
    this(new MachineHealthCheckList());
  }
  
  public MachineHealthCheckListBuilder(MachineHealthCheckListFluent<?> fluent) {
    this(fluent, new MachineHealthCheckList());
  }
  
  public MachineHealthCheckListBuilder(MachineHealthCheckList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineHealthCheckListBuilder(MachineHealthCheckListFluent<?> fluent,MachineHealthCheckList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineHealthCheckList build() {
    MachineHealthCheckList buildable = new MachineHealthCheckList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}