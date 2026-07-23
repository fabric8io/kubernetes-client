package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatewayClassListBuilder extends GatewayClassListFluent<GatewayClassListBuilder> implements VisitableBuilder<GatewayClassList,GatewayClassListBuilder>{

  GatewayClassListFluent<?> fluent;

  public GatewayClassListBuilder() {
    this(new GatewayClassList());
  }
  
  public GatewayClassListBuilder(GatewayClassListFluent<?> fluent) {
    this(fluent, new GatewayClassList());
  }
  
  public GatewayClassListBuilder(GatewayClassList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatewayClassListBuilder(GatewayClassListFluent<?> fluent,GatewayClassList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GatewayClassList build() {
    GatewayClassList buildable = new GatewayClassList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}