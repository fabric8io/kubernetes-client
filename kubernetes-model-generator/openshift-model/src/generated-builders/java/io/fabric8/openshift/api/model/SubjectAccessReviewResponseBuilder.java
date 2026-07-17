package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubjectAccessReviewResponseBuilder extends SubjectAccessReviewResponseFluent<SubjectAccessReviewResponseBuilder> implements VisitableBuilder<SubjectAccessReviewResponse,SubjectAccessReviewResponseBuilder>{

  SubjectAccessReviewResponseFluent<?> fluent;

  public SubjectAccessReviewResponseBuilder() {
    this(new SubjectAccessReviewResponse());
  }
  
  public SubjectAccessReviewResponseBuilder(SubjectAccessReviewResponseFluent<?> fluent) {
    this(fluent, new SubjectAccessReviewResponse());
  }
  
  public SubjectAccessReviewResponseBuilder(SubjectAccessReviewResponse instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubjectAccessReviewResponseBuilder(SubjectAccessReviewResponseFluent<?> fluent,SubjectAccessReviewResponse instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubjectAccessReviewResponse build() {
    SubjectAccessReviewResponse buildable = new SubjectAccessReviewResponse(fluent.getAllowed(), fluent.getApiVersion(), fluent.getEvaluationError(), fluent.getKind(), fluent.getNamespace(), fluent.getReason());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}