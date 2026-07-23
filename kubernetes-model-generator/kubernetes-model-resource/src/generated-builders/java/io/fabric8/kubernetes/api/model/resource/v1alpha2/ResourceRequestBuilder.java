package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceRequestBuilder extends ResourceRequestFluent<ResourceRequestBuilder> implements VisitableBuilder<ResourceRequest,ResourceRequestBuilder>{

  ResourceRequestFluent<?> fluent;

  public ResourceRequestBuilder() {
    this(new ResourceRequest());
  }
  
  public ResourceRequestBuilder(ResourceRequestFluent<?> fluent) {
    this(fluent, new ResourceRequest());
  }
  
  public ResourceRequestBuilder(ResourceRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceRequestBuilder(ResourceRequestFluent<?> fluent,ResourceRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceRequest build() {
    ResourceRequest buildable = new ResourceRequest(fluent.buildNamedResources(), fluent.getVendorParameters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}