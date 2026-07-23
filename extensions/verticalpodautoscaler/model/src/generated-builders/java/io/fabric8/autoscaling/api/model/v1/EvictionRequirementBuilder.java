package io.fabric8.autoscaling.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EvictionRequirementBuilder extends EvictionRequirementFluent<EvictionRequirementBuilder> implements VisitableBuilder<EvictionRequirement,EvictionRequirementBuilder>{

  EvictionRequirementFluent<?> fluent;

  public EvictionRequirementBuilder() {
    this(new EvictionRequirement());
  }
  
  public EvictionRequirementBuilder(EvictionRequirementFluent<?> fluent) {
    this(fluent, new EvictionRequirement());
  }
  
  public EvictionRequirementBuilder(EvictionRequirement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EvictionRequirementBuilder(EvictionRequirementFluent<?> fluent,EvictionRequirement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EvictionRequirement build() {
    EvictionRequirement buildable = new EvictionRequirement(fluent.getChangeRequirement(), fluent.getResources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}