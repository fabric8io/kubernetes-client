package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KernelChaosStatusBuilder extends KernelChaosStatusFluent<KernelChaosStatusBuilder> implements VisitableBuilder<KernelChaosStatus,KernelChaosStatusBuilder>{

  KernelChaosStatusFluent<?> fluent;

  public KernelChaosStatusBuilder() {
    this(new KernelChaosStatus());
  }
  
  public KernelChaosStatusBuilder(KernelChaosStatusFluent<?> fluent) {
    this(fluent, new KernelChaosStatus());
  }
  
  public KernelChaosStatusBuilder(KernelChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KernelChaosStatusBuilder(KernelChaosStatusFluent<?> fluent,KernelChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KernelChaosStatus build() {
    KernelChaosStatus buildable = new KernelChaosStatus(fluent.buildConditions(), fluent.buildExperiment());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}