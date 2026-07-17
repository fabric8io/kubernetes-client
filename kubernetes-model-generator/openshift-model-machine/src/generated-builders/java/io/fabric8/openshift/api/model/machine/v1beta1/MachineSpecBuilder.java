package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineSpecBuilder extends MachineSpecFluent<MachineSpecBuilder> implements VisitableBuilder<MachineSpec,MachineSpecBuilder>{

  MachineSpecFluent<?> fluent;

  public MachineSpecBuilder() {
    this(new MachineSpec());
  }
  
  public MachineSpecBuilder(MachineSpecFluent<?> fluent) {
    this(fluent, new MachineSpec());
  }
  
  public MachineSpecBuilder(MachineSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineSpecBuilder(MachineSpecFluent<?> fluent,MachineSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineSpec build() {
    MachineSpec buildable = new MachineSpec(fluent.getAuthoritativeAPI(), fluent.buildLifecycleHooks(), fluent.buildMetadata(), fluent.getProviderID(), fluent.buildProviderSpec(), fluent.getTaints());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}