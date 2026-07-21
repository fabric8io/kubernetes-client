package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PhysicalMachineBuilder extends PhysicalMachineFluent<PhysicalMachineBuilder> implements VisitableBuilder<PhysicalMachine,PhysicalMachineBuilder>{

  PhysicalMachineFluent<?> fluent;

  public PhysicalMachineBuilder() {
    this(new PhysicalMachine());
  }
  
  public PhysicalMachineBuilder(PhysicalMachineFluent<?> fluent) {
    this(fluent, new PhysicalMachine());
  }
  
  public PhysicalMachineBuilder(PhysicalMachine instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PhysicalMachineBuilder(PhysicalMachineFluent<?> fluent,PhysicalMachine instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PhysicalMachine build() {
    PhysicalMachine buildable = new PhysicalMachine(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}