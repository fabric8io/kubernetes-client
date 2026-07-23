package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressBackendBuilder extends IngressBackendFluent<IngressBackendBuilder> implements VisitableBuilder<IngressBackend,IngressBackendBuilder>{

  IngressBackendFluent<?> fluent;

  public IngressBackendBuilder() {
    this(new IngressBackend());
  }
  
  public IngressBackendBuilder(IngressBackendFluent<?> fluent) {
    this(fluent, new IngressBackend());
  }
  
  public IngressBackendBuilder(IngressBackend instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressBackendBuilder(IngressBackendFluent<?> fluent,IngressBackend instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressBackend build() {
    IngressBackend buildable = new IngressBackend(fluent.getServiceName(), fluent.getServiceNamespace(), fluent.buildServicePort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}