package io.fabric8.kubernetes.api.model.authorization.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubjectRulesReviewStatusBuilder extends SubjectRulesReviewStatusFluent<SubjectRulesReviewStatusBuilder> implements VisitableBuilder<SubjectRulesReviewStatus,SubjectRulesReviewStatusBuilder>{

  SubjectRulesReviewStatusFluent<?> fluent;

  public SubjectRulesReviewStatusBuilder() {
    this(new SubjectRulesReviewStatus());
  }
  
  public SubjectRulesReviewStatusBuilder(SubjectRulesReviewStatusFluent<?> fluent) {
    this(fluent, new SubjectRulesReviewStatus());
  }
  
  public SubjectRulesReviewStatusBuilder(SubjectRulesReviewStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubjectRulesReviewStatusBuilder(SubjectRulesReviewStatusFluent<?> fluent,SubjectRulesReviewStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubjectRulesReviewStatus build() {
    SubjectRulesReviewStatus buildable = new SubjectRulesReviewStatus(fluent.getEvaluationError(), fluent.getIncomplete(), fluent.buildNonResourceRules(), fluent.buildResourceRules());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}