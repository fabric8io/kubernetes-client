package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerSettingsConsistentHashLBHttpHeaderNameBuilder extends LoadBalancerSettingsConsistentHashLBHttpHeaderNameFluent<LoadBalancerSettingsConsistentHashLBHttpHeaderNameBuilder> implements VisitableBuilder<LoadBalancerSettingsConsistentHashLBHttpHeaderName,LoadBalancerSettingsConsistentHashLBHttpHeaderNameBuilder>{

  LoadBalancerSettingsConsistentHashLBHttpHeaderNameFluent<?> fluent;

  public LoadBalancerSettingsConsistentHashLBHttpHeaderNameBuilder() {
    this(new LoadBalancerSettingsConsistentHashLBHttpHeaderName());
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpHeaderNameBuilder(LoadBalancerSettingsConsistentHashLBHttpHeaderNameFluent<?> fluent) {
    this(fluent, new LoadBalancerSettingsConsistentHashLBHttpHeaderName());
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpHeaderNameBuilder(LoadBalancerSettingsConsistentHashLBHttpHeaderName instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpHeaderNameBuilder(LoadBalancerSettingsConsistentHashLBHttpHeaderNameFluent<?> fluent,LoadBalancerSettingsConsistentHashLBHttpHeaderName instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerSettingsConsistentHashLBHttpHeaderName build() {
    LoadBalancerSettingsConsistentHashLBHttpHeaderName buildable = new LoadBalancerSettingsConsistentHashLBHttpHeaderName(fluent.getHttpHeaderName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}