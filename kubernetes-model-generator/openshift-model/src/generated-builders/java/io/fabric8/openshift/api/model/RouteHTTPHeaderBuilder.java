package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteHTTPHeaderBuilder extends RouteHTTPHeaderFluent<RouteHTTPHeaderBuilder> implements VisitableBuilder<RouteHTTPHeader,RouteHTTPHeaderBuilder>{

  RouteHTTPHeaderFluent<?> fluent;

  public RouteHTTPHeaderBuilder() {
    this(new RouteHTTPHeader());
  }
  
  public RouteHTTPHeaderBuilder(RouteHTTPHeaderFluent<?> fluent) {
    this(fluent, new RouteHTTPHeader());
  }
  
  public RouteHTTPHeaderBuilder(RouteHTTPHeader instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteHTTPHeaderBuilder(RouteHTTPHeaderFluent<?> fluent,RouteHTTPHeader instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteHTTPHeader build() {
    RouteHTTPHeader buildable = new RouteHTTPHeader(fluent.buildAction(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}