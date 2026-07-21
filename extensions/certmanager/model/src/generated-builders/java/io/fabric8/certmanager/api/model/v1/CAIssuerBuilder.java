package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CAIssuerBuilder extends CAIssuerFluent<CAIssuerBuilder> implements VisitableBuilder<CAIssuer,CAIssuerBuilder>{

  CAIssuerFluent<?> fluent;

  public CAIssuerBuilder() {
    this(new CAIssuer());
  }
  
  public CAIssuerBuilder(CAIssuerFluent<?> fluent) {
    this(fluent, new CAIssuer());
  }
  
  public CAIssuerBuilder(CAIssuer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CAIssuerBuilder(CAIssuerFluent<?> fluent,CAIssuer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CAIssuer build() {
    CAIssuer buildable = new CAIssuer(fluent.getCrlDistributionPoints(), fluent.getIssuingCertificateURLs(), fluent.getOcspServers(), fluent.getSecretName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}