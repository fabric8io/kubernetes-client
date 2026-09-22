package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateACMEARIStatusBuilder extends CertificateACMEARIStatusFluent<CertificateACMEARIStatusBuilder> implements VisitableBuilder<CertificateACMEARIStatus,CertificateACMEARIStatusBuilder>{

  CertificateACMEARIStatusFluent<?> fluent;

  public CertificateACMEARIStatusBuilder() {
    this(new CertificateACMEARIStatus());
  }
  
  public CertificateACMEARIStatusBuilder(CertificateACMEARIStatusFluent<?> fluent) {
    this(fluent, new CertificateACMEARIStatus());
  }
  
  public CertificateACMEARIStatusBuilder(CertificateACMEARIStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateACMEARIStatusBuilder(CertificateACMEARIStatusFluent<?> fluent,CertificateACMEARIStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateACMEARIStatus build() {
    CertificateACMEARIStatus buildable = new CertificateACMEARIStatus(fluent.getExplanationURL(), fluent.getLastChecked(), fluent.getLastError(), fluent.getNextCheck(), fluent.buildSuggestedWindow());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}