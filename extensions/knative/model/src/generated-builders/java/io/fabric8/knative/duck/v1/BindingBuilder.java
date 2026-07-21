package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BindingBuilder extends BindingFluent<BindingBuilder> implements VisitableBuilder<Binding,BindingBuilder>{

  BindingFluent<?> fluent;

  public BindingBuilder() {
    this(new Binding());
  }
  
  public BindingBuilder(BindingFluent<?> fluent) {
    this(fluent, new Binding());
  }
  
  public BindingBuilder(Binding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BindingBuilder(BindingFluent<?> fluent,Binding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Binding build() {
    Binding buildable = new Binding(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}