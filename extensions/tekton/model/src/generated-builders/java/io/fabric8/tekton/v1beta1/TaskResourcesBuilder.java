package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskResourcesBuilder extends TaskResourcesFluent<TaskResourcesBuilder> implements VisitableBuilder<TaskResources,TaskResourcesBuilder>{

  TaskResourcesFluent<?> fluent;

  public TaskResourcesBuilder() {
    this(new TaskResources());
  }
  
  public TaskResourcesBuilder(TaskResourcesFluent<?> fluent) {
    this(fluent, new TaskResources());
  }
  
  public TaskResourcesBuilder(TaskResources instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskResourcesBuilder(TaskResourcesFluent<?> fluent,TaskResources instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskResources build() {
    TaskResources buildable = new TaskResources(fluent.buildInputs(), fluent.buildOutputs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}