package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RolloutProgressivePerGroupBuilder extends RolloutProgressivePerGroupFluent<RolloutProgressivePerGroupBuilder> implements VisitableBuilder<RolloutProgressivePerGroup,RolloutProgressivePerGroupBuilder>{

  RolloutProgressivePerGroupFluent<?> fluent;

  public RolloutProgressivePerGroupBuilder() {
    this(new RolloutProgressivePerGroup());
  }
  
  public RolloutProgressivePerGroupBuilder(RolloutProgressivePerGroupFluent<?> fluent) {
    this(fluent, new RolloutProgressivePerGroup());
  }
  
  public RolloutProgressivePerGroupBuilder(RolloutProgressivePerGroup instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RolloutProgressivePerGroupBuilder(RolloutProgressivePerGroupFluent<?> fluent,RolloutProgressivePerGroup instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RolloutProgressivePerGroup build() {
    RolloutProgressivePerGroup buildable = new RolloutProgressivePerGroup(fluent.buildMandatoryDecisionGroups(), fluent.buildMaxFailures(), fluent.getMinSuccessTime(), fluent.getProgressDeadline());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}