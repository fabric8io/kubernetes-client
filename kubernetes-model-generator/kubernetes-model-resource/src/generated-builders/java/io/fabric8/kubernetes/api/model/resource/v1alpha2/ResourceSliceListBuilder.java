package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceSliceListBuilder extends ResourceSliceListFluent<ResourceSliceListBuilder> implements VisitableBuilder<ResourceSliceList,ResourceSliceListBuilder>{

  ResourceSliceListFluent<?> fluent;

  public ResourceSliceListBuilder() {
    this(new ResourceSliceList());
  }
  
  public ResourceSliceListBuilder(ResourceSliceListFluent<?> fluent) {
    this(fluent, new ResourceSliceList());
  }
  
  public ResourceSliceListBuilder(ResourceSliceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceSliceListBuilder(ResourceSliceListFluent<?> fluent,ResourceSliceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceSliceList build() {
    ResourceSliceList buildable = new ResourceSliceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}