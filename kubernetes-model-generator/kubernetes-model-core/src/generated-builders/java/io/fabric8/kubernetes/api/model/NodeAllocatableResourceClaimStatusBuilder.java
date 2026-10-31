package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeAllocatableResourceClaimStatusBuilder extends NodeAllocatableResourceClaimStatusFluent<NodeAllocatableResourceClaimStatusBuilder> implements VisitableBuilder<NodeAllocatableResourceClaimStatus,NodeAllocatableResourceClaimStatusBuilder>{

  NodeAllocatableResourceClaimStatusFluent<?> fluent;

  public NodeAllocatableResourceClaimStatusBuilder() {
    this(new NodeAllocatableResourceClaimStatus());
  }
  
  public NodeAllocatableResourceClaimStatusBuilder(NodeAllocatableResourceClaimStatusFluent<?> fluent) {
    this(fluent, new NodeAllocatableResourceClaimStatus());
  }
  
  public NodeAllocatableResourceClaimStatusBuilder(NodeAllocatableResourceClaimStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeAllocatableResourceClaimStatusBuilder(NodeAllocatableResourceClaimStatusFluent<?> fluent,NodeAllocatableResourceClaimStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeAllocatableResourceClaimStatus build() {
    NodeAllocatableResourceClaimStatus buildable = new NodeAllocatableResourceClaimStatus(fluent.getContainers(), fluent.buildMapping(), fluent.buildOverhead(), fluent.getResourceClaimName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}