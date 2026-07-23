package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameBuilder extends LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameFluent<LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameBuilder> implements VisitableBuilder<LoadBalancerSettingsConsistentHashLBHttpQueryParameterName,LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameBuilder>{

  LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameFluent<?> fluent;

  public LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameBuilder() {
    this(new LoadBalancerSettingsConsistentHashLBHttpQueryParameterName());
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameBuilder(LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameFluent<?> fluent) {
    this(fluent, new LoadBalancerSettingsConsistentHashLBHttpQueryParameterName());
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameBuilder(LoadBalancerSettingsConsistentHashLBHttpQueryParameterName instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameBuilder(LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameFluent<?> fluent,LoadBalancerSettingsConsistentHashLBHttpQueryParameterName instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerSettingsConsistentHashLBHttpQueryParameterName build() {
    LoadBalancerSettingsConsistentHashLBHttpQueryParameterName buildable = new LoadBalancerSettingsConsistentHashLBHttpQueryParameterName(fluent.getHttpQueryParameterName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}