package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EvictionResponderBuilder extends EvictionResponderFluent<EvictionResponderBuilder> implements VisitableBuilder<EvictionResponder,EvictionResponderBuilder>{

  EvictionResponderFluent<?> fluent;

  public EvictionResponderBuilder() {
    this(new EvictionResponder());
  }
  
  public EvictionResponderBuilder(EvictionResponderFluent<?> fluent) {
    this(fluent, new EvictionResponder());
  }
  
  public EvictionResponderBuilder(EvictionResponder instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EvictionResponderBuilder(EvictionResponderFluent<?> fluent,EvictionResponder instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EvictionResponder build() {
    EvictionResponder buildable = new EvictionResponder(fluent.getName(), fluent.getPriority());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}