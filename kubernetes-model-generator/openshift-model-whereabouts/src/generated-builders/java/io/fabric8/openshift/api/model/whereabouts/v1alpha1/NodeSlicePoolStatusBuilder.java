package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeSlicePoolStatusBuilder extends NodeSlicePoolStatusFluent<NodeSlicePoolStatusBuilder> implements VisitableBuilder<NodeSlicePoolStatus,NodeSlicePoolStatusBuilder>{

  NodeSlicePoolStatusFluent<?> fluent;

  public NodeSlicePoolStatusBuilder() {
    this(new NodeSlicePoolStatus());
  }
  
  public NodeSlicePoolStatusBuilder(NodeSlicePoolStatusFluent<?> fluent) {
    this(fluent, new NodeSlicePoolStatus());
  }
  
  public NodeSlicePoolStatusBuilder(NodeSlicePoolStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeSlicePoolStatusBuilder(NodeSlicePoolStatusFluent<?> fluent,NodeSlicePoolStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeSlicePoolStatus build() {
    NodeSlicePoolStatus buildable = new NodeSlicePoolStatus(fluent.buildAllocations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}