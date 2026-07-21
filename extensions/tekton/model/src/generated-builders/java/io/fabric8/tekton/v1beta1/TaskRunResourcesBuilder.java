package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskRunResourcesBuilder extends TaskRunResourcesFluent<TaskRunResourcesBuilder> implements VisitableBuilder<TaskRunResources,TaskRunResourcesBuilder>{

  TaskRunResourcesFluent<?> fluent;

  public TaskRunResourcesBuilder() {
    this(new TaskRunResources());
  }
  
  public TaskRunResourcesBuilder(TaskRunResourcesFluent<?> fluent) {
    this(fluent, new TaskRunResources());
  }
  
  public TaskRunResourcesBuilder(TaskRunResources instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskRunResourcesBuilder(TaskRunResourcesFluent<?> fluent,TaskRunResources instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskRunResources build() {
    TaskRunResources buildable = new TaskRunResources(fluent.buildInputs(), fluent.buildOutputs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}