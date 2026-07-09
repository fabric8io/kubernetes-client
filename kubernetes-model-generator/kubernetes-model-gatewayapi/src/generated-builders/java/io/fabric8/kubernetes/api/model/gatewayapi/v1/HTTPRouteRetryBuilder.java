package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRouteRetryBuilder extends HTTPRouteRetryFluent<HTTPRouteRetryBuilder> implements VisitableBuilder<HTTPRouteRetry,HTTPRouteRetryBuilder>{

  HTTPRouteRetryFluent<?> fluent;

  public HTTPRouteRetryBuilder() {
    this(new HTTPRouteRetry());
  }
  
  public HTTPRouteRetryBuilder(HTTPRouteRetryFluent<?> fluent) {
    this(fluent, new HTTPRouteRetry());
  }
  
  public HTTPRouteRetryBuilder(HTTPRouteRetry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRouteRetryBuilder(HTTPRouteRetryFluent<?> fluent,HTTPRouteRetry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRouteRetry build() {
    HTTPRouteRetry buildable = new HTTPRouteRetry(fluent.getAttempts(), fluent.getBackoff(), fluent.getCodes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}