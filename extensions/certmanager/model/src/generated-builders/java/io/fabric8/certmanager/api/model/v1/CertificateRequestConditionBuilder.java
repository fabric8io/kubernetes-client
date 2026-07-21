package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateRequestConditionBuilder extends CertificateRequestConditionFluent<CertificateRequestConditionBuilder> implements VisitableBuilder<CertificateRequestCondition,CertificateRequestConditionBuilder>{

  CertificateRequestConditionFluent<?> fluent;

  public CertificateRequestConditionBuilder() {
    this(new CertificateRequestCondition());
  }
  
  public CertificateRequestConditionBuilder(CertificateRequestConditionFluent<?> fluent) {
    this(fluent, new CertificateRequestCondition());
  }
  
  public CertificateRequestConditionBuilder(CertificateRequestCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateRequestConditionBuilder(CertificateRequestConditionFluent<?> fluent,CertificateRequestCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateRequestCondition build() {
    CertificateRequestCondition buildable = new CertificateRequestCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}