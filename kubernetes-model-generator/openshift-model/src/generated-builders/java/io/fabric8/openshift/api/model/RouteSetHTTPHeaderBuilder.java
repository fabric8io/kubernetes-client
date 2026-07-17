package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteSetHTTPHeaderBuilder extends RouteSetHTTPHeaderFluent<RouteSetHTTPHeaderBuilder> implements VisitableBuilder<RouteSetHTTPHeader,RouteSetHTTPHeaderBuilder>{

  RouteSetHTTPHeaderFluent<?> fluent;

  public RouteSetHTTPHeaderBuilder() {
    this(new RouteSetHTTPHeader());
  }
  
  public RouteSetHTTPHeaderBuilder(RouteSetHTTPHeaderFluent<?> fluent) {
    this(fluent, new RouteSetHTTPHeader());
  }
  
  public RouteSetHTTPHeaderBuilder(RouteSetHTTPHeader instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteSetHTTPHeaderBuilder(RouteSetHTTPHeaderFluent<?> fluent,RouteSetHTTPHeader instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteSetHTTPHeader build() {
    RouteSetHTTPHeader buildable = new RouteSetHTTPHeader(fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}