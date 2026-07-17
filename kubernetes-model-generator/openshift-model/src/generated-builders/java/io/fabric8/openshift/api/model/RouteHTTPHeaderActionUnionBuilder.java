package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteHTTPHeaderActionUnionBuilder extends RouteHTTPHeaderActionUnionFluent<RouteHTTPHeaderActionUnionBuilder> implements VisitableBuilder<RouteHTTPHeaderActionUnion,RouteHTTPHeaderActionUnionBuilder>{

  RouteHTTPHeaderActionUnionFluent<?> fluent;

  public RouteHTTPHeaderActionUnionBuilder() {
    this(new RouteHTTPHeaderActionUnion());
  }
  
  public RouteHTTPHeaderActionUnionBuilder(RouteHTTPHeaderActionUnionFluent<?> fluent) {
    this(fluent, new RouteHTTPHeaderActionUnion());
  }
  
  public RouteHTTPHeaderActionUnionBuilder(RouteHTTPHeaderActionUnion instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteHTTPHeaderActionUnionBuilder(RouteHTTPHeaderActionUnionFluent<?> fluent,RouteHTTPHeaderActionUnion instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteHTTPHeaderActionUnion build() {
    RouteHTTPHeaderActionUnion buildable = new RouteHTTPHeaderActionUnion(fluent.buildSet(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}