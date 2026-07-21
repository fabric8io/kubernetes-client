package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AppliedEventPoliciesStatusBuilder extends AppliedEventPoliciesStatusFluent<AppliedEventPoliciesStatusBuilder> implements VisitableBuilder<AppliedEventPoliciesStatus,AppliedEventPoliciesStatusBuilder>{

  AppliedEventPoliciesStatusFluent<?> fluent;

  public AppliedEventPoliciesStatusBuilder() {
    this(new AppliedEventPoliciesStatus());
  }
  
  public AppliedEventPoliciesStatusBuilder(AppliedEventPoliciesStatusFluent<?> fluent) {
    this(fluent, new AppliedEventPoliciesStatus());
  }
  
  public AppliedEventPoliciesStatusBuilder(AppliedEventPoliciesStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AppliedEventPoliciesStatusBuilder(AppliedEventPoliciesStatusFluent<?> fluent,AppliedEventPoliciesStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AppliedEventPoliciesStatus build() {
    AppliedEventPoliciesStatus buildable = new AppliedEventPoliciesStatus(fluent.buildPolicies());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}