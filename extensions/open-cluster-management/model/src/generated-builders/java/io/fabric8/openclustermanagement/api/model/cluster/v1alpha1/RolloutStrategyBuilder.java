package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RolloutStrategyBuilder extends RolloutStrategyFluent<RolloutStrategyBuilder> implements VisitableBuilder<RolloutStrategy,RolloutStrategyBuilder>{

  RolloutStrategyFluent<?> fluent;

  public RolloutStrategyBuilder() {
    this(new RolloutStrategy());
  }
  
  public RolloutStrategyBuilder(RolloutStrategyFluent<?> fluent) {
    this(fluent, new RolloutStrategy());
  }
  
  public RolloutStrategyBuilder(RolloutStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RolloutStrategyBuilder(RolloutStrategyFluent<?> fluent,RolloutStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RolloutStrategy build() {
    RolloutStrategy buildable = new RolloutStrategy(fluent.buildAll(), fluent.buildProgressive(), fluent.buildProgressivePerGroup(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}