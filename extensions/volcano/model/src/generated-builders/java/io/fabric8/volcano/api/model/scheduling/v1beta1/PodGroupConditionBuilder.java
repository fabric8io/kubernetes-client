package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodGroupConditionBuilder extends PodGroupConditionFluent<PodGroupConditionBuilder> implements VisitableBuilder<PodGroupCondition,PodGroupConditionBuilder>{

  PodGroupConditionFluent<?> fluent;

  public PodGroupConditionBuilder() {
    this(new PodGroupCondition());
  }
  
  public PodGroupConditionBuilder(PodGroupConditionFluent<?> fluent) {
    this(fluent, new PodGroupCondition());
  }
  
  public PodGroupConditionBuilder(PodGroupCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodGroupConditionBuilder(PodGroupConditionFluent<?> fluent,PodGroupCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodGroupCondition build() {
    PodGroupCondition buildable = new PodGroupCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getTransitionID(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}