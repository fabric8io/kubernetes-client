package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkflowNodeListBuilder extends WorkflowNodeListFluent<WorkflowNodeListBuilder> implements VisitableBuilder<WorkflowNodeList,WorkflowNodeListBuilder>{

  WorkflowNodeListFluent<?> fluent;

  public WorkflowNodeListBuilder() {
    this(new WorkflowNodeList());
  }
  
  public WorkflowNodeListBuilder(WorkflowNodeListFluent<?> fluent) {
    this(fluent, new WorkflowNodeList());
  }
  
  public WorkflowNodeListBuilder(WorkflowNodeList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkflowNodeListBuilder(WorkflowNodeListFluent<?> fluent,WorkflowNodeList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkflowNodeList build() {
    WorkflowNodeList buildable = new WorkflowNodeList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}