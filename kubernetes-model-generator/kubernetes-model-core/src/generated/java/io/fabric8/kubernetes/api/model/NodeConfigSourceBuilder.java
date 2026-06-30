package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeConfigSourceBuilder extends NodeConfigSourceFluent<NodeConfigSourceBuilder> implements VisitableBuilder<NodeConfigSource,NodeConfigSourceBuilder>{

  NodeConfigSourceFluent<?> fluent;

  public NodeConfigSourceBuilder() {
    this(new NodeConfigSource());
  }
  
  public NodeConfigSourceBuilder(NodeConfigSourceFluent<?> fluent) {
    this(fluent, new NodeConfigSource());
  }
  
  public NodeConfigSourceBuilder(NodeConfigSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeConfigSourceBuilder(NodeConfigSourceFluent<?> fluent,NodeConfigSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeConfigSource build() {
    NodeConfigSource buildable = new NodeConfigSource(fluent.buildConfigMap());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}