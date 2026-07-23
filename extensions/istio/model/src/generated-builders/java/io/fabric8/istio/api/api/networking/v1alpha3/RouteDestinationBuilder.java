package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteDestinationBuilder extends RouteDestinationFluent<RouteDestinationBuilder> implements VisitableBuilder<RouteDestination,RouteDestinationBuilder>{

  RouteDestinationFluent<?> fluent;

  public RouteDestinationBuilder() {
    this(new RouteDestination());
  }
  
  public RouteDestinationBuilder(RouteDestinationFluent<?> fluent) {
    this(fluent, new RouteDestination());
  }
  
  public RouteDestinationBuilder(RouteDestination instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteDestinationBuilder(RouteDestinationFluent<?> fluent,RouteDestination instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteDestination build() {
    RouteDestination buildable = new RouteDestination(fluent.buildDestination(), fluent.getWeight());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}