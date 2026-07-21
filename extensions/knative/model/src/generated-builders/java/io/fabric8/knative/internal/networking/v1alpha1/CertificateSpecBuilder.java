package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateSpecBuilder extends CertificateSpecFluent<CertificateSpecBuilder> implements VisitableBuilder<CertificateSpec,CertificateSpecBuilder>{

  CertificateSpecFluent<?> fluent;

  public CertificateSpecBuilder() {
    this(new CertificateSpec());
  }
  
  public CertificateSpecBuilder(CertificateSpecFluent<?> fluent) {
    this(fluent, new CertificateSpec());
  }
  
  public CertificateSpecBuilder(CertificateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateSpecBuilder(CertificateSpecFluent<?> fluent,CertificateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateSpec build() {
    CertificateSpec buildable = new CertificateSpec(fluent.getDnsNames(), fluent.getDomain(), fluent.getSecretName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}