package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClaimConsumerReferenceBuilder extends ResourceClaimConsumerReferenceFluent<ResourceClaimConsumerReferenceBuilder> implements VisitableBuilder<ResourceClaimConsumerReference,ResourceClaimConsumerReferenceBuilder>{

  ResourceClaimConsumerReferenceFluent<?> fluent;

  public ResourceClaimConsumerReferenceBuilder() {
    this(new ResourceClaimConsumerReference());
  }
  
  public ResourceClaimConsumerReferenceBuilder(ResourceClaimConsumerReferenceFluent<?> fluent) {
    this(fluent, new ResourceClaimConsumerReference());
  }
  
  public ResourceClaimConsumerReferenceBuilder(ResourceClaimConsumerReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClaimConsumerReferenceBuilder(ResourceClaimConsumerReferenceFluent<?> fluent,ResourceClaimConsumerReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClaimConsumerReference build() {
    ResourceClaimConsumerReference buildable = new ResourceClaimConsumerReference(fluent.getApiGroup(), fluent.getName(), fluent.getResource(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}