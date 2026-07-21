package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskRunResultBuilder extends TaskRunResultFluent<TaskRunResultBuilder> implements VisitableBuilder<TaskRunResult,TaskRunResultBuilder>{

  TaskRunResultFluent<?> fluent;

  public TaskRunResultBuilder() {
    this(new TaskRunResult());
  }
  
  public TaskRunResultBuilder(TaskRunResultFluent<?> fluent) {
    this(fluent, new TaskRunResult());
  }
  
  public TaskRunResultBuilder(TaskRunResult instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskRunResultBuilder(TaskRunResultFluent<?> fluent,TaskRunResult instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskRunResult build() {
    TaskRunResult buildable = new TaskRunResult(fluent.getName(), fluent.getType(), fluent.buildValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}