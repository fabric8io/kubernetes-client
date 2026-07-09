package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedResourcesStringSliceBuilder extends NamedResourcesStringSliceFluent<NamedResourcesStringSliceBuilder> implements VisitableBuilder<NamedResourcesStringSlice,NamedResourcesStringSliceBuilder>{

  NamedResourcesStringSliceFluent<?> fluent;

  public NamedResourcesStringSliceBuilder() {
    this(new NamedResourcesStringSlice());
  }
  
  public NamedResourcesStringSliceBuilder(NamedResourcesStringSliceFluent<?> fluent) {
    this(fluent, new NamedResourcesStringSlice());
  }
  
  public NamedResourcesStringSliceBuilder(NamedResourcesStringSlice instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedResourcesStringSliceBuilder(NamedResourcesStringSliceFluent<?> fluent,NamedResourcesStringSlice instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedResourcesStringSlice build() {
    NamedResourcesStringSlice buildable = new NamedResourcesStringSlice(fluent.getStrings());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}