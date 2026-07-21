package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskRunSidecarOverrideBuilder extends TaskRunSidecarOverrideFluent<TaskRunSidecarOverrideBuilder> implements VisitableBuilder<TaskRunSidecarOverride,TaskRunSidecarOverrideBuilder>{

  TaskRunSidecarOverrideFluent<?> fluent;

  public TaskRunSidecarOverrideBuilder() {
    this(new TaskRunSidecarOverride());
  }
  
  public TaskRunSidecarOverrideBuilder(TaskRunSidecarOverrideFluent<?> fluent) {
    this(fluent, new TaskRunSidecarOverride());
  }
  
  public TaskRunSidecarOverrideBuilder(TaskRunSidecarOverride instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskRunSidecarOverrideBuilder(TaskRunSidecarOverrideFluent<?> fluent,TaskRunSidecarOverride instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskRunSidecarOverride build() {
    TaskRunSidecarOverride buildable = new TaskRunSidecarOverride(fluent.getName(), fluent.buildResources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}