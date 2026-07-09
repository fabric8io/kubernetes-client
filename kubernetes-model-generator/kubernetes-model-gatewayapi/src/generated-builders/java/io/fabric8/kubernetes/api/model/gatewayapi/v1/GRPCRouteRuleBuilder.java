package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GRPCRouteRuleBuilder extends GRPCRouteRuleFluent<GRPCRouteRuleBuilder> implements VisitableBuilder<GRPCRouteRule,GRPCRouteRuleBuilder>{

  GRPCRouteRuleFluent<?> fluent;

  public GRPCRouteRuleBuilder() {
    this(new GRPCRouteRule());
  }
  
  public GRPCRouteRuleBuilder(GRPCRouteRuleFluent<?> fluent) {
    this(fluent, new GRPCRouteRule());
  }
  
  public GRPCRouteRuleBuilder(GRPCRouteRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GRPCRouteRuleBuilder(GRPCRouteRuleFluent<?> fluent,GRPCRouteRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GRPCRouteRule build() {
    GRPCRouteRule buildable = new GRPCRouteRule(fluent.buildBackendRefs(), fluent.buildFilters(), fluent.buildMatches(), fluent.getName(), fluent.buildSessionPersistence());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}