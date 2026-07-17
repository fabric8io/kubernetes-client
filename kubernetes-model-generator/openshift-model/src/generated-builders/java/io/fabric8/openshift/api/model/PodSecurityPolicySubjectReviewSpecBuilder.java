package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSecurityPolicySubjectReviewSpecBuilder extends PodSecurityPolicySubjectReviewSpecFluent<PodSecurityPolicySubjectReviewSpecBuilder> implements VisitableBuilder<PodSecurityPolicySubjectReviewSpec,PodSecurityPolicySubjectReviewSpecBuilder>{

  PodSecurityPolicySubjectReviewSpecFluent<?> fluent;

  public PodSecurityPolicySubjectReviewSpecBuilder() {
    this(new PodSecurityPolicySubjectReviewSpec());
  }
  
  public PodSecurityPolicySubjectReviewSpecBuilder(PodSecurityPolicySubjectReviewSpecFluent<?> fluent) {
    this(fluent, new PodSecurityPolicySubjectReviewSpec());
  }
  
  public PodSecurityPolicySubjectReviewSpecBuilder(PodSecurityPolicySubjectReviewSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSecurityPolicySubjectReviewSpecBuilder(PodSecurityPolicySubjectReviewSpecFluent<?> fluent,PodSecurityPolicySubjectReviewSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSecurityPolicySubjectReviewSpec build() {
    PodSecurityPolicySubjectReviewSpec buildable = new PodSecurityPolicySubjectReviewSpec(fluent.getGroups(), fluent.buildTemplate(), fluent.getUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}