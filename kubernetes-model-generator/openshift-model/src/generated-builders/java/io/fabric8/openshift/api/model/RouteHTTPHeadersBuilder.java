package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteHTTPHeadersBuilder extends RouteHTTPHeadersFluent<RouteHTTPHeadersBuilder> implements VisitableBuilder<RouteHTTPHeaders,RouteHTTPHeadersBuilder>{

  RouteHTTPHeadersFluent<?> fluent;

  public RouteHTTPHeadersBuilder() {
    this(new RouteHTTPHeaders());
  }
  
  public RouteHTTPHeadersBuilder(RouteHTTPHeadersFluent<?> fluent) {
    this(fluent, new RouteHTTPHeaders());
  }
  
  public RouteHTTPHeadersBuilder(RouteHTTPHeaders instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteHTTPHeadersBuilder(RouteHTTPHeadersFluent<?> fluent,RouteHTTPHeaders instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteHTTPHeaders build() {
    RouteHTTPHeaders buildable = new RouteHTTPHeaders(fluent.buildActions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}