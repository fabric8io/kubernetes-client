package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelfSubjectRulesReviewBuilder extends SelfSubjectRulesReviewFluent<SelfSubjectRulesReviewBuilder> implements VisitableBuilder<SelfSubjectRulesReview,SelfSubjectRulesReviewBuilder>{

  SelfSubjectRulesReviewFluent<?> fluent;

  public SelfSubjectRulesReviewBuilder() {
    this(new SelfSubjectRulesReview());
  }
  
  public SelfSubjectRulesReviewBuilder(SelfSubjectRulesReviewFluent<?> fluent) {
    this(fluent, new SelfSubjectRulesReview());
  }
  
  public SelfSubjectRulesReviewBuilder(SelfSubjectRulesReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelfSubjectRulesReviewBuilder(SelfSubjectRulesReviewFluent<?> fluent,SelfSubjectRulesReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SelfSubjectRulesReview build() {
    SelfSubjectRulesReview buildable = new SelfSubjectRulesReview(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}