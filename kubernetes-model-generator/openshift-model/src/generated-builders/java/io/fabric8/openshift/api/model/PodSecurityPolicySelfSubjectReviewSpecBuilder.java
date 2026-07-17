package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSecurityPolicySelfSubjectReviewSpecBuilder extends PodSecurityPolicySelfSubjectReviewSpecFluent<PodSecurityPolicySelfSubjectReviewSpecBuilder> implements VisitableBuilder<PodSecurityPolicySelfSubjectReviewSpec,PodSecurityPolicySelfSubjectReviewSpecBuilder>{

  PodSecurityPolicySelfSubjectReviewSpecFluent<?> fluent;

  public PodSecurityPolicySelfSubjectReviewSpecBuilder() {
    this(new PodSecurityPolicySelfSubjectReviewSpec());
  }
  
  public PodSecurityPolicySelfSubjectReviewSpecBuilder(PodSecurityPolicySelfSubjectReviewSpecFluent<?> fluent) {
    this(fluent, new PodSecurityPolicySelfSubjectReviewSpec());
  }
  
  public PodSecurityPolicySelfSubjectReviewSpecBuilder(PodSecurityPolicySelfSubjectReviewSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSecurityPolicySelfSubjectReviewSpecBuilder(PodSecurityPolicySelfSubjectReviewSpecFluent<?> fluent,PodSecurityPolicySelfSubjectReviewSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSecurityPolicySelfSubjectReviewSpec build() {
    PodSecurityPolicySelfSubjectReviewSpec buildable = new PodSecurityPolicySelfSubjectReviewSpec(fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}