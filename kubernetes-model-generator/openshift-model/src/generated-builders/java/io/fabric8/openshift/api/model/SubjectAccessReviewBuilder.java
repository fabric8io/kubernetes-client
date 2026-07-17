package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubjectAccessReviewBuilder extends SubjectAccessReviewFluent<SubjectAccessReviewBuilder> implements VisitableBuilder<SubjectAccessReview,SubjectAccessReviewBuilder>{

  SubjectAccessReviewFluent<?> fluent;

  public SubjectAccessReviewBuilder() {
    this(new SubjectAccessReview());
  }
  
  public SubjectAccessReviewBuilder(SubjectAccessReviewFluent<?> fluent) {
    this(fluent, new SubjectAccessReview());
  }
  
  public SubjectAccessReviewBuilder(SubjectAccessReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubjectAccessReviewBuilder(SubjectAccessReviewFluent<?> fluent,SubjectAccessReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubjectAccessReview build() {
    SubjectAccessReview buildable = new SubjectAccessReview(fluent.getApiVersion(), fluent.getContent(), fluent.getGroups(), fluent.getIsNonResourceURL(), fluent.getKind(), fluent.buildMetadata(), fluent.getNamespace(), fluent.getPath(), fluent.getResource(), fluent.getResourceAPIGroup(), fluent.getResourceAPIVersion(), fluent.getResourceName(), fluent.getScopes(), fluent.getUser(), fluent.getVerb());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}