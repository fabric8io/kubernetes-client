package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskResultBuilder extends TaskResultFluent<TaskResultBuilder> implements VisitableBuilder<TaskResult,TaskResultBuilder>{

  TaskResultFluent<?> fluent;

  public TaskResultBuilder() {
    this(new TaskResult());
  }
  
  public TaskResultBuilder(TaskResultFluent<?> fluent) {
    this(fluent, new TaskResult());
  }
  
  public TaskResultBuilder(TaskResult instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskResultBuilder(TaskResultFluent<?> fluent,TaskResult instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskResult build() {
    TaskResult buildable = new TaskResult(fluent.getDescription(), fluent.getName(), fluent.getProperties(), fluent.getType(), fluent.buildValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}