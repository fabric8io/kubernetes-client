package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateBuilder extends CertificateFluent<CertificateBuilder> implements VisitableBuilder<Certificate,CertificateBuilder>{

  CertificateFluent<?> fluent;

  public CertificateBuilder() {
    this(new Certificate());
  }
  
  public CertificateBuilder(CertificateFluent<?> fluent) {
    this(fluent, new Certificate());
  }
  
  public CertificateBuilder(Certificate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateBuilder(CertificateFluent<?> fluent,Certificate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Certificate build() {
    Certificate buildable = new Certificate(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}