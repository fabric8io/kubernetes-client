package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateRequestBuilder extends CertificateRequestFluent<CertificateRequestBuilder> implements VisitableBuilder<CertificateRequest,CertificateRequestBuilder>{

  CertificateRequestFluent<?> fluent;

  public CertificateRequestBuilder() {
    this(new CertificateRequest());
  }
  
  public CertificateRequestBuilder(CertificateRequestFluent<?> fluent) {
    this(fluent, new CertificateRequest());
  }
  
  public CertificateRequestBuilder(CertificateRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateRequestBuilder(CertificateRequestFluent<?> fluent,CertificateRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateRequest build() {
    CertificateRequest buildable = new CertificateRequest(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}