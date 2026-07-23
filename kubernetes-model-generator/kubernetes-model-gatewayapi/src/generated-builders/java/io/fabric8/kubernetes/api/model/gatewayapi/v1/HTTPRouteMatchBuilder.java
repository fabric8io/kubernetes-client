package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRouteMatchBuilder extends HTTPRouteMatchFluent<HTTPRouteMatchBuilder> implements VisitableBuilder<HTTPRouteMatch,HTTPRouteMatchBuilder>{

  HTTPRouteMatchFluent<?> fluent;

  public HTTPRouteMatchBuilder() {
    this(new HTTPRouteMatch());
  }
  
  public HTTPRouteMatchBuilder(HTTPRouteMatchFluent<?> fluent) {
    this(fluent, new HTTPRouteMatch());
  }
  
  public HTTPRouteMatchBuilder(HTTPRouteMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRouteMatchBuilder(HTTPRouteMatchFluent<?> fluent,HTTPRouteMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRouteMatch build() {
    HTTPRouteMatch buildable = new HTTPRouteMatch(fluent.buildHeaders(), fluent.getMethod(), fluent.buildPath(), fluent.buildQueryParams());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}