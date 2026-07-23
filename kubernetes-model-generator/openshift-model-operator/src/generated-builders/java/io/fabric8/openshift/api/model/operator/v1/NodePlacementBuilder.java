package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodePlacementBuilder extends NodePlacementFluent<NodePlacementBuilder> implements VisitableBuilder<NodePlacement,NodePlacementBuilder>{

  NodePlacementFluent<?> fluent;

  public NodePlacementBuilder() {
    this(new NodePlacement());
  }
  
  public NodePlacementBuilder(NodePlacementFluent<?> fluent) {
    this(fluent, new NodePlacement());
  }
  
  public NodePlacementBuilder(NodePlacement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodePlacementBuilder(NodePlacementFluent<?> fluent,NodePlacement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodePlacement build() {
    NodePlacement buildable = new NodePlacement(fluent.buildNodeSelector(), fluent.getTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}