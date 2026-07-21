package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEIssuerDNS01ProviderAzureDNSBuilder extends ACMEIssuerDNS01ProviderAzureDNSFluent<ACMEIssuerDNS01ProviderAzureDNSBuilder> implements VisitableBuilder<ACMEIssuerDNS01ProviderAzureDNS,ACMEIssuerDNS01ProviderAzureDNSBuilder>{

  ACMEIssuerDNS01ProviderAzureDNSFluent<?> fluent;

  public ACMEIssuerDNS01ProviderAzureDNSBuilder() {
    this(new ACMEIssuerDNS01ProviderAzureDNS());
  }
  
  public ACMEIssuerDNS01ProviderAzureDNSBuilder(ACMEIssuerDNS01ProviderAzureDNSFluent<?> fluent) {
    this(fluent, new ACMEIssuerDNS01ProviderAzureDNS());
  }
  
  public ACMEIssuerDNS01ProviderAzureDNSBuilder(ACMEIssuerDNS01ProviderAzureDNS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEIssuerDNS01ProviderAzureDNSBuilder(ACMEIssuerDNS01ProviderAzureDNSFluent<?> fluent,ACMEIssuerDNS01ProviderAzureDNS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEIssuerDNS01ProviderAzureDNS build() {
    ACMEIssuerDNS01ProviderAzureDNS buildable = new ACMEIssuerDNS01ProviderAzureDNS(fluent.getClientID(), fluent.buildClientSecretSecretRef(), fluent.getEnvironment(), fluent.getHostedZoneName(), fluent.buildManagedIdentity(), fluent.getResourceGroupName(), fluent.getSubscriptionID(), fluent.getTenantID(), fluent.getZoneType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}