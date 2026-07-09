package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourcePoolStatusRequestBuilder extends ResourcePoolStatusRequestFluent<ResourcePoolStatusRequestBuilder> implements VisitableBuilder<ResourcePoolStatusRequest,ResourcePoolStatusRequestBuilder>{

  ResourcePoolStatusRequestFluent<?> fluent;

  public ResourcePoolStatusRequestBuilder() {
    this(new ResourcePoolStatusRequest());
  }
  
  public ResourcePoolStatusRequestBuilder(ResourcePoolStatusRequestFluent<?> fluent) {
    this(fluent, new ResourcePoolStatusRequest());
  }
  
  public ResourcePoolStatusRequestBuilder(ResourcePoolStatusRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourcePoolStatusRequestBuilder(ResourcePoolStatusRequestFluent<?> fluent,ResourcePoolStatusRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourcePoolStatusRequest build() {
    ResourcePoolStatusRequest buildable = new ResourcePoolStatusRequest(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}