package io.fabric8.volcano.api.model.nodeinfo.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodAllocationBuilder extends PodAllocationFluent<PodAllocationBuilder> implements VisitableBuilder<PodAllocation,PodAllocationBuilder>{

  PodAllocationFluent<?> fluent;

  public PodAllocationBuilder() {
    this(new PodAllocation());
  }
  
  public PodAllocationBuilder(PodAllocationFluent<?> fluent) {
    this(fluent, new PodAllocation());
  }
  
  public PodAllocationBuilder(PodAllocation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodAllocationBuilder(PodAllocationFluent<?> fluent,PodAllocation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodAllocation build() {
    PodAllocation buildable = new PodAllocation(fluent.buildContainerAllocations(), fluent.getName(), fluent.getNamespace(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}