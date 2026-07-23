package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RunResultBuilder extends RunResultFluent<RunResultBuilder> implements VisitableBuilder<RunResult,RunResultBuilder>{

  RunResultFluent<?> fluent;

  public RunResultBuilder() {
    this(new RunResult());
  }
  
  public RunResultBuilder(RunResultFluent<?> fluent) {
    this(fluent, new RunResult());
  }
  
  public RunResultBuilder(RunResult instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RunResultBuilder(RunResultFluent<?> fluent,RunResult instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RunResult build() {
    RunResult buildable = new RunResult(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}