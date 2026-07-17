package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateBundleStatusBuilder extends CertificateBundleStatusFluent<CertificateBundleStatusBuilder> implements VisitableBuilder<CertificateBundleStatus,CertificateBundleStatusBuilder>{

  CertificateBundleStatusFluent<?> fluent;

  public CertificateBundleStatusBuilder() {
    this(new CertificateBundleStatus());
  }
  
  public CertificateBundleStatusBuilder(CertificateBundleStatusFluent<?> fluent) {
    this(fluent, new CertificateBundleStatus());
  }
  
  public CertificateBundleStatusBuilder(CertificateBundleStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateBundleStatusBuilder(CertificateBundleStatusFluent<?> fluent,CertificateBundleStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateBundleStatus build() {
    CertificateBundleStatus buildable = new CertificateBundleStatus(fluent.getGenerated(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}