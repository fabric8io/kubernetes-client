package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeSlicePoolStatusAllocationsBuilder extends NodeSlicePoolStatusAllocationsFluent<NodeSlicePoolStatusAllocationsBuilder> implements VisitableBuilder<NodeSlicePoolStatusAllocations,NodeSlicePoolStatusAllocationsBuilder>{

  NodeSlicePoolStatusAllocationsFluent<?> fluent;

  public NodeSlicePoolStatusAllocationsBuilder() {
    this(new NodeSlicePoolStatusAllocations());
  }
  
  public NodeSlicePoolStatusAllocationsBuilder(NodeSlicePoolStatusAllocationsFluent<?> fluent) {
    this(fluent, new NodeSlicePoolStatusAllocations());
  }
  
  public NodeSlicePoolStatusAllocationsBuilder(NodeSlicePoolStatusAllocations instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeSlicePoolStatusAllocationsBuilder(NodeSlicePoolStatusAllocationsFluent<?> fluent,NodeSlicePoolStatusAllocations instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeSlicePoolStatusAllocations build() {
    NodeSlicePoolStatusAllocations buildable = new NodeSlicePoolStatusAllocations(fluent.getNodeName(), fluent.getSliceRange());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}