package io.fabric8.kubernetes.api.model.batch.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodFailurePolicyOnExitCodesRequirementBuilder extends PodFailurePolicyOnExitCodesRequirementFluent<PodFailurePolicyOnExitCodesRequirementBuilder> implements VisitableBuilder<PodFailurePolicyOnExitCodesRequirement,PodFailurePolicyOnExitCodesRequirementBuilder>{

  PodFailurePolicyOnExitCodesRequirementFluent<?> fluent;

  public PodFailurePolicyOnExitCodesRequirementBuilder() {
    this(new PodFailurePolicyOnExitCodesRequirement());
  }
  
  public PodFailurePolicyOnExitCodesRequirementBuilder(PodFailurePolicyOnExitCodesRequirementFluent<?> fluent) {
    this(fluent, new PodFailurePolicyOnExitCodesRequirement());
  }
  
  public PodFailurePolicyOnExitCodesRequirementBuilder(PodFailurePolicyOnExitCodesRequirement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodFailurePolicyOnExitCodesRequirementBuilder(PodFailurePolicyOnExitCodesRequirementFluent<?> fluent,PodFailurePolicyOnExitCodesRequirement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodFailurePolicyOnExitCodesRequirement build() {
    PodFailurePolicyOnExitCodesRequirement buildable = new PodFailurePolicyOnExitCodesRequirement(fluent.getContainerName(), fluent.getOperator(), fluent.getValues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}