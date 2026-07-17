package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineListBuilder extends MachineListFluent<MachineListBuilder> implements VisitableBuilder<MachineList,MachineListBuilder>{

  MachineListFluent<?> fluent;

  public MachineListBuilder() {
    this(new MachineList());
  }
  
  public MachineListBuilder(MachineListFluent<?> fluent) {
    this(fluent, new MachineList());
  }
  
  public MachineListBuilder(MachineList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineListBuilder(MachineListFluent<?> fluent,MachineList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineList build() {
    MachineList buildable = new MachineList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}