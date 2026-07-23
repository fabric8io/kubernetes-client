package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateStatusBuilder extends CertificateStatusFluent<CertificateStatusBuilder> implements VisitableBuilder<CertificateStatus,CertificateStatusBuilder>{

  CertificateStatusFluent<?> fluent;

  public CertificateStatusBuilder() {
    this(new CertificateStatus());
  }
  
  public CertificateStatusBuilder(CertificateStatusFluent<?> fluent) {
    this(fluent, new CertificateStatus());
  }
  
  public CertificateStatusBuilder(CertificateStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateStatusBuilder(CertificateStatusFluent<?> fluent,CertificateStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateStatus build() {
    CertificateStatus buildable = new CertificateStatus(fluent.buildConditions(), fluent.getFailedIssuanceAttempts(), fluent.getLastFailureTime(), fluent.getNextPrivateKeySecretName(), fluent.getNotAfter(), fluent.getNotBefore(), fluent.getRenewalTime(), fluent.getRevision());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}