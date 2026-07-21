package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerSettingsConsistentHashLBUseSourceIpBuilder extends LoadBalancerSettingsConsistentHashLBUseSourceIpFluent<LoadBalancerSettingsConsistentHashLBUseSourceIpBuilder> implements VisitableBuilder<LoadBalancerSettingsConsistentHashLBUseSourceIp,LoadBalancerSettingsConsistentHashLBUseSourceIpBuilder>{

  LoadBalancerSettingsConsistentHashLBUseSourceIpFluent<?> fluent;

  public LoadBalancerSettingsConsistentHashLBUseSourceIpBuilder() {
    this(new LoadBalancerSettingsConsistentHashLBUseSourceIp());
  }
  
  public LoadBalancerSettingsConsistentHashLBUseSourceIpBuilder(LoadBalancerSettingsConsistentHashLBUseSourceIpFluent<?> fluent) {
    this(fluent, new LoadBalancerSettingsConsistentHashLBUseSourceIp());
  }
  
  public LoadBalancerSettingsConsistentHashLBUseSourceIpBuilder(LoadBalancerSettingsConsistentHashLBUseSourceIp instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerSettingsConsistentHashLBUseSourceIpBuilder(LoadBalancerSettingsConsistentHashLBUseSourceIpFluent<?> fluent,LoadBalancerSettingsConsistentHashLBUseSourceIp instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerSettingsConsistentHashLBUseSourceIp build() {
    LoadBalancerSettingsConsistentHashLBUseSourceIp buildable = new LoadBalancerSettingsConsistentHashLBUseSourceIp(fluent.getUseSourceIp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}