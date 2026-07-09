package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClaimSchedulingStatusBuilder extends ResourceClaimSchedulingStatusFluent<ResourceClaimSchedulingStatusBuilder> implements VisitableBuilder<ResourceClaimSchedulingStatus,ResourceClaimSchedulingStatusBuilder>{

  ResourceClaimSchedulingStatusFluent<?> fluent;

  public ResourceClaimSchedulingStatusBuilder() {
    this(new ResourceClaimSchedulingStatus());
  }
  
  public ResourceClaimSchedulingStatusBuilder(ResourceClaimSchedulingStatusFluent<?> fluent) {
    this(fluent, new ResourceClaimSchedulingStatus());
  }
  
  public ResourceClaimSchedulingStatusBuilder(ResourceClaimSchedulingStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClaimSchedulingStatusBuilder(ResourceClaimSchedulingStatusFluent<?> fluent,ResourceClaimSchedulingStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClaimSchedulingStatus build() {
    ResourceClaimSchedulingStatus buildable = new ResourceClaimSchedulingStatus(fluent.getName(), fluent.getUnsuitableNodes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}