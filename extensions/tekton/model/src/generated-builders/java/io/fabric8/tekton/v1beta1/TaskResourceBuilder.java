package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskResourceBuilder extends TaskResourceFluent<TaskResourceBuilder> implements VisitableBuilder<TaskResource,TaskResourceBuilder>{

  TaskResourceFluent<?> fluent;

  public TaskResourceBuilder() {
    this(new TaskResource());
  }
  
  public TaskResourceBuilder(TaskResourceFluent<?> fluent) {
    this(fluent, new TaskResource());
  }
  
  public TaskResourceBuilder(TaskResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskResourceBuilder(TaskResourceFluent<?> fluent,TaskResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskResource build() {
    TaskResource buildable = new TaskResource(fluent.getDescription(), fluent.getName(), fluent.getOptional(), fluent.getTargetPath(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}