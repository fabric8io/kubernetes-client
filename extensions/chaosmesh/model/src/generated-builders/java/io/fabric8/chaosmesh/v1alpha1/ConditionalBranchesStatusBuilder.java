package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConditionalBranchesStatusBuilder extends ConditionalBranchesStatusFluent<ConditionalBranchesStatusBuilder> implements VisitableBuilder<ConditionalBranchesStatus,ConditionalBranchesStatusBuilder>{

  ConditionalBranchesStatusFluent<?> fluent;

  public ConditionalBranchesStatusBuilder() {
    this(new ConditionalBranchesStatus());
  }
  
  public ConditionalBranchesStatusBuilder(ConditionalBranchesStatusFluent<?> fluent) {
    this(fluent, new ConditionalBranchesStatus());
  }
  
  public ConditionalBranchesStatusBuilder(ConditionalBranchesStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConditionalBranchesStatusBuilder(ConditionalBranchesStatusFluent<?> fluent,ConditionalBranchesStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConditionalBranchesStatus build() {
    ConditionalBranchesStatus buildable = new ConditionalBranchesStatus(fluent.buildBranches(), fluent.getContext());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}