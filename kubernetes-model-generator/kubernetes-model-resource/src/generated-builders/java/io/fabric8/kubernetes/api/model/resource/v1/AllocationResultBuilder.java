package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AllocationResultBuilder extends AllocationResultFluent<AllocationResultBuilder> implements VisitableBuilder<AllocationResult,AllocationResultBuilder>{

  AllocationResultFluent<?> fluent;

  public AllocationResultBuilder() {
    this(new AllocationResult());
  }
  
  public AllocationResultBuilder(AllocationResultFluent<?> fluent) {
    this(fluent, new AllocationResult());
  }
  
  public AllocationResultBuilder(AllocationResult instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AllocationResultBuilder(AllocationResultFluent<?> fluent,AllocationResult instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AllocationResult build() {
    AllocationResult buildable = new AllocationResult(fluent.getAllocationTimestamp(), fluent.buildDevices(), fluent.getNodeSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}