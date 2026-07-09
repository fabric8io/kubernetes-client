package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TLSRouteRuleBuilder extends TLSRouteRuleFluent<TLSRouteRuleBuilder> implements VisitableBuilder<TLSRouteRule,TLSRouteRuleBuilder>{

  TLSRouteRuleFluent<?> fluent;

  public TLSRouteRuleBuilder() {
    this(new TLSRouteRule());
  }
  
  public TLSRouteRuleBuilder(TLSRouteRuleFluent<?> fluent) {
    this(fluent, new TLSRouteRule());
  }
  
  public TLSRouteRuleBuilder(TLSRouteRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TLSRouteRuleBuilder(TLSRouteRuleFluent<?> fluent,TLSRouteRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TLSRouteRule build() {
    TLSRouteRule buildable = new TLSRouteRule(fluent.buildBackendRefs(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}