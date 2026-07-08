package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScopedResourceSelectorRequirementBuilder extends ScopedResourceSelectorRequirementFluent<ScopedResourceSelectorRequirementBuilder> implements VisitableBuilder<ScopedResourceSelectorRequirement,ScopedResourceSelectorRequirementBuilder>{

  ScopedResourceSelectorRequirementFluent<?> fluent;

  public ScopedResourceSelectorRequirementBuilder() {
    this(new ScopedResourceSelectorRequirement());
  }
  
  public ScopedResourceSelectorRequirementBuilder(ScopedResourceSelectorRequirementFluent<?> fluent) {
    this(fluent, new ScopedResourceSelectorRequirement());
  }
  
  public ScopedResourceSelectorRequirementBuilder(ScopedResourceSelectorRequirement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScopedResourceSelectorRequirementBuilder(ScopedResourceSelectorRequirementFluent<?> fluent,ScopedResourceSelectorRequirement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScopedResourceSelectorRequirement build() {
    ScopedResourceSelectorRequirement buildable = new ScopedResourceSelectorRequirement(fluent.getOperator(), fluent.getScopeName(), fluent.getValues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}