package io.fabric8.openclustermanagement.api.model.observability.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatusConditionBuilder extends StatusConditionFluent<StatusConditionBuilder> implements VisitableBuilder<StatusCondition,StatusConditionBuilder>{

  StatusConditionFluent<?> fluent;

  public StatusConditionBuilder() {
    this(new StatusCondition());
  }
  
  public StatusConditionBuilder(StatusConditionFluent<?> fluent) {
    this(fluent, new StatusCondition());
  }
  
  public StatusConditionBuilder(StatusCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatusConditionBuilder(StatusConditionFluent<?> fluent,StatusCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatusCondition build() {
    StatusCondition buildable = new StatusCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}