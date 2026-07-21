package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateRequestListBuilder extends CertificateRequestListFluent<CertificateRequestListBuilder> implements VisitableBuilder<CertificateRequestList,CertificateRequestListBuilder>{

  CertificateRequestListFluent<?> fluent;

  public CertificateRequestListBuilder() {
    this(new CertificateRequestList());
  }
  
  public CertificateRequestListBuilder(CertificateRequestListFluent<?> fluent) {
    this(fluent, new CertificateRequestList());
  }
  
  public CertificateRequestListBuilder(CertificateRequestList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateRequestListBuilder(CertificateRequestListFluent<?> fluent,CertificateRequestList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateRequestList build() {
    CertificateRequestList buildable = new CertificateRequestList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}