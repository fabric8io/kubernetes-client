package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ShardingStrategyBuilder extends ShardingStrategyFluent<ShardingStrategyBuilder> implements VisitableBuilder<ShardingStrategy,ShardingStrategyBuilder>{

  ShardingStrategyFluent<?> fluent;

  public ShardingStrategyBuilder() {
    this(new ShardingStrategy());
  }
  
  public ShardingStrategyBuilder(ShardingStrategyFluent<?> fluent) {
    this(fluent, new ShardingStrategy());
  }
  
  public ShardingStrategyBuilder(ShardingStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ShardingStrategyBuilder(ShardingStrategyFluent<?> fluent,ShardingStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ShardingStrategy build() {
    ShardingStrategy buildable = new ShardingStrategy(fluent.getMode(), fluent.buildTopology());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}