package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StepStateBuilder extends StepStateFluent<StepStateBuilder> implements VisitableBuilder<StepState,StepStateBuilder>{

  StepStateFluent<?> fluent;

  public StepStateBuilder() {
    this(new StepState());
  }
  
  public StepStateBuilder(StepStateFluent<?> fluent) {
    this(fluent, new StepState());
  }
  
  public StepStateBuilder(StepState instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StepStateBuilder(StepStateFluent<?> fluent,StepState instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StepState build() {
    StepState buildable = new StepState(fluent.getContainer(), fluent.getImageID(), fluent.buildInputs(), fluent.getName(), fluent.buildOutputs(), fluent.buildProvenance(), fluent.buildResults(), fluent.getRunning(), fluent.getTerminated(), fluent.getWaiting());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}