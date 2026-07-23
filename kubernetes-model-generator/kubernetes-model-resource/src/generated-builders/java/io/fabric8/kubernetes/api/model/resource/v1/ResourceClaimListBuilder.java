package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClaimListBuilder extends ResourceClaimListFluent<ResourceClaimListBuilder> implements VisitableBuilder<ResourceClaimList,ResourceClaimListBuilder>{

  ResourceClaimListFluent<?> fluent;

  public ResourceClaimListBuilder() {
    this(new ResourceClaimList());
  }
  
  public ResourceClaimListBuilder(ResourceClaimListFluent<?> fluent) {
    this(fluent, new ResourceClaimList());
  }
  
  public ResourceClaimListBuilder(ResourceClaimList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClaimListBuilder(ResourceClaimListFluent<?> fluent,ResourceClaimList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClaimList build() {
    ResourceClaimList buildable = new ResourceClaimList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}