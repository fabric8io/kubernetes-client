package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateRenewalBuilder extends CertificateRenewalFluent<CertificateRenewalBuilder> implements VisitableBuilder<CertificateRenewal,CertificateRenewalBuilder>{

  CertificateRenewalFluent<?> fluent;

  public CertificateRenewalBuilder() {
    this(new CertificateRenewal());
  }
  
  public CertificateRenewalBuilder(CertificateRenewalFluent<?> fluent) {
    this(fluent, new CertificateRenewal());
  }
  
  public CertificateRenewalBuilder(CertificateRenewal instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateRenewalBuilder(CertificateRenewalFluent<?> fluent,CertificateRenewal instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateRenewal build() {
    CertificateRenewal buildable = new CertificateRenewal(fluent.getPolicy(), fluent.buildWindows());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}