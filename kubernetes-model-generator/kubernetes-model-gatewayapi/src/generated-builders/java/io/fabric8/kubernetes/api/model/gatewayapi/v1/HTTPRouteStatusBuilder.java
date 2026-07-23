package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRouteStatusBuilder extends HTTPRouteStatusFluent<HTTPRouteStatusBuilder> implements VisitableBuilder<HTTPRouteStatus,HTTPRouteStatusBuilder>{

  HTTPRouteStatusFluent<?> fluent;

  public HTTPRouteStatusBuilder() {
    this(new HTTPRouteStatus());
  }
  
  public HTTPRouteStatusBuilder(HTTPRouteStatusFluent<?> fluent) {
    this(fluent, new HTTPRouteStatus());
  }
  
  public HTTPRouteStatusBuilder(HTTPRouteStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRouteStatusBuilder(HTTPRouteStatusFluent<?> fluent,HTTPRouteStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRouteStatus build() {
    HTTPRouteStatus buildable = new HTTPRouteStatus(fluent.buildParents());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}