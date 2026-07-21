package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteListBuilder extends RouteListFluent<RouteListBuilder> implements VisitableBuilder<RouteList,RouteListBuilder>{

  RouteListFluent<?> fluent;

  public RouteListBuilder() {
    this(new RouteList());
  }
  
  public RouteListBuilder(RouteListFluent<?> fluent) {
    this(fluent, new RouteList());
  }
  
  public RouteListBuilder(RouteList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteListBuilder(RouteListFluent<?> fluent,RouteList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteList build() {
    RouteList buildable = new RouteList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}