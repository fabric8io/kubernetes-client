package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSecurityPolicySubjectReviewStatusBuilder extends PodSecurityPolicySubjectReviewStatusFluent<PodSecurityPolicySubjectReviewStatusBuilder> implements VisitableBuilder<PodSecurityPolicySubjectReviewStatus,PodSecurityPolicySubjectReviewStatusBuilder>{

  PodSecurityPolicySubjectReviewStatusFluent<?> fluent;

  public PodSecurityPolicySubjectReviewStatusBuilder() {
    this(new PodSecurityPolicySubjectReviewStatus());
  }
  
  public PodSecurityPolicySubjectReviewStatusBuilder(PodSecurityPolicySubjectReviewStatusFluent<?> fluent) {
    this(fluent, new PodSecurityPolicySubjectReviewStatus());
  }
  
  public PodSecurityPolicySubjectReviewStatusBuilder(PodSecurityPolicySubjectReviewStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSecurityPolicySubjectReviewStatusBuilder(PodSecurityPolicySubjectReviewStatusFluent<?> fluent,PodSecurityPolicySubjectReviewStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSecurityPolicySubjectReviewStatus build() {
    PodSecurityPolicySubjectReviewStatus buildable = new PodSecurityPolicySubjectReviewStatus(fluent.buildAllowedBy(), fluent.getReason(), fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}