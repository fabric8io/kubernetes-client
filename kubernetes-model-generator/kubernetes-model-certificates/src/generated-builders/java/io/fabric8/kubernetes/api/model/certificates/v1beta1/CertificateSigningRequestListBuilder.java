package io.fabric8.kubernetes.api.model.certificates.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateSigningRequestListBuilder extends CertificateSigningRequestListFluent<CertificateSigningRequestListBuilder> implements VisitableBuilder<CertificateSigningRequestList,CertificateSigningRequestListBuilder>{

  CertificateSigningRequestListFluent<?> fluent;

  public CertificateSigningRequestListBuilder() {
    this(new CertificateSigningRequestList());
  }
  
  public CertificateSigningRequestListBuilder(CertificateSigningRequestListFluent<?> fluent) {
    this(fluent, new CertificateSigningRequestList());
  }
  
  public CertificateSigningRequestListBuilder(CertificateSigningRequestList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateSigningRequestListBuilder(CertificateSigningRequestListFluent<?> fluent,CertificateSigningRequestList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateSigningRequestList build() {
    CertificateSigningRequestList buildable = new CertificateSigningRequestList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}