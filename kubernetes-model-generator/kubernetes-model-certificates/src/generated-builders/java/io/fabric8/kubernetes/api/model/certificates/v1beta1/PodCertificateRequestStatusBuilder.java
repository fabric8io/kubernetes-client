package io.fabric8.kubernetes.api.model.certificates.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodCertificateRequestStatusBuilder extends PodCertificateRequestStatusFluent<PodCertificateRequestStatusBuilder> implements VisitableBuilder<PodCertificateRequestStatus,PodCertificateRequestStatusBuilder>{

  PodCertificateRequestStatusFluent<?> fluent;

  public PodCertificateRequestStatusBuilder() {
    this(new PodCertificateRequestStatus());
  }
  
  public PodCertificateRequestStatusBuilder(PodCertificateRequestStatusFluent<?> fluent) {
    this(fluent, new PodCertificateRequestStatus());
  }
  
  public PodCertificateRequestStatusBuilder(PodCertificateRequestStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodCertificateRequestStatusBuilder(PodCertificateRequestStatusFluent<?> fluent,PodCertificateRequestStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodCertificateRequestStatus build() {
    PodCertificateRequestStatus buildable = new PodCertificateRequestStatus(fluent.getBeginRefreshAt(), fluent.getCertificateChain(), fluent.getConditions(), fluent.getNotAfter(), fluent.getNotBefore());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}