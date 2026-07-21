package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEIssuerDNS01ProviderRoute53Builder extends ACMEIssuerDNS01ProviderRoute53Fluent<ACMEIssuerDNS01ProviderRoute53Builder> implements VisitableBuilder<ACMEIssuerDNS01ProviderRoute53,ACMEIssuerDNS01ProviderRoute53Builder>{

  ACMEIssuerDNS01ProviderRoute53Fluent<?> fluent;

  public ACMEIssuerDNS01ProviderRoute53Builder() {
    this(new ACMEIssuerDNS01ProviderRoute53());
  }
  
  public ACMEIssuerDNS01ProviderRoute53Builder(ACMEIssuerDNS01ProviderRoute53Fluent<?> fluent) {
    this(fluent, new ACMEIssuerDNS01ProviderRoute53());
  }
  
  public ACMEIssuerDNS01ProviderRoute53Builder(ACMEIssuerDNS01ProviderRoute53 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEIssuerDNS01ProviderRoute53Builder(ACMEIssuerDNS01ProviderRoute53Fluent<?> fluent,ACMEIssuerDNS01ProviderRoute53 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEIssuerDNS01ProviderRoute53 build() {
    ACMEIssuerDNS01ProviderRoute53 buildable = new ACMEIssuerDNS01ProviderRoute53(fluent.getAccessKeyID(), fluent.buildAccessKeyIDSecretRef(), fluent.buildAuth(), fluent.getHostedZoneID(), fluent.getRegion(), fluent.getRole(), fluent.buildSecretAccessKeySecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}