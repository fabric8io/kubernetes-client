package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteStatusBuilder extends RouteStatusFluent<RouteStatusBuilder> implements VisitableBuilder<RouteStatus,RouteStatusBuilder>{

  RouteStatusFluent<?> fluent;

  public RouteStatusBuilder() {
    this(new RouteStatus());
  }
  
  public RouteStatusBuilder(RouteStatusFluent<?> fluent) {
    this(fluent, new RouteStatus());
  }
  
  public RouteStatusBuilder(RouteStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteStatusBuilder(RouteStatusFluent<?> fluent,RouteStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteStatus build() {
    RouteStatus buildable = new RouteStatus(fluent.buildIngress());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}