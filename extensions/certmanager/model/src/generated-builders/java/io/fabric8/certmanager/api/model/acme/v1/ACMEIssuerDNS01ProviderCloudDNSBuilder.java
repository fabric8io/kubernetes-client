package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEIssuerDNS01ProviderCloudDNSBuilder extends ACMEIssuerDNS01ProviderCloudDNSFluent<ACMEIssuerDNS01ProviderCloudDNSBuilder> implements VisitableBuilder<ACMEIssuerDNS01ProviderCloudDNS,ACMEIssuerDNS01ProviderCloudDNSBuilder>{

  ACMEIssuerDNS01ProviderCloudDNSFluent<?> fluent;

  public ACMEIssuerDNS01ProviderCloudDNSBuilder() {
    this(new ACMEIssuerDNS01ProviderCloudDNS());
  }
  
  public ACMEIssuerDNS01ProviderCloudDNSBuilder(ACMEIssuerDNS01ProviderCloudDNSFluent<?> fluent) {
    this(fluent, new ACMEIssuerDNS01ProviderCloudDNS());
  }
  
  public ACMEIssuerDNS01ProviderCloudDNSBuilder(ACMEIssuerDNS01ProviderCloudDNS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEIssuerDNS01ProviderCloudDNSBuilder(ACMEIssuerDNS01ProviderCloudDNSFluent<?> fluent,ACMEIssuerDNS01ProviderCloudDNS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEIssuerDNS01ProviderCloudDNS build() {
    ACMEIssuerDNS01ProviderCloudDNS buildable = new ACMEIssuerDNS01ProviderCloudDNS(fluent.getHostedZoneName(), fluent.getProject(), fluent.buildServiceAccountSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}