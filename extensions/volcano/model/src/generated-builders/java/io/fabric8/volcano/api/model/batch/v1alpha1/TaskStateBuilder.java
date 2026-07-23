package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskStateBuilder extends TaskStateFluent<TaskStateBuilder> implements VisitableBuilder<TaskState,TaskStateBuilder>{

  TaskStateFluent<?> fluent;

  public TaskStateBuilder() {
    this(new TaskState());
  }
  
  public TaskStateBuilder(TaskStateFluent<?> fluent) {
    this(fluent, new TaskState());
  }
  
  public TaskStateBuilder(TaskState instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskStateBuilder(TaskStateFluent<?> fluent,TaskState instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskState build() {
    TaskState buildable = new TaskState(fluent.getPhase());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}