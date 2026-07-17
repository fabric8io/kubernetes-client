package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RequirementStatusBuilder extends RequirementStatusFluent<RequirementStatusBuilder> implements VisitableBuilder<RequirementStatus,RequirementStatusBuilder>{

  RequirementStatusFluent<?> fluent;

  public RequirementStatusBuilder() {
    this(new RequirementStatus());
  }
  
  public RequirementStatusBuilder(RequirementStatusFluent<?> fluent) {
    this(fluent, new RequirementStatus());
  }
  
  public RequirementStatusBuilder(RequirementStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RequirementStatusBuilder(RequirementStatusFluent<?> fluent,RequirementStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RequirementStatus build() {
    RequirementStatus buildable = new RequirementStatus(fluent.buildDependents(), fluent.getGroup(), fluent.getKind(), fluent.getMessage(), fluent.getName(), fluent.getStatus(), fluent.getUuid(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}