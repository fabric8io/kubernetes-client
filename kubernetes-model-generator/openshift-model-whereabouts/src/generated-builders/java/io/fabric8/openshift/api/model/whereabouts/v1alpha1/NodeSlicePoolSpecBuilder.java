package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeSlicePoolSpecBuilder extends NodeSlicePoolSpecFluent<NodeSlicePoolSpecBuilder> implements VisitableBuilder<NodeSlicePoolSpec,NodeSlicePoolSpecBuilder>{

  NodeSlicePoolSpecFluent<?> fluent;

  public NodeSlicePoolSpecBuilder() {
    this(new NodeSlicePoolSpec());
  }
  
  public NodeSlicePoolSpecBuilder(NodeSlicePoolSpecFluent<?> fluent) {
    this(fluent, new NodeSlicePoolSpec());
  }
  
  public NodeSlicePoolSpecBuilder(NodeSlicePoolSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeSlicePoolSpecBuilder(NodeSlicePoolSpecFluent<?> fluent,NodeSlicePoolSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeSlicePoolSpec build() {
    NodeSlicePoolSpec buildable = new NodeSlicePoolSpec(fluent.getRange(), fluent.getSliceSize());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}