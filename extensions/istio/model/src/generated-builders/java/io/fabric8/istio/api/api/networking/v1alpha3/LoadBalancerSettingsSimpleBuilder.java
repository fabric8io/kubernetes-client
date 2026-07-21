package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoadBalancerSettingsSimpleBuilder extends LoadBalancerSettingsSimpleFluent<LoadBalancerSettingsSimpleBuilder> implements VisitableBuilder<LoadBalancerSettingsSimple,LoadBalancerSettingsSimpleBuilder>{

  LoadBalancerSettingsSimpleFluent<?> fluent;

  public LoadBalancerSettingsSimpleBuilder() {
    this(new LoadBalancerSettingsSimple());
  }
  
  public LoadBalancerSettingsSimpleBuilder(LoadBalancerSettingsSimpleFluent<?> fluent) {
    this(fluent, new LoadBalancerSettingsSimple());
  }
  
  public LoadBalancerSettingsSimpleBuilder(LoadBalancerSettingsSimple instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoadBalancerSettingsSimpleBuilder(LoadBalancerSettingsSimpleFluent<?> fluent,LoadBalancerSettingsSimple instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoadBalancerSettingsSimple build() {
    LoadBalancerSettingsSimple buildable = new LoadBalancerSettingsSimple(fluent.getSimple());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}