package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateListBuilder extends CertificateListFluent<CertificateListBuilder> implements VisitableBuilder<CertificateList,CertificateListBuilder>{

  CertificateListFluent<?> fluent;

  public CertificateListBuilder() {
    this(new CertificateList());
  }
  
  public CertificateListBuilder(CertificateListFluent<?> fluent) {
    this(fluent, new CertificateList());
  }
  
  public CertificateListBuilder(CertificateList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateListBuilder(CertificateListFluent<?> fluent,CertificateList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateList build() {
    CertificateList buildable = new CertificateList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}