package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeAllocatableResourceBuilder extends NodeAllocatableResourceFluent<NodeAllocatableResourceBuilder> implements VisitableBuilder<NodeAllocatableResource,NodeAllocatableResourceBuilder>{

  NodeAllocatableResourceFluent<?> fluent;

  public NodeAllocatableResourceBuilder() {
    this(new NodeAllocatableResource());
  }
  
  public NodeAllocatableResourceBuilder(NodeAllocatableResourceFluent<?> fluent) {
    this(fluent, new NodeAllocatableResource());
  }
  
  public NodeAllocatableResourceBuilder(NodeAllocatableResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeAllocatableResourceBuilder(NodeAllocatableResourceFluent<?> fluent,NodeAllocatableResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeAllocatableResource build() {
    NodeAllocatableResource buildable = new NodeAllocatableResource(fluent.buildMapping(), fluent.buildOverhead());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}