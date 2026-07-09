package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedResourcesIntSliceBuilder extends NamedResourcesIntSliceFluent<NamedResourcesIntSliceBuilder> implements VisitableBuilder<NamedResourcesIntSlice,NamedResourcesIntSliceBuilder>{

  NamedResourcesIntSliceFluent<?> fluent;

  public NamedResourcesIntSliceBuilder() {
    this(new NamedResourcesIntSlice());
  }
  
  public NamedResourcesIntSliceBuilder(NamedResourcesIntSliceFluent<?> fluent) {
    this(fluent, new NamedResourcesIntSlice());
  }
  
  public NamedResourcesIntSliceBuilder(NamedResourcesIntSlice instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedResourcesIntSliceBuilder(NamedResourcesIntSliceFluent<?> fluent,NamedResourcesIntSlice instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedResourcesIntSlice build() {
    NamedResourcesIntSlice buildable = new NamedResourcesIntSlice(fluent.getInts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}