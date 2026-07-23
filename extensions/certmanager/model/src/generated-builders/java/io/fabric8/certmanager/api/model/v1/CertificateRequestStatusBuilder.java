package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateRequestStatusBuilder extends CertificateRequestStatusFluent<CertificateRequestStatusBuilder> implements VisitableBuilder<CertificateRequestStatus,CertificateRequestStatusBuilder>{

  CertificateRequestStatusFluent<?> fluent;

  public CertificateRequestStatusBuilder() {
    this(new CertificateRequestStatus());
  }
  
  public CertificateRequestStatusBuilder(CertificateRequestStatusFluent<?> fluent) {
    this(fluent, new CertificateRequestStatus());
  }
  
  public CertificateRequestStatusBuilder(CertificateRequestStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateRequestStatusBuilder(CertificateRequestStatusFluent<?> fluent,CertificateRequestStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateRequestStatus build() {
    CertificateRequestStatus buildable = new CertificateRequestStatus(fluent.getCa(), fluent.getCertificate(), fluent.buildConditions(), fluent.getFailureTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}