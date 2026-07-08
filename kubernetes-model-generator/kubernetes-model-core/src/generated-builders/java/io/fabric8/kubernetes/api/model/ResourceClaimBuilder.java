package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClaimBuilder extends ResourceClaimFluent<ResourceClaimBuilder> implements VisitableBuilder<ResourceClaim,ResourceClaimBuilder>{

  ResourceClaimFluent<?> fluent;

  public ResourceClaimBuilder() {
    this(new ResourceClaim());
  }
  
  public ResourceClaimBuilder(ResourceClaimFluent<?> fluent) {
    this(fluent, new ResourceClaim());
  }
  
  public ResourceClaimBuilder(ResourceClaim instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClaimBuilder(ResourceClaimFluent<?> fluent,ResourceClaim instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClaim build() {
    ResourceClaim buildable = new ResourceClaim(fluent.getName(), fluent.getRequest());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}