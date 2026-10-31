package io.fabric8.openshift.api.model.installer.aws.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostPlacementBuilder extends HostPlacementFluent<HostPlacementBuilder> implements VisitableBuilder<HostPlacement,HostPlacementBuilder>{

  HostPlacementFluent<?> fluent;

  public HostPlacementBuilder() {
    this(new HostPlacement());
  }
  
  public HostPlacementBuilder(HostPlacementFluent<?> fluent) {
    this(fluent, new HostPlacement());
  }
  
  public HostPlacementBuilder(HostPlacement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostPlacementBuilder(HostPlacementFluent<?> fluent,HostPlacement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostPlacement build() {
    HostPlacement buildable = new HostPlacement(fluent.getAffinity(), fluent.buildDedicatedHost());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}