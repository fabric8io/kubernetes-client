package io.fabric8.volcano.api.model.nodeinfo.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceInfoBuilder extends ResourceInfoFluent<ResourceInfoBuilder> implements VisitableBuilder<ResourceInfo,ResourceInfoBuilder>{

  ResourceInfoFluent<?> fluent;

  public ResourceInfoBuilder() {
    this(new ResourceInfo());
  }
  
  public ResourceInfoBuilder(ResourceInfoFluent<?> fluent) {
    this(fluent, new ResourceInfo());
  }
  
  public ResourceInfoBuilder(ResourceInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceInfoBuilder(ResourceInfoFluent<?> fluent,ResourceInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceInfo build() {
    ResourceInfo buildable = new ResourceInfo(fluent.getAllocatable(), fluent.getCapacity());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}