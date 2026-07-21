package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskRunOutputsBuilder extends TaskRunOutputsFluent<TaskRunOutputsBuilder> implements VisitableBuilder<TaskRunOutputs,TaskRunOutputsBuilder>{

  TaskRunOutputsFluent<?> fluent;

  public TaskRunOutputsBuilder() {
    this(new TaskRunOutputs());
  }
  
  public TaskRunOutputsBuilder(TaskRunOutputsFluent<?> fluent) {
    this(fluent, new TaskRunOutputs());
  }
  
  public TaskRunOutputsBuilder(TaskRunOutputs instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskRunOutputsBuilder(TaskRunOutputsFluent<?> fluent,TaskRunOutputs instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskRunOutputs build() {
    TaskRunOutputs buildable = new TaskRunOutputs(fluent.buildResources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}