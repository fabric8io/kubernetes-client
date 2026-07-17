package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CapabilityVisibilityBuilder extends CapabilityVisibilityFluent<CapabilityVisibilityBuilder> implements VisitableBuilder<CapabilityVisibility,CapabilityVisibilityBuilder>{

  CapabilityVisibilityFluent<?> fluent;

  public CapabilityVisibilityBuilder() {
    this(new CapabilityVisibility());
  }
  
  public CapabilityVisibilityBuilder(CapabilityVisibilityFluent<?> fluent) {
    this(fluent, new CapabilityVisibility());
  }
  
  public CapabilityVisibilityBuilder(CapabilityVisibility instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CapabilityVisibilityBuilder(CapabilityVisibilityFluent<?> fluent,CapabilityVisibility instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CapabilityVisibility build() {
    CapabilityVisibility buildable = new CapabilityVisibility(fluent.getState());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}