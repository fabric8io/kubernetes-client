package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerStatusBuilder extends LoadBalancerStatusFluent<LoadBalancerStatusBuilder> implements VisitableBuilder<LoadBalancerStatus,LoadBalancerStatusBuilder>{

  LoadBalancerStatusFluent<?> fluent;

  public LoadBalancerStatusBuilder() {
    this(new LoadBalancerStatus());
  }
  
  public LoadBalancerStatusBuilder(LoadBalancerStatusFluent<?> fluent) {
    this(fluent, new LoadBalancerStatus());
  }
  
  public LoadBalancerStatusBuilder(LoadBalancerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerStatusBuilder(LoadBalancerStatusFluent<?> fluent,LoadBalancerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerStatus build() {
    LoadBalancerStatus buildable = new LoadBalancerStatus(fluent.buildIngress());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}