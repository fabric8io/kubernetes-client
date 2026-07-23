package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceRequirementBuilder extends ResourceRequirementFluent<ResourceRequirementBuilder> implements VisitableBuilder<ResourceRequirement,ResourceRequirementBuilder>{

  ResourceRequirementFluent<?> fluent;

  public ResourceRequirementBuilder() {
    this(new ResourceRequirement());
  }
  
  public ResourceRequirementBuilder(ResourceRequirementFluent<?> fluent) {
    this(fluent, new ResourceRequirement());
  }
  
  public ResourceRequirementBuilder(ResourceRequirement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceRequirementBuilder(ResourceRequirementFluent<?> fluent,ResourceRequirement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceRequirement build() {
    ResourceRequirement buildable = new ResourceRequirement(fluent.buildResourceRequirements(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}