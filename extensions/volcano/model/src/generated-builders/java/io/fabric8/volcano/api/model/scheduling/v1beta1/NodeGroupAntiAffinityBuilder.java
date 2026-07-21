package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeGroupAntiAffinityBuilder extends NodeGroupAntiAffinityFluent<NodeGroupAntiAffinityBuilder> implements VisitableBuilder<NodeGroupAntiAffinity,NodeGroupAntiAffinityBuilder>{

  NodeGroupAntiAffinityFluent<?> fluent;

  public NodeGroupAntiAffinityBuilder() {
    this(new NodeGroupAntiAffinity());
  }
  
  public NodeGroupAntiAffinityBuilder(NodeGroupAntiAffinityFluent<?> fluent) {
    this(fluent, new NodeGroupAntiAffinity());
  }
  
  public NodeGroupAntiAffinityBuilder(NodeGroupAntiAffinity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeGroupAntiAffinityBuilder(NodeGroupAntiAffinityFluent<?> fluent,NodeGroupAntiAffinity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeGroupAntiAffinity build() {
    NodeGroupAntiAffinity buildable = new NodeGroupAntiAffinity(fluent.getPreferredDuringSchedulingIgnoredDuringExecution(), fluent.getRequiredDuringSchedulingIgnoredDuringExecution());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}