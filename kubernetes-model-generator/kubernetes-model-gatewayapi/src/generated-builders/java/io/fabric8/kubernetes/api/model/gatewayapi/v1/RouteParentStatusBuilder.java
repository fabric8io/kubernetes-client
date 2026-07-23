package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteParentStatusBuilder extends RouteParentStatusFluent<RouteParentStatusBuilder> implements VisitableBuilder<RouteParentStatus,RouteParentStatusBuilder>{

  RouteParentStatusFluent<?> fluent;

  public RouteParentStatusBuilder() {
    this(new RouteParentStatus());
  }
  
  public RouteParentStatusBuilder(RouteParentStatusFluent<?> fluent) {
    this(fluent, new RouteParentStatus());
  }
  
  public RouteParentStatusBuilder(RouteParentStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteParentStatusBuilder(RouteParentStatusFluent<?> fluent,RouteParentStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteParentStatus build() {
    RouteParentStatus buildable = new RouteParentStatus(fluent.getConditions(), fluent.getControllerName(), fluent.buildParentRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}