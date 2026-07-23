package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TopologyShardingStrategyBuilder extends TopologyShardingStrategyFluent<TopologyShardingStrategyBuilder> implements VisitableBuilder<TopologyShardingStrategy,TopologyShardingStrategyBuilder>{

  TopologyShardingStrategyFluent<?> fluent;

  public TopologyShardingStrategyBuilder() {
    this(new TopologyShardingStrategy());
  }
  
  public TopologyShardingStrategyBuilder(TopologyShardingStrategyFluent<?> fluent) {
    this(fluent, new TopologyShardingStrategy());
  }
  
  public TopologyShardingStrategyBuilder(TopologyShardingStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TopologyShardingStrategyBuilder(TopologyShardingStrategyFluent<?> fluent,TopologyShardingStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TopologyShardingStrategy build() {
    TopologyShardingStrategy buildable = new TopologyShardingStrategy(fluent.getExternalLabelName(), fluent.getValues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}