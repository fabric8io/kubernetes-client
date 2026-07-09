package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GRPCHeaderMatchBuilder extends GRPCHeaderMatchFluent<GRPCHeaderMatchBuilder> implements VisitableBuilder<GRPCHeaderMatch,GRPCHeaderMatchBuilder>{

  GRPCHeaderMatchFluent<?> fluent;

  public GRPCHeaderMatchBuilder() {
    this(new GRPCHeaderMatch());
  }
  
  public GRPCHeaderMatchBuilder(GRPCHeaderMatchFluent<?> fluent) {
    this(fluent, new GRPCHeaderMatch());
  }
  
  public GRPCHeaderMatchBuilder(GRPCHeaderMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GRPCHeaderMatchBuilder(GRPCHeaderMatchFluent<?> fluent,GRPCHeaderMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GRPCHeaderMatch build() {
    GRPCHeaderMatch buildable = new GRPCHeaderMatch(fluent.getName(), fluent.getType(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}