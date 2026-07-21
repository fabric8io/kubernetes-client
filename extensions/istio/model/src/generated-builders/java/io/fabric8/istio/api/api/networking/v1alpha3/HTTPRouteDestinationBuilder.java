package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRouteDestinationBuilder extends HTTPRouteDestinationFluent<HTTPRouteDestinationBuilder> implements VisitableBuilder<HTTPRouteDestination,HTTPRouteDestinationBuilder>{

  HTTPRouteDestinationFluent<?> fluent;

  public HTTPRouteDestinationBuilder() {
    this(new HTTPRouteDestination());
  }
  
  public HTTPRouteDestinationBuilder(HTTPRouteDestinationFluent<?> fluent) {
    this(fluent, new HTTPRouteDestination());
  }
  
  public HTTPRouteDestinationBuilder(HTTPRouteDestination instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRouteDestinationBuilder(HTTPRouteDestinationFluent<?> fluent,HTTPRouteDestination instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRouteDestination build() {
    HTTPRouteDestination buildable = new HTTPRouteDestination(fluent.buildDestination(), fluent.buildHeaders(), fluent.getWeight());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}