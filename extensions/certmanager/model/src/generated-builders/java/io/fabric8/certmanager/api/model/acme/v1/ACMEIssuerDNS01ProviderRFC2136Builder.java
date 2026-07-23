package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEIssuerDNS01ProviderRFC2136Builder extends ACMEIssuerDNS01ProviderRFC2136Fluent<ACMEIssuerDNS01ProviderRFC2136Builder> implements VisitableBuilder<ACMEIssuerDNS01ProviderRFC2136,ACMEIssuerDNS01ProviderRFC2136Builder>{

  ACMEIssuerDNS01ProviderRFC2136Fluent<?> fluent;

  public ACMEIssuerDNS01ProviderRFC2136Builder() {
    this(new ACMEIssuerDNS01ProviderRFC2136());
  }
  
  public ACMEIssuerDNS01ProviderRFC2136Builder(ACMEIssuerDNS01ProviderRFC2136Fluent<?> fluent) {
    this(fluent, new ACMEIssuerDNS01ProviderRFC2136());
  }
  
  public ACMEIssuerDNS01ProviderRFC2136Builder(ACMEIssuerDNS01ProviderRFC2136 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEIssuerDNS01ProviderRFC2136Builder(ACMEIssuerDNS01ProviderRFC2136Fluent<?> fluent,ACMEIssuerDNS01ProviderRFC2136 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEIssuerDNS01ProviderRFC2136 build() {
    ACMEIssuerDNS01ProviderRFC2136 buildable = new ACMEIssuerDNS01ProviderRFC2136(fluent.getNameserver(), fluent.getProtocol(), fluent.getTsigAlgorithm(), fluent.getTsigKeyName(), fluent.buildTsigSecretSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}