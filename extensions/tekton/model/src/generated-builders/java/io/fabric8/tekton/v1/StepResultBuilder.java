package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StepResultBuilder extends StepResultFluent<StepResultBuilder> implements VisitableBuilder<StepResult,StepResultBuilder>{

  StepResultFluent<?> fluent;

  public StepResultBuilder() {
    this(new StepResult());
  }
  
  public StepResultBuilder(StepResultFluent<?> fluent) {
    this(fluent, new StepResult());
  }
  
  public StepResultBuilder(StepResult instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StepResultBuilder(StepResultFluent<?> fluent,StepResult instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StepResult build() {
    StepResult buildable = new StepResult(fluent.getDescription(), fluent.getName(), fluent.getProperties(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}