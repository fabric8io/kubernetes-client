package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerSettingsConsistentHashLBHTTPCookieAttributeBuilder extends LoadBalancerSettingsConsistentHashLBHTTPCookieAttributeFluent<LoadBalancerSettingsConsistentHashLBHTTPCookieAttributeBuilder> implements VisitableBuilder<LoadBalancerSettingsConsistentHashLBHTTPCookieAttribute,LoadBalancerSettingsConsistentHashLBHTTPCookieAttributeBuilder>{

  LoadBalancerSettingsConsistentHashLBHTTPCookieAttributeFluent<?> fluent;

  public LoadBalancerSettingsConsistentHashLBHTTPCookieAttributeBuilder() {
    this(new LoadBalancerSettingsConsistentHashLBHTTPCookieAttribute());
  }
  
  public LoadBalancerSettingsConsistentHashLBHTTPCookieAttributeBuilder(LoadBalancerSettingsConsistentHashLBHTTPCookieAttributeFluent<?> fluent) {
    this(fluent, new LoadBalancerSettingsConsistentHashLBHTTPCookieAttribute());
  }
  
  public LoadBalancerSettingsConsistentHashLBHTTPCookieAttributeBuilder(LoadBalancerSettingsConsistentHashLBHTTPCookieAttribute instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerSettingsConsistentHashLBHTTPCookieAttributeBuilder(LoadBalancerSettingsConsistentHashLBHTTPCookieAttributeFluent<?> fluent,LoadBalancerSettingsConsistentHashLBHTTPCookieAttribute instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerSettingsConsistentHashLBHTTPCookieAttribute build() {
    LoadBalancerSettingsConsistentHashLBHTTPCookieAttribute buildable = new LoadBalancerSettingsConsistentHashLBHTTPCookieAttribute(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}