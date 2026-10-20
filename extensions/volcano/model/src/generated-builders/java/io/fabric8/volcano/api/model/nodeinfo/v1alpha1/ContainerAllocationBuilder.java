package io.fabric8.volcano.api.model.nodeinfo.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerAllocationBuilder extends ContainerAllocationFluent<ContainerAllocationBuilder> implements VisitableBuilder<ContainerAllocation,ContainerAllocationBuilder>{

  ContainerAllocationFluent<?> fluent;

  public ContainerAllocationBuilder() {
    this(new ContainerAllocation());
  }
  
  public ContainerAllocationBuilder(ContainerAllocationFluent<?> fluent) {
    this(fluent, new ContainerAllocation());
  }
  
  public ContainerAllocationBuilder(ContainerAllocation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerAllocationBuilder(ContainerAllocationFluent<?> fluent,ContainerAllocation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerAllocation build() {
    ContainerAllocation buildable = new ContainerAllocation(fluent.getAllocations(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}