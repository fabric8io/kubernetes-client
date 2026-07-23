package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClaimParametersReferenceBuilder extends ResourceClaimParametersReferenceFluent<ResourceClaimParametersReferenceBuilder> implements VisitableBuilder<ResourceClaimParametersReference,ResourceClaimParametersReferenceBuilder>{

  ResourceClaimParametersReferenceFluent<?> fluent;

  public ResourceClaimParametersReferenceBuilder() {
    this(new ResourceClaimParametersReference());
  }
  
  public ResourceClaimParametersReferenceBuilder(ResourceClaimParametersReferenceFluent<?> fluent) {
    this(fluent, new ResourceClaimParametersReference());
  }
  
  public ResourceClaimParametersReferenceBuilder(ResourceClaimParametersReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClaimParametersReferenceBuilder(ResourceClaimParametersReferenceFluent<?> fluent,ResourceClaimParametersReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClaimParametersReference build() {
    ResourceClaimParametersReference buildable = new ResourceClaimParametersReference(fluent.getApiGroup(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}