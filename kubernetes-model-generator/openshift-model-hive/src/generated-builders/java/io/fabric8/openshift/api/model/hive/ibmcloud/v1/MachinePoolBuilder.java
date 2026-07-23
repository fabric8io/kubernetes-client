package io.fabric8.openshift.api.model.hive.ibmcloud.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachinePoolBuilder extends MachinePoolFluent<MachinePoolBuilder> implements VisitableBuilder<MachinePool,MachinePoolBuilder>{

  MachinePoolFluent<?> fluent;

  public MachinePoolBuilder() {
    this(new MachinePool());
  }
  
  public MachinePoolBuilder(MachinePoolFluent<?> fluent) {
    this(fluent, new MachinePool());
  }
  
  public MachinePoolBuilder(MachinePool instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachinePoolBuilder(MachinePoolFluent<?> fluent,MachinePool instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachinePool build() {
    MachinePool buildable = new MachinePool(fluent.buildBootVolume(), fluent.buildDedicatedHosts(), fluent.getType(), fluent.getZones());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}