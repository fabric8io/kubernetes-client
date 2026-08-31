package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeAllocatableMappedResourcesBuilder extends NodeAllocatableMappedResourcesFluent<NodeAllocatableMappedResourcesBuilder> implements VisitableBuilder<NodeAllocatableMappedResources,NodeAllocatableMappedResourcesBuilder>{

  NodeAllocatableMappedResourcesFluent<?> fluent;

  public NodeAllocatableMappedResourcesBuilder() {
    this(new NodeAllocatableMappedResources());
  }
  
  public NodeAllocatableMappedResourcesBuilder(NodeAllocatableMappedResourcesFluent<?> fluent) {
    this(fluent, new NodeAllocatableMappedResources());
  }
  
  public NodeAllocatableMappedResourcesBuilder(NodeAllocatableMappedResources instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeAllocatableMappedResourcesBuilder(NodeAllocatableMappedResourcesFluent<?> fluent,NodeAllocatableMappedResources instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeAllocatableMappedResources build() {
    NodeAllocatableMappedResources buildable = new NodeAllocatableMappedResources(fluent.getName(), fluent.buildQuantity());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}