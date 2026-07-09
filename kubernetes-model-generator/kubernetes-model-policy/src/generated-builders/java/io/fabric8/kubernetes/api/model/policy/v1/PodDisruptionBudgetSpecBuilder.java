package io.fabric8.kubernetes.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodDisruptionBudgetSpecBuilder extends PodDisruptionBudgetSpecFluent<PodDisruptionBudgetSpecBuilder> implements VisitableBuilder<PodDisruptionBudgetSpec,PodDisruptionBudgetSpecBuilder>{

  PodDisruptionBudgetSpecFluent<?> fluent;

  public PodDisruptionBudgetSpecBuilder() {
    this(new PodDisruptionBudgetSpec());
  }
  
  public PodDisruptionBudgetSpecBuilder(PodDisruptionBudgetSpecFluent<?> fluent) {
    this(fluent, new PodDisruptionBudgetSpec());
  }
  
  public PodDisruptionBudgetSpecBuilder(PodDisruptionBudgetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodDisruptionBudgetSpecBuilder(PodDisruptionBudgetSpecFluent<?> fluent,PodDisruptionBudgetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodDisruptionBudgetSpec build() {
    PodDisruptionBudgetSpec buildable = new PodDisruptionBudgetSpec(fluent.buildMaxUnavailable(), fluent.buildMinAvailable(), fluent.buildSelector(), fluent.getUnhealthyPodEvictionPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}