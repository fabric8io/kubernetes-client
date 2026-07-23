package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSecurityPolicySubjectReviewBuilder extends PodSecurityPolicySubjectReviewFluent<PodSecurityPolicySubjectReviewBuilder> implements VisitableBuilder<PodSecurityPolicySubjectReview,PodSecurityPolicySubjectReviewBuilder>{

  PodSecurityPolicySubjectReviewFluent<?> fluent;

  public PodSecurityPolicySubjectReviewBuilder() {
    this(new PodSecurityPolicySubjectReview());
  }
  
  public PodSecurityPolicySubjectReviewBuilder(PodSecurityPolicySubjectReviewFluent<?> fluent) {
    this(fluent, new PodSecurityPolicySubjectReview());
  }
  
  public PodSecurityPolicySubjectReviewBuilder(PodSecurityPolicySubjectReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSecurityPolicySubjectReviewBuilder(PodSecurityPolicySubjectReviewFluent<?> fluent,PodSecurityPolicySubjectReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSecurityPolicySubjectReview build() {
    PodSecurityPolicySubjectReview buildable = new PodSecurityPolicySubjectReview(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}