package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IsPersonalSubjectAccessReviewBuilder extends IsPersonalSubjectAccessReviewFluent<IsPersonalSubjectAccessReviewBuilder> implements VisitableBuilder<IsPersonalSubjectAccessReview,IsPersonalSubjectAccessReviewBuilder>{

  IsPersonalSubjectAccessReviewFluent<?> fluent;

  public IsPersonalSubjectAccessReviewBuilder() {
    this(new IsPersonalSubjectAccessReview());
  }
  
  public IsPersonalSubjectAccessReviewBuilder(IsPersonalSubjectAccessReviewFluent<?> fluent) {
    this(fluent, new IsPersonalSubjectAccessReview());
  }
  
  public IsPersonalSubjectAccessReviewBuilder(IsPersonalSubjectAccessReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IsPersonalSubjectAccessReviewBuilder(IsPersonalSubjectAccessReviewFluent<?> fluent,IsPersonalSubjectAccessReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IsPersonalSubjectAccessReview build() {
    IsPersonalSubjectAccessReview buildable = new IsPersonalSubjectAccessReview(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}