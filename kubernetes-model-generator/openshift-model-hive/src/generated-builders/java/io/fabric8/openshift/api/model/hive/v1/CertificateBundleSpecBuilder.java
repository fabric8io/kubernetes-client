package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateBundleSpecBuilder extends CertificateBundleSpecFluent<CertificateBundleSpecBuilder> implements VisitableBuilder<CertificateBundleSpec,CertificateBundleSpecBuilder>{

  CertificateBundleSpecFluent<?> fluent;

  public CertificateBundleSpecBuilder() {
    this(new CertificateBundleSpec());
  }
  
  public CertificateBundleSpecBuilder(CertificateBundleSpecFluent<?> fluent) {
    this(fluent, new CertificateBundleSpec());
  }
  
  public CertificateBundleSpecBuilder(CertificateBundleSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateBundleSpecBuilder(CertificateBundleSpecFluent<?> fluent,CertificateBundleSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateBundleSpec build() {
    CertificateBundleSpec buildable = new CertificateBundleSpec(fluent.buildCertificateSecretRef(), fluent.getGenerate(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}