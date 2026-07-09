package io.fabric8.kubernetes.api.model.networking.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressClassSpecBuilder extends IngressClassSpecFluent<IngressClassSpecBuilder> implements VisitableBuilder<IngressClassSpec,IngressClassSpecBuilder>{

  IngressClassSpecFluent<?> fluent;

  public IngressClassSpecBuilder() {
    this(new IngressClassSpec());
  }
  
  public IngressClassSpecBuilder(IngressClassSpecFluent<?> fluent) {
    this(fluent, new IngressClassSpec());
  }
  
  public IngressClassSpecBuilder(IngressClassSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressClassSpecBuilder(IngressClassSpecFluent<?> fluent,IngressClassSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressClassSpec build() {
    IngressClassSpec buildable = new IngressClassSpec(fluent.getController(), fluent.buildParameters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}