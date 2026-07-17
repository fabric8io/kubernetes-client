package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeDisruptionPolicySpecUnitBuilder extends NodeDisruptionPolicySpecUnitFluent<NodeDisruptionPolicySpecUnitBuilder> implements VisitableBuilder<NodeDisruptionPolicySpecUnit,NodeDisruptionPolicySpecUnitBuilder>{

  NodeDisruptionPolicySpecUnitFluent<?> fluent;

  public NodeDisruptionPolicySpecUnitBuilder() {
    this(new NodeDisruptionPolicySpecUnit());
  }
  
  public NodeDisruptionPolicySpecUnitBuilder(NodeDisruptionPolicySpecUnitFluent<?> fluent) {
    this(fluent, new NodeDisruptionPolicySpecUnit());
  }
  
  public NodeDisruptionPolicySpecUnitBuilder(NodeDisruptionPolicySpecUnit instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeDisruptionPolicySpecUnitBuilder(NodeDisruptionPolicySpecUnitFluent<?> fluent,NodeDisruptionPolicySpecUnit instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeDisruptionPolicySpecUnit build() {
    NodeDisruptionPolicySpecUnit buildable = new NodeDisruptionPolicySpecUnit(fluent.buildActions(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}