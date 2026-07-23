package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CapabilityBuilder extends CapabilityFluent<CapabilityBuilder> implements VisitableBuilder<Capability,CapabilityBuilder>{

  CapabilityFluent<?> fluent;

  public CapabilityBuilder() {
    this(new Capability());
  }
  
  public CapabilityBuilder(CapabilityFluent<?> fluent) {
    this(fluent, new Capability());
  }
  
  public CapabilityBuilder(Capability instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CapabilityBuilder(CapabilityFluent<?> fluent,Capability instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Capability build() {
    Capability buildable = new Capability(fluent.getName(), fluent.buildVisibility());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}