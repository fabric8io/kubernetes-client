package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConditionBuilder extends ConditionFluent<ConditionBuilder> implements VisitableBuilder<Condition,ConditionBuilder>{

  ConditionFluent<?> fluent;

  public ConditionBuilder() {
    this(new Condition());
  }
  
  public ConditionBuilder(ConditionFluent<?> fluent) {
    this(fluent, new Condition());
  }
  
  public ConditionBuilder(Condition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConditionBuilder(ConditionFluent<?> fluent,Condition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Condition build() {
    Condition buildable = new Condition(fluent.getCreateTime(), fluent.getPhase(), fluent.getRunningDuration(), fluent.getTaskStatusCount());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}