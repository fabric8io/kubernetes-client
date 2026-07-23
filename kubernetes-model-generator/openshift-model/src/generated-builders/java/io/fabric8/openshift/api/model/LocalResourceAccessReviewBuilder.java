package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LocalResourceAccessReviewBuilder extends LocalResourceAccessReviewFluent<LocalResourceAccessReviewBuilder> implements VisitableBuilder<LocalResourceAccessReview,LocalResourceAccessReviewBuilder>{

  LocalResourceAccessReviewFluent<?> fluent;

  public LocalResourceAccessReviewBuilder() {
    this(new LocalResourceAccessReview());
  }
  
  public LocalResourceAccessReviewBuilder(LocalResourceAccessReviewFluent<?> fluent) {
    this(fluent, new LocalResourceAccessReview());
  }
  
  public LocalResourceAccessReviewBuilder(LocalResourceAccessReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LocalResourceAccessReviewBuilder(LocalResourceAccessReviewFluent<?> fluent,LocalResourceAccessReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LocalResourceAccessReview build() {
    LocalResourceAccessReview buildable = new LocalResourceAccessReview(fluent.getApiVersion(), fluent.getContent(), fluent.getIsNonResourceURL(), fluent.getKind(), fluent.buildMetadata(), fluent.getNamespace(), fluent.getPath(), fluent.getResource(), fluent.getResourceAPIGroup(), fluent.getResourceAPIVersion(), fluent.getResourceName(), fluent.getVerb());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}