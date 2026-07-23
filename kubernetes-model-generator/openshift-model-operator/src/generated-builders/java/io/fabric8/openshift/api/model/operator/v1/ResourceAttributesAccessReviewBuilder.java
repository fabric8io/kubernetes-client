package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceAttributesAccessReviewBuilder extends ResourceAttributesAccessReviewFluent<ResourceAttributesAccessReviewBuilder> implements VisitableBuilder<ResourceAttributesAccessReview,ResourceAttributesAccessReviewBuilder>{

  ResourceAttributesAccessReviewFluent<?> fluent;

  public ResourceAttributesAccessReviewBuilder() {
    this(new ResourceAttributesAccessReview());
  }
  
  public ResourceAttributesAccessReviewBuilder(ResourceAttributesAccessReviewFluent<?> fluent) {
    this(fluent, new ResourceAttributesAccessReview());
  }
  
  public ResourceAttributesAccessReviewBuilder(ResourceAttributesAccessReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceAttributesAccessReviewBuilder(ResourceAttributesAccessReviewFluent<?> fluent,ResourceAttributesAccessReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceAttributesAccessReview build() {
    ResourceAttributesAccessReview buildable = new ResourceAttributesAccessReview(fluent.getMissing(), fluent.getRequired());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}