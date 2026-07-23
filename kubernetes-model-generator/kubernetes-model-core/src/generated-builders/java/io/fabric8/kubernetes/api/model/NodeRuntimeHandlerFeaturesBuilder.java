package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeRuntimeHandlerFeaturesBuilder extends NodeRuntimeHandlerFeaturesFluent<NodeRuntimeHandlerFeaturesBuilder> implements VisitableBuilder<NodeRuntimeHandlerFeatures,NodeRuntimeHandlerFeaturesBuilder>{

  NodeRuntimeHandlerFeaturesFluent<?> fluent;

  public NodeRuntimeHandlerFeaturesBuilder() {
    this(new NodeRuntimeHandlerFeatures());
  }
  
  public NodeRuntimeHandlerFeaturesBuilder(NodeRuntimeHandlerFeaturesFluent<?> fluent) {
    this(fluent, new NodeRuntimeHandlerFeatures());
  }
  
  public NodeRuntimeHandlerFeaturesBuilder(NodeRuntimeHandlerFeatures instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeRuntimeHandlerFeaturesBuilder(NodeRuntimeHandlerFeaturesFluent<?> fluent,NodeRuntimeHandlerFeatures instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeRuntimeHandlerFeatures build() {
    NodeRuntimeHandlerFeatures buildable = new NodeRuntimeHandlerFeatures(fluent.getRecursiveReadOnlyMounts(), fluent.getUserNamespaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}