package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteNamespacesBuilder extends RouteNamespacesFluent<RouteNamespacesBuilder> implements VisitableBuilder<RouteNamespaces,RouteNamespacesBuilder>{

  RouteNamespacesFluent<?> fluent;

  public RouteNamespacesBuilder() {
    this(new RouteNamespaces());
  }
  
  public RouteNamespacesBuilder(RouteNamespacesFluent<?> fluent) {
    this(fluent, new RouteNamespaces());
  }
  
  public RouteNamespacesBuilder(RouteNamespaces instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteNamespacesBuilder(RouteNamespacesFluent<?> fluent,RouteNamespaces instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteNamespaces build() {
    RouteNamespaces buildable = new RouteNamespaces(fluent.getFrom(), fluent.buildSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}