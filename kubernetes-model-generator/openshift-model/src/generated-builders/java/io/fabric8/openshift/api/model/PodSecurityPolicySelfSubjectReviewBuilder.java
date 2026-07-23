package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSecurityPolicySelfSubjectReviewBuilder extends PodSecurityPolicySelfSubjectReviewFluent<PodSecurityPolicySelfSubjectReviewBuilder> implements VisitableBuilder<PodSecurityPolicySelfSubjectReview,PodSecurityPolicySelfSubjectReviewBuilder>{

  PodSecurityPolicySelfSubjectReviewFluent<?> fluent;

  public PodSecurityPolicySelfSubjectReviewBuilder() {
    this(new PodSecurityPolicySelfSubjectReview());
  }
  
  public PodSecurityPolicySelfSubjectReviewBuilder(PodSecurityPolicySelfSubjectReviewFluent<?> fluent) {
    this(fluent, new PodSecurityPolicySelfSubjectReview());
  }
  
  public PodSecurityPolicySelfSubjectReviewBuilder(PodSecurityPolicySelfSubjectReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSecurityPolicySelfSubjectReviewBuilder(PodSecurityPolicySelfSubjectReviewFluent<?> fluent,PodSecurityPolicySelfSubjectReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSecurityPolicySelfSubjectReview build() {
    PodSecurityPolicySelfSubjectReview buildable = new PodSecurityPolicySelfSubjectReview(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}