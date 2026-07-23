package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PhysicalMachineSpecBuilder extends PhysicalMachineSpecFluent<PhysicalMachineSpecBuilder> implements VisitableBuilder<PhysicalMachineSpec,PhysicalMachineSpecBuilder>{

  PhysicalMachineSpecFluent<?> fluent;

  public PhysicalMachineSpecBuilder() {
    this(new PhysicalMachineSpec());
  }
  
  public PhysicalMachineSpecBuilder(PhysicalMachineSpecFluent<?> fluent) {
    this(fluent, new PhysicalMachineSpec());
  }
  
  public PhysicalMachineSpecBuilder(PhysicalMachineSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PhysicalMachineSpecBuilder(PhysicalMachineSpecFluent<?> fluent,PhysicalMachineSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PhysicalMachineSpec build() {
    PhysicalMachineSpec buildable = new PhysicalMachineSpec(fluent.getAddress());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}