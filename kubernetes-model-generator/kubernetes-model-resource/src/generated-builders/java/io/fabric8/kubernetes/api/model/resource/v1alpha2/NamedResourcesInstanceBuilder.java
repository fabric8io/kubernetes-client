package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedResourcesInstanceBuilder extends NamedResourcesInstanceFluent<NamedResourcesInstanceBuilder> implements VisitableBuilder<NamedResourcesInstance,NamedResourcesInstanceBuilder>{

  NamedResourcesInstanceFluent<?> fluent;

  public NamedResourcesInstanceBuilder() {
    this(new NamedResourcesInstance());
  }
  
  public NamedResourcesInstanceBuilder(NamedResourcesInstanceFluent<?> fluent) {
    this(fluent, new NamedResourcesInstance());
  }
  
  public NamedResourcesInstanceBuilder(NamedResourcesInstance instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedResourcesInstanceBuilder(NamedResourcesInstanceFluent<?> fluent,NamedResourcesInstance instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedResourcesInstance build() {
    NamedResourcesInstance buildable = new NamedResourcesInstance(fluent.buildAttributes(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}