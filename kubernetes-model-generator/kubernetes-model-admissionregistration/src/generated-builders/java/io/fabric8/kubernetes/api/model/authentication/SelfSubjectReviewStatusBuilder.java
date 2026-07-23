package io.fabric8.kubernetes.api.model.authentication;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelfSubjectReviewStatusBuilder extends SelfSubjectReviewStatusFluent<SelfSubjectReviewStatusBuilder> implements VisitableBuilder<SelfSubjectReviewStatus,SelfSubjectReviewStatusBuilder>{

  SelfSubjectReviewStatusFluent<?> fluent;

  public SelfSubjectReviewStatusBuilder() {
    this(new SelfSubjectReviewStatus());
  }
  
  public SelfSubjectReviewStatusBuilder(SelfSubjectReviewStatusFluent<?> fluent) {
    this(fluent, new SelfSubjectReviewStatus());
  }
  
  public SelfSubjectReviewStatusBuilder(SelfSubjectReviewStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelfSubjectReviewStatusBuilder(SelfSubjectReviewStatusFluent<?> fluent,SelfSubjectReviewStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SelfSubjectReviewStatus build() {
    SelfSubjectReviewStatus buildable = new SelfSubjectReviewStatus(fluent.buildUserInfo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}