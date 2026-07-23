package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskSpecBuilder extends TaskSpecFluent<TaskSpecBuilder> implements VisitableBuilder<TaskSpec,TaskSpecBuilder>{

  TaskSpecFluent<?> fluent;

  public TaskSpecBuilder() {
    this(new TaskSpec());
  }
  
  public TaskSpecBuilder(TaskSpecFluent<?> fluent) {
    this(fluent, new TaskSpec());
  }
  
  public TaskSpecBuilder(TaskSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskSpecBuilder(TaskSpecFluent<?> fluent,TaskSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskSpec build() {
    TaskSpec buildable = new TaskSpec(fluent.getDescription(), fluent.getDisplayName(), fluent.buildParams(), fluent.buildResults(), fluent.buildSidecars(), fluent.buildStepTemplate(), fluent.buildSteps(), fluent.buildVolumes(), fluent.buildWorkspaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}