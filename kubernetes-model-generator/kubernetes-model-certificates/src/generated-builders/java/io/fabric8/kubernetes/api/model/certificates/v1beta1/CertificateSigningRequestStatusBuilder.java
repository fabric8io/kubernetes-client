package io.fabric8.kubernetes.api.model.certificates.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateSigningRequestStatusBuilder extends CertificateSigningRequestStatusFluent<CertificateSigningRequestStatusBuilder> implements VisitableBuilder<CertificateSigningRequestStatus,CertificateSigningRequestStatusBuilder>{

  CertificateSigningRequestStatusFluent<?> fluent;

  public CertificateSigningRequestStatusBuilder() {
    this(new CertificateSigningRequestStatus());
  }
  
  public CertificateSigningRequestStatusBuilder(CertificateSigningRequestStatusFluent<?> fluent) {
    this(fluent, new CertificateSigningRequestStatus());
  }
  
  public CertificateSigningRequestStatusBuilder(CertificateSigningRequestStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateSigningRequestStatusBuilder(CertificateSigningRequestStatusFluent<?> fluent,CertificateSigningRequestStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateSigningRequestStatus build() {
    CertificateSigningRequestStatus buildable = new CertificateSigningRequestStatus(fluent.getCertificate(), fluent.buildConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}