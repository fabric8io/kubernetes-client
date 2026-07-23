package io.fabric8.kubernetes.api.model.authorization.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelfSubjectAccessReviewSpecBuilder extends SelfSubjectAccessReviewSpecFluent<SelfSubjectAccessReviewSpecBuilder> implements VisitableBuilder<SelfSubjectAccessReviewSpec,SelfSubjectAccessReviewSpecBuilder>{

  SelfSubjectAccessReviewSpecFluent<?> fluent;

  public SelfSubjectAccessReviewSpecBuilder() {
    this(new SelfSubjectAccessReviewSpec());
  }
  
  public SelfSubjectAccessReviewSpecBuilder(SelfSubjectAccessReviewSpecFluent<?> fluent) {
    this(fluent, new SelfSubjectAccessReviewSpec());
  }
  
  public SelfSubjectAccessReviewSpecBuilder(SelfSubjectAccessReviewSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelfSubjectAccessReviewSpecBuilder(SelfSubjectAccessReviewSpecFluent<?> fluent,SelfSubjectAccessReviewSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SelfSubjectAccessReviewSpec build() {
    SelfSubjectAccessReviewSpec buildable = new SelfSubjectAccessReviewSpec(fluent.buildNonResourceAttributes(), fluent.buildResourceAttributes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}