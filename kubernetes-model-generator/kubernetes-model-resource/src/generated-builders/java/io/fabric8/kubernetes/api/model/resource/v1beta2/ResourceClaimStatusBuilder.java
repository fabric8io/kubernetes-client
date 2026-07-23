package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClaimStatusBuilder extends ResourceClaimStatusFluent<ResourceClaimStatusBuilder> implements VisitableBuilder<ResourceClaimStatus,ResourceClaimStatusBuilder>{

  ResourceClaimStatusFluent<?> fluent;

  public ResourceClaimStatusBuilder() {
    this(new ResourceClaimStatus());
  }
  
  public ResourceClaimStatusBuilder(ResourceClaimStatusFluent<?> fluent) {
    this(fluent, new ResourceClaimStatus());
  }
  
  public ResourceClaimStatusBuilder(ResourceClaimStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClaimStatusBuilder(ResourceClaimStatusFluent<?> fluent,ResourceClaimStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClaimStatus build() {
    ResourceClaimStatus buildable = new ResourceClaimStatus(fluent.buildAllocation(), fluent.buildDevices(), fluent.buildReservedFor());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}