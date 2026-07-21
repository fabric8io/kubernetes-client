package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConditionalBranchBuilder extends ConditionalBranchFluent<ConditionalBranchBuilder> implements VisitableBuilder<ConditionalBranch,ConditionalBranchBuilder>{

  ConditionalBranchFluent<?> fluent;

  public ConditionalBranchBuilder() {
    this(new ConditionalBranch());
  }
  
  public ConditionalBranchBuilder(ConditionalBranchFluent<?> fluent) {
    this(fluent, new ConditionalBranch());
  }
  
  public ConditionalBranchBuilder(ConditionalBranch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConditionalBranchBuilder(ConditionalBranchFluent<?> fluent,ConditionalBranch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConditionalBranch build() {
    ConditionalBranch buildable = new ConditionalBranch(fluent.getExpression(), fluent.getTarget());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}