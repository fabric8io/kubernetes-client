package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureProviderStatusBuilder extends AzureProviderStatusFluent<AzureProviderStatusBuilder> implements VisitableBuilder<AzureProviderStatus,AzureProviderStatusBuilder>{

  AzureProviderStatusFluent<?> fluent;

  public AzureProviderStatusBuilder() {
    this(new AzureProviderStatus());
  }
  
  public AzureProviderStatusBuilder(AzureProviderStatusFluent<?> fluent) {
    this(fluent, new AzureProviderStatus());
  }
  
  public AzureProviderStatusBuilder(AzureProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureProviderStatusBuilder(AzureProviderStatusFluent<?> fluent,AzureProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureProviderStatus build() {
    AzureProviderStatus buildable = new AzureProviderStatus(fluent.getApiVersion(), fluent.getAppID(), fluent.getKind(), fluent.getName(), fluent.getSecretLastResourceVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}