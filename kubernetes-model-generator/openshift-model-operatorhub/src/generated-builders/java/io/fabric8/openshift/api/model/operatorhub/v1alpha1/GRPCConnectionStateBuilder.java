package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GRPCConnectionStateBuilder extends GRPCConnectionStateFluent<GRPCConnectionStateBuilder> implements VisitableBuilder<GRPCConnectionState,GRPCConnectionStateBuilder>{

  GRPCConnectionStateFluent<?> fluent;

  public GRPCConnectionStateBuilder() {
    this(new GRPCConnectionState());
  }
  
  public GRPCConnectionStateBuilder(GRPCConnectionStateFluent<?> fluent) {
    this(fluent, new GRPCConnectionState());
  }
  
  public GRPCConnectionStateBuilder(GRPCConnectionState instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GRPCConnectionStateBuilder(GRPCConnectionStateFluent<?> fluent,GRPCConnectionState instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GRPCConnectionState build() {
    GRPCConnectionState buildable = new GRPCConnectionState(fluent.getAddress(), fluent.getLastConnect(), fluent.getLastObservedState());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}