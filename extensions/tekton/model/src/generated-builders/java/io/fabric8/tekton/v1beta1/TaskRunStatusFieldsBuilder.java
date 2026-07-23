package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskRunStatusFieldsBuilder extends TaskRunStatusFieldsFluent<TaskRunStatusFieldsBuilder> implements VisitableBuilder<TaskRunStatusFields,TaskRunStatusFieldsBuilder>{

  TaskRunStatusFieldsFluent<?> fluent;

  public TaskRunStatusFieldsBuilder() {
    this(new TaskRunStatusFields());
  }
  
  public TaskRunStatusFieldsBuilder(TaskRunStatusFieldsFluent<?> fluent) {
    this(fluent, new TaskRunStatusFields());
  }
  
  public TaskRunStatusFieldsBuilder(TaskRunStatusFields instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskRunStatusFieldsBuilder(TaskRunStatusFieldsFluent<?> fluent,TaskRunStatusFields instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskRunStatusFields build() {
    TaskRunStatusFields buildable = new TaskRunStatusFields(fluent.buildCloudEvents(), fluent.getCompletionTime(), fluent.getPodName(), fluent.buildProvenance(), fluent.buildResourcesResult(), fluent.buildRetriesStatus(), fluent.buildSidecars(), fluent.getSpanContext(), fluent.getStartTime(), fluent.buildSteps(), fluent.buildTaskResults(), fluent.buildTaskSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}