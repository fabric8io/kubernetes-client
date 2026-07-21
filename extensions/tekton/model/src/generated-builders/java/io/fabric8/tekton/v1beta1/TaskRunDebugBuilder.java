package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskRunDebugBuilder extends TaskRunDebugFluent<TaskRunDebugBuilder> implements VisitableBuilder<TaskRunDebug,TaskRunDebugBuilder>{

  TaskRunDebugFluent<?> fluent;

  public TaskRunDebugBuilder() {
    this(new TaskRunDebug());
  }
  
  public TaskRunDebugBuilder(TaskRunDebugFluent<?> fluent) {
    this(fluent, new TaskRunDebug());
  }
  
  public TaskRunDebugBuilder(TaskRunDebug instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskRunDebugBuilder(TaskRunDebugFluent<?> fluent,TaskRunDebug instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskRunDebug build() {
    TaskRunDebug buildable = new TaskRunDebug(fluent.buildBreakpoints());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}