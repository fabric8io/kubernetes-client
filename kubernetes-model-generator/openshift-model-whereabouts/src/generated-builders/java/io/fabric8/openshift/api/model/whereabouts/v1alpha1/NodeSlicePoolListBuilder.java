package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeSlicePoolListBuilder extends NodeSlicePoolListFluent<NodeSlicePoolListBuilder> implements VisitableBuilder<NodeSlicePoolList,NodeSlicePoolListBuilder>{

  NodeSlicePoolListFluent<?> fluent;

  public NodeSlicePoolListBuilder() {
    this(new NodeSlicePoolList());
  }
  
  public NodeSlicePoolListBuilder(NodeSlicePoolListFluent<?> fluent) {
    this(fluent, new NodeSlicePoolList());
  }
  
  public NodeSlicePoolListBuilder(NodeSlicePoolList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeSlicePoolListBuilder(NodeSlicePoolListFluent<?> fluent,NodeSlicePoolList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeSlicePoolList build() {
    NodeSlicePoolList buildable = new NodeSlicePoolList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}