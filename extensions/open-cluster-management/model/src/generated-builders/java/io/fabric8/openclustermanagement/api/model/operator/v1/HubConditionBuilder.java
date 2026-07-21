package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HubConditionBuilder extends HubConditionFluent<HubConditionBuilder> implements VisitableBuilder<HubCondition,HubConditionBuilder>{

  HubConditionFluent<?> fluent;

  public HubConditionBuilder() {
    this(new HubCondition());
  }
  
  public HubConditionBuilder(HubConditionFluent<?> fluent) {
    this(fluent, new HubCondition());
  }
  
  public HubConditionBuilder(HubCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HubConditionBuilder(HubConditionFluent<?> fluent,HubCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HubCondition build() {
    HubCondition buildable = new HubCondition(fluent.getLastTransitionTime(), fluent.getLastUpdateTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}