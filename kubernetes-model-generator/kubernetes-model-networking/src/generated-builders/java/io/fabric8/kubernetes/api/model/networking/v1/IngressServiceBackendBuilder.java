package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressServiceBackendBuilder extends IngressServiceBackendFluent<IngressServiceBackendBuilder> implements VisitableBuilder<IngressServiceBackend,IngressServiceBackendBuilder>{

  IngressServiceBackendFluent<?> fluent;

  public IngressServiceBackendBuilder() {
    this(new IngressServiceBackend());
  }
  
  public IngressServiceBackendBuilder(IngressServiceBackendFluent<?> fluent) {
    this(fluent, new IngressServiceBackend());
  }
  
  public IngressServiceBackendBuilder(IngressServiceBackend instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressServiceBackendBuilder(IngressServiceBackendFluent<?> fluent,IngressServiceBackend instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressServiceBackend build() {
    IngressServiceBackend buildable = new IngressServiceBackend(fluent.getName(), fluent.buildPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}