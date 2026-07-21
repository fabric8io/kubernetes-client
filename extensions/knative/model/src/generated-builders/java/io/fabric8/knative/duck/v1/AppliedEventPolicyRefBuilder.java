package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AppliedEventPolicyRefBuilder extends AppliedEventPolicyRefFluent<AppliedEventPolicyRefBuilder> implements VisitableBuilder<AppliedEventPolicyRef,AppliedEventPolicyRefBuilder>{

  AppliedEventPolicyRefFluent<?> fluent;

  public AppliedEventPolicyRefBuilder() {
    this(new AppliedEventPolicyRef());
  }
  
  public AppliedEventPolicyRefBuilder(AppliedEventPolicyRefFluent<?> fluent) {
    this(fluent, new AppliedEventPolicyRef());
  }
  
  public AppliedEventPolicyRefBuilder(AppliedEventPolicyRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AppliedEventPolicyRefBuilder(AppliedEventPolicyRefFluent<?> fluent,AppliedEventPolicyRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AppliedEventPolicyRef build() {
    AppliedEventPolicyRef buildable = new AppliedEventPolicyRef(fluent.getApiVersion(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}