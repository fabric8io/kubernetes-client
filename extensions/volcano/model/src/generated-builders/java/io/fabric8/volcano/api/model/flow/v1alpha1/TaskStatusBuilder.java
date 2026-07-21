package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskStatusBuilder extends TaskStatusFluent<TaskStatusBuilder> implements VisitableBuilder<TaskStatus,TaskStatusBuilder>{

  TaskStatusFluent<?> fluent;

  public TaskStatusBuilder() {
    this(new TaskStatus());
  }
  
  public TaskStatusBuilder(TaskStatusFluent<?> fluent) {
    this(fluent, new TaskStatus());
  }
  
  public TaskStatusBuilder(TaskStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskStatusBuilder(TaskStatusFluent<?> fluent,TaskStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskStatus build() {
    TaskStatus buildable = new TaskStatus(fluent.getPhase(), fluent.getTaskName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}