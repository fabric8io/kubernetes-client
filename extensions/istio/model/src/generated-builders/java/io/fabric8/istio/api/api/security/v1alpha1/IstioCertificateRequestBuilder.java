package io.fabric8.istio.api.api.security.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IstioCertificateRequestBuilder extends IstioCertificateRequestFluent<IstioCertificateRequestBuilder> implements VisitableBuilder<IstioCertificateRequest,IstioCertificateRequestBuilder>{

  IstioCertificateRequestFluent<?> fluent;

  public IstioCertificateRequestBuilder() {
    this(new IstioCertificateRequest());
  }
  
  public IstioCertificateRequestBuilder(IstioCertificateRequestFluent<?> fluent) {
    this(fluent, new IstioCertificateRequest());
  }
  
  public IstioCertificateRequestBuilder(IstioCertificateRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IstioCertificateRequestBuilder(IstioCertificateRequestFluent<?> fluent,IstioCertificateRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IstioCertificateRequest build() {
    IstioCertificateRequest buildable = new IstioCertificateRequest(fluent.getCsr(), fluent.getMetadata(), fluent.getValidityDuration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}