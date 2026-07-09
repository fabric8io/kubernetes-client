package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UDPRouteRuleBuilder extends UDPRouteRuleFluent<UDPRouteRuleBuilder> implements VisitableBuilder<UDPRouteRule,UDPRouteRuleBuilder>{

  UDPRouteRuleFluent<?> fluent;

  public UDPRouteRuleBuilder() {
    this(new UDPRouteRule());
  }
  
  public UDPRouteRuleBuilder(UDPRouteRuleFluent<?> fluent) {
    this(fluent, new UDPRouteRule());
  }
  
  public UDPRouteRuleBuilder(UDPRouteRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UDPRouteRuleBuilder(UDPRouteRuleFluent<?> fluent,UDPRouteRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UDPRouteRule build() {
    UDPRouteRule buildable = new UDPRouteRule(fluent.buildBackendRefs(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}