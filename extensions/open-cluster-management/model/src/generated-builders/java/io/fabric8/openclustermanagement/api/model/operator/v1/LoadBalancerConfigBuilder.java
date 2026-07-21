package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerConfigBuilder extends LoadBalancerConfigFluent<LoadBalancerConfigBuilder> implements VisitableBuilder<LoadBalancerConfig,LoadBalancerConfigBuilder>{

  LoadBalancerConfigFluent<?> fluent;

  public LoadBalancerConfigBuilder() {
    this(new LoadBalancerConfig());
  }
  
  public LoadBalancerConfigBuilder(LoadBalancerConfigFluent<?> fluent) {
    this(fluent, new LoadBalancerConfig());
  }
  
  public LoadBalancerConfigBuilder(LoadBalancerConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerConfigBuilder(LoadBalancerConfigFluent<?> fluent,LoadBalancerConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerConfig build() {
    LoadBalancerConfig buildable = new LoadBalancerConfig(fluent.getCaBundle(), fluent.getHost());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}