package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertificateSpecBuilder extends CertificateSpecFluent<CertificateSpecBuilder> implements VisitableBuilder<CertificateSpec,CertificateSpecBuilder>{

  CertificateSpecFluent<?> fluent;

  public CertificateSpecBuilder() {
    this(new CertificateSpec());
  }
  
  public CertificateSpecBuilder(CertificateSpecFluent<?> fluent) {
    this(fluent, new CertificateSpec());
  }
  
  public CertificateSpecBuilder(CertificateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertificateSpecBuilder(CertificateSpecFluent<?> fluent,CertificateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertificateSpec build() {
    CertificateSpec buildable = new CertificateSpec(fluent.buildAdditionalOutputFormats(), fluent.getCommonName(), fluent.getDnsNames(), fluent.getDuration(), fluent.getEmailAddresses(), fluent.getEncodeUsagesInRequest(), fluent.getIpAddresses(), fluent.getIsCA(), fluent.buildIssuerRef(), fluent.buildKeystores(), fluent.getLiteralSubject(), fluent.buildNameConstraints(), fluent.buildOtherNames(), fluent.buildPrivateKey(), fluent.getRenewBefore(), fluent.getRenewBeforePercentage(), fluent.getRevisionHistoryLimit(), fluent.getSecretName(), fluent.buildSecretTemplate(), fluent.getSignatureAlgorithm(), fluent.buildSubject(), fluent.getUris(), fluent.getUsages());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}