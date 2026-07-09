package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteGroupKindBuilder extends RouteGroupKindFluent<RouteGroupKindBuilder> implements VisitableBuilder<RouteGroupKind,RouteGroupKindBuilder>{

  RouteGroupKindFluent<?> fluent;

  public RouteGroupKindBuilder() {
    this(new RouteGroupKind());
  }
  
  public RouteGroupKindBuilder(RouteGroupKindFluent<?> fluent) {
    this(fluent, new RouteGroupKind());
  }
  
  public RouteGroupKindBuilder(RouteGroupKind instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteGroupKindBuilder(RouteGroupKindFluent<?> fluent,RouteGroupKind instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteGroupKind build() {
    RouteGroupKind buildable = new RouteGroupKind(fluent.getGroup(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}