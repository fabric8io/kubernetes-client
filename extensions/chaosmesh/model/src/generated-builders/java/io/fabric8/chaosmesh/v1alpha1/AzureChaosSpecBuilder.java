package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureChaosSpecBuilder extends AzureChaosSpecFluent<AzureChaosSpecBuilder> implements VisitableBuilder<AzureChaosSpec,AzureChaosSpecBuilder>{

  AzureChaosSpecFluent<?> fluent;

  public AzureChaosSpecBuilder() {
    this(new AzureChaosSpec());
  }
  
  public AzureChaosSpecBuilder(AzureChaosSpecFluent<?> fluent) {
    this(fluent, new AzureChaosSpec());
  }
  
  public AzureChaosSpecBuilder(AzureChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureChaosSpecBuilder(AzureChaosSpecFluent<?> fluent,AzureChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureChaosSpec build() {
    AzureChaosSpec buildable = new AzureChaosSpec(fluent.getAction(), fluent.getDiskName(), fluent.getDuration(), fluent.getLun(), fluent.getRemoteCluster(), fluent.getResourceGroupName(), fluent.getSecretName(), fluent.getSubscriptionID(), fluent.getVmName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}