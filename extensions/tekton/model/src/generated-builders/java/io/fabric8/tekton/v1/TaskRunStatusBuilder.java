package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskRunStatusBuilder extends TaskRunStatusFluent<TaskRunStatusBuilder> implements VisitableBuilder<TaskRunStatus,TaskRunStatusBuilder>{

  TaskRunStatusFluent<?> fluent;

  public TaskRunStatusBuilder() {
    this(new TaskRunStatus());
  }
  
  public TaskRunStatusBuilder(TaskRunStatusFluent<?> fluent) {
    this(fluent, new TaskRunStatus());
  }
  
  public TaskRunStatusBuilder(TaskRunStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskRunStatusBuilder(TaskRunStatusFluent<?> fluent,TaskRunStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskRunStatus build() {
    TaskRunStatus buildable = new TaskRunStatus(fluent.getAnnotations(), fluent.buildArtifacts(), fluent.getCompletionTime(), fluent.getConditions(), fluent.getObservedGeneration(), fluent.getPodName(), fluent.buildProvenance(), fluent.buildResults(), fluent.buildRetriesStatus(), fluent.buildSidecars(), fluent.getSpanContext(), fluent.getStartTime(), fluent.buildSteps(), fluent.buildTaskSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}