package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeDisruptionPolicyStatusUnitBuilder extends NodeDisruptionPolicyStatusUnitFluent<NodeDisruptionPolicyStatusUnitBuilder> implements VisitableBuilder<NodeDisruptionPolicyStatusUnit,NodeDisruptionPolicyStatusUnitBuilder>{

  NodeDisruptionPolicyStatusUnitFluent<?> fluent;

  public NodeDisruptionPolicyStatusUnitBuilder() {
    this(new NodeDisruptionPolicyStatusUnit());
  }
  
  public NodeDisruptionPolicyStatusUnitBuilder(NodeDisruptionPolicyStatusUnitFluent<?> fluent) {
    this(fluent, new NodeDisruptionPolicyStatusUnit());
  }
  
  public NodeDisruptionPolicyStatusUnitBuilder(NodeDisruptionPolicyStatusUnit instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeDisruptionPolicyStatusUnitBuilder(NodeDisruptionPolicyStatusUnitFluent<?> fluent,NodeDisruptionPolicyStatusUnit instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeDisruptionPolicyStatusUnit build() {
    NodeDisruptionPolicyStatusUnit buildable = new NodeDisruptionPolicyStatusUnit(fluent.buildActions(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}