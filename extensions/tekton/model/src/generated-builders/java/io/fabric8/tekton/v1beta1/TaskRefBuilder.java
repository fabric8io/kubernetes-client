package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskRefBuilder extends TaskRefFluent<TaskRefBuilder> implements VisitableBuilder<TaskRef,TaskRefBuilder>{

  TaskRefFluent<?> fluent;

  public TaskRefBuilder() {
    this(new TaskRef());
  }
  
  public TaskRefBuilder(TaskRefFluent<?> fluent) {
    this(fluent, new TaskRef());
  }
  
  public TaskRefBuilder(TaskRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskRefBuilder(TaskRefFluent<?> fluent,TaskRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskRef build() {
    TaskRef buildable = new TaskRef(fluent.getApiVersion(), fluent.getBundle(), fluent.getKind(), fluent.getName(), fluent.buildParams(), fluent.getResolver());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}