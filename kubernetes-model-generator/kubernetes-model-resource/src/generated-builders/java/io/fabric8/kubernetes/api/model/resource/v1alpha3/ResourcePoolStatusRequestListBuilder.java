package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourcePoolStatusRequestListBuilder extends ResourcePoolStatusRequestListFluent<ResourcePoolStatusRequestListBuilder> implements VisitableBuilder<ResourcePoolStatusRequestList,ResourcePoolStatusRequestListBuilder>{

  ResourcePoolStatusRequestListFluent<?> fluent;

  public ResourcePoolStatusRequestListBuilder() {
    this(new ResourcePoolStatusRequestList());
  }
  
  public ResourcePoolStatusRequestListBuilder(ResourcePoolStatusRequestListFluent<?> fluent) {
    this(fluent, new ResourcePoolStatusRequestList());
  }
  
  public ResourcePoolStatusRequestListBuilder(ResourcePoolStatusRequestList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourcePoolStatusRequestListBuilder(ResourcePoolStatusRequestListFluent<?> fluent,ResourcePoolStatusRequestList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourcePoolStatusRequestList build() {
    ResourcePoolStatusRequestList buildable = new ResourcePoolStatusRequestList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}