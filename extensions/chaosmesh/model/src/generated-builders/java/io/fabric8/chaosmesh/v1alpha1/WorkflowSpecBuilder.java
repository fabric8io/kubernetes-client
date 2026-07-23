package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkflowSpecBuilder extends WorkflowSpecFluent<WorkflowSpecBuilder> implements VisitableBuilder<WorkflowSpec,WorkflowSpecBuilder>{

  WorkflowSpecFluent<?> fluent;

  public WorkflowSpecBuilder() {
    this(new WorkflowSpec());
  }
  
  public WorkflowSpecBuilder(WorkflowSpecFluent<?> fluent) {
    this(fluent, new WorkflowSpec());
  }
  
  public WorkflowSpecBuilder(WorkflowSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkflowSpecBuilder(WorkflowSpecFluent<?> fluent,WorkflowSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkflowSpec build() {
    WorkflowSpec buildable = new WorkflowSpec(fluent.getEntry(), fluent.buildTemplates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}