package io.fabric8.kubernetes.api.model.certificates.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateSigningRequestBuilder extends CertificateSigningRequestFluent<CertificateSigningRequestBuilder> implements VisitableBuilder<CertificateSigningRequest,CertificateSigningRequestBuilder>{

  CertificateSigningRequestFluent<?> fluent;

  public CertificateSigningRequestBuilder() {
    this(new CertificateSigningRequest());
  }
  
  public CertificateSigningRequestBuilder(CertificateSigningRequestFluent<?> fluent) {
    this(fluent, new CertificateSigningRequest());
  }
  
  public CertificateSigningRequestBuilder(CertificateSigningRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateSigningRequestBuilder(CertificateSigningRequestFluent<?> fluent,CertificateSigningRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateSigningRequest build() {
    CertificateSigningRequest buildable = new CertificateSigningRequest(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}