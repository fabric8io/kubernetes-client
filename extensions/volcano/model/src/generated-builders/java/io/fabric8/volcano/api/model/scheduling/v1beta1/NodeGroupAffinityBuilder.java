package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeGroupAffinityBuilder extends NodeGroupAffinityFluent<NodeGroupAffinityBuilder> implements VisitableBuilder<NodeGroupAffinity,NodeGroupAffinityBuilder>{

  NodeGroupAffinityFluent<?> fluent;

  public NodeGroupAffinityBuilder() {
    this(new NodeGroupAffinity());
  }
  
  public NodeGroupAffinityBuilder(NodeGroupAffinityFluent<?> fluent) {
    this(fluent, new NodeGroupAffinity());
  }
  
  public NodeGroupAffinityBuilder(NodeGroupAffinity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeGroupAffinityBuilder(NodeGroupAffinityFluent<?> fluent,NodeGroupAffinity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeGroupAffinity build() {
    NodeGroupAffinity buildable = new NodeGroupAffinity(fluent.getPreferredDuringSchedulingIgnoredDuringExecution(), fluent.getRequiredDuringSchedulingIgnoredDuringExecution());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}