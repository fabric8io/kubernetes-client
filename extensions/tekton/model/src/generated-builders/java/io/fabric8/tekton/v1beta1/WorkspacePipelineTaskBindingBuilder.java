package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkspacePipelineTaskBindingBuilder extends WorkspacePipelineTaskBindingFluent<WorkspacePipelineTaskBindingBuilder> implements VisitableBuilder<WorkspacePipelineTaskBinding,WorkspacePipelineTaskBindingBuilder>{

  WorkspacePipelineTaskBindingFluent<?> fluent;

  public WorkspacePipelineTaskBindingBuilder() {
    this(new WorkspacePipelineTaskBinding());
  }
  
  public WorkspacePipelineTaskBindingBuilder(WorkspacePipelineTaskBindingFluent<?> fluent) {
    this(fluent, new WorkspacePipelineTaskBinding());
  }
  
  public WorkspacePipelineTaskBindingBuilder(WorkspacePipelineTaskBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkspacePipelineTaskBindingBuilder(WorkspacePipelineTaskBindingFluent<?> fluent,WorkspacePipelineTaskBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkspacePipelineTaskBinding build() {
    WorkspacePipelineTaskBinding buildable = new WorkspacePipelineTaskBinding(fluent.getName(), fluent.getSubPath(), fluent.getWorkspace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}