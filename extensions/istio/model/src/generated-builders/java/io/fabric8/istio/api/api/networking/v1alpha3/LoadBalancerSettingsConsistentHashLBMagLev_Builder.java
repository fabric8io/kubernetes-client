package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerSettingsConsistentHashLBMagLev_Builder extends LoadBalancerSettingsConsistentHashLBMagLev_Fluent<LoadBalancerSettingsConsistentHashLBMagLev_Builder> implements VisitableBuilder<LoadBalancerSettingsConsistentHashLBMagLev_,LoadBalancerSettingsConsistentHashLBMagLev_Builder>{

  LoadBalancerSettingsConsistentHashLBMagLev_Fluent<?> fluent;

  public LoadBalancerSettingsConsistentHashLBMagLev_Builder() {
    this(new LoadBalancerSettingsConsistentHashLBMagLev_());
  }
  
  public LoadBalancerSettingsConsistentHashLBMagLev_Builder(LoadBalancerSettingsConsistentHashLBMagLev_Fluent<?> fluent) {
    this(fluent, new LoadBalancerSettingsConsistentHashLBMagLev_());
  }
  
  public LoadBalancerSettingsConsistentHashLBMagLev_Builder(LoadBalancerSettingsConsistentHashLBMagLev_ instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerSettingsConsistentHashLBMagLev_Builder(LoadBalancerSettingsConsistentHashLBMagLev_Fluent<?> fluent,LoadBalancerSettingsConsistentHashLBMagLev_ instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerSettingsConsistentHashLBMagLev_ build() {
    LoadBalancerSettingsConsistentHashLBMagLev_ buildable = new LoadBalancerSettingsConsistentHashLBMagLev_(fluent.getTableSize());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}