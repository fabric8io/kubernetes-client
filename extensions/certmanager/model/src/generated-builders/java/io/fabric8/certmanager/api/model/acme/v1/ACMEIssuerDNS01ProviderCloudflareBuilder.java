package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEIssuerDNS01ProviderCloudflareBuilder extends ACMEIssuerDNS01ProviderCloudflareFluent<ACMEIssuerDNS01ProviderCloudflareBuilder> implements VisitableBuilder<ACMEIssuerDNS01ProviderCloudflare,ACMEIssuerDNS01ProviderCloudflareBuilder>{

  ACMEIssuerDNS01ProviderCloudflareFluent<?> fluent;

  public ACMEIssuerDNS01ProviderCloudflareBuilder() {
    this(new ACMEIssuerDNS01ProviderCloudflare());
  }
  
  public ACMEIssuerDNS01ProviderCloudflareBuilder(ACMEIssuerDNS01ProviderCloudflareFluent<?> fluent) {
    this(fluent, new ACMEIssuerDNS01ProviderCloudflare());
  }
  
  public ACMEIssuerDNS01ProviderCloudflareBuilder(ACMEIssuerDNS01ProviderCloudflare instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEIssuerDNS01ProviderCloudflareBuilder(ACMEIssuerDNS01ProviderCloudflareFluent<?> fluent,ACMEIssuerDNS01ProviderCloudflare instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEIssuerDNS01ProviderCloudflare build() {
    ACMEIssuerDNS01ProviderCloudflare buildable = new ACMEIssuerDNS01ProviderCloudflare(fluent.buildApiKeySecretRef(), fluent.buildApiTokenSecretRef(), fluent.getEmail());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}