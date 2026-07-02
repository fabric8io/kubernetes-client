package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GRPCActionBuilder extends GRPCActionFluent<GRPCActionBuilder> implements VisitableBuilder<GRPCAction,GRPCActionBuilder>{

  GRPCActionFluent<?> fluent;

  public GRPCActionBuilder() {
    this(new GRPCAction());
  }
  
  public GRPCActionBuilder(GRPCActionFluent<?> fluent) {
    this(fluent, new GRPCAction());
  }
  
  public GRPCActionBuilder(GRPCAction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GRPCActionBuilder(GRPCActionFluent<?> fluent,GRPCAction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GRPCAction build() {
    GRPCAction buildable = new GRPCAction(fluent.getPort(), fluent.getService());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}