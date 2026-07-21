package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RolloutProgressiveBuilder extends RolloutProgressiveFluent<RolloutProgressiveBuilder> implements VisitableBuilder<RolloutProgressive,RolloutProgressiveBuilder>{

  RolloutProgressiveFluent<?> fluent;

  public RolloutProgressiveBuilder() {
    this(new RolloutProgressive());
  }
  
  public RolloutProgressiveBuilder(RolloutProgressiveFluent<?> fluent) {
    this(fluent, new RolloutProgressive());
  }
  
  public RolloutProgressiveBuilder(RolloutProgressive instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RolloutProgressiveBuilder(RolloutProgressiveFluent<?> fluent,RolloutProgressive instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RolloutProgressive build() {
    RolloutProgressive buildable = new RolloutProgressive(fluent.buildMandatoryDecisionGroups(), fluent.buildMaxConcurrency(), fluent.buildMaxFailures(), fluent.getMinSuccessTime(), fluent.getProgressDeadline());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}