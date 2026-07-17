package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteIngressBuilder extends RouteIngressFluent<RouteIngressBuilder> implements VisitableBuilder<RouteIngress,RouteIngressBuilder>{

  RouteIngressFluent<?> fluent;

  public RouteIngressBuilder() {
    this(new RouteIngress());
  }
  
  public RouteIngressBuilder(RouteIngressFluent<?> fluent) {
    this(fluent, new RouteIngress());
  }
  
  public RouteIngressBuilder(RouteIngress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteIngressBuilder(RouteIngressFluent<?> fluent,RouteIngress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteIngress build() {
    RouteIngress buildable = new RouteIngress(fluent.buildConditions(), fluent.getHost(), fluent.getRouterCanonicalHostname(), fluent.getRouterName(), fluent.getWildcardPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}