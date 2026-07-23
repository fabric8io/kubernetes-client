package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEIssuerDNS01ProviderDigitalOceanBuilder extends ACMEIssuerDNS01ProviderDigitalOceanFluent<ACMEIssuerDNS01ProviderDigitalOceanBuilder> implements VisitableBuilder<ACMEIssuerDNS01ProviderDigitalOcean,ACMEIssuerDNS01ProviderDigitalOceanBuilder>{

  ACMEIssuerDNS01ProviderDigitalOceanFluent<?> fluent;

  public ACMEIssuerDNS01ProviderDigitalOceanBuilder() {
    this(new ACMEIssuerDNS01ProviderDigitalOcean());
  }
  
  public ACMEIssuerDNS01ProviderDigitalOceanBuilder(ACMEIssuerDNS01ProviderDigitalOceanFluent<?> fluent) {
    this(fluent, new ACMEIssuerDNS01ProviderDigitalOcean());
  }
  
  public ACMEIssuerDNS01ProviderDigitalOceanBuilder(ACMEIssuerDNS01ProviderDigitalOcean instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEIssuerDNS01ProviderDigitalOceanBuilder(ACMEIssuerDNS01ProviderDigitalOceanFluent<?> fluent,ACMEIssuerDNS01ProviderDigitalOcean instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEIssuerDNS01ProviderDigitalOcean build() {
    ACMEIssuerDNS01ProviderDigitalOcean buildable = new ACMEIssuerDNS01ProviderDigitalOcean(fluent.buildTokenSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}