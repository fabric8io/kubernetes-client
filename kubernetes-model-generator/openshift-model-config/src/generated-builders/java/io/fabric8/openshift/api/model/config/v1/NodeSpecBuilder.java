package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeSpecBuilder extends NodeSpecFluent<NodeSpecBuilder> implements VisitableBuilder<NodeSpec,NodeSpecBuilder>{

  NodeSpecFluent<?> fluent;

  public NodeSpecBuilder() {
    this(new NodeSpec());
  }
  
  public NodeSpecBuilder(NodeSpecFluent<?> fluent) {
    this(fluent, new NodeSpec());
  }
  
  public NodeSpecBuilder(NodeSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeSpecBuilder(NodeSpecFluent<?> fluent,NodeSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeSpec build() {
    NodeSpec buildable = new NodeSpec(fluent.getCgroupMode(), fluent.getMinimumKubeletVersion(), fluent.getWorkerLatencyProfile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}