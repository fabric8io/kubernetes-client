package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskRunInputsBuilder extends TaskRunInputsFluent<TaskRunInputsBuilder> implements VisitableBuilder<TaskRunInputs,TaskRunInputsBuilder>{

  TaskRunInputsFluent<?> fluent;

  public TaskRunInputsBuilder() {
    this(new TaskRunInputs());
  }
  
  public TaskRunInputsBuilder(TaskRunInputsFluent<?> fluent) {
    this(fluent, new TaskRunInputs());
  }
  
  public TaskRunInputsBuilder(TaskRunInputs instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskRunInputsBuilder(TaskRunInputsFluent<?> fluent,TaskRunInputs instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskRunInputs build() {
    TaskRunInputs buildable = new TaskRunInputs(fluent.buildParams());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}