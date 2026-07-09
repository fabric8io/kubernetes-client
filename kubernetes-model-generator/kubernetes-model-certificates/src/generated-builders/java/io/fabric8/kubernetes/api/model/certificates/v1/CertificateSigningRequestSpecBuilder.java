package io.fabric8.kubernetes.api.model.certificates.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateSigningRequestSpecBuilder extends CertificateSigningRequestSpecFluent<CertificateSigningRequestSpecBuilder> implements VisitableBuilder<CertificateSigningRequestSpec,CertificateSigningRequestSpecBuilder>{

  CertificateSigningRequestSpecFluent<?> fluent;

  public CertificateSigningRequestSpecBuilder() {
    this(new CertificateSigningRequestSpec());
  }
  
  public CertificateSigningRequestSpecBuilder(CertificateSigningRequestSpecFluent<?> fluent) {
    this(fluent, new CertificateSigningRequestSpec());
  }
  
  public CertificateSigningRequestSpecBuilder(CertificateSigningRequestSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateSigningRequestSpecBuilder(CertificateSigningRequestSpecFluent<?> fluent,CertificateSigningRequestSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateSigningRequestSpec build() {
    CertificateSigningRequestSpec buildable = new CertificateSigningRequestSpec(fluent.getExpirationSeconds(), fluent.getExtra(), fluent.getGroups(), fluent.getRequest(), fluent.getSignerName(), fluent.getUid(), fluent.getUsages(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}