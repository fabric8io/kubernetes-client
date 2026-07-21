package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskBuilder extends TaskFluent<TaskBuilder> implements VisitableBuilder<Task,TaskBuilder>{

  TaskFluent<?> fluent;

  public TaskBuilder() {
    this(new Task());
  }
  
  public TaskBuilder(TaskFluent<?> fluent) {
    this(fluent, new Task());
  }
  
  public TaskBuilder(Task instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskBuilder(TaskFluent<?> fluent,Task instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Task build() {
    Task buildable = new Task(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}