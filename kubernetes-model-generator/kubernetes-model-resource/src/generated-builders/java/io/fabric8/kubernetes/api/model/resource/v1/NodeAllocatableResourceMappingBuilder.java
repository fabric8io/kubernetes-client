package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeAllocatableResourceMappingBuilder extends NodeAllocatableResourceMappingFluent<NodeAllocatableResourceMappingBuilder> implements VisitableBuilder<NodeAllocatableResourceMapping,NodeAllocatableResourceMappingBuilder>{

  NodeAllocatableResourceMappingFluent<?> fluent;

  public NodeAllocatableResourceMappingBuilder() {
    this(new NodeAllocatableResourceMapping());
  }
  
  public NodeAllocatableResourceMappingBuilder(NodeAllocatableResourceMappingFluent<?> fluent) {
    this(fluent, new NodeAllocatableResourceMapping());
  }
  
  public NodeAllocatableResourceMappingBuilder(NodeAllocatableResourceMapping instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeAllocatableResourceMappingBuilder(NodeAllocatableResourceMappingFluent<?> fluent,NodeAllocatableResourceMapping instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeAllocatableResourceMapping build() {
    NodeAllocatableResourceMapping buildable = new NodeAllocatableResourceMapping(fluent.getAllocationMultiplier(), fluent.getCapacityKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}