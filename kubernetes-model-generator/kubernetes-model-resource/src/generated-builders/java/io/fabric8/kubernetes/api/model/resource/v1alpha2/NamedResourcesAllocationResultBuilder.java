package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedResourcesAllocationResultBuilder extends NamedResourcesAllocationResultFluent<NamedResourcesAllocationResultBuilder> implements VisitableBuilder<NamedResourcesAllocationResult,NamedResourcesAllocationResultBuilder>{

  NamedResourcesAllocationResultFluent<?> fluent;

  public NamedResourcesAllocationResultBuilder() {
    this(new NamedResourcesAllocationResult());
  }
  
  public NamedResourcesAllocationResultBuilder(NamedResourcesAllocationResultFluent<?> fluent) {
    this(fluent, new NamedResourcesAllocationResult());
  }
  
  public NamedResourcesAllocationResultBuilder(NamedResourcesAllocationResult instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedResourcesAllocationResultBuilder(NamedResourcesAllocationResultFluent<?> fluent,NamedResourcesAllocationResult instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedResourcesAllocationResult build() {
    NamedResourcesAllocationResult buildable = new NamedResourcesAllocationResult(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}