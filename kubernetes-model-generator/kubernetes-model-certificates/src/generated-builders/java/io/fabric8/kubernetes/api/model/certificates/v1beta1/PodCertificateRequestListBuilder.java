package io.fabric8.kubernetes.api.model.certificates.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodCertificateRequestListBuilder extends PodCertificateRequestListFluent<PodCertificateRequestListBuilder> implements VisitableBuilder<PodCertificateRequestList,PodCertificateRequestListBuilder>{

  PodCertificateRequestListFluent<?> fluent;

  public PodCertificateRequestListBuilder() {
    this(new PodCertificateRequestList());
  }
  
  public PodCertificateRequestListBuilder(PodCertificateRequestListFluent<?> fluent) {
    this(fluent, new PodCertificateRequestList());
  }
  
  public PodCertificateRequestListBuilder(PodCertificateRequestList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodCertificateRequestListBuilder(PodCertificateRequestListFluent<?> fluent,PodCertificateRequestList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodCertificateRequestList build() {
    PodCertificateRequestList buildable = new PodCertificateRequestList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}