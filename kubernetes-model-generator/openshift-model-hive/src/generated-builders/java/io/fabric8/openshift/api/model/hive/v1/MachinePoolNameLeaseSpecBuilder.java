package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachinePoolNameLeaseSpecBuilder extends MachinePoolNameLeaseSpecFluent<MachinePoolNameLeaseSpecBuilder> implements VisitableBuilder<MachinePoolNameLeaseSpec,MachinePoolNameLeaseSpecBuilder>{

  MachinePoolNameLeaseSpecFluent<?> fluent;

  public MachinePoolNameLeaseSpecBuilder() {
    this(new MachinePoolNameLeaseSpec());
  }
  
  public MachinePoolNameLeaseSpecBuilder(MachinePoolNameLeaseSpecFluent<?> fluent) {
    this(fluent, new MachinePoolNameLeaseSpec());
  }
  
  public MachinePoolNameLeaseSpecBuilder(MachinePoolNameLeaseSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachinePoolNameLeaseSpecBuilder(MachinePoolNameLeaseSpecFluent<?> fluent,MachinePoolNameLeaseSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachinePoolNameLeaseSpec build() {
    MachinePoolNameLeaseSpec buildable = new MachinePoolNameLeaseSpec();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}