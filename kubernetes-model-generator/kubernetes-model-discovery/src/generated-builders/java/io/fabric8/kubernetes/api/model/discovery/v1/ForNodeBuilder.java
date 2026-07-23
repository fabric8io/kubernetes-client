package io.fabric8.kubernetes.api.model.discovery.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ForNodeBuilder extends ForNodeFluent<ForNodeBuilder> implements VisitableBuilder<ForNode,ForNodeBuilder>{

  ForNodeFluent<?> fluent;

  public ForNodeBuilder() {
    this(new ForNode());
  }
  
  public ForNodeBuilder(ForNodeFluent<?> fluent) {
    this(fluent, new ForNode());
  }
  
  public ForNodeBuilder(ForNode instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ForNodeBuilder(ForNodeFluent<?> fluent,ForNode instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ForNode build() {
    ForNode buildable = new ForNode(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}