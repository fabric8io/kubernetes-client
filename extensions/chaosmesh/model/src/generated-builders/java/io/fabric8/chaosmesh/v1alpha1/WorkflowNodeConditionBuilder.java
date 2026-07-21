package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkflowNodeConditionBuilder extends WorkflowNodeConditionFluent<WorkflowNodeConditionBuilder> implements VisitableBuilder<WorkflowNodeCondition,WorkflowNodeConditionBuilder>{

  WorkflowNodeConditionFluent<?> fluent;

  public WorkflowNodeConditionBuilder() {
    this(new WorkflowNodeCondition());
  }
  
  public WorkflowNodeConditionBuilder(WorkflowNodeConditionFluent<?> fluent) {
    this(fluent, new WorkflowNodeCondition());
  }
  
  public WorkflowNodeConditionBuilder(WorkflowNodeCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkflowNodeConditionBuilder(WorkflowNodeConditionFluent<?> fluent,WorkflowNodeCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkflowNodeCondition build() {
    WorkflowNodeCondition buildable = new WorkflowNodeCondition(fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}