package io.fabric8.knative.serving.v1;

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
    RouteStatus buildable = new RouteStatus(fluent.buildAddress(), fluent.getAnnotations(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.buildTraffic(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}