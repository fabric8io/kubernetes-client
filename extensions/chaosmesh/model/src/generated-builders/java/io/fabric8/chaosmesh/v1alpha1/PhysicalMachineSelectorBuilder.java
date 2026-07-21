package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PhysicalMachineSelectorBuilder extends PhysicalMachineSelectorFluent<PhysicalMachineSelectorBuilder> implements VisitableBuilder<PhysicalMachineSelector,PhysicalMachineSelectorBuilder>{

  PhysicalMachineSelectorFluent<?> fluent;

  public PhysicalMachineSelectorBuilder() {
    this(new PhysicalMachineSelector());
  }
  
  public PhysicalMachineSelectorBuilder(PhysicalMachineSelectorFluent<?> fluent) {
    this(fluent, new PhysicalMachineSelector());
  }
  
  public PhysicalMachineSelectorBuilder(PhysicalMachineSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PhysicalMachineSelectorBuilder(PhysicalMachineSelectorFluent<?> fluent,PhysicalMachineSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PhysicalMachineSelector build() {
    PhysicalMachineSelector buildable = new PhysicalMachineSelector(fluent.getAddress(), fluent.getMode(), fluent.buildSelector(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}