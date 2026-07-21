package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PhysicalMachineChaosListBuilder extends PhysicalMachineChaosListFluent<PhysicalMachineChaosListBuilder> implements VisitableBuilder<PhysicalMachineChaosList,PhysicalMachineChaosListBuilder>{

  PhysicalMachineChaosListFluent<?> fluent;

  public PhysicalMachineChaosListBuilder() {
    this(new PhysicalMachineChaosList());
  }
  
  public PhysicalMachineChaosListBuilder(PhysicalMachineChaosListFluent<?> fluent) {
    this(fluent, new PhysicalMachineChaosList());
  }
  
  public PhysicalMachineChaosListBuilder(PhysicalMachineChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PhysicalMachineChaosListBuilder(PhysicalMachineChaosListFluent<?> fluent,PhysicalMachineChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PhysicalMachineChaosList build() {
    PhysicalMachineChaosList buildable = new PhysicalMachineChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}