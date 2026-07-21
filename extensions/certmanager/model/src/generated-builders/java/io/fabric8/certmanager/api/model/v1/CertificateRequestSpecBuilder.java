package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateRequestSpecBuilder extends CertificateRequestSpecFluent<CertificateRequestSpecBuilder> implements VisitableBuilder<CertificateRequestSpec,CertificateRequestSpecBuilder>{

  CertificateRequestSpecFluent<?> fluent;

  public CertificateRequestSpecBuilder() {
    this(new CertificateRequestSpec());
  }
  
  public CertificateRequestSpecBuilder(CertificateRequestSpecFluent<?> fluent) {
    this(fluent, new CertificateRequestSpec());
  }
  
  public CertificateRequestSpecBuilder(CertificateRequestSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateRequestSpecBuilder(CertificateRequestSpecFluent<?> fluent,CertificateRequestSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateRequestSpec build() {
    CertificateRequestSpec buildable = new CertificateRequestSpec(fluent.getDuration(), fluent.getExtra(), fluent.getGroups(), fluent.getIsCA(), fluent.buildIssuerRef(), fluent.getRequest(), fluent.getUid(), fluent.getUsages(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}