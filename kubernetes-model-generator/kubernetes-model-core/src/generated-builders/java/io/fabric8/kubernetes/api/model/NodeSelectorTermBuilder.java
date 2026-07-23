package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeSelectorTermBuilder extends NodeSelectorTermFluent<NodeSelectorTermBuilder> implements VisitableBuilder<NodeSelectorTerm,NodeSelectorTermBuilder>{

  NodeSelectorTermFluent<?> fluent;

  public NodeSelectorTermBuilder() {
    this(new NodeSelectorTerm());
  }
  
  public NodeSelectorTermBuilder(NodeSelectorTermFluent<?> fluent) {
    this(fluent, new NodeSelectorTerm());
  }
  
  public NodeSelectorTermBuilder(NodeSelectorTerm instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeSelectorTermBuilder(NodeSelectorTermFluent<?> fluent,NodeSelectorTerm instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeSelectorTerm build() {
    NodeSelectorTerm buildable = new NodeSelectorTerm(fluent.buildMatchExpressions(), fluent.buildMatchFields());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}