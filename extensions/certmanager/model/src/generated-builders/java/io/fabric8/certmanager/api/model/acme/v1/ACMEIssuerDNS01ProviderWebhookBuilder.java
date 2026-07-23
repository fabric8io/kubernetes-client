package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEIssuerDNS01ProviderWebhookBuilder extends ACMEIssuerDNS01ProviderWebhookFluent<ACMEIssuerDNS01ProviderWebhookBuilder> implements VisitableBuilder<ACMEIssuerDNS01ProviderWebhook,ACMEIssuerDNS01ProviderWebhookBuilder>{

  ACMEIssuerDNS01ProviderWebhookFluent<?> fluent;

  public ACMEIssuerDNS01ProviderWebhookBuilder() {
    this(new ACMEIssuerDNS01ProviderWebhook());
  }
  
  public ACMEIssuerDNS01ProviderWebhookBuilder(ACMEIssuerDNS01ProviderWebhookFluent<?> fluent) {
    this(fluent, new ACMEIssuerDNS01ProviderWebhook());
  }
  
  public ACMEIssuerDNS01ProviderWebhookBuilder(ACMEIssuerDNS01ProviderWebhook instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEIssuerDNS01ProviderWebhookBuilder(ACMEIssuerDNS01ProviderWebhookFluent<?> fluent,ACMEIssuerDNS01ProviderWebhook instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEIssuerDNS01ProviderWebhook build() {
    ACMEIssuerDNS01ProviderWebhook buildable = new ACMEIssuerDNS01ProviderWebhook(fluent.getConfig(), fluent.getGroupName(), fluent.getSolverName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}