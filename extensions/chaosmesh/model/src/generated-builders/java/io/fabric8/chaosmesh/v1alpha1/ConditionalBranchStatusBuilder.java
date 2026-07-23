package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConditionalBranchStatusBuilder extends ConditionalBranchStatusFluent<ConditionalBranchStatusBuilder> implements VisitableBuilder<ConditionalBranchStatus,ConditionalBranchStatusBuilder>{

  ConditionalBranchStatusFluent<?> fluent;

  public ConditionalBranchStatusBuilder() {
    this(new ConditionalBranchStatus());
  }
  
  public ConditionalBranchStatusBuilder(ConditionalBranchStatusFluent<?> fluent) {
    this(fluent, new ConditionalBranchStatus());
  }
  
  public ConditionalBranchStatusBuilder(ConditionalBranchStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConditionalBranchStatusBuilder(ConditionalBranchStatusFluent<?> fluent,ConditionalBranchStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConditionalBranchStatus build() {
    ConditionalBranchStatus buildable = new ConditionalBranchStatus(fluent.getEvaluationResult(), fluent.getTarget());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}