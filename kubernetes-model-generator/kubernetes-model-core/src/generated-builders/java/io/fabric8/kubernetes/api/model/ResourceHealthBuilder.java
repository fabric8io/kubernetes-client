package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceHealthBuilder extends ResourceHealthFluent<ResourceHealthBuilder> implements VisitableBuilder<ResourceHealth,ResourceHealthBuilder>{

  ResourceHealthFluent<?> fluent;

  public ResourceHealthBuilder() {
    this(new ResourceHealth());
  }
  
  public ResourceHealthBuilder(ResourceHealthFluent<?> fluent) {
    this(fluent, new ResourceHealth());
  }
  
  public ResourceHealthBuilder(ResourceHealth instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceHealthBuilder(ResourceHealthFluent<?> fluent,ResourceHealth instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceHealth build() {
    ResourceHealth buildable = new ResourceHealth(fluent.getHealth(), fluent.getMessage(), fluent.getResourceID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}