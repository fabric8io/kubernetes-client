package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceRequirementsBuilder extends ResourceRequirementsFluent<ResourceRequirementsBuilder> implements VisitableBuilder<ResourceRequirements,ResourceRequirementsBuilder>{

  ResourceRequirementsFluent<?> fluent;

  public ResourceRequirementsBuilder() {
    this(new ResourceRequirements());
  }
  
  public ResourceRequirementsBuilder(ResourceRequirementsFluent<?> fluent) {
    this(fluent, new ResourceRequirements());
  }
  
  public ResourceRequirementsBuilder(ResourceRequirements instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceRequirementsBuilder(ResourceRequirementsFluent<?> fluent,ResourceRequirements instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceRequirements build() {
    ResourceRequirements buildable = new ResourceRequirements(fluent.buildClaims(), fluent.getLimits(), fluent.getRequests());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}