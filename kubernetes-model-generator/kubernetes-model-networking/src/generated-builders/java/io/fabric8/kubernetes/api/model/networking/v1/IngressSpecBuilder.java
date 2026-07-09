package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressSpecBuilder extends IngressSpecFluent<IngressSpecBuilder> implements VisitableBuilder<IngressSpec,IngressSpecBuilder>{

  IngressSpecFluent<?> fluent;

  public IngressSpecBuilder() {
    this(new IngressSpec());
  }
  
  public IngressSpecBuilder(IngressSpecFluent<?> fluent) {
    this(fluent, new IngressSpec());
  }
  
  public IngressSpecBuilder(IngressSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressSpecBuilder(IngressSpecFluent<?> fluent,IngressSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressSpec build() {
    IngressSpec buildable = new IngressSpec(fluent.buildDefaultBackend(), fluent.getIngressClassName(), fluent.buildRules(), fluent.buildTls());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}