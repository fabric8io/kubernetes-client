package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureOAuthBuilder extends AzureOAuthFluent<AzureOAuthBuilder> implements VisitableBuilder<AzureOAuth,AzureOAuthBuilder>{

  AzureOAuthFluent<?> fluent;

  public AzureOAuthBuilder() {
    this(new AzureOAuth());
  }
  
  public AzureOAuthBuilder(AzureOAuthFluent<?> fluent) {
    this(fluent, new AzureOAuth());
  }
  
  public AzureOAuthBuilder(AzureOAuth instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureOAuthBuilder(AzureOAuthFluent<?> fluent,AzureOAuth instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureOAuth build() {
    AzureOAuth buildable = new AzureOAuth(fluent.getClientId(), fluent.getClientSecret(), fluent.getTenantId());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}