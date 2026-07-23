package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerStrategyBuilder extends LoadBalancerStrategyFluent<LoadBalancerStrategyBuilder> implements VisitableBuilder<LoadBalancerStrategy,LoadBalancerStrategyBuilder>{

  LoadBalancerStrategyFluent<?> fluent;

  public LoadBalancerStrategyBuilder() {
    this(new LoadBalancerStrategy());
  }
  
  public LoadBalancerStrategyBuilder(LoadBalancerStrategyFluent<?> fluent) {
    this(fluent, new LoadBalancerStrategy());
  }
  
  public LoadBalancerStrategyBuilder(LoadBalancerStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerStrategyBuilder(LoadBalancerStrategyFluent<?> fluent,LoadBalancerStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerStrategy build() {
    LoadBalancerStrategy buildable = new LoadBalancerStrategy(fluent.getAllowedSourceRanges(), fluent.getDnsManagementPolicy(), fluent.buildProviderParameters(), fluent.getScope());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}