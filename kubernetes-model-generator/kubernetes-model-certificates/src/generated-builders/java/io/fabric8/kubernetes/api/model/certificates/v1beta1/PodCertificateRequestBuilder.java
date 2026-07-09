package io.fabric8.kubernetes.api.model.certificates.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodCertificateRequestBuilder extends PodCertificateRequestFluent<PodCertificateRequestBuilder> implements VisitableBuilder<PodCertificateRequest,PodCertificateRequestBuilder>{

  PodCertificateRequestFluent<?> fluent;

  public PodCertificateRequestBuilder() {
    this(new PodCertificateRequest());
  }
  
  public PodCertificateRequestBuilder(PodCertificateRequestFluent<?> fluent) {
    this(fluent, new PodCertificateRequest());
  }
  
  public PodCertificateRequestBuilder(PodCertificateRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodCertificateRequestBuilder(PodCertificateRequestFluent<?> fluent,PodCertificateRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodCertificateRequest build() {
    PodCertificateRequest buildable = new PodCertificateRequest(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}