package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceStatusBuilder extends ResourceStatusFluent<ResourceStatusBuilder> implements VisitableBuilder<ResourceStatus,ResourceStatusBuilder>{

  ResourceStatusFluent<?> fluent;

  public ResourceStatusBuilder() {
    this(new ResourceStatus());
  }
  
  public ResourceStatusBuilder(ResourceStatusFluent<?> fluent) {
    this(fluent, new ResourceStatus());
  }
  
  public ResourceStatusBuilder(ResourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceStatusBuilder(ResourceStatusFluent<?> fluent,ResourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceStatus build() {
    ResourceStatus buildable = new ResourceStatus(fluent.getName(), fluent.buildResources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}