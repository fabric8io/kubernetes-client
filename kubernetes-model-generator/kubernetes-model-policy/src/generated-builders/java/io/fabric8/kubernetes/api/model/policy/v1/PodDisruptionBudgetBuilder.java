package io.fabric8.kubernetes.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodDisruptionBudgetBuilder extends PodDisruptionBudgetFluent<PodDisruptionBudgetBuilder> implements VisitableBuilder<PodDisruptionBudget,PodDisruptionBudgetBuilder>{

  PodDisruptionBudgetFluent<?> fluent;

  public PodDisruptionBudgetBuilder() {
    this(new PodDisruptionBudget());
  }
  
  public PodDisruptionBudgetBuilder(PodDisruptionBudgetFluent<?> fluent) {
    this(fluent, new PodDisruptionBudget());
  }
  
  public PodDisruptionBudgetBuilder(PodDisruptionBudget instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodDisruptionBudgetBuilder(PodDisruptionBudgetFluent<?> fluent,PodDisruptionBudget instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodDisruptionBudget build() {
    PodDisruptionBudget buildable = new PodDisruptionBudget(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}