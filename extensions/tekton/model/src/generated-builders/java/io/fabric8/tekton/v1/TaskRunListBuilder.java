package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskRunListBuilder extends TaskRunListFluent<TaskRunListBuilder> implements VisitableBuilder<TaskRunList,TaskRunListBuilder>{

  TaskRunListFluent<?> fluent;

  public TaskRunListBuilder() {
    this(new TaskRunList());
  }
  
  public TaskRunListBuilder(TaskRunListFluent<?> fluent) {
    this(fluent, new TaskRunList());
  }
  
  public TaskRunListBuilder(TaskRunList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskRunListBuilder(TaskRunListFluent<?> fluent,TaskRunList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskRunList build() {
    TaskRunList buildable = new TaskRunList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}