package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourcePoolStatusRequestSpecBuilder extends ResourcePoolStatusRequestSpecFluent<ResourcePoolStatusRequestSpecBuilder> implements VisitableBuilder<ResourcePoolStatusRequestSpec,ResourcePoolStatusRequestSpecBuilder>{

  ResourcePoolStatusRequestSpecFluent<?> fluent;

  public ResourcePoolStatusRequestSpecBuilder() {
    this(new ResourcePoolStatusRequestSpec());
  }
  
  public ResourcePoolStatusRequestSpecBuilder(ResourcePoolStatusRequestSpecFluent<?> fluent) {
    this(fluent, new ResourcePoolStatusRequestSpec());
  }
  
  public ResourcePoolStatusRequestSpecBuilder(ResourcePoolStatusRequestSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourcePoolStatusRequestSpecBuilder(ResourcePoolStatusRequestSpecFluent<?> fluent,ResourcePoolStatusRequestSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourcePoolStatusRequestSpec build() {
    ResourcePoolStatusRequestSpec buildable = new ResourcePoolStatusRequestSpec(fluent.getDriver(), fluent.getLimit(), fluent.getPoolName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}