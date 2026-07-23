package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskRunBuilder extends TaskRunFluent<TaskRunBuilder> implements VisitableBuilder<TaskRun,TaskRunBuilder>{

  TaskRunFluent<?> fluent;

  public TaskRunBuilder() {
    this(new TaskRun());
  }
  
  public TaskRunBuilder(TaskRunFluent<?> fluent) {
    this(fluent, new TaskRun());
  }
  
  public TaskRunBuilder(TaskRun instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskRunBuilder(TaskRunFluent<?> fluent,TaskRun instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskRun build() {
    TaskRun buildable = new TaskRun(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}