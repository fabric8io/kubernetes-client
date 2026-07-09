package io.fabric8.kubernetes.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodDisruptionBudgetListBuilder extends PodDisruptionBudgetListFluent<PodDisruptionBudgetListBuilder> implements VisitableBuilder<PodDisruptionBudgetList,PodDisruptionBudgetListBuilder>{

  PodDisruptionBudgetListFluent<?> fluent;

  public PodDisruptionBudgetListBuilder() {
    this(new PodDisruptionBudgetList());
  }
  
  public PodDisruptionBudgetListBuilder(PodDisruptionBudgetListFluent<?> fluent) {
    this(fluent, new PodDisruptionBudgetList());
  }
  
  public PodDisruptionBudgetListBuilder(PodDisruptionBudgetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodDisruptionBudgetListBuilder(PodDisruptionBudgetListFluent<?> fluent,PodDisruptionBudgetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodDisruptionBudgetList build() {
    PodDisruptionBudgetList buildable = new PodDisruptionBudgetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}