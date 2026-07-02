package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeAffinityBuilder extends NodeAffinityFluent<NodeAffinityBuilder> implements VisitableBuilder<NodeAffinity,NodeAffinityBuilder>{

  NodeAffinityFluent<?> fluent;

  public NodeAffinityBuilder() {
    this(new NodeAffinity());
  }
  
  public NodeAffinityBuilder(NodeAffinityFluent<?> fluent) {
    this(fluent, new NodeAffinity());
  }
  
  public NodeAffinityBuilder(NodeAffinity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeAffinityBuilder(NodeAffinityFluent<?> fluent,NodeAffinity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeAffinity build() {
    NodeAffinity buildable = new NodeAffinity(fluent.buildPreferredDuringSchedulingIgnoredDuringExecution(), fluent.buildRequiredDuringSchedulingIgnoredDuringExecution());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}