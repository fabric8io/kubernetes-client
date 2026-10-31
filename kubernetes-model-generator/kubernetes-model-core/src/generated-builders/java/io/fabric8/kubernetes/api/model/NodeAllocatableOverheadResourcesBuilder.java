package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeAllocatableOverheadResourcesBuilder extends NodeAllocatableOverheadResourcesFluent<NodeAllocatableOverheadResourcesBuilder> implements VisitableBuilder<NodeAllocatableOverheadResources,NodeAllocatableOverheadResourcesBuilder>{

  NodeAllocatableOverheadResourcesFluent<?> fluent;

  public NodeAllocatableOverheadResourcesBuilder() {
    this(new NodeAllocatableOverheadResources());
  }
  
  public NodeAllocatableOverheadResourcesBuilder(NodeAllocatableOverheadResourcesFluent<?> fluent) {
    this(fluent, new NodeAllocatableOverheadResources());
  }
  
  public NodeAllocatableOverheadResourcesBuilder(NodeAllocatableOverheadResources instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeAllocatableOverheadResourcesBuilder(NodeAllocatableOverheadResourcesFluent<?> fluent,NodeAllocatableOverheadResources instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeAllocatableOverheadResources build() {
    NodeAllocatableOverheadResources buildable = new NodeAllocatableOverheadResources(fluent.getName(), fluent.buildPerContainer(), fluent.buildPerPod());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}