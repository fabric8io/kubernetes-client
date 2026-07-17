package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RoutePortBuilder extends RoutePortFluent<RoutePortBuilder> implements VisitableBuilder<RoutePort,RoutePortBuilder>{

  RoutePortFluent<?> fluent;

  public RoutePortBuilder() {
    this(new RoutePort());
  }
  
  public RoutePortBuilder(RoutePortFluent<?> fluent) {
    this(fluent, new RoutePort());
  }
  
  public RoutePortBuilder(RoutePort instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RoutePortBuilder(RoutePortFluent<?> fluent,RoutePort instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RoutePort build() {
    RoutePort buildable = new RoutePort(fluent.buildTargetPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}