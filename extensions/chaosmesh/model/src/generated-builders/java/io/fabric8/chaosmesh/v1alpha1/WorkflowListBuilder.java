package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkflowListBuilder extends WorkflowListFluent<WorkflowListBuilder> implements VisitableBuilder<WorkflowList,WorkflowListBuilder>{

  WorkflowListFluent<?> fluent;

  public WorkflowListBuilder() {
    this(new WorkflowList());
  }
  
  public WorkflowListBuilder(WorkflowListFluent<?> fluent) {
    this(fluent, new WorkflowList());
  }
  
  public WorkflowListBuilder(WorkflowList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkflowListBuilder(WorkflowListFluent<?> fluent,WorkflowList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkflowList build() {
    WorkflowList buildable = new WorkflowList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}