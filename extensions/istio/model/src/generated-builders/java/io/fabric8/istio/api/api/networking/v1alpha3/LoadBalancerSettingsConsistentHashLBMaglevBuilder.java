package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerSettingsConsistentHashLBMaglevBuilder extends LoadBalancerSettingsConsistentHashLBMaglevFluent<LoadBalancerSettingsConsistentHashLBMaglevBuilder> implements VisitableBuilder<LoadBalancerSettingsConsistentHashLBMaglev,LoadBalancerSettingsConsistentHashLBMaglevBuilder>{

  LoadBalancerSettingsConsistentHashLBMaglevFluent<?> fluent;

  public LoadBalancerSettingsConsistentHashLBMaglevBuilder() {
    this(new LoadBalancerSettingsConsistentHashLBMaglev());
  }
  
  public LoadBalancerSettingsConsistentHashLBMaglevBuilder(LoadBalancerSettingsConsistentHashLBMaglevFluent<?> fluent) {
    this(fluent, new LoadBalancerSettingsConsistentHashLBMaglev());
  }
  
  public LoadBalancerSettingsConsistentHashLBMaglevBuilder(LoadBalancerSettingsConsistentHashLBMaglev instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerSettingsConsistentHashLBMaglevBuilder(LoadBalancerSettingsConsistentHashLBMaglevFluent<?> fluent,LoadBalancerSettingsConsistentHashLBMaglev instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerSettingsConsistentHashLBMaglev build() {
    LoadBalancerSettingsConsistentHashLBMaglev buildable = new LoadBalancerSettingsConsistentHashLBMaglev(fluent.buildMaglev());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}