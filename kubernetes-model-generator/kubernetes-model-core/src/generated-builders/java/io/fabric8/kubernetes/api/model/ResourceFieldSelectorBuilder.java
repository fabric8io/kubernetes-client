package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceFieldSelectorBuilder extends ResourceFieldSelectorFluent<ResourceFieldSelectorBuilder> implements VisitableBuilder<ResourceFieldSelector,ResourceFieldSelectorBuilder>{

  ResourceFieldSelectorFluent<?> fluent;

  public ResourceFieldSelectorBuilder() {
    this(new ResourceFieldSelector());
  }
  
  public ResourceFieldSelectorBuilder(ResourceFieldSelectorFluent<?> fluent) {
    this(fluent, new ResourceFieldSelector());
  }
  
  public ResourceFieldSelectorBuilder(ResourceFieldSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceFieldSelectorBuilder(ResourceFieldSelectorFluent<?> fluent,ResourceFieldSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceFieldSelector build() {
    ResourceFieldSelector buildable = new ResourceFieldSelector(fluent.getContainerName(), fluent.buildDivisor(), fluent.getResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}