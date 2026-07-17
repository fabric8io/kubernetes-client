package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteHTTPHeaderActionsBuilder extends RouteHTTPHeaderActionsFluent<RouteHTTPHeaderActionsBuilder> implements VisitableBuilder<RouteHTTPHeaderActions,RouteHTTPHeaderActionsBuilder>{

  RouteHTTPHeaderActionsFluent<?> fluent;

  public RouteHTTPHeaderActionsBuilder() {
    this(new RouteHTTPHeaderActions());
  }
  
  public RouteHTTPHeaderActionsBuilder(RouteHTTPHeaderActionsFluent<?> fluent) {
    this(fluent, new RouteHTTPHeaderActions());
  }
  
  public RouteHTTPHeaderActionsBuilder(RouteHTTPHeaderActions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteHTTPHeaderActionsBuilder(RouteHTTPHeaderActionsFluent<?> fluent,RouteHTTPHeaderActions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteHTTPHeaderActions build() {
    RouteHTTPHeaderActions buildable = new RouteHTTPHeaderActions(fluent.buildRequest(), fluent.buildResponse());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}