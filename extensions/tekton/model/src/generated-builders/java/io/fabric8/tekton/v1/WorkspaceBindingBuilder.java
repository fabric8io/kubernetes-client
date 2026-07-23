package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkspaceBindingBuilder extends WorkspaceBindingFluent<WorkspaceBindingBuilder> implements VisitableBuilder<WorkspaceBinding,WorkspaceBindingBuilder>{

  WorkspaceBindingFluent<?> fluent;

  public WorkspaceBindingBuilder() {
    this(new WorkspaceBinding());
  }
  
  public WorkspaceBindingBuilder(WorkspaceBindingFluent<?> fluent) {
    this(fluent, new WorkspaceBinding());
  }
  
  public WorkspaceBindingBuilder(WorkspaceBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkspaceBindingBuilder(WorkspaceBindingFluent<?> fluent,WorkspaceBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkspaceBinding build() {
    WorkspaceBinding buildable = new WorkspaceBinding(fluent.getConfigMap(), fluent.getCsi(), fluent.getEmptyDir(), fluent.getName(), fluent.getPersistentVolumeClaim(), fluent.getProjected(), fluent.getSecret(), fluent.getSubPath(), fluent.buildVolumeClaimTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}