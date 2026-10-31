package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeAllocatableOverheadBuilder extends NodeAllocatableOverheadFluent<NodeAllocatableOverheadBuilder> implements VisitableBuilder<NodeAllocatableOverhead,NodeAllocatableOverheadBuilder>{

  NodeAllocatableOverheadFluent<?> fluent;

  public NodeAllocatableOverheadBuilder() {
    this(new NodeAllocatableOverhead());
  }
  
  public NodeAllocatableOverheadBuilder(NodeAllocatableOverheadFluent<?> fluent) {
    this(fluent, new NodeAllocatableOverhead());
  }
  
  public NodeAllocatableOverheadBuilder(NodeAllocatableOverhead instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeAllocatableOverheadBuilder(NodeAllocatableOverheadFluent<?> fluent,NodeAllocatableOverhead instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeAllocatableOverhead build() {
    NodeAllocatableOverhead buildable = new NodeAllocatableOverhead(fluent.getPerContainer(), fluent.getPerPod());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}