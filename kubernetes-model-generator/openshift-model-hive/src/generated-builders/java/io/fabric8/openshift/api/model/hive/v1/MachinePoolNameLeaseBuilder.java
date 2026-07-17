package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachinePoolNameLeaseBuilder extends MachinePoolNameLeaseFluent<MachinePoolNameLeaseBuilder> implements VisitableBuilder<MachinePoolNameLease,MachinePoolNameLeaseBuilder>{

  MachinePoolNameLeaseFluent<?> fluent;

  public MachinePoolNameLeaseBuilder() {
    this(new MachinePoolNameLease());
  }
  
  public MachinePoolNameLeaseBuilder(MachinePoolNameLeaseFluent<?> fluent) {
    this(fluent, new MachinePoolNameLease());
  }
  
  public MachinePoolNameLeaseBuilder(MachinePoolNameLease instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachinePoolNameLeaseBuilder(MachinePoolNameLeaseFluent<?> fluent,MachinePoolNameLease instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachinePoolNameLease build() {
    MachinePoolNameLease buildable = new MachinePoolNameLease(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}