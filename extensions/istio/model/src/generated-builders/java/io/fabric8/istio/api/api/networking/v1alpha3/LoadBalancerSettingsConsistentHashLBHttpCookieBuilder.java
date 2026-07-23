package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerSettingsConsistentHashLBHttpCookieBuilder extends LoadBalancerSettingsConsistentHashLBHttpCookieFluent<LoadBalancerSettingsConsistentHashLBHttpCookieBuilder> implements VisitableBuilder<LoadBalancerSettingsConsistentHashLBHttpCookie,LoadBalancerSettingsConsistentHashLBHttpCookieBuilder>{

  LoadBalancerSettingsConsistentHashLBHttpCookieFluent<?> fluent;

  public LoadBalancerSettingsConsistentHashLBHttpCookieBuilder() {
    this(new LoadBalancerSettingsConsistentHashLBHttpCookie());
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpCookieBuilder(LoadBalancerSettingsConsistentHashLBHttpCookieFluent<?> fluent) {
    this(fluent, new LoadBalancerSettingsConsistentHashLBHttpCookie());
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpCookieBuilder(LoadBalancerSettingsConsistentHashLBHttpCookie instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpCookieBuilder(LoadBalancerSettingsConsistentHashLBHttpCookieFluent<?> fluent,LoadBalancerSettingsConsistentHashLBHttpCookie instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerSettingsConsistentHashLBHttpCookie build() {
    LoadBalancerSettingsConsistentHashLBHttpCookie buildable = new LoadBalancerSettingsConsistentHashLBHttpCookie(fluent.buildHttpCookie());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}