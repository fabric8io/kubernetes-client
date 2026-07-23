package io.fabric8.istio.api.api.networking.v1alpha3;

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
    HTTPRoute buildable = new HTTPRoute(fluent.buildCorsPolicy(), fluent.buildDelegate(), fluent.buildDirectResponse(), fluent.buildFault(), fluent.buildHeaders(), fluent.buildMatch(), fluent.buildMirror(), fluent.getMirrorPercent(), fluent.buildMirrorPercentage(), fluent.buildMirrors(), fluent.getName(), fluent.buildRedirect(), fluent.buildRetries(), fluent.buildRewrite(), fluent.buildRoute(), fluent.getTimeout());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}