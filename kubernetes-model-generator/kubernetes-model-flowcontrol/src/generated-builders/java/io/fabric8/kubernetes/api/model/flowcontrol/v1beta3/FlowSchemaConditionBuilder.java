package io.fabric8.kubernetes.api.model.flowcontrol.v1beta3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FlowSchemaConditionBuilder extends FlowSchemaConditionFluent<FlowSchemaConditionBuilder> implements VisitableBuilder<FlowSchemaCondition,FlowSchemaConditionBuilder>{

  FlowSchemaConditionFluent<?> fluent;

  public FlowSchemaConditionBuilder() {
    this(new FlowSchemaCondition());
  }
  
  public FlowSchemaConditionBuilder(FlowSchemaConditionFluent<?> fluent) {
    this(fluent, new FlowSchemaCondition());
  }
  
  public FlowSchemaConditionBuilder(FlowSchemaCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FlowSchemaConditionBuilder(FlowSchemaConditionFluent<?> fluent,FlowSchemaCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FlowSchemaCondition build() {
    FlowSchemaCondition buildable = new FlowSchemaCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}