package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeDisruptionPolicyConfigBuilder extends NodeDisruptionPolicyConfigFluent<NodeDisruptionPolicyConfigBuilder> implements VisitableBuilder<NodeDisruptionPolicyConfig,NodeDisruptionPolicyConfigBuilder>{

  NodeDisruptionPolicyConfigFluent<?> fluent;

  public NodeDisruptionPolicyConfigBuilder() {
    this(new NodeDisruptionPolicyConfig());
  }
  
  public NodeDisruptionPolicyConfigBuilder(NodeDisruptionPolicyConfigFluent<?> fluent) {
    this(fluent, new NodeDisruptionPolicyConfig());
  }
  
  public NodeDisruptionPolicyConfigBuilder(NodeDisruptionPolicyConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeDisruptionPolicyConfigBuilder(NodeDisruptionPolicyConfigFluent<?> fluent,NodeDisruptionPolicyConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeDisruptionPolicyConfig build() {
    NodeDisruptionPolicyConfig buildable = new NodeDisruptionPolicyConfig(fluent.buildFiles(), fluent.buildSshkey(), fluent.buildUnits());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}