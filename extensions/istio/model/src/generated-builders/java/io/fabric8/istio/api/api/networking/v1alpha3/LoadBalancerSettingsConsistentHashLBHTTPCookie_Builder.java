package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder extends LoadBalancerSettingsConsistentHashLBHTTPCookie_Fluent<LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder> implements VisitableBuilder<LoadBalancerSettingsConsistentHashLBHTTPCookie_,LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder>{

  LoadBalancerSettingsConsistentHashLBHTTPCookie_Fluent<?> fluent;

  public LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder() {
    this(new LoadBalancerSettingsConsistentHashLBHTTPCookie_());
  }
  
  public LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder(LoadBalancerSettingsConsistentHashLBHTTPCookie_Fluent<?> fluent) {
    this(fluent, new LoadBalancerSettingsConsistentHashLBHTTPCookie_());
  }
  
  public LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder(LoadBalancerSettingsConsistentHashLBHTTPCookie_ instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder(LoadBalancerSettingsConsistentHashLBHTTPCookie_Fluent<?> fluent,LoadBalancerSettingsConsistentHashLBHTTPCookie_ instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerSettingsConsistentHashLBHTTPCookie_ build() {
    LoadBalancerSettingsConsistentHashLBHTTPCookie_ buildable = new LoadBalancerSettingsConsistentHashLBHTTPCookie_(fluent.buildAttributes(), fluent.getName(), fluent.getPath(), fluent.getTtl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}