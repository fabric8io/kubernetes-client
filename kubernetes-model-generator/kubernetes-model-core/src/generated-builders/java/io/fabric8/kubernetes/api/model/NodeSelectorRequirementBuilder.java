package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeSelectorRequirementBuilder extends NodeSelectorRequirementFluent<NodeSelectorRequirementBuilder> implements VisitableBuilder<NodeSelectorRequirement,NodeSelectorRequirementBuilder>{

  NodeSelectorRequirementFluent<?> fluent;

  public NodeSelectorRequirementBuilder() {
    this(new NodeSelectorRequirement());
  }
  
  public NodeSelectorRequirementBuilder(NodeSelectorRequirementFluent<?> fluent) {
    this(fluent, new NodeSelectorRequirement());
  }
  
  public NodeSelectorRequirementBuilder(NodeSelectorRequirement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeSelectorRequirementBuilder(NodeSelectorRequirementFluent<?> fluent,NodeSelectorRequirement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeSelectorRequirement build() {
    NodeSelectorRequirement buildable = new NodeSelectorRequirement(fluent.getKey(), fluent.getOperator(), fluent.getValues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}