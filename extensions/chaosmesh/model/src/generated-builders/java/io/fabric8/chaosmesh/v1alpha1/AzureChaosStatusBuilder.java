package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureChaosStatusBuilder extends AzureChaosStatusFluent<AzureChaosStatusBuilder> implements VisitableBuilder<AzureChaosStatus,AzureChaosStatusBuilder>{

  AzureChaosStatusFluent<?> fluent;

  public AzureChaosStatusBuilder() {
    this(new AzureChaosStatus());
  }
  
  public AzureChaosStatusBuilder(AzureChaosStatusFluent<?> fluent) {
    this(fluent, new AzureChaosStatus());
  }
  
  public AzureChaosStatusBuilder(AzureChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureChaosStatusBuilder(AzureChaosStatusFluent<?> fluent,AzureChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureChaosStatus build() {
    AzureChaosStatus buildable = new AzureChaosStatus(fluent.buildConditions(), fluent.buildExperiment());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}