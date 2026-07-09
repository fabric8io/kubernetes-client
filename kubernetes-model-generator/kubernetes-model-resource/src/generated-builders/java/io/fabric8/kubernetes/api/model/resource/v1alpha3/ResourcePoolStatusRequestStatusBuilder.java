package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourcePoolStatusRequestStatusBuilder extends ResourcePoolStatusRequestStatusFluent<ResourcePoolStatusRequestStatusBuilder> implements VisitableBuilder<ResourcePoolStatusRequestStatus,ResourcePoolStatusRequestStatusBuilder>{

  ResourcePoolStatusRequestStatusFluent<?> fluent;

  public ResourcePoolStatusRequestStatusBuilder() {
    this(new ResourcePoolStatusRequestStatus());
  }
  
  public ResourcePoolStatusRequestStatusBuilder(ResourcePoolStatusRequestStatusFluent<?> fluent) {
    this(fluent, new ResourcePoolStatusRequestStatus());
  }
  
  public ResourcePoolStatusRequestStatusBuilder(ResourcePoolStatusRequestStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourcePoolStatusRequestStatusBuilder(ResourcePoolStatusRequestStatusFluent<?> fluent,ResourcePoolStatusRequestStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourcePoolStatusRequestStatus build() {
    ResourcePoolStatusRequestStatus buildable = new ResourcePoolStatusRequestStatus(fluent.getConditions(), fluent.getPoolCount(), fluent.buildPools());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}