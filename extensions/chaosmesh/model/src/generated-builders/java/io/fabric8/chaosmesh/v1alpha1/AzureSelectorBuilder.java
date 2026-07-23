package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureSelectorBuilder extends AzureSelectorFluent<AzureSelectorBuilder> implements VisitableBuilder<AzureSelector,AzureSelectorBuilder>{

  AzureSelectorFluent<?> fluent;

  public AzureSelectorBuilder() {
    this(new AzureSelector());
  }
  
  public AzureSelectorBuilder(AzureSelectorFluent<?> fluent) {
    this(fluent, new AzureSelector());
  }
  
  public AzureSelectorBuilder(AzureSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureSelectorBuilder(AzureSelectorFluent<?> fluent,AzureSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureSelector build() {
    AzureSelector buildable = new AzureSelector(fluent.getDiskName(), fluent.getLun(), fluent.getRemoteCluster(), fluent.getResourceGroupName(), fluent.getSecretName(), fluent.getSubscriptionID(), fluent.getVmName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}