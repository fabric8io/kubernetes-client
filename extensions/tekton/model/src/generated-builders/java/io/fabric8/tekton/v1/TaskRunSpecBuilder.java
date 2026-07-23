package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskRunSpecBuilder extends TaskRunSpecFluent<TaskRunSpecBuilder> implements VisitableBuilder<TaskRunSpec,TaskRunSpecBuilder>{

  TaskRunSpecFluent<?> fluent;

  public TaskRunSpecBuilder() {
    this(new TaskRunSpec());
  }
  
  public TaskRunSpecBuilder(TaskRunSpecFluent<?> fluent) {
    this(fluent, new TaskRunSpec());
  }
  
  public TaskRunSpecBuilder(TaskRunSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskRunSpecBuilder(TaskRunSpecFluent<?> fluent,TaskRunSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskRunSpec build() {
    TaskRunSpec buildable = new TaskRunSpec(fluent.buildComputeResources(), fluent.buildDebug(), fluent.getManagedBy(), fluent.buildParams(), fluent.buildPodTemplate(), fluent.getRetries(), fluent.getServiceAccountName(), fluent.buildSidecarSpecs(), fluent.getStatus(), fluent.getStatusMessage(), fluent.buildStepSpecs(), fluent.buildTaskRef(), fluent.buildTaskSpec(), fluent.getTimeout(), fluent.buildWorkspaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}