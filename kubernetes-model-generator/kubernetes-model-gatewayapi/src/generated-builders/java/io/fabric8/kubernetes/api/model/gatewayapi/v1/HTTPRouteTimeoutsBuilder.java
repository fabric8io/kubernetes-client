package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRouteTimeoutsBuilder extends HTTPRouteTimeoutsFluent<HTTPRouteTimeoutsBuilder> implements VisitableBuilder<HTTPRouteTimeouts,HTTPRouteTimeoutsBuilder>{

  HTTPRouteTimeoutsFluent<?> fluent;

  public HTTPRouteTimeoutsBuilder() {
    this(new HTTPRouteTimeouts());
  }
  
  public HTTPRouteTimeoutsBuilder(HTTPRouteTimeoutsFluent<?> fluent) {
    this(fluent, new HTTPRouteTimeouts());
  }
  
  public HTTPRouteTimeoutsBuilder(HTTPRouteTimeouts instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRouteTimeoutsBuilder(HTTPRouteTimeoutsFluent<?> fluent,HTTPRouteTimeouts instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRouteTimeouts build() {
    HTTPRouteTimeouts buildable = new HTTPRouteTimeouts(fluent.getBackendRequest(), fluent.getRequest());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}