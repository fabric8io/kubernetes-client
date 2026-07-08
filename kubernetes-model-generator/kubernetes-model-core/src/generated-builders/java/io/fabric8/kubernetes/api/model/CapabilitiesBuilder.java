package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CapabilitiesBuilder extends CapabilitiesFluent<CapabilitiesBuilder> implements VisitableBuilder<Capabilities,CapabilitiesBuilder>{

  CapabilitiesFluent<?> fluent;

  public CapabilitiesBuilder() {
    this(new Capabilities());
  }
  
  public CapabilitiesBuilder(CapabilitiesFluent<?> fluent) {
    this(fluent, new Capabilities());
  }
  
  public CapabilitiesBuilder(Capabilities instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CapabilitiesBuilder(CapabilitiesFluent<?> fluent,Capabilities instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Capabilities build() {
    Capabilities buildable = new Capabilities(fluent.getAdd(), fluent.getDrop());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}