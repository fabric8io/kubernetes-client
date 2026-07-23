package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StepBuilder extends StepFluent<StepBuilder> implements VisitableBuilder<Step,StepBuilder>{

  StepFluent<?> fluent;

  public StepBuilder() {
    this(new Step());
  }
  
  public StepBuilder(StepFluent<?> fluent) {
    this(fluent, new Step());
  }
  
  public StepBuilder(Step instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StepBuilder(StepFluent<?> fluent,Step instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Step build() {
    Step buildable = new Step(fluent.getOptional(), fluent.getResolving(), fluent.buildResource(), fluent.getStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}