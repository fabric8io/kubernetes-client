package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateACMEStatusBuilder extends CertificateACMEStatusFluent<CertificateACMEStatusBuilder> implements VisitableBuilder<CertificateACMEStatus,CertificateACMEStatusBuilder>{

  CertificateACMEStatusFluent<?> fluent;

  public CertificateACMEStatusBuilder() {
    this(new CertificateACMEStatus());
  }
  
  public CertificateACMEStatusBuilder(CertificateACMEStatusFluent<?> fluent) {
    this(fluent, new CertificateACMEStatus());
  }
  
  public CertificateACMEStatusBuilder(CertificateACMEStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateACMEStatusBuilder(CertificateACMEStatusFluent<?> fluent,CertificateACMEStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateACMEStatus build() {
    CertificateACMEStatus buildable = new CertificateACMEStatus(fluent.buildAri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}