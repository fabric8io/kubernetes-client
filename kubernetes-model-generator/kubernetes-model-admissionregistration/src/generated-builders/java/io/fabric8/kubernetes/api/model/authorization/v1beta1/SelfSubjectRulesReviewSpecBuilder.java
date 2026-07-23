package io.fabric8.kubernetes.api.model.authorization.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelfSubjectRulesReviewSpecBuilder extends SelfSubjectRulesReviewSpecFluent<SelfSubjectRulesReviewSpecBuilder> implements VisitableBuilder<SelfSubjectRulesReviewSpec,SelfSubjectRulesReviewSpecBuilder>{

  SelfSubjectRulesReviewSpecFluent<?> fluent;

  public SelfSubjectRulesReviewSpecBuilder() {
    this(new SelfSubjectRulesReviewSpec());
  }
  
  public SelfSubjectRulesReviewSpecBuilder(SelfSubjectRulesReviewSpecFluent<?> fluent) {
    this(fluent, new SelfSubjectRulesReviewSpec());
  }
  
  public SelfSubjectRulesReviewSpecBuilder(SelfSubjectRulesReviewSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelfSubjectRulesReviewSpecBuilder(SelfSubjectRulesReviewSpecFluent<?> fluent,SelfSubjectRulesReviewSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SelfSubjectRulesReviewSpec build() {
    SelfSubjectRulesReviewSpec buildable = new SelfSubjectRulesReviewSpec(fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}