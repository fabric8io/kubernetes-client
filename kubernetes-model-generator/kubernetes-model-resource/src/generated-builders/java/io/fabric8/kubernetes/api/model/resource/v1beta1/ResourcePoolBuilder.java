package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourcePoolBuilder extends ResourcePoolFluent<ResourcePoolBuilder> implements VisitableBuilder<ResourcePool,ResourcePoolBuilder>{

  ResourcePoolFluent<?> fluent;

  public ResourcePoolBuilder() {
    this(new ResourcePool());
  }
  
  public ResourcePoolBuilder(ResourcePoolFluent<?> fluent) {
    this(fluent, new ResourcePool());
  }
  
  public ResourcePoolBuilder(ResourcePool instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourcePoolBuilder(ResourcePoolFluent<?> fluent,ResourcePool instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourcePool build() {
    ResourcePool buildable = new ResourcePool(fluent.getGeneration(), fluent.getName(), fluent.getResourceSliceCount());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}