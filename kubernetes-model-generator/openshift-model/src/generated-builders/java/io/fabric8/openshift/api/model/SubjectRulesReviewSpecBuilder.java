package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubjectRulesReviewSpecBuilder extends SubjectRulesReviewSpecFluent<SubjectRulesReviewSpecBuilder> implements VisitableBuilder<SubjectRulesReviewSpec,SubjectRulesReviewSpecBuilder>{

  SubjectRulesReviewSpecFluent<?> fluent;

  public SubjectRulesReviewSpecBuilder() {
    this(new SubjectRulesReviewSpec());
  }
  
  public SubjectRulesReviewSpecBuilder(SubjectRulesReviewSpecFluent<?> fluent) {
    this(fluent, new SubjectRulesReviewSpec());
  }
  
  public SubjectRulesReviewSpecBuilder(SubjectRulesReviewSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubjectRulesReviewSpecBuilder(SubjectRulesReviewSpecFluent<?> fluent,SubjectRulesReviewSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubjectRulesReviewSpec build() {
    SubjectRulesReviewSpec buildable = new SubjectRulesReviewSpec(fluent.getGroups(), fluent.getScopes(), fluent.getUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}