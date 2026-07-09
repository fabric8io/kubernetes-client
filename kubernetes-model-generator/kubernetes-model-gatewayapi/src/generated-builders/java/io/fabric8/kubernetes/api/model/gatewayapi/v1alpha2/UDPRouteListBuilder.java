package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UDPRouteListBuilder extends UDPRouteListFluent<UDPRouteListBuilder> implements VisitableBuilder<UDPRouteList,UDPRouteListBuilder>{

  UDPRouteListFluent<?> fluent;

  public UDPRouteListBuilder() {
    this(new UDPRouteList());
  }
  
  public UDPRouteListBuilder(UDPRouteListFluent<?> fluent) {
    this(fluent, new UDPRouteList());
  }
  
  public UDPRouteListBuilder(UDPRouteList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UDPRouteListBuilder(UDPRouteListFluent<?> fluent,UDPRouteList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UDPRouteList build() {
    UDPRouteList buildable = new UDPRouteList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}