package io.fabric8.kubernetes.api.model.authorization.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LocalSubjectAccessReviewBuilder extends LocalSubjectAccessReviewFluent<LocalSubjectAccessReviewBuilder> implements VisitableBuilder<LocalSubjectAccessReview,LocalSubjectAccessReviewBuilder>{

  LocalSubjectAccessReviewFluent<?> fluent;

  public LocalSubjectAccessReviewBuilder() {
    this(new LocalSubjectAccessReview());
  }
  
  public LocalSubjectAccessReviewBuilder(LocalSubjectAccessReviewFluent<?> fluent) {
    this(fluent, new LocalSubjectAccessReview());
  }
  
  public LocalSubjectAccessReviewBuilder(LocalSubjectAccessReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LocalSubjectAccessReviewBuilder(LocalSubjectAccessReviewFluent<?> fluent,LocalSubjectAccessReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LocalSubjectAccessReview build() {
    LocalSubjectAccessReview buildable = new LocalSubjectAccessReview(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}