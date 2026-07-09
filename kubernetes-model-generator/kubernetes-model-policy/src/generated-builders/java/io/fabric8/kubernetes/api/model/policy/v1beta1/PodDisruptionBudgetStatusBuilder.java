package io.fabric8.kubernetes.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodDisruptionBudgetStatusBuilder extends PodDisruptionBudgetStatusFluent<PodDisruptionBudgetStatusBuilder> implements VisitableBuilder<PodDisruptionBudgetStatus,PodDisruptionBudgetStatusBuilder>{

  PodDisruptionBudgetStatusFluent<?> fluent;

  public PodDisruptionBudgetStatusBuilder() {
    this(new PodDisruptionBudgetStatus());
  }
  
  public PodDisruptionBudgetStatusBuilder(PodDisruptionBudgetStatusFluent<?> fluent) {
    this(fluent, new PodDisruptionBudgetStatus());
  }
  
  public PodDisruptionBudgetStatusBuilder(PodDisruptionBudgetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodDisruptionBudgetStatusBuilder(PodDisruptionBudgetStatusFluent<?> fluent,PodDisruptionBudgetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodDisruptionBudgetStatus build() {
    PodDisruptionBudgetStatus buildable = new PodDisruptionBudgetStatus(fluent.getConditions(), fluent.getCurrentHealthy(), fluent.getDesiredHealthy(), fluent.getDisruptedPods(), fluent.getDisruptionsAllowed(), fluent.getExpectedPods(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}