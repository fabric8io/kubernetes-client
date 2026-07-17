package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeSlicePoolBuilder extends NodeSlicePoolFluent<NodeSlicePoolBuilder> implements VisitableBuilder<NodeSlicePool,NodeSlicePoolBuilder>{

  NodeSlicePoolFluent<?> fluent;

  public NodeSlicePoolBuilder() {
    this(new NodeSlicePool());
  }
  
  public NodeSlicePoolBuilder(NodeSlicePoolFluent<?> fluent) {
    this(fluent, new NodeSlicePool());
  }
  
  public NodeSlicePoolBuilder(NodeSlicePool instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeSlicePoolBuilder(NodeSlicePoolFluent<?> fluent,NodeSlicePool instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeSlicePool build() {
    NodeSlicePool buildable = new NodeSlicePool(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}