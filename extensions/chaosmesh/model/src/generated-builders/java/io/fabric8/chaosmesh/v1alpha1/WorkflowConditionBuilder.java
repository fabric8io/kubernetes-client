package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkflowConditionBuilder extends WorkflowConditionFluent<WorkflowConditionBuilder> implements VisitableBuilder<WorkflowCondition,WorkflowConditionBuilder>{

  WorkflowConditionFluent<?> fluent;

  public WorkflowConditionBuilder() {
    this(new WorkflowCondition());
  }
  
  public WorkflowConditionBuilder(WorkflowConditionFluent<?> fluent) {
    this(fluent, new WorkflowCondition());
  }
  
  public WorkflowConditionBuilder(WorkflowCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkflowConditionBuilder(WorkflowConditionFluent<?> fluent,WorkflowCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkflowCondition build() {
    WorkflowCondition buildable = new WorkflowCondition(fluent.getReason(), fluent.getStartTime(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}