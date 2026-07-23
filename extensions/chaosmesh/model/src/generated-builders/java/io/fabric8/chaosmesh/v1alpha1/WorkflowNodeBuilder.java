package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkflowNodeBuilder extends WorkflowNodeFluent<WorkflowNodeBuilder> implements VisitableBuilder<WorkflowNode,WorkflowNodeBuilder>{

  WorkflowNodeFluent<?> fluent;

  public WorkflowNodeBuilder() {
    this(new WorkflowNode());
  }
  
  public WorkflowNodeBuilder(WorkflowNodeFluent<?> fluent) {
    this(fluent, new WorkflowNode());
  }
  
  public WorkflowNodeBuilder(WorkflowNode instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkflowNodeBuilder(WorkflowNodeFluent<?> fluent,WorkflowNode instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkflowNode build() {
    WorkflowNode buildable = new WorkflowNode(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}