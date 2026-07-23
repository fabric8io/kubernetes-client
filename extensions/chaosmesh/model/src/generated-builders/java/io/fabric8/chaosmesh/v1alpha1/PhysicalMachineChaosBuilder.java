package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PhysicalMachineChaosBuilder extends PhysicalMachineChaosFluent<PhysicalMachineChaosBuilder> implements VisitableBuilder<PhysicalMachineChaos,PhysicalMachineChaosBuilder>{

  PhysicalMachineChaosFluent<?> fluent;

  public PhysicalMachineChaosBuilder() {
    this(new PhysicalMachineChaos());
  }
  
  public PhysicalMachineChaosBuilder(PhysicalMachineChaosFluent<?> fluent) {
    this(fluent, new PhysicalMachineChaos());
  }
  
  public PhysicalMachineChaosBuilder(PhysicalMachineChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PhysicalMachineChaosBuilder(PhysicalMachineChaosFluent<?> fluent,PhysicalMachineChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PhysicalMachineChaos build() {
    PhysicalMachineChaos buildable = new PhysicalMachineChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}