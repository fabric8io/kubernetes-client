package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkspaceUsageBuilder extends WorkspaceUsageFluent<WorkspaceUsageBuilder> implements VisitableBuilder<WorkspaceUsage,WorkspaceUsageBuilder>{

  WorkspaceUsageFluent<?> fluent;

  public WorkspaceUsageBuilder() {
    this(new WorkspaceUsage());
  }
  
  public WorkspaceUsageBuilder(WorkspaceUsageFluent<?> fluent) {
    this(fluent, new WorkspaceUsage());
  }
  
  public WorkspaceUsageBuilder(WorkspaceUsage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkspaceUsageBuilder(WorkspaceUsageFluent<?> fluent,WorkspaceUsage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkspaceUsage build() {
    WorkspaceUsage buildable = new WorkspaceUsage(fluent.getMountPath(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}