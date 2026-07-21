package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEIssuerDNS01ProviderAcmeDNSBuilder extends ACMEIssuerDNS01ProviderAcmeDNSFluent<ACMEIssuerDNS01ProviderAcmeDNSBuilder> implements VisitableBuilder<ACMEIssuerDNS01ProviderAcmeDNS,ACMEIssuerDNS01ProviderAcmeDNSBuilder>{

  ACMEIssuerDNS01ProviderAcmeDNSFluent<?> fluent;

  public ACMEIssuerDNS01ProviderAcmeDNSBuilder() {
    this(new ACMEIssuerDNS01ProviderAcmeDNS());
  }
  
  public ACMEIssuerDNS01ProviderAcmeDNSBuilder(ACMEIssuerDNS01ProviderAcmeDNSFluent<?> fluent) {
    this(fluent, new ACMEIssuerDNS01ProviderAcmeDNS());
  }
  
  public ACMEIssuerDNS01ProviderAcmeDNSBuilder(ACMEIssuerDNS01ProviderAcmeDNS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEIssuerDNS01ProviderAcmeDNSBuilder(ACMEIssuerDNS01ProviderAcmeDNSFluent<?> fluent,ACMEIssuerDNS01ProviderAcmeDNS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEIssuerDNS01ProviderAcmeDNS build() {
    ACMEIssuerDNS01ProviderAcmeDNS buildable = new ACMEIssuerDNS01ProviderAcmeDNS(fluent.buildAccountSecretRef(), fluent.getHost());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}