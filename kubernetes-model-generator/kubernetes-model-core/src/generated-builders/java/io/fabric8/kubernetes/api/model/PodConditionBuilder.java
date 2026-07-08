package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodConditionBuilder extends PodConditionFluent<PodConditionBuilder> implements VisitableBuilder<PodCondition,PodConditionBuilder>{

  PodConditionFluent<?> fluent;

  public PodConditionBuilder() {
    this(new PodCondition());
  }
  
  public PodConditionBuilder(PodConditionFluent<?> fluent) {
    this(fluent, new PodCondition());
  }
  
  public PodConditionBuilder(PodCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodConditionBuilder(PodConditionFluent<?> fluent,PodCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodCondition build() {
    PodCondition buildable = new PodCondition(fluent.getLastProbeTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getObservedGeneration(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}