package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TopologySelectorTermBuilder extends TopologySelectorTermFluent<TopologySelectorTermBuilder> implements VisitableBuilder<TopologySelectorTerm,TopologySelectorTermBuilder>{

  TopologySelectorTermFluent<?> fluent;

  public TopologySelectorTermBuilder() {
    this(new TopologySelectorTerm());
  }
  
  public TopologySelectorTermBuilder(TopologySelectorTermFluent<?> fluent) {
    this(fluent, new TopologySelectorTerm());
  }
  
  public TopologySelectorTermBuilder(TopologySelectorTerm instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TopologySelectorTermBuilder(TopologySelectorTermFluent<?> fluent,TopologySelectorTerm instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TopologySelectorTerm build() {
    TopologySelectorTerm buildable = new TopologySelectorTerm(fluent.buildMatchLabelExpressions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}