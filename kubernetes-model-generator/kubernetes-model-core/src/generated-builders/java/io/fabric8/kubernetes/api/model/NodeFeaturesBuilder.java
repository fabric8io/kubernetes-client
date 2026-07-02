package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeFeaturesBuilder extends NodeFeaturesFluent<NodeFeaturesBuilder> implements VisitableBuilder<NodeFeatures,NodeFeaturesBuilder>{

  NodeFeaturesFluent<?> fluent;

  public NodeFeaturesBuilder() {
    this(new NodeFeatures());
  }
  
  public NodeFeaturesBuilder(NodeFeaturesFluent<?> fluent) {
    this(fluent, new NodeFeatures());
  }
  
  public NodeFeaturesBuilder(NodeFeatures instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeFeaturesBuilder(NodeFeaturesFluent<?> fluent,NodeFeatures instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeFeatures build() {
    NodeFeatures buildable = new NodeFeatures(fluent.getSupplementalGroupsPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}