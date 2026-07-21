package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StepActionBuilder extends StepActionFluent<StepActionBuilder> implements VisitableBuilder<StepAction,StepActionBuilder>{

  StepActionFluent<?> fluent;

  public StepActionBuilder() {
    this(new StepAction());
  }
  
  public StepActionBuilder(StepActionFluent<?> fluent) {
    this(fluent, new StepAction());
  }
  
  public StepActionBuilder(StepAction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StepActionBuilder(StepActionFluent<?> fluent,StepAction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StepAction build() {
    StepAction buildable = new StepAction(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}