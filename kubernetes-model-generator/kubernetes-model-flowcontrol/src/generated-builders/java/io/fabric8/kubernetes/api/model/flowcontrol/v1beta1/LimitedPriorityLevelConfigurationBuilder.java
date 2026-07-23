package io.fabric8.kubernetes.api.model.flowcontrol.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LimitedPriorityLevelConfigurationBuilder extends LimitedPriorityLevelConfigurationFluent<LimitedPriorityLevelConfigurationBuilder> implements VisitableBuilder<LimitedPriorityLevelConfiguration,LimitedPriorityLevelConfigurationBuilder>{

  LimitedPriorityLevelConfigurationFluent<?> fluent;

  public LimitedPriorityLevelConfigurationBuilder() {
    this(new LimitedPriorityLevelConfiguration());
  }
  
  public LimitedPriorityLevelConfigurationBuilder(LimitedPriorityLevelConfigurationFluent<?> fluent) {
    this(fluent, new LimitedPriorityLevelConfiguration());
  }
  
  public LimitedPriorityLevelConfigurationBuilder(LimitedPriorityLevelConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LimitedPriorityLevelConfigurationBuilder(LimitedPriorityLevelConfigurationFluent<?> fluent,LimitedPriorityLevelConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LimitedPriorityLevelConfiguration build() {
    LimitedPriorityLevelConfiguration buildable = new LimitedPriorityLevelConfiguration(fluent.getAssuredConcurrencyShares(), fluent.buildLimitResponse());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}