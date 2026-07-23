package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerBuilder extends LoadBalancerFluent<LoadBalancerBuilder> implements VisitableBuilder<LoadBalancer,LoadBalancerBuilder>{

  LoadBalancerFluent<?> fluent;

  public LoadBalancerBuilder() {
    this(new LoadBalancer());
  }
  
  public LoadBalancerBuilder(LoadBalancerFluent<?> fluent) {
    this(fluent, new LoadBalancer());
  }
  
  public LoadBalancerBuilder(LoadBalancer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerBuilder(LoadBalancerFluent<?> fluent,LoadBalancer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancer build() {
    LoadBalancer buildable = new LoadBalancer(fluent.buildPlatform());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}