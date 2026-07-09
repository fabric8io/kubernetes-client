package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRouteFilterBuilder extends HTTPRouteFilterFluent<HTTPRouteFilterBuilder> implements VisitableBuilder<HTTPRouteFilter,HTTPRouteFilterBuilder>{

  HTTPRouteFilterFluent<?> fluent;

  public HTTPRouteFilterBuilder() {
    this(new HTTPRouteFilter());
  }
  
  public HTTPRouteFilterBuilder(HTTPRouteFilterFluent<?> fluent) {
    this(fluent, new HTTPRouteFilter());
  }
  
  public HTTPRouteFilterBuilder(HTTPRouteFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRouteFilterBuilder(HTTPRouteFilterFluent<?> fluent,HTTPRouteFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRouteFilter build() {
    HTTPRouteFilter buildable = new HTTPRouteFilter(fluent.buildCors(), fluent.buildExtensionRef(), fluent.buildExternalAuth(), fluent.buildRequestHeaderModifier(), fluent.buildRequestMirror(), fluent.buildRequestRedirect(), fluent.buildResponseHeaderModifier(), fluent.getType(), fluent.buildUrlRewrite());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}