package io.fabric8.kubernetes.api.model.authorization.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelfSubjectAccessReviewBuilder extends SelfSubjectAccessReviewFluent<SelfSubjectAccessReviewBuilder> implements VisitableBuilder<SelfSubjectAccessReview,SelfSubjectAccessReviewBuilder>{

  SelfSubjectAccessReviewFluent<?> fluent;

  public SelfSubjectAccessReviewBuilder() {
    this(new SelfSubjectAccessReview());
  }
  
  public SelfSubjectAccessReviewBuilder(SelfSubjectAccessReviewFluent<?> fluent) {
    this(fluent, new SelfSubjectAccessReview());
  }
  
  public SelfSubjectAccessReviewBuilder(SelfSubjectAccessReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelfSubjectAccessReviewBuilder(SelfSubjectAccessReviewFluent<?> fluent,SelfSubjectAccessReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SelfSubjectAccessReview build() {
    SelfSubjectAccessReview buildable = new SelfSubjectAccessReview(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}