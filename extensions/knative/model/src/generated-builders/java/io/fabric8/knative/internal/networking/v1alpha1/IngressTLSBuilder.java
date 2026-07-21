package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressTLSBuilder extends IngressTLSFluent<IngressTLSBuilder> implements VisitableBuilder<IngressTLS,IngressTLSBuilder>{

  IngressTLSFluent<?> fluent;

  public IngressTLSBuilder() {
    this(new IngressTLS());
  }
  
  public IngressTLSBuilder(IngressTLSFluent<?> fluent) {
    this(fluent, new IngressTLS());
  }
  
  public IngressTLSBuilder(IngressTLS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressTLSBuilder(IngressTLSFluent<?> fluent,IngressTLS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressTLS build() {
    IngressTLS buildable = new IngressTLS(fluent.getHosts(), fluent.getSecretName(), fluent.getSecretNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}