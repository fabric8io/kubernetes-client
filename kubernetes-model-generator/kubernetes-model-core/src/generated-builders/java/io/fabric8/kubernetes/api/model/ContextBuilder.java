package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContextBuilder extends ContextFluent<ContextBuilder> implements VisitableBuilder<Context,ContextBuilder>{

  ContextFluent<?> fluent;

  public ContextBuilder() {
    this(new Context());
  }
  
  public ContextBuilder(ContextFluent<?> fluent) {
    this(fluent, new Context());
  }
  
  public ContextBuilder(Context instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContextBuilder(ContextFluent<?> fluent,Context instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Context build() {
    Context buildable = new Context(fluent.getCluster(), fluent.buildExtensions(), fluent.getNamespace(), fluent.getUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}