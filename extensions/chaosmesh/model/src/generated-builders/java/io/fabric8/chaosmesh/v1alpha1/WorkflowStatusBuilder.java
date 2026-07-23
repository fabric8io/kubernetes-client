package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkflowStatusBuilder extends WorkflowStatusFluent<WorkflowStatusBuilder> implements VisitableBuilder<WorkflowStatus,WorkflowStatusBuilder>{

  WorkflowStatusFluent<?> fluent;

  public WorkflowStatusBuilder() {
    this(new WorkflowStatus());
  }
  
  public WorkflowStatusBuilder(WorkflowStatusFluent<?> fluent) {
    this(fluent, new WorkflowStatus());
  }
  
  public WorkflowStatusBuilder(WorkflowStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkflowStatusBuilder(WorkflowStatusFluent<?> fluent,WorkflowStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkflowStatus build() {
    WorkflowStatus buildable = new WorkflowStatus(fluent.buildConditions(), fluent.getEndTime(), fluent.getEntryNode(), fluent.getStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}