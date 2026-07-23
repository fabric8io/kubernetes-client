package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TCPRouteRuleBuilder extends TCPRouteRuleFluent<TCPRouteRuleBuilder> implements VisitableBuilder<TCPRouteRule,TCPRouteRuleBuilder>{

  TCPRouteRuleFluent<?> fluent;

  public TCPRouteRuleBuilder() {
    this(new TCPRouteRule());
  }
  
  public TCPRouteRuleBuilder(TCPRouteRuleFluent<?> fluent) {
    this(fluent, new TCPRouteRule());
  }
  
  public TCPRouteRuleBuilder(TCPRouteRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TCPRouteRuleBuilder(TCPRouteRuleFluent<?> fluent,TCPRouteRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TCPRouteRule build() {
    TCPRouteRule buildable = new TCPRouteRule(fluent.buildBackendRefs(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}