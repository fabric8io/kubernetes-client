package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSecurityPolicyReviewBuilder extends PodSecurityPolicyReviewFluent<PodSecurityPolicyReviewBuilder> implements VisitableBuilder<PodSecurityPolicyReview,PodSecurityPolicyReviewBuilder>{

  PodSecurityPolicyReviewFluent<?> fluent;

  public PodSecurityPolicyReviewBuilder() {
    this(new PodSecurityPolicyReview());
  }
  
  public PodSecurityPolicyReviewBuilder(PodSecurityPolicyReviewFluent<?> fluent) {
    this(fluent, new PodSecurityPolicyReview());
  }
  
  public PodSecurityPolicyReviewBuilder(PodSecurityPolicyReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSecurityPolicyReviewBuilder(PodSecurityPolicyReviewFluent<?> fluent,PodSecurityPolicyReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSecurityPolicyReview build() {
    PodSecurityPolicyReview buildable = new PodSecurityPolicyReview(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}