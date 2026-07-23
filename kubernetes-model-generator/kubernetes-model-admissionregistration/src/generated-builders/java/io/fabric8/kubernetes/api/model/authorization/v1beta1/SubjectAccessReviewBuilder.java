package io.fabric8.kubernetes.api.model.authorization.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubjectAccessReviewBuilder extends SubjectAccessReviewFluent<SubjectAccessReviewBuilder> implements VisitableBuilder<SubjectAccessReview,SubjectAccessReviewBuilder>{

  SubjectAccessReviewFluent<?> fluent;

  public SubjectAccessReviewBuilder() {
    this(new SubjectAccessReview());
  }
  
  public SubjectAccessReviewBuilder(SubjectAccessReviewFluent<?> fluent) {
    this(fluent, new SubjectAccessReview());
  }
  
  public SubjectAccessReviewBuilder(SubjectAccessReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubjectAccessReviewBuilder(SubjectAccessReviewFluent<?> fluent,SubjectAccessReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubjectAccessReview build() {
    SubjectAccessReview buildable = new SubjectAccessReview(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}