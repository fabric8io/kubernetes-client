package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubjectRulesReviewBuilder extends SubjectRulesReviewFluent<SubjectRulesReviewBuilder> implements VisitableBuilder<SubjectRulesReview,SubjectRulesReviewBuilder>{

  SubjectRulesReviewFluent<?> fluent;

  public SubjectRulesReviewBuilder() {
    this(new SubjectRulesReview());
  }
  
  public SubjectRulesReviewBuilder(SubjectRulesReviewFluent<?> fluent) {
    this(fluent, new SubjectRulesReview());
  }
  
  public SubjectRulesReviewBuilder(SubjectRulesReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubjectRulesReviewBuilder(SubjectRulesReviewFluent<?> fluent,SubjectRulesReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubjectRulesReview build() {
    SubjectRulesReview buildable = new SubjectRulesReview(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}