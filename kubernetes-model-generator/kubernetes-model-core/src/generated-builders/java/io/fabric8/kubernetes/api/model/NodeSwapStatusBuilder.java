package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeSwapStatusBuilder extends NodeSwapStatusFluent<NodeSwapStatusBuilder> implements VisitableBuilder<NodeSwapStatus,NodeSwapStatusBuilder>{

  NodeSwapStatusFluent<?> fluent;

  public NodeSwapStatusBuilder() {
    this(new NodeSwapStatus());
  }
  
  public NodeSwapStatusBuilder(NodeSwapStatusFluent<?> fluent) {
    this(fluent, new NodeSwapStatus());
  }
  
  public NodeSwapStatusBuilder(NodeSwapStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeSwapStatusBuilder(NodeSwapStatusFluent<?> fluent,NodeSwapStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeSwapStatus build() {
    NodeSwapStatus buildable = new NodeSwapStatus(fluent.getCapacity());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}