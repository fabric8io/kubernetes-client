package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteBuilder extends RouteFluent<RouteBuilder> implements VisitableBuilder<Route,RouteBuilder>{

  RouteFluent<?> fluent;

  public RouteBuilder() {
    this(new Route());
  }
  
  public RouteBuilder(RouteFluent<?> fluent) {
    this(fluent, new Route());
  }
  
  public RouteBuilder(Route instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteBuilder(RouteFluent<?> fluent,Route instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Route build() {
    Route buildable = new Route(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}