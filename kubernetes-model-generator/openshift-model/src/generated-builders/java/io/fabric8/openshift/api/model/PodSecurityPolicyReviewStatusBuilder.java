package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSecurityPolicyReviewStatusBuilder extends PodSecurityPolicyReviewStatusFluent<PodSecurityPolicyReviewStatusBuilder> implements VisitableBuilder<PodSecurityPolicyReviewStatus,PodSecurityPolicyReviewStatusBuilder>{

  PodSecurityPolicyReviewStatusFluent<?> fluent;

  public PodSecurityPolicyReviewStatusBuilder() {
    this(new PodSecurityPolicyReviewStatus());
  }
  
  public PodSecurityPolicyReviewStatusBuilder(PodSecurityPolicyReviewStatusFluent<?> fluent) {
    this(fluent, new PodSecurityPolicyReviewStatus());
  }
  
  public PodSecurityPolicyReviewStatusBuilder(PodSecurityPolicyReviewStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSecurityPolicyReviewStatusBuilder(PodSecurityPolicyReviewStatusFluent<?> fluent,PodSecurityPolicyReviewStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSecurityPolicyReviewStatus build() {
    PodSecurityPolicyReviewStatus buildable = new PodSecurityPolicyReviewStatus(fluent.buildAllowedServiceAccounts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}