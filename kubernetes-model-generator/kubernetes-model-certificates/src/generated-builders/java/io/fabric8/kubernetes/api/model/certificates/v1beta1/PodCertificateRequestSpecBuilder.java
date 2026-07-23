package io.fabric8.kubernetes.api.model.certificates.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodCertificateRequestSpecBuilder extends PodCertificateRequestSpecFluent<PodCertificateRequestSpecBuilder> implements VisitableBuilder<PodCertificateRequestSpec,PodCertificateRequestSpecBuilder>{

  PodCertificateRequestSpecFluent<?> fluent;

  public PodCertificateRequestSpecBuilder() {
    this(new PodCertificateRequestSpec());
  }
  
  public PodCertificateRequestSpecBuilder(PodCertificateRequestSpecFluent<?> fluent) {
    this(fluent, new PodCertificateRequestSpec());
  }
  
  public PodCertificateRequestSpecBuilder(PodCertificateRequestSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodCertificateRequestSpecBuilder(PodCertificateRequestSpecFluent<?> fluent,PodCertificateRequestSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodCertificateRequestSpec build() {
    PodCertificateRequestSpec buildable = new PodCertificateRequestSpec(fluent.getMaxExpirationSeconds(), fluent.getNodeName(), fluent.getNodeUID(), fluent.getPkixPublicKey(), fluent.getPodName(), fluent.getPodUID(), fluent.getProofOfPossession(), fluent.getServiceAccountName(), fluent.getServiceAccountUID(), fluent.getSignerName(), fluent.getStubPKCS10Request(), fluent.getUnverifiedUserAnnotations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}