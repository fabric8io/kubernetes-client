package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GRPCBackendRefBuilder extends GRPCBackendRefFluent<GRPCBackendRefBuilder> implements VisitableBuilder<GRPCBackendRef,GRPCBackendRefBuilder>{

  GRPCBackendRefFluent<?> fluent;

  public GRPCBackendRefBuilder() {
    this(new GRPCBackendRef());
  }
  
  public GRPCBackendRefBuilder(GRPCBackendRefFluent<?> fluent) {
    this(fluent, new GRPCBackendRef());
  }
  
  public GRPCBackendRefBuilder(GRPCBackendRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GRPCBackendRefBuilder(GRPCBackendRefFluent<?> fluent,GRPCBackendRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GRPCBackendRef build() {
    GRPCBackendRef buildable = new GRPCBackendRef(fluent.buildFilters(), fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace(), fluent.getPort(), fluent.getWeight());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}