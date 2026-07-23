package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkflowBuilder extends WorkflowFluent<WorkflowBuilder> implements VisitableBuilder<Workflow,WorkflowBuilder>{

  WorkflowFluent<?> fluent;

  public WorkflowBuilder() {
    this(new Workflow());
  }
  
  public WorkflowBuilder(WorkflowFluent<?> fluent) {
    this(fluent, new Workflow());
  }
  
  public WorkflowBuilder(Workflow instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkflowBuilder(WorkflowFluent<?> fluent,Workflow instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Workflow build() {
    Workflow buildable = new Workflow(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}