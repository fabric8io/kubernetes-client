package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigNodeSpecBuilder extends MachineConfigNodeSpecFluent<MachineConfigNodeSpecBuilder> implements VisitableBuilder<MachineConfigNodeSpec,MachineConfigNodeSpecBuilder>{

  MachineConfigNodeSpecFluent<?> fluent;

  public MachineConfigNodeSpecBuilder() {
    this(new MachineConfigNodeSpec());
  }
  
  public MachineConfigNodeSpecBuilder(MachineConfigNodeSpecFluent<?> fluent) {
    this(fluent, new MachineConfigNodeSpec());
  }
  
  public MachineConfigNodeSpecBuilder(MachineConfigNodeSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigNodeSpecBuilder(MachineConfigNodeSpecFluent<?> fluent,MachineConfigNodeSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigNodeSpec build() {
    MachineConfigNodeSpec buildable = new MachineConfigNodeSpec(fluent.buildConfigVersion(), fluent.buildNode(), fluent.buildPool());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}