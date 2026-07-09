package io.fabric8.kubernetes.api.model.certificates.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateSigningRequestConditionBuilder extends CertificateSigningRequestConditionFluent<CertificateSigningRequestConditionBuilder> implements VisitableBuilder<CertificateSigningRequestCondition,CertificateSigningRequestConditionBuilder>{

  CertificateSigningRequestConditionFluent<?> fluent;

  public CertificateSigningRequestConditionBuilder() {
    this(new CertificateSigningRequestCondition());
  }
  
  public CertificateSigningRequestConditionBuilder(CertificateSigningRequestConditionFluent<?> fluent) {
    this(fluent, new CertificateSigningRequestCondition());
  }
  
  public CertificateSigningRequestConditionBuilder(CertificateSigningRequestCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateSigningRequestConditionBuilder(CertificateSigningRequestConditionFluent<?> fluent,CertificateSigningRequestCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateSigningRequestCondition build() {
    CertificateSigningRequestCondition buildable = new CertificateSigningRequestCondition(fluent.getLastTransitionTime(), fluent.getLastUpdateTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}