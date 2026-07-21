package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PhysicalMachineSelectorSpecBuilder extends PhysicalMachineSelectorSpecFluent<PhysicalMachineSelectorSpecBuilder> implements VisitableBuilder<PhysicalMachineSelectorSpec,PhysicalMachineSelectorSpecBuilder>{

  PhysicalMachineSelectorSpecFluent<?> fluent;

  public PhysicalMachineSelectorSpecBuilder() {
    this(new PhysicalMachineSelectorSpec());
  }
  
  public PhysicalMachineSelectorSpecBuilder(PhysicalMachineSelectorSpecFluent<?> fluent) {
    this(fluent, new PhysicalMachineSelectorSpec());
  }
  
  public PhysicalMachineSelectorSpecBuilder(PhysicalMachineSelectorSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PhysicalMachineSelectorSpecBuilder(PhysicalMachineSelectorSpecFluent<?> fluent,PhysicalMachineSelectorSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PhysicalMachineSelectorSpec build() {
    PhysicalMachineSelectorSpec buildable = new PhysicalMachineSelectorSpec(fluent.getAnnotationSelectors(), fluent.getFieldSelectors(), fluent.getLabelSelectors(), fluent.getNamespaces(), fluent.getPhysicalMachines());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}