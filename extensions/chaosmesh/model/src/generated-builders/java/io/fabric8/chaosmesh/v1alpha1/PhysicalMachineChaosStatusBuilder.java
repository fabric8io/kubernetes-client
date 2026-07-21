package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PhysicalMachineChaosStatusBuilder extends PhysicalMachineChaosStatusFluent<PhysicalMachineChaosStatusBuilder> implements VisitableBuilder<PhysicalMachineChaosStatus,PhysicalMachineChaosStatusBuilder>{

  PhysicalMachineChaosStatusFluent<?> fluent;

  public PhysicalMachineChaosStatusBuilder() {
    this(new PhysicalMachineChaosStatus());
  }
  
  public PhysicalMachineChaosStatusBuilder(PhysicalMachineChaosStatusFluent<?> fluent) {
    this(fluent, new PhysicalMachineChaosStatus());
  }
  
  public PhysicalMachineChaosStatusBuilder(PhysicalMachineChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PhysicalMachineChaosStatusBuilder(PhysicalMachineChaosStatusFluent<?> fluent,PhysicalMachineChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PhysicalMachineChaosStatus build() {
    PhysicalMachineChaosStatus buildable = new PhysicalMachineChaosStatus(fluent.buildConditions(), fluent.buildExperiment());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}