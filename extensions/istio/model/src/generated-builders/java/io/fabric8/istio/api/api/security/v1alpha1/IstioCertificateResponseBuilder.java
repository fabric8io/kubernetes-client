package io.fabric8.istio.api.api.security.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IstioCertificateResponseBuilder extends IstioCertificateResponseFluent<IstioCertificateResponseBuilder> implements VisitableBuilder<IstioCertificateResponse,IstioCertificateResponseBuilder>{

  IstioCertificateResponseFluent<?> fluent;

  public IstioCertificateResponseBuilder() {
    this(new IstioCertificateResponse());
  }
  
  public IstioCertificateResponseBuilder(IstioCertificateResponseFluent<?> fluent) {
    this(fluent, new IstioCertificateResponse());
  }
  
  public IstioCertificateResponseBuilder(IstioCertificateResponse instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IstioCertificateResponseBuilder(IstioCertificateResponseFluent<?> fluent,IstioCertificateResponse instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IstioCertificateResponse build() {
    IstioCertificateResponse buildable = new IstioCertificateResponse(fluent.getCertChain());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}