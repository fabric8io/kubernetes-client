package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ComponentConditionBuilder extends ComponentConditionFluent<ComponentConditionBuilder> implements VisitableBuilder<ComponentCondition,ComponentConditionBuilder>{

  ComponentConditionFluent<?> fluent;

  public ComponentConditionBuilder() {
    this(new ComponentCondition());
  }
  
  public ComponentConditionBuilder(ComponentConditionFluent<?> fluent) {
    this(fluent, new ComponentCondition());
  }
  
  public ComponentConditionBuilder(ComponentCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ComponentConditionBuilder(ComponentConditionFluent<?> fluent,ComponentCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ComponentCondition build() {
    ComponentCondition buildable = new ComponentCondition(fluent.getError(), fluent.getMessage(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}