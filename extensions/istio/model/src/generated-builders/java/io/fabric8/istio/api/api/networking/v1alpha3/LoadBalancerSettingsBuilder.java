package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerSettingsBuilder extends LoadBalancerSettingsFluent<LoadBalancerSettingsBuilder> implements VisitableBuilder<LoadBalancerSettings,LoadBalancerSettingsBuilder>{

  LoadBalancerSettingsFluent<?> fluent;

  public LoadBalancerSettingsBuilder() {
    this(new LoadBalancerSettings());
  }
  
  public LoadBalancerSettingsBuilder(LoadBalancerSettingsFluent<?> fluent) {
    this(fluent, new LoadBalancerSettings());
  }
  
  public LoadBalancerSettingsBuilder(LoadBalancerSettings instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerSettingsBuilder(LoadBalancerSettingsFluent<?> fluent,LoadBalancerSettings instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerSettings build() {
    LoadBalancerSettings buildable = new LoadBalancerSettings(fluent.buildLbPolicy(), fluent.buildLocalityLbSetting(), fluent.buildWarmup(), fluent.getWarmupDurationSecs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}