package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEIssuerDNS01ProviderAkamaiBuilder extends ACMEIssuerDNS01ProviderAkamaiFluent<ACMEIssuerDNS01ProviderAkamaiBuilder> implements VisitableBuilder<ACMEIssuerDNS01ProviderAkamai,ACMEIssuerDNS01ProviderAkamaiBuilder>{

  ACMEIssuerDNS01ProviderAkamaiFluent<?> fluent;

  public ACMEIssuerDNS01ProviderAkamaiBuilder() {
    this(new ACMEIssuerDNS01ProviderAkamai());
  }
  
  public ACMEIssuerDNS01ProviderAkamaiBuilder(ACMEIssuerDNS01ProviderAkamaiFluent<?> fluent) {
    this(fluent, new ACMEIssuerDNS01ProviderAkamai());
  }
  
  public ACMEIssuerDNS01ProviderAkamaiBuilder(ACMEIssuerDNS01ProviderAkamai instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEIssuerDNS01ProviderAkamaiBuilder(ACMEIssuerDNS01ProviderAkamaiFluent<?> fluent,ACMEIssuerDNS01ProviderAkamai instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEIssuerDNS01ProviderAkamai build() {
    ACMEIssuerDNS01ProviderAkamai buildable = new ACMEIssuerDNS01ProviderAkamai(fluent.buildAccessTokenSecretRef(), fluent.buildClientSecretSecretRef(), fluent.buildClientTokenSecretRef(), fluent.getServiceConsumerDomain());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}