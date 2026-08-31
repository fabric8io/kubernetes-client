package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeAllocatableMappingBuilder extends NodeAllocatableMappingFluent<NodeAllocatableMappingBuilder> implements VisitableBuilder<NodeAllocatableMapping,NodeAllocatableMappingBuilder>{

  NodeAllocatableMappingFluent<?> fluent;

  public NodeAllocatableMappingBuilder() {
    this(new NodeAllocatableMapping());
  }
  
  public NodeAllocatableMappingBuilder(NodeAllocatableMappingFluent<?> fluent) {
    this(fluent, new NodeAllocatableMapping());
  }
  
  public NodeAllocatableMappingBuilder(NodeAllocatableMapping instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeAllocatableMappingBuilder(NodeAllocatableMappingFluent<?> fluent,NodeAllocatableMapping instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeAllocatableMapping build() {
    NodeAllocatableMapping buildable = new NodeAllocatableMapping(fluent.getCapacityKey(), fluent.getCapacityMultiplier(), fluent.getDeviceMultiplier());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}