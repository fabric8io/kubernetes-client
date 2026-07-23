package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskRunSidecarSpecBuilder extends TaskRunSidecarSpecFluent<TaskRunSidecarSpecBuilder> implements VisitableBuilder<TaskRunSidecarSpec,TaskRunSidecarSpecBuilder>{

  TaskRunSidecarSpecFluent<?> fluent;

  public TaskRunSidecarSpecBuilder() {
    this(new TaskRunSidecarSpec());
  }
  
  public TaskRunSidecarSpecBuilder(TaskRunSidecarSpecFluent<?> fluent) {
    this(fluent, new TaskRunSidecarSpec());
  }
  
  public TaskRunSidecarSpecBuilder(TaskRunSidecarSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskRunSidecarSpecBuilder(TaskRunSidecarSpecFluent<?> fluent,TaskRunSidecarSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskRunSidecarSpec build() {
    TaskRunSidecarSpec buildable = new TaskRunSidecarSpec(fluent.buildComputeResources(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}