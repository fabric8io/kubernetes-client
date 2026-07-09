package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceFilterBuilder extends ResourceFilterFluent<ResourceFilterBuilder> implements VisitableBuilder<ResourceFilter,ResourceFilterBuilder>{

  ResourceFilterFluent<?> fluent;

  public ResourceFilterBuilder() {
    this(new ResourceFilter());
  }
  
  public ResourceFilterBuilder(ResourceFilterFluent<?> fluent) {
    this(fluent, new ResourceFilter());
  }
  
  public ResourceFilterBuilder(ResourceFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceFilterBuilder(ResourceFilterFluent<?> fluent,ResourceFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceFilter build() {
    ResourceFilter buildable = new ResourceFilter(fluent.getDriverName(), fluent.buildNamedResources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}