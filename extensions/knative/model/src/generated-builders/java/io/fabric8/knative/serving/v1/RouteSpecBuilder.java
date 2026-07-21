package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteSpecBuilder extends RouteSpecFluent<RouteSpecBuilder> implements VisitableBuilder<RouteSpec,RouteSpecBuilder>{

  RouteSpecFluent<?> fluent;

  public RouteSpecBuilder() {
    this(new RouteSpec());
  }
  
  public RouteSpecBuilder(RouteSpecFluent<?> fluent) {
    this(fluent, new RouteSpec());
  }
  
  public RouteSpecBuilder(RouteSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteSpecBuilder(RouteSpecFluent<?> fluent,RouteSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteSpec build() {
    RouteSpec buildable = new RouteSpec(fluent.buildTraffic());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}