package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachinePoolNameLeaseListBuilder extends MachinePoolNameLeaseListFluent<MachinePoolNameLeaseListBuilder> implements VisitableBuilder<MachinePoolNameLeaseList,MachinePoolNameLeaseListBuilder>{

  MachinePoolNameLeaseListFluent<?> fluent;

  public MachinePoolNameLeaseListBuilder() {
    this(new MachinePoolNameLeaseList());
  }
  
  public MachinePoolNameLeaseListBuilder(MachinePoolNameLeaseListFluent<?> fluent) {
    this(fluent, new MachinePoolNameLeaseList());
  }
  
  public MachinePoolNameLeaseListBuilder(MachinePoolNameLeaseList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachinePoolNameLeaseListBuilder(MachinePoolNameLeaseListFluent<?> fluent,MachinePoolNameLeaseList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachinePoolNameLeaseList build() {
    MachinePoolNameLeaseList buildable = new MachinePoolNameLeaseList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}