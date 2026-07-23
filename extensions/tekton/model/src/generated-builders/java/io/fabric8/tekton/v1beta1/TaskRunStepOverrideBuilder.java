package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskRunStepOverrideBuilder extends TaskRunStepOverrideFluent<TaskRunStepOverrideBuilder> implements VisitableBuilder<TaskRunStepOverride,TaskRunStepOverrideBuilder>{

  TaskRunStepOverrideFluent<?> fluent;

  public TaskRunStepOverrideBuilder() {
    this(new TaskRunStepOverride());
  }
  
  public TaskRunStepOverrideBuilder(TaskRunStepOverrideFluent<?> fluent) {
    this(fluent, new TaskRunStepOverride());
  }
  
  public TaskRunStepOverrideBuilder(TaskRunStepOverride instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskRunStepOverrideBuilder(TaskRunStepOverrideFluent<?> fluent,TaskRunStepOverride instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskRunStepOverride build() {
    TaskRunStepOverride buildable = new TaskRunStepOverride(fluent.getName(), fluent.buildResources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}