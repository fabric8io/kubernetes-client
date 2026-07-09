package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRouteRuleBuilder extends HTTPRouteRuleFluent<HTTPRouteRuleBuilder> implements VisitableBuilder<HTTPRouteRule,HTTPRouteRuleBuilder>{

  HTTPRouteRuleFluent<?> fluent;

  public HTTPRouteRuleBuilder() {
    this(new HTTPRouteRule());
  }
  
  public HTTPRouteRuleBuilder(HTTPRouteRuleFluent<?> fluent) {
    this(fluent, new HTTPRouteRule());
  }
  
  public HTTPRouteRuleBuilder(HTTPRouteRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRouteRuleBuilder(HTTPRouteRuleFluent<?> fluent,HTTPRouteRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRouteRule build() {
    HTTPRouteRule buildable = new HTTPRouteRule(fluent.buildBackendRefs(), fluent.buildFilters(), fluent.buildMatches(), fluent.getName(), fluent.buildRetry(), fluent.buildSessionPersistence(), fluent.buildTimeouts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}