package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeDisruptionPolicyStatusBuilder extends NodeDisruptionPolicyStatusFluent<NodeDisruptionPolicyStatusBuilder> implements VisitableBuilder<NodeDisruptionPolicyStatus,NodeDisruptionPolicyStatusBuilder>{

  NodeDisruptionPolicyStatusFluent<?> fluent;

  public NodeDisruptionPolicyStatusBuilder() {
    this(new NodeDisruptionPolicyStatus());
  }
  
  public NodeDisruptionPolicyStatusBuilder(NodeDisruptionPolicyStatusFluent<?> fluent) {
    this(fluent, new NodeDisruptionPolicyStatus());
  }
  
  public NodeDisruptionPolicyStatusBuilder(NodeDisruptionPolicyStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeDisruptionPolicyStatusBuilder(NodeDisruptionPolicyStatusFluent<?> fluent,NodeDisruptionPolicyStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeDisruptionPolicyStatus build() {
    NodeDisruptionPolicyStatus buildable = new NodeDisruptionPolicyStatus(fluent.buildClusterPolicies());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}