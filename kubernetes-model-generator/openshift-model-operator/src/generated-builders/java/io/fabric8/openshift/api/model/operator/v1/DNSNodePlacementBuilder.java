package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSNodePlacementBuilder extends DNSNodePlacementFluent<DNSNodePlacementBuilder> implements VisitableBuilder<DNSNodePlacement,DNSNodePlacementBuilder>{

  DNSNodePlacementFluent<?> fluent;

  public DNSNodePlacementBuilder() {
    this(new DNSNodePlacement());
  }
  
  public DNSNodePlacementBuilder(DNSNodePlacementFluent<?> fluent) {
    this(fluent, new DNSNodePlacement());
  }
  
  public DNSNodePlacementBuilder(DNSNodePlacement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSNodePlacementBuilder(DNSNodePlacementFluent<?> fluent,DNSNodePlacement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSNodePlacement build() {
    DNSNodePlacement buildable = new DNSNodePlacement(fluent.getNodeSelector(), fluent.getTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}