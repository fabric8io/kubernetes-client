package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskRunStepSpecBuilder extends TaskRunStepSpecFluent<TaskRunStepSpecBuilder> implements VisitableBuilder<TaskRunStepSpec,TaskRunStepSpecBuilder>{

  TaskRunStepSpecFluent<?> fluent;

  public TaskRunStepSpecBuilder() {
    this(new TaskRunStepSpec());
  }
  
  public TaskRunStepSpecBuilder(TaskRunStepSpecFluent<?> fluent) {
    this(fluent, new TaskRunStepSpec());
  }
  
  public TaskRunStepSpecBuilder(TaskRunStepSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskRunStepSpecBuilder(TaskRunStepSpecFluent<?> fluent,TaskRunStepSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskRunStepSpec build() {
    TaskRunStepSpec buildable = new TaskRunStepSpec(fluent.buildComputeResources(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}