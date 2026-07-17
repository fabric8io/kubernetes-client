package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineSetListBuilder extends MachineSetListFluent<MachineSetListBuilder> implements VisitableBuilder<MachineSetList,MachineSetListBuilder>{

  MachineSetListFluent<?> fluent;

  public MachineSetListBuilder() {
    this(new MachineSetList());
  }
  
  public MachineSetListBuilder(MachineSetListFluent<?> fluent) {
    this(fluent, new MachineSetList());
  }
  
  public MachineSetListBuilder(MachineSetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineSetListBuilder(MachineSetListFluent<?> fluent,MachineSetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineSetList build() {
    MachineSetList buildable = new MachineSetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}