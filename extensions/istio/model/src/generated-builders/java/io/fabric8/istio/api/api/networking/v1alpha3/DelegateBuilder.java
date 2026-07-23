package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DelegateBuilder extends DelegateFluent<DelegateBuilder> implements VisitableBuilder<Delegate,DelegateBuilder>{

  DelegateFluent<?> fluent;

  public DelegateBuilder() {
    this(new Delegate());
  }
  
  public DelegateBuilder(DelegateFluent<?> fluent) {
    this(fluent, new Delegate());
  }
  
  public DelegateBuilder(Delegate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DelegateBuilder(DelegateFluent<?> fluent,Delegate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Delegate build() {
    Delegate buildable = new Delegate(fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}