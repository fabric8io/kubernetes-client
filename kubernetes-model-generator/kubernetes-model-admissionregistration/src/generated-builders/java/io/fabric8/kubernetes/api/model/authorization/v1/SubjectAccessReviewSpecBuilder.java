package io.fabric8.kubernetes.api.model.authorization.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubjectAccessReviewSpecBuilder extends SubjectAccessReviewSpecFluent<SubjectAccessReviewSpecBuilder> implements VisitableBuilder<SubjectAccessReviewSpec,SubjectAccessReviewSpecBuilder>{

  SubjectAccessReviewSpecFluent<?> fluent;

  public SubjectAccessReviewSpecBuilder() {
    this(new SubjectAccessReviewSpec());
  }
  
  public SubjectAccessReviewSpecBuilder(SubjectAccessReviewSpecFluent<?> fluent) {
    this(fluent, new SubjectAccessReviewSpec());
  }
  
  public SubjectAccessReviewSpecBuilder(SubjectAccessReviewSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubjectAccessReviewSpecBuilder(SubjectAccessReviewSpecFluent<?> fluent,SubjectAccessReviewSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubjectAccessReviewSpec build() {
    SubjectAccessReviewSpec buildable = new SubjectAccessReviewSpec(fluent.getExtra(), fluent.getGroups(), fluent.buildNonResourceAttributes(), fluent.buildResourceAttributes(), fluent.getUid(), fluent.getUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}