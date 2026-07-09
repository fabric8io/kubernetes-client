package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CapacityRequirementsBuilder extends CapacityRequirementsFluent<CapacityRequirementsBuilder> implements VisitableBuilder<CapacityRequirements,CapacityRequirementsBuilder>{

  CapacityRequirementsFluent<?> fluent;

  public CapacityRequirementsBuilder() {
    this(new CapacityRequirements());
  }
  
  public CapacityRequirementsBuilder(CapacityRequirementsFluent<?> fluent) {
    this(fluent, new CapacityRequirements());
  }
  
  public CapacityRequirementsBuilder(CapacityRequirements instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CapacityRequirementsBuilder(CapacityRequirementsFluent<?> fluent,CapacityRequirements instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CapacityRequirements build() {
    CapacityRequirements buildable = new CapacityRequirements(fluent.getRequests());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}