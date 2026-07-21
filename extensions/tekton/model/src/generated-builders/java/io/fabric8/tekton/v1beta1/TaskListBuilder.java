package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskListBuilder extends TaskListFluent<TaskListBuilder> implements VisitableBuilder<TaskList,TaskListBuilder>{

  TaskListFluent<?> fluent;

  public TaskListBuilder() {
    this(new TaskList());
  }
  
  public TaskListBuilder(TaskListFluent<?> fluent) {
    this(fluent, new TaskList());
  }
  
  public TaskListBuilder(TaskList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskListBuilder(TaskListFluent<?> fluent,TaskList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskList build() {
    TaskList buildable = new TaskList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}