package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureChaosListBuilder extends AzureChaosListFluent<AzureChaosListBuilder> implements VisitableBuilder<AzureChaosList,AzureChaosListBuilder>{

  AzureChaosListFluent<?> fluent;

  public AzureChaosListBuilder() {
    this(new AzureChaosList());
  }
  
  public AzureChaosListBuilder(AzureChaosListFluent<?> fluent) {
    this(fluent, new AzureChaosList());
  }
  
  public AzureChaosListBuilder(AzureChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureChaosListBuilder(AzureChaosListFluent<?> fluent,AzureChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureChaosList build() {
    AzureChaosList buildable = new AzureChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}