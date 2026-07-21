package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureChaosBuilder extends AzureChaosFluent<AzureChaosBuilder> implements VisitableBuilder<AzureChaos,AzureChaosBuilder>{

  AzureChaosFluent<?> fluent;

  public AzureChaosBuilder() {
    this(new AzureChaos());
  }
  
  public AzureChaosBuilder(AzureChaosFluent<?> fluent) {
    this(fluent, new AzureChaos());
  }
  
  public AzureChaosBuilder(AzureChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureChaosBuilder(AzureChaosFluent<?> fluent,AzureChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureChaos build() {
    AzureChaos buildable = new AzureChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}