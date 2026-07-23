package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceSliceBuilder extends ResourceSliceFluent<ResourceSliceBuilder> implements VisitableBuilder<ResourceSlice,ResourceSliceBuilder>{

  ResourceSliceFluent<?> fluent;

  public ResourceSliceBuilder() {
    this(new ResourceSlice());
  }
  
  public ResourceSliceBuilder(ResourceSliceFluent<?> fluent) {
    this(fluent, new ResourceSlice());
  }
  
  public ResourceSliceBuilder(ResourceSlice instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceSliceBuilder(ResourceSliceFluent<?> fluent,ResourceSlice instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceSlice build() {
    ResourceSlice buildable = new ResourceSlice(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}