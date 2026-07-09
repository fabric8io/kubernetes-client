package io.fabric8.kubernetes.api.model.authorization.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubjectAccessReviewStatusBuilder extends SubjectAccessReviewStatusFluent<SubjectAccessReviewStatusBuilder> implements VisitableBuilder<SubjectAccessReviewStatus,SubjectAccessReviewStatusBuilder>{

  SubjectAccessReviewStatusFluent<?> fluent;

  public SubjectAccessReviewStatusBuilder() {
    this(new SubjectAccessReviewStatus());
  }
  
  public SubjectAccessReviewStatusBuilder(SubjectAccessReviewStatusFluent<?> fluent) {
    this(fluent, new SubjectAccessReviewStatus());
  }
  
  public SubjectAccessReviewStatusBuilder(SubjectAccessReviewStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubjectAccessReviewStatusBuilder(SubjectAccessReviewStatusFluent<?> fluent,SubjectAccessReviewStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubjectAccessReviewStatus build() {
    SubjectAccessReviewStatus buildable = new SubjectAccessReviewStatus(fluent.getAllowed(), fluent.getDenied(), fluent.getEvaluationError(), fluent.getReason());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}