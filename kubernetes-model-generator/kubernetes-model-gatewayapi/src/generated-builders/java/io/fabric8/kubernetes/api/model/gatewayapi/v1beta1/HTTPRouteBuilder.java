package io.fabric8.kubernetes.api.model.gatewayapi.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRouteBuilder extends HTTPRouteFluent<HTTPRouteBuilder> implements VisitableBuilder<HTTPRoute,HTTPRouteBuilder>{

  HTTPRouteFluent<?> fluent;

  public HTTPRouteBuilder() {
    this(new HTTPRoute());
  }
  
  public HTTPRouteBuilder(HTTPRouteFluent<?> fluent) {
    this(fluent, new HTTPRoute());
  }
  
  public HTTPRouteBuilder(HTTPRoute instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRouteBuilder(HTTPRouteFluent<?> fluent,HTTPRoute instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRoute build() {
    HTTPRoute buildable = new HTTPRoute(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}