package io.fabric8.kubernetes.api.model.networking.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressClassBuilder extends IngressClassFluent<IngressClassBuilder> implements VisitableBuilder<IngressClass,IngressClassBuilder>{

  IngressClassFluent<?> fluent;

  public IngressClassBuilder() {
    this(new IngressClass());
  }
  
  public IngressClassBuilder(IngressClassFluent<?> fluent) {
    this(fluent, new IngressClass());
  }
  
  public IngressClassBuilder(IngressClass instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressClassBuilder(IngressClassFluent<?> fluent,IngressClass instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressClass build() {
    IngressClass buildable = new IngressClass(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}