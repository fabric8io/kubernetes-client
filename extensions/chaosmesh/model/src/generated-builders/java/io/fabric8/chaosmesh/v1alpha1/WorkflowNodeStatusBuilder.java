package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkflowNodeStatusBuilder extends WorkflowNodeStatusFluent<WorkflowNodeStatusBuilder> implements VisitableBuilder<WorkflowNodeStatus,WorkflowNodeStatusBuilder>{

  WorkflowNodeStatusFluent<?> fluent;

  public WorkflowNodeStatusBuilder() {
    this(new WorkflowNodeStatus());
  }
  
  public WorkflowNodeStatusBuilder(WorkflowNodeStatusFluent<?> fluent) {
    this(fluent, new WorkflowNodeStatus());
  }
  
  public WorkflowNodeStatusBuilder(WorkflowNodeStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkflowNodeStatusBuilder(WorkflowNodeStatusFluent<?> fluent,WorkflowNodeStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkflowNodeStatus build() {
    WorkflowNodeStatus buildable = new WorkflowNodeStatus(fluent.buildActiveChildren(), fluent.getChaosResource(), fluent.buildConditionalBranchesStatus(), fluent.buildConditions(), fluent.buildFinishedChildren());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}