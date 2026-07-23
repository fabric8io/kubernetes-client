package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PhysicalMachineListBuilder extends PhysicalMachineListFluent<PhysicalMachineListBuilder> implements VisitableBuilder<PhysicalMachineList,PhysicalMachineListBuilder>{

  PhysicalMachineListFluent<?> fluent;

  public PhysicalMachineListBuilder() {
    this(new PhysicalMachineList());
  }
  
  public PhysicalMachineListBuilder(PhysicalMachineListFluent<?> fluent) {
    this(fluent, new PhysicalMachineList());
  }
  
  public PhysicalMachineListBuilder(PhysicalMachineList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PhysicalMachineListBuilder(PhysicalMachineListFluent<?> fluent,PhysicalMachineList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PhysicalMachineList build() {
    PhysicalMachineList buildable = new PhysicalMachineList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}