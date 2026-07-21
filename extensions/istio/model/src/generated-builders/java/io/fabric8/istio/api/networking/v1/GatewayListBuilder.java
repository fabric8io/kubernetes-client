package io.fabric8.istio.api.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatewayListBuilder extends GatewayListFluent<GatewayListBuilder> implements VisitableBuilder<GatewayList,GatewayListBuilder>{

  GatewayListFluent<?> fluent;

  public GatewayListBuilder() {
    this(new GatewayList());
  }
  
  public GatewayListBuilder(GatewayListFluent<?> fluent) {
    this(fluent, new GatewayList());
  }
  
  public GatewayListBuilder(GatewayList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatewayListBuilder(GatewayListFluent<?> fluent,GatewayList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GatewayList build() {
    GatewayList buildable = new GatewayList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}