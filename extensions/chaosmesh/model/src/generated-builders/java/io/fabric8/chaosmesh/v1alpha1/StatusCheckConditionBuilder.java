package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatusCheckConditionBuilder extends StatusCheckConditionFluent<StatusCheckConditionBuilder> implements VisitableBuilder<StatusCheckCondition,StatusCheckConditionBuilder>{

  StatusCheckConditionFluent<?> fluent;

  public StatusCheckConditionBuilder() {
    this(new StatusCheckCondition());
  }
  
  public StatusCheckConditionBuilder(StatusCheckConditionFluent<?> fluent) {
    this(fluent, new StatusCheckCondition());
  }
  
  public StatusCheckConditionBuilder(StatusCheckCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatusCheckConditionBuilder(StatusCheckConditionFluent<?> fluent,StatusCheckCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatusCheckCondition build() {
    StatusCheckCondition buildable = new StatusCheckCondition(fluent.getLastProbeTime(), fluent.getLastTransitionTime(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}