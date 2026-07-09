package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClaimTemplateSpecBuilder extends ResourceClaimTemplateSpecFluent<ResourceClaimTemplateSpecBuilder> implements VisitableBuilder<ResourceClaimTemplateSpec,ResourceClaimTemplateSpecBuilder>{

  ResourceClaimTemplateSpecFluent<?> fluent;

  public ResourceClaimTemplateSpecBuilder() {
    this(new ResourceClaimTemplateSpec());
  }
  
  public ResourceClaimTemplateSpecBuilder(ResourceClaimTemplateSpecFluent<?> fluent) {
    this(fluent, new ResourceClaimTemplateSpec());
  }
  
  public ResourceClaimTemplateSpecBuilder(ResourceClaimTemplateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClaimTemplateSpecBuilder(ResourceClaimTemplateSpecFluent<?> fluent,ResourceClaimTemplateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClaimTemplateSpec build() {
    ResourceClaimTemplateSpec buildable = new ResourceClaimTemplateSpec(fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}