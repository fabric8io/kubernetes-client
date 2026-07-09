package io.fabric8.kubernetes.api.model.authentication;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelfSubjectReviewBuilder extends SelfSubjectReviewFluent<SelfSubjectReviewBuilder> implements VisitableBuilder<SelfSubjectReview,SelfSubjectReviewBuilder>{

  SelfSubjectReviewFluent<?> fluent;

  public SelfSubjectReviewBuilder() {
    this(new SelfSubjectReview());
  }
  
  public SelfSubjectReviewBuilder(SelfSubjectReviewFluent<?> fluent) {
    this(fluent, new SelfSubjectReview());
  }
  
  public SelfSubjectReviewBuilder(SelfSubjectReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelfSubjectReviewBuilder(SelfSubjectReviewFluent<?> fluent,SelfSubjectReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SelfSubjectReview build() {
    SelfSubjectReview buildable = new SelfSubjectReview(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}