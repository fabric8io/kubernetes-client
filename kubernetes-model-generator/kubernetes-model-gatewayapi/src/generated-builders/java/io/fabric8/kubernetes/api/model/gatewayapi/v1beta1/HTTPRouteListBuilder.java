package io.fabric8.kubernetes.api.model.gatewayapi.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRouteListBuilder extends HTTPRouteListFluent<HTTPRouteListBuilder> implements VisitableBuilder<HTTPRouteList,HTTPRouteListBuilder>{

  HTTPRouteListFluent<?> fluent;

  public HTTPRouteListBuilder() {
    this(new HTTPRouteList());
  }
  
  public HTTPRouteListBuilder(HTTPRouteListFluent<?> fluent) {
    this(fluent, new HTTPRouteList());
  }
  
  public HTTPRouteListBuilder(HTTPRouteList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRouteListBuilder(HTTPRouteListFluent<?> fluent,HTTPRouteList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRouteList build() {
    HTTPRouteList buildable = new HTTPRouteList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}