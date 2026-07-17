package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceAccessReviewBuilder extends ResourceAccessReviewFluent<ResourceAccessReviewBuilder> implements VisitableBuilder<ResourceAccessReview,ResourceAccessReviewBuilder>{

  ResourceAccessReviewFluent<?> fluent;

  public ResourceAccessReviewBuilder() {
    this(new ResourceAccessReview());
  }
  
  public ResourceAccessReviewBuilder(ResourceAccessReviewFluent<?> fluent) {
    this(fluent, new ResourceAccessReview());
  }
  
  public ResourceAccessReviewBuilder(ResourceAccessReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceAccessReviewBuilder(ResourceAccessReviewFluent<?> fluent,ResourceAccessReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceAccessReview build() {
    ResourceAccessReview buildable = new ResourceAccessReview(fluent.getApiVersion(), fluent.getContent(), fluent.getIsNonResourceURL(), fluent.getKind(), fluent.buildMetadata(), fluent.getNamespace(), fluent.getPath(), fluent.getResource(), fluent.getResourceAPIGroup(), fluent.getResourceAPIVersion(), fluent.getResourceName(), fluent.getVerb());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}