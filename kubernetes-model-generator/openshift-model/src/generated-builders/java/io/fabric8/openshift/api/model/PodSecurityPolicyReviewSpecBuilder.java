package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSecurityPolicyReviewSpecBuilder extends PodSecurityPolicyReviewSpecFluent<PodSecurityPolicyReviewSpecBuilder> implements VisitableBuilder<PodSecurityPolicyReviewSpec,PodSecurityPolicyReviewSpecBuilder>{

  PodSecurityPolicyReviewSpecFluent<?> fluent;

  public PodSecurityPolicyReviewSpecBuilder() {
    this(new PodSecurityPolicyReviewSpec());
  }
  
  public PodSecurityPolicyReviewSpecBuilder(PodSecurityPolicyReviewSpecFluent<?> fluent) {
    this(fluent, new PodSecurityPolicyReviewSpec());
  }
  
  public PodSecurityPolicyReviewSpecBuilder(PodSecurityPolicyReviewSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSecurityPolicyReviewSpecBuilder(PodSecurityPolicyReviewSpecFluent<?> fluent,PodSecurityPolicyReviewSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSecurityPolicyReviewSpec build() {
    PodSecurityPolicyReviewSpec buildable = new PodSecurityPolicyReviewSpec(fluent.getServiceAccountNames(), fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}