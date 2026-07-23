package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RunStatusBuilder extends RunStatusFluent<RunStatusBuilder> implements VisitableBuilder<RunStatus,RunStatusBuilder>{

  RunStatusFluent<?> fluent;

  public RunStatusBuilder() {
    this(new RunStatus());
  }
  
  public RunStatusBuilder(RunStatusFluent<?> fluent) {
    this(fluent, new RunStatus());
  }
  
  public RunStatusBuilder(RunStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RunStatusBuilder(RunStatusFluent<?> fluent,RunStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RunStatus build() {
    RunStatus buildable = new RunStatus(fluent.getAnnotations(), fluent.getCompletionTime(), fluent.getConditions(), fluent.getExtraFields(), fluent.getObservedGeneration(), fluent.buildResults(), fluent.buildRetriesStatus(), fluent.getStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}