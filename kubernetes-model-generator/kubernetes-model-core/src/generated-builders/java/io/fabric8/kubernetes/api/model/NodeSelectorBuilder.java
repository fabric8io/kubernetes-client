package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeSelectorBuilder extends NodeSelectorFluent<NodeSelectorBuilder> implements VisitableBuilder<NodeSelector,NodeSelectorBuilder>{

  NodeSelectorFluent<?> fluent;

  public NodeSelectorBuilder() {
    this(new NodeSelector());
  }
  
  public NodeSelectorBuilder(NodeSelectorFluent<?> fluent) {
    this(fluent, new NodeSelector());
  }
  
  public NodeSelectorBuilder(NodeSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeSelectorBuilder(NodeSelectorFluent<?> fluent,NodeSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeSelector build() {
    NodeSelector buildable = new NodeSelector(fluent.buildNodeSelectorTerms());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}