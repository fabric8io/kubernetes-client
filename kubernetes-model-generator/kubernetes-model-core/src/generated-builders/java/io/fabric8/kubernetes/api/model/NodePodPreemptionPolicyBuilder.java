package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodePodPreemptionPolicyBuilder extends NodePodPreemptionPolicyFluent<NodePodPreemptionPolicyBuilder> implements VisitableBuilder<NodePodPreemptionPolicy,NodePodPreemptionPolicyBuilder>{

  NodePodPreemptionPolicyFluent<?> fluent;

  public NodePodPreemptionPolicyBuilder() {
    this(new NodePodPreemptionPolicy());
  }
  
  public NodePodPreemptionPolicyBuilder(NodePodPreemptionPolicyFluent<?> fluent) {
    this(fluent, new NodePodPreemptionPolicy());
  }
  
  public NodePodPreemptionPolicyBuilder(NodePodPreemptionPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodePodPreemptionPolicyBuilder(NodePodPreemptionPolicyFluent<?> fluent,NodePodPreemptionPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodePodPreemptionPolicy build() {
    NodePodPreemptionPolicy buildable = new NodePodPreemptionPolicy(fluent.getDisableResizePreemption());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}