package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachinePoolListBuilder extends MachinePoolListFluent<MachinePoolListBuilder> implements VisitableBuilder<MachinePoolList,MachinePoolListBuilder>{

  MachinePoolListFluent<?> fluent;

  public MachinePoolListBuilder() {
    this(new MachinePoolList());
  }
  
  public MachinePoolListBuilder(MachinePoolListFluent<?> fluent) {
    this(fluent, new MachinePoolList());
  }
  
  public MachinePoolListBuilder(MachinePoolList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachinePoolListBuilder(MachinePoolListFluent<?> fluent,MachinePoolList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachinePoolList build() {
    MachinePoolList buildable = new MachinePoolList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}