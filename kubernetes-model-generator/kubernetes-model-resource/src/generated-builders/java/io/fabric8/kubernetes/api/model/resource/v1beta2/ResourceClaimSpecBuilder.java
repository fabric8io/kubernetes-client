package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClaimSpecBuilder extends ResourceClaimSpecFluent<ResourceClaimSpecBuilder> implements VisitableBuilder<ResourceClaimSpec,ResourceClaimSpecBuilder>{

  ResourceClaimSpecFluent<?> fluent;

  public ResourceClaimSpecBuilder() {
    this(new ResourceClaimSpec());
  }
  
  public ResourceClaimSpecBuilder(ResourceClaimSpecFluent<?> fluent) {
    this(fluent, new ResourceClaimSpec());
  }
  
  public ResourceClaimSpecBuilder(ResourceClaimSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClaimSpecBuilder(ResourceClaimSpecFluent<?> fluent,ResourceClaimSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClaimSpec build() {
    ResourceClaimSpec buildable = new ResourceClaimSpec(fluent.buildDevices());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}