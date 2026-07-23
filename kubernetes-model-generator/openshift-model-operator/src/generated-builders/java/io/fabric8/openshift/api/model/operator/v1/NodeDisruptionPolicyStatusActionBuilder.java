package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeDisruptionPolicyStatusActionBuilder extends NodeDisruptionPolicyStatusActionFluent<NodeDisruptionPolicyStatusActionBuilder> implements VisitableBuilder<NodeDisruptionPolicyStatusAction,NodeDisruptionPolicyStatusActionBuilder>{

  NodeDisruptionPolicyStatusActionFluent<?> fluent;

  public NodeDisruptionPolicyStatusActionBuilder() {
    this(new NodeDisruptionPolicyStatusAction());
  }
  
  public NodeDisruptionPolicyStatusActionBuilder(NodeDisruptionPolicyStatusActionFluent<?> fluent) {
    this(fluent, new NodeDisruptionPolicyStatusAction());
  }
  
  public NodeDisruptionPolicyStatusActionBuilder(NodeDisruptionPolicyStatusAction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeDisruptionPolicyStatusActionBuilder(NodeDisruptionPolicyStatusActionFluent<?> fluent,NodeDisruptionPolicyStatusAction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeDisruptionPolicyStatusAction build() {
    NodeDisruptionPolicyStatusAction buildable = new NodeDisruptionPolicyStatusAction(fluent.buildReload(), fluent.buildRestart(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}