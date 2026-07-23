package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TCPRouteListBuilder extends TCPRouteListFluent<TCPRouteListBuilder> implements VisitableBuilder<TCPRouteList,TCPRouteListBuilder>{

  TCPRouteListFluent<?> fluent;

  public TCPRouteListBuilder() {
    this(new TCPRouteList());
  }
  
  public TCPRouteListBuilder(TCPRouteListFluent<?> fluent) {
    this(fluent, new TCPRouteList());
  }
  
  public TCPRouteListBuilder(TCPRouteList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TCPRouteListBuilder(TCPRouteListFluent<?> fluent,TCPRouteList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TCPRouteList build() {
    TCPRouteList buildable = new TCPRouteList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}