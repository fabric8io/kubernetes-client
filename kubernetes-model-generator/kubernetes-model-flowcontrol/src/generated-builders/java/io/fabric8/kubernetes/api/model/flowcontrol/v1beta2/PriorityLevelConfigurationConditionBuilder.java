package io.fabric8.kubernetes.api.model.flowcontrol.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PriorityLevelConfigurationConditionBuilder extends PriorityLevelConfigurationConditionFluent<PriorityLevelConfigurationConditionBuilder> implements VisitableBuilder<PriorityLevelConfigurationCondition,PriorityLevelConfigurationConditionBuilder>{

  PriorityLevelConfigurationConditionFluent<?> fluent;

  public PriorityLevelConfigurationConditionBuilder() {
    this(new PriorityLevelConfigurationCondition());
  }
  
  public PriorityLevelConfigurationConditionBuilder(PriorityLevelConfigurationConditionFluent<?> fluent) {
    this(fluent, new PriorityLevelConfigurationCondition());
  }
  
  public PriorityLevelConfigurationConditionBuilder(PriorityLevelConfigurationCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PriorityLevelConfigurationConditionBuilder(PriorityLevelConfigurationConditionFluent<?> fluent,PriorityLevelConfigurationCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PriorityLevelConfigurationCondition build() {
    PriorityLevelConfigurationCondition buildable = new PriorityLevelConfigurationCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}