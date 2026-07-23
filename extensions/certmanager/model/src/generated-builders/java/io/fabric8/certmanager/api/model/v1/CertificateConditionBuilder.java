package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateConditionBuilder extends CertificateConditionFluent<CertificateConditionBuilder> implements VisitableBuilder<CertificateCondition,CertificateConditionBuilder>{

  CertificateConditionFluent<?> fluent;

  public CertificateConditionBuilder() {
    this(new CertificateCondition());
  }
  
  public CertificateConditionBuilder(CertificateConditionFluent<?> fluent) {
    this(fluent, new CertificateCondition());
  }
  
  public CertificateConditionBuilder(CertificateCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateConditionBuilder(CertificateConditionFluent<?> fluent,CertificateCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateCondition build() {
    CertificateCondition buildable = new CertificateCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getObservedGeneration(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}