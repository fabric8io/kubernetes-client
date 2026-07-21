package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskResourceBindingBuilder extends TaskResourceBindingFluent<TaskResourceBindingBuilder> implements VisitableBuilder<TaskResourceBinding,TaskResourceBindingBuilder>{

  TaskResourceBindingFluent<?> fluent;

  public TaskResourceBindingBuilder() {
    this(new TaskResourceBinding());
  }
  
  public TaskResourceBindingBuilder(TaskResourceBindingFluent<?> fluent) {
    this(fluent, new TaskResourceBinding());
  }
  
  public TaskResourceBindingBuilder(TaskResourceBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskResourceBindingBuilder(TaskResourceBindingFluent<?> fluent,TaskResourceBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskResourceBinding build() {
    TaskResourceBinding buildable = new TaskResourceBinding(fluent.getName(), fluent.getPaths(), fluent.buildResourceRef(), fluent.buildResourceSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}