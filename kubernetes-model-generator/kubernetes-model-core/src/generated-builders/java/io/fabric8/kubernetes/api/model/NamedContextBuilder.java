package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedContextBuilder extends NamedContextFluent<NamedContextBuilder> implements VisitableBuilder<NamedContext,NamedContextBuilder>{

  NamedContextFluent<?> fluent;

  public NamedContextBuilder() {
    this(new NamedContext());
  }
  
  public NamedContextBuilder(NamedContextFluent<?> fluent) {
    this(fluent, new NamedContext());
  }
  
  public NamedContextBuilder(NamedContext instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedContextBuilder(NamedContextFluent<?> fluent,NamedContext instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedContext build() {
    NamedContext buildable = new NamedContext(fluent.buildContext(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}