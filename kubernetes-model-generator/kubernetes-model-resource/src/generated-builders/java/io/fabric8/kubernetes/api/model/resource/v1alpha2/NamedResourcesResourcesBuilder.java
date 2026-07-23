package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedResourcesResourcesBuilder extends NamedResourcesResourcesFluent<NamedResourcesResourcesBuilder> implements VisitableBuilder<NamedResourcesResources,NamedResourcesResourcesBuilder>{

  NamedResourcesResourcesFluent<?> fluent;

  public NamedResourcesResourcesBuilder() {
    this(new NamedResourcesResources());
  }
  
  public NamedResourcesResourcesBuilder(NamedResourcesResourcesFluent<?> fluent) {
    this(fluent, new NamedResourcesResources());
  }
  
  public NamedResourcesResourcesBuilder(NamedResourcesResources instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedResourcesResourcesBuilder(NamedResourcesResourcesFluent<?> fluent,NamedResourcesResources instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedResourcesResources build() {
    NamedResourcesResources buildable = new NamedResourcesResources(fluent.buildInstances());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}