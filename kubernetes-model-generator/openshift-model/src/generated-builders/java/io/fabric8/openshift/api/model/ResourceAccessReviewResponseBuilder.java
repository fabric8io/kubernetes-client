package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceAccessReviewResponseBuilder extends ResourceAccessReviewResponseFluent<ResourceAccessReviewResponseBuilder> implements VisitableBuilder<ResourceAccessReviewResponse,ResourceAccessReviewResponseBuilder>{

  ResourceAccessReviewResponseFluent<?> fluent;

  public ResourceAccessReviewResponseBuilder() {
    this(new ResourceAccessReviewResponse());
  }
  
  public ResourceAccessReviewResponseBuilder(ResourceAccessReviewResponseFluent<?> fluent) {
    this(fluent, new ResourceAccessReviewResponse());
  }
  
  public ResourceAccessReviewResponseBuilder(ResourceAccessReviewResponse instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceAccessReviewResponseBuilder(ResourceAccessReviewResponseFluent<?> fluent,ResourceAccessReviewResponse instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceAccessReviewResponse build() {
    ResourceAccessReviewResponse buildable = new ResourceAccessReviewResponse(fluent.getApiVersion(), fluent.getEvalutionError(), fluent.getGroups(), fluent.getKind(), fluent.getNamespace(), fluent.getUsers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}