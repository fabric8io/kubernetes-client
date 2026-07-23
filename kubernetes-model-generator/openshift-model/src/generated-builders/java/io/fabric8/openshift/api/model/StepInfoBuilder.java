package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StepInfoBuilder extends StepInfoFluent<StepInfoBuilder> implements VisitableBuilder<StepInfo,StepInfoBuilder>{

  StepInfoFluent<?> fluent;

  public StepInfoBuilder() {
    this(new StepInfo());
  }
  
  public StepInfoBuilder(StepInfoFluent<?> fluent) {
    this(fluent, new StepInfo());
  }
  
  public StepInfoBuilder(StepInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StepInfoBuilder(StepInfoFluent<?> fluent,StepInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StepInfo build() {
    StepInfo buildable = new StepInfo(fluent.getDurationMilliseconds(), fluent.getName(), fluent.getStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}